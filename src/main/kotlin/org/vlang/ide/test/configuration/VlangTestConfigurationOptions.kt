package org.vlang.ide.test.configuration

import com.intellij.execution.configurations.RunConfigurationOptions

class VlangTestConfigurationOptions : RunConfigurationOptions() {
    private val myTestName = string("").provideDelegate(this, "vlangTestName")
    private val myTestModule = string("").provideDelegate(this, "vlangTestModule")
    private val myAdditionalParameters = string("").provideDelegate(this, "vlangAdditionalParameters")

    var testName: String
        get() = myTestName.getValue(this) ?: ""
        set(value) {
            myTestName.setValue(this, value)
        }

    var testModule: String
        get() = myTestModule.getValue(this) ?: ""
        set(value) {
            myTestModule.setValue(this, value)
        }

    var additionalParameters: String
        get() = myAdditionalParameters.getValue(this) ?: ""
        set(value) {
            myAdditionalParameters.setValue(this, value)
        }
}
