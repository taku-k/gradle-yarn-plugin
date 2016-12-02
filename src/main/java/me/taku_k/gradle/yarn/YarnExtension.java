package me.taku_k.gradle.yarn;

import lombok.Getter;
import lombok.Setter;
import org.gradle.api.Project;

import static java.lang.String.format;

public class YarnExtension {
    public static final String NAME = "yarn";

    @Getter
    @Setter
    private String version = "";

    @Getter
    @Setter
    private String workingDir = "yarn";

    @Getter
    @Setter
    private Project project;

    public String getBinPath() {
        if ("".equals(version)) {
            return "yarn";
        }
        return format("%s/.gradle/%s/yarn-%s.js", project.getRootDir(), workingDir, version);
    }

    public boolean isSpecifiedVersion() {
        return !version.isEmpty();
    }
}
