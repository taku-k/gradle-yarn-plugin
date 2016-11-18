package me.taku_k.gradle.yarn

import nebula.test.ProjectSpec

class YarnPluginTest extends ProjectSpec {
    def 'has Project'() {
        expect:
        project != null
    }

    def 'check default tasks'()
    {
        when:
        this.project.apply plugin: 'me.taku_k.yarn'
        this.project.evaluate()

        then:
        this.project.extensions.getByName('yarn')
        this.project.tasks.getByName('yarnSetup')
        this.project.tasks.getByName('yarnInstall')
    }
}
