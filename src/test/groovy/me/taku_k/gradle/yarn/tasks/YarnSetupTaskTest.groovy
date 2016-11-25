package me.taku_k.gradle.yarn.tasks

import nebula.test.ProjectSpec;

class YarnSetupTaskTest extends ProjectSpec {
    def "test getYarnBin"() {
        given:
        def task = this.project.tasks.create("simple", YarnSetupTask)
        def actualStream = new ByteArrayOutputStream();
        when:
        task.getYarnBin("https://github.com/yarnpkg/yarn/releases/download/v0.17.4/yarn-0.17.4.js", actualStream)
        then:
        actualStream.toString().startsWith("#!/usr/bin/env node") == true
    }
}
