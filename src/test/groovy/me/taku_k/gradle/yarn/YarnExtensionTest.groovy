package me.taku_k.gradle.yarn

import nebula.test.ProjectSpec

class YarnExtensionTest extends ProjectSpec {
    def "check default values for extension"() {
        when:
        this.project.apply plugin: 'me.taku_k.yarn'
        def ext = this.project.getExtensions().getByName('yarn')

        then:
        ext != null
        ext.version == ''
        ext.workingDir == 'yarn'
    }
}
