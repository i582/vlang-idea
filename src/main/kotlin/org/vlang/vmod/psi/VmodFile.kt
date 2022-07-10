package org.vlang.vmod.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
import org.vlang.ide.ui.PluginIcons
import org.vlang.vmod.VmodFileType
import org.vlang.vmod.VmodLanguage

class VmodFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, VmodLanguage.INSTANCE) {
    override fun getFileType() = VmodFileType.INSTANCE

    override fun toString() = "V module file"

    override fun getIcon(flags: Int) = PluginIcons.vlangModule

    override fun getReference() = references.getOrNull(0)

    override fun getReferences(): Array<PsiReference?> = ReferenceProvidersRegistry.getReferencesFromProviders(this)
}
