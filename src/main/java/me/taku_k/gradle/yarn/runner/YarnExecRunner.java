package me.taku_k.gradle.yarn.runner;

import org.gradle.api.Project;

public class YarnExecRunner {
    private final Project project;

    public YarnExecRunner(Project project) {
        this.project = project;
    }

    public void exec() {
        project.exec(new YarnExecAction(project));
    }
}
