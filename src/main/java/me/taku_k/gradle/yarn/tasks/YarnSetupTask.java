package me.taku_k.gradle.yarn.tasks;

import me.taku_k.gradle.yarn.runner.YarnExecRunner;
import org.gradle.api.Project;
import org.gradle.api.internal.ConventionTask;
import org.gradle.api.tasks.TaskAction;

public class YarnSetupTask extends ConventionTask {
    public static final String NAME = "yarnSetup";

    public YarnSetupTask() {
        setGroup("Yarn");
        setDescription("Setup a specific version of yarn to be used by the build.");
    }

    @TaskAction
    public void setup() {
        getLogger().info("abc");
        Project project = getProject();
        new YarnExecRunner(project).exec();
    }
}
