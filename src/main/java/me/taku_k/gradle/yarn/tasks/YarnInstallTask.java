package me.taku_k.gradle.yarn.tasks;

import me.taku_k.gradle.yarn.runner.YarnExecRunner;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.util.Collections;
import java.util.List;

public class YarnInstallTask extends DefaultTask {
    public static final String NAME = "yarnInstall";

    public YarnInstallTask() {
        setGroup("Yarn");
        setDescription("Install node packages from yarn.lock or package.json.");
    }

    @TaskAction
    public void install() {
        List<String> args = Collections.singletonList("install");
        new YarnExecRunner(getProject()).exec(args);
    }
}
