package org.vlang.ide.sdk

import com.intellij.openapi.options.Configurable
import com.intellij.openapi.options.SearchableConfigurable
import com.intellij.openapi.project.Project
import org.vlang.ide.sdk.VlangSdkUtil
import javax.swing.JComponent

class VlangProjectConfigurable(private val project: Project) : SearchableConfigurable, Configurable {
    init {
        VlangSdkUtil.updateKnownSdkPaths(project, "/Users/petrmakhnev/v/v")
    }

    override fun createComponent(): JComponent? {
        return null
    }

    override fun isModified(): Boolean {
        return false
    }

    override fun apply() {

    }

    override fun getDisplayName(): String {
        return "V"
    }

    override fun getId(): String {
        return "vlang.project.configurable"
    }
}
