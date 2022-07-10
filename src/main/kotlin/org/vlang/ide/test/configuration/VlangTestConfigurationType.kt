package org.vlang.ide.test.configuration

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationTypeBase
import com.intellij.openapi.project.Project
import org.vlang.ide.ui.PluginIcons

class VlangTestConfigurationType : ConfigurationTypeBase(
    ID, "Test",
    "Run V test",
    PluginIcons.vlang
) {
    companion object {
        const val ID = "VlangTest"
    }

    init {
        addFactory(object : ConfigurationFactory(this) {
            override fun getId() = ID

            override fun createTemplateConfiguration(project: Project) =
                VlangTestConfiguration(project, this, "Run Vlang test")

            override fun getOptionsClass() = VlangTestConfigurationOptions::class.java
        })
    }
}
