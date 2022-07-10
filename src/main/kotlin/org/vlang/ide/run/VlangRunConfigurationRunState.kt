package org.vlang.ide.run

import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.KillableColoredProcessHandler
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.runners.ExecutionEnvironment
import java.io.File

class VlangRunConfigurationRunState(
    env: ExecutionEnvironment,
    private val conf: VlangRunConfiguration
) : CommandLineState(env) {

    override fun startProcess(): ProcessHandler {
        val file = File(conf.scriptName)
        val workingDir = file.parentFile

        val commandLine = GeneralCommandLine()
            .withExePath("/Users/petrmakhnev/v/v")
            .withParameters("crun", conf.scriptName)
            .withWorkDirectory(workingDir)

        if (conf.additionalParameters.isNotEmpty()) {
            commandLine.withParameters(conf.additionalParameters.split(" "))
        }

        return KillableColoredProcessHandler(commandLine)
    }
}
