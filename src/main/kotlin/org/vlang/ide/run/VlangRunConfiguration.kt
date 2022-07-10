package org.vlang.ide.run

import com.intellij.execution.Executor
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunConfigurationBase
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.project.Project
import com.vk.admstorm.configuration.kbench.VlangRunConfigurationEditor
import org.jdom.Element

open class VlangRunConfiguration(project: Project, factory: ConfigurationFactory?, name: String?) :
    RunConfigurationBase<VlangRunConfigurationOptions?>(project, factory, name) {

    override fun getOptions() = super.getOptions() as VlangRunConfigurationOptions

    var scriptName: String
        get() = options.scriptName
        set(value) {
            options.scriptName = value
        }

    var additionalParameters: String
        get() = options.additionalParameters
        set(value) {
            options.additionalParameters = value
        }

    override fun writeExternal(element: Element) {
        super.writeExternal(element)
        element.writeString("scriptName", scriptName)
        element.writeString("additionalParameters", additionalParameters)
    }

    override fun readExternal(element: Element) {
        super.readExternal(element)
        element.readString("scriptName")?.let { scriptName = it }
        element.readString("additionalParameters")?.let { additionalParameters = it }
    }

    override fun getConfigurationEditor() = VlangRunConfigurationEditor(project)

    override fun checkConfiguration() {
        // TODO: add check for class or method?
    }

    override fun getState(executor: Executor, executionEnvironment: ExecutionEnvironment): RunProfileState? {
        return VlangRunConfigurationRunState(executionEnvironment, this)
    }

    private fun Element.writeString(name: String, value: String) {
        val opt = Element("option")
        opt.setAttribute("name", name)
        opt.setAttribute("value", value)
        addContent(opt)
    }

    private fun Element.readString(name: String): String? =
        children
            .find { it.name == "option" && it.getAttributeValue("name") == name }
            ?.getAttributeValue("value")

}
