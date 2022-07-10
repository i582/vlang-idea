package org.vlang.lang

import com.intellij.openapi.fileTypes.LanguageFileType
import org.vlang.lang.ui.PluginIcons

class VlangFileType : LanguageFileType(VlangLanguage.INSTANCE) {
    override fun getName() = "V"

    override fun getDescription() = "Vlang language file"

    override fun getDefaultExtension() = FILE_EXTENSION

    override fun getIcon() = PluginIcons.vlangModule

    companion object {
        const val FILE_EXTENSION = "v"
        val INSTANCE = VlangFileType()
    }
}
