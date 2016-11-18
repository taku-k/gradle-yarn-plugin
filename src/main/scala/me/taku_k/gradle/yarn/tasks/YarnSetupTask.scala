package me.taku_k.gradle.yarn.tasks

import org.gradle.api.internal.ConventionTask
import org.gradle.api.tasks.TaskAction
import org.gradle.internal.logging.slf4j.OutputEventListenerBackedLogger

class YarnSetupTask extends ConventionTask {
  setDescription("Setup a specific version of yarn to be used by the build.")
  setGroup("Yarn")

  @TaskAction
  def setup() = {
    getLogger.asInstanceOf[OutputEventListenerBackedLogger].debug("abc")
    println("abc")
  }
}

object YarnSetupTask {
  val NAME = "yarnSetup"
}
