package me.taku_k.gradle.yarn;

import me.taku_k.gradle.yarn.tasks.YarnInstallTask;
import me.taku_k.gradle.yarn.tasks.YarnSetupTask;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class YarnPlugin implements Plugin<Project> {
    private Project project;

    @Override
    public void apply(Project project) {
        this.project = project;
        this.project.getExtensions().add(YarnExtension.NAME, YarnExtension.class);
        YarnExtension yarnExtension = (YarnExtension) this.project.getExtensions().findByName(YarnExtension.NAME);
        yarnExtension.setProject(this.project);
        addTasks();
    }

    private void addTasks() {
        project.getTasks().create(YarnSetupTask.NAME, YarnSetupTask.class);
        project.getTasks().create(YarnInstallTask.NAME, YarnInstallTask.class);
    }
}
