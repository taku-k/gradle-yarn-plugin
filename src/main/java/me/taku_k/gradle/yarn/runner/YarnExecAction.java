package me.taku_k.gradle.yarn.runner;

import org.gradle.api.Action;
import org.gradle.api.Project;
import org.gradle.process.ExecSpec;

import java.util.Arrays;

public class YarnExecAction implements Action<ExecSpec> {
    private final Project project;

    public YarnExecAction(Project project) {
        this.project = project;
    }

    @Override
    public void execute(ExecSpec execSpec) {
        execSpec.setExecutable(".gradle/yarn/yarn-0.17.4.js");
        execSpec.setArgs(Arrays.asList("--version"));
    }
}
