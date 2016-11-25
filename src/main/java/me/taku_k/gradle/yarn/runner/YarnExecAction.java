package me.taku_k.gradle.yarn.runner;

import me.taku_k.gradle.yarn.YarnExtension;
import org.gradle.api.Action;
import org.gradle.api.Project;
import org.gradle.process.ExecSpec;

import java.util.List;

public class YarnExecAction implements Action<ExecSpec> {
    private final YarnExtension ext;

    private final List<String> args;

    public YarnExecAction(Project project, List<String> args) {
        this.args = args;
        this.ext = (YarnExtension) project.getExtensions().getByName(YarnExtension.NAME);
    }

    @Override
    public void execute(ExecSpec execSpec) {
        execSpec.setExecutable(ext.getBinPath());
        execSpec.setArgs(args);
    }
}
