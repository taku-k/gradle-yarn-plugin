package me.taku_k.gradle.yarn.tasks;

import org.gradle.api.internal.ConventionTask;

public class YarnInstallTask extends ConventionTask {
    public static final String NAME = "yarnInstall";

    public YarnInstallTask() {
        setGroup("Yarn");
        setDescription("Install node packages from yarn.lock or package.json.");
    }
}
