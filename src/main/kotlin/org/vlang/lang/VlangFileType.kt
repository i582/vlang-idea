package org.vlang.lang

import com.intellij.openapi.fileTypes.LanguageFileType
import org.vlang.lang.ui.PluginIcons

class VlangFileType : LanguageFileType(VlangLanguage.INSTANCE) {
    override fun getName() = "vlang"

    override fun getDescription() = "Vlang language file"

    override fun getDefaultExtension() = FILE_EXTENSION

    override fun getIcon() = PluginIcons.vlang

    companion object {
        const val FILE_EXTENSION = "v"
        val INSTANCE = VlangFileType()
    }
}
