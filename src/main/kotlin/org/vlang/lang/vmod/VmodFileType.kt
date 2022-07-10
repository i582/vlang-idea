package org.vlang.lang.vmod

import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import org.vlang.lang.ui.PluginIcons

class VmodFileType : LanguageFileType(VmodLanguage.INSTANCE) {
    override fun getName() = "V Module"

    override fun getDescription() = "V module file"

    override fun getDefaultExtension() = FILE_EXTENSION

    override fun getIcon() = PluginIcons.vlangModule

    companion object {
        const val FILE_EXTENSION = "mod"
        val INSTANCE = VmodFileType()
    }
}
