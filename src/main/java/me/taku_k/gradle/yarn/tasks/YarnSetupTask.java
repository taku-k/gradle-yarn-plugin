package me.taku_k.gradle.yarn.tasks;

import me.taku_k.gradle.yarn.YarnExtension;
import org.apache.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HttpContext;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class YarnSetupTask extends DefaultTask {
    public static final String NAME = "yarnSetup";
    private final String YARN_BASE = "https://github.com/yarnpkg/yarn/releases/download/v%s/yarn-%s.js";

    public YarnSetupTask() {
        setGroup("Yarn");
        setDescription("Setup a specific version of yarn to be used by the build.");
    }

    private String buildUrl(String version) {
        return String.format(YARN_BASE, version, version);
    }

    private HttpEntity requestDownloadYarn(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader("Content-Type", "application/octet-stream"));
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultHeaders(headers)
                .setRedirectStrategy(new DefaultRedirectStrategy() {
                    public boolean isRedirected(HttpRequest request, HttpResponse response, HttpContext context)  {
                        boolean isRedirect=false;
                        try {
                            isRedirect = super.isRedirected(request, response, context);
                        } catch (ProtocolException e) {
                            e.printStackTrace();
                        }
                        if (!isRedirect) {
                            int responseCode = response.getStatusLine().getStatusCode();
                            if (responseCode == 301 || responseCode == 302) {
                                return true;
                            }
                        }
                        return isRedirect;
                    }
                })
                .build();
        CloseableHttpResponse response = httpClient.execute(httpGet);
        return response.getEntity();
    }

    public void getYarnBin(String url, OutputStream out) {
        try {
            HttpEntity entity = requestDownloadYarn(url);
            if (entity != null) {
                entity.writeTo(out);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @TaskAction
    public void setup() {
        YarnExtension ext = (YarnExtension) getProject().getExtensions().getByName(YarnExtension.NAME);
        // yarn is setup when version is specified
        if (ext.isSpecifiedVersion()) {
            String version = ext.getVersion();
            String url = buildUrl(version);
            try {
                // download yarn script to ext.getBinPath()
                FileOutputStream fos = new FileOutputStream(ext.getBinPath());
                getYarnBin(url, fos);
                // set the execute permission for yarn script
                new File(ext.getBinPath()).setExecutable(true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
