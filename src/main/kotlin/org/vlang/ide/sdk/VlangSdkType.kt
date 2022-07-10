package org.vlang.ide.sdk

import com.intellij.openapi.projectRoots.*
import org.jdom.Element

class VlangSdkType : SdkType("Vlang Sdk") {
    override fun saveAdditionalData(additionalData: SdkAdditionalData, additional: Element) {
    }

    override fun setupSdkPaths(sdk: Sdk, sdkModel: SdkModel): Boolean {
        val modificator = sdk.sdkModificator
        modificator.versionString = getVersionString(sdk)
        modificator.commitChanges()
        return true
    }

    override fun getVersionString(sdk: Sdk): String {
        return "0.0.1"
    }

    override fun getVersionString(sdkHome: String?): String {
        return "0.0.1"
    }

    override fun suggestHomePath(): String {
        return "~/v"
    }

    override fun isValidSdkHome(path: String): Boolean {
        return true
    }

    override fun suggestSdkName(currentSdkName: String?, sdkHome: String): String {
        return "$currentSdkName 1"
    }

    override fun createAdditionalDataConfigurable(
        sdkModel: SdkModel,
        sdkModificator: SdkModificator
    ): AdditionalDataConfigurable? {
        return null
    }

    override fun getPresentableName() = "Vlang SDK"
}
