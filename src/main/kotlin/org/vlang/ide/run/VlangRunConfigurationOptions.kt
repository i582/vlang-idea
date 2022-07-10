package org.vlang.ide.run

import com.intellij.execution.configurations.RunConfigurationOptions

class VlangRunConfigurationOptions : RunConfigurationOptions() {
    private val myScriptName = string("").provideDelegate(this, "vlangScriptName")
    private val myAdditionalParameters = string("").provideDelegate(this, "vlangAdditionalParameters")

    var scriptName: String
        get() = myScriptName.getValue(this) ?: ""
        set(value) {
            myScriptName.setValue(this, value)
        }

    var additionalParameters: String
        get() = myAdditionalParameters.getValue(this) ?: ""
        set(value) {
            myAdditionalParameters.setValue(this, value)
        }
}
