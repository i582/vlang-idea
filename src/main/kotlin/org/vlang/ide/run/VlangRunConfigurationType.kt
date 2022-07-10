package org.vlang.ide.run

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationTypeBase
import com.intellij.openapi.project.Project
import org.vlang.ide.ui.PluginIcons

class VlangRunConfigurationType : ConfigurationTypeBase(
    ID, "Run",
    "Run V script",
    PluginIcons.vlang
) {
    companion object {
        const val ID = "VlangRun"
    }

    init {
        addFactory(object : ConfigurationFactory(this) {
            override fun getId() = ID

            override fun createTemplateConfiguration(project: Project) =
                VlangRunConfiguration(project, this, "Run Vlang script")

            override fun getOptionsClass() = VlangRunConfigurationOptions::class.java
        })
    }
}
