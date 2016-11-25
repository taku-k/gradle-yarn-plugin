package me.taku_k.gradle.yarn.tasks;

import lombok.Getter;
import lombok.Setter;
import me.taku_k.gradle.yarn.runner.YarnExecRunner;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.util.ArrayList;
import java.util.List;

public class YarnTask extends DefaultTask {
    public static final String NAME = "";

    private YarnExecRunner runner;

    @Getter
    @Setter
    private List<String> args = new ArrayList<>();

    public YarnTask() {
        this.runner = new YarnExecRunner(this.getProject());
        dependsOn( YarnSetupTask.NAME );
    }

    @TaskAction
    public void exec() {
        runner.exec(args);
    }
}
