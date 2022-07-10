package org.vlang.lang.vmod.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.icons.AllIcons
import com.intellij.psi.*
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.CachedValueProvider
import com.intellij.psi.util.CachedValuesManager
import com.intellij.util.ArrayFactory
import org.vlang.lang.VlangFileType
import org.vlang.lang.VlangLanguage
import org.vlang.lang.VlangTypes
import org.vlang.lang.psi.impl.VlangPsiImplUtil
import org.vlang.lang.stubs.VlangFileStub
import org.vlang.lang.stubs.types.VlangFunctionDeclarationStubElementType
import org.vlang.lang.stubs.types.VlangMethodDeclarationStubElementType
import org.vlang.lang.ui.PluginIcons
import org.vlang.lang.vmod.VmodFileType
import org.vlang.lang.vmod.VmodLanguage

class VmodFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, VmodLanguage.INSTANCE) {
    override fun getFileType() = VmodFileType.INSTANCE

    override fun toString() = "V module file"

    override fun getIcon(flags: Int) = AllIcons.FileTypes.Config

    override fun getReference() = references.getOrNull(0)

    override fun getReferences(): Array<PsiReference?> = ReferenceProvidersRegistry.getReferencesFromProviders(this)
}
