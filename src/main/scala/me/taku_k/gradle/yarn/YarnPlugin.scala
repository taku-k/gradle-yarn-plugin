package me.taku_k.gradle.yarn

import me.taku_k.gradle.yarn.tasks.{YarnInstallTask, YarnSetupTask}
import org.gradle.api.{Plugin, Project}

class YarnPlugin extends Plugin[Project] {
  private var project: Project = _

  override def apply(project: Project): Unit = {
    this.project = project
    this.project.getExtensions.add(YarnExtension.NAME, YarnExtension)
    addTasks()
  }

  def addTasks() = {
    project.getTasks.create(YarnSetupTask.NAME, classOf[YarnSetupTask])
    project.getTasks.create(YarnInstallTask.NAME, classOf[YarnInstallTask])
  }
}
