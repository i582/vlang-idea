package org.vlang.lang.vmod

import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import org.vlang.lang.ui.PluginIcons

class VmodFileType : LanguageFileType(VmodLanguage.INSTANCE) {
    override fun getName() = "vmod"

    override fun getDescription() = "V module file"

    override fun getDefaultExtension() = FILE_EXTENSION

    override fun getIcon() = AllIcons.FileTypes.Config

    companion object {
        const val FILE_EXTENSION = "mod"
        val INSTANCE = VmodFileType()
    }
}
