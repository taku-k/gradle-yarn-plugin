package me.taku_k.gradle.yarn;

import lombok.Getter;
import lombok.Setter;

public class YarnExtension {
    public static final String NAME = "yarn";

    @Getter
    @Setter
    private String version = "";

    @Getter
    @Setter
    private String workingDir = "yarn";

    public String getBinPath() {
        if ("".equals(version)) {
            return "yarn";
        }
        return String.format(".gradle/%s/yarn-%s.js", workingDir, version);
    }

    public boolean isSpecifiedVersion() {
        return !version.isEmpty();
    }
}
