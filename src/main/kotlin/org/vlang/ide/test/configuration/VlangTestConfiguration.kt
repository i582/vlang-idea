package org.vlang.ide.test.configuration

import com.intellij.execution.Executor
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunConfigurationBase
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.project.Project
import org.jdom.Element

open class VlangTestConfiguration(project: Project, factory: ConfigurationFactory?, name: String?) :
    RunConfigurationBase<VlangTestConfigurationOptions?>(project, factory, name) {

    override fun getOptions() = super.getOptions() as VlangTestConfigurationOptions

    var testFile: String
        get() = options.testName
        set(value) {
            options.testName = value
        }

    var testModule: String
        get() = options.testModule
        set(value) {
            options.testModule = value
        }

    var additionalParameters: String
        get() = options.additionalParameters
        set(value) {
            options.additionalParameters = value
        }

    override fun writeExternal(element: Element) {
        super.writeExternal(element)
        element.writeString("testFile", testFile)
        element.writeString("testModule", testFile)
        element.writeString("additionalParameters", additionalParameters)
    }

    override fun readExternal(element: Element) {
        super.readExternal(element)
        element.readString("testFile")?.let { testFile = it }
        element.readString("testModule")?.let { testFile = it }
        element.readString("additionalParameters")?.let { additionalParameters = it }
    }

    override fun getConfigurationEditor() = VlangTestConfigurationEditor(project)

    override fun checkConfiguration() {
        // TODO: add check for class or method?
    }

    override fun getState(executor: Executor, executionEnvironment: ExecutionEnvironment): RunProfileState? {
        return VlangTestConfigurationRunState(executionEnvironment, this)
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
