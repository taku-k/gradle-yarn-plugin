package me.taku_k.gradle.yarn.runner;

import org.gradle.api.Project;

import java.util.List;

public class YarnExecRunner {
    private final Project project;

    public YarnExecRunner(Project project) {
        this.project = project;
    }

    public void exec(List<String> args) {
        project.exec(new YarnExecAction(project, args));
    }
}
