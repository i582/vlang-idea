package org.vlang.lang.psi

import com.intellij.extapi.psi.PsiFileBase
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
import org.vlang.ide.ui.PluginIcons

class VlangFile(viewProvider: FileViewProvider) :
    PsiFileBase(viewProvider, VlangLanguage.INSTANCE), PsiImportHolder, PsiClassOwner {

    override fun getFileType() = VlangFileType.INSTANCE

    override fun toString() = "Vlang Language file"

    override fun getIcon(flags: Int) = PluginIcons.vlang

    override fun getReference() = references.getOrNull(0)

    override fun getReferences(): Array<PsiReference?> = ReferenceProvidersRegistry.getReferencesFromProviders(this)

    override fun getClasses(): Array<PsiClass> = emptyArray()

    override fun getPackageName() = getModuleName()

    override fun setPackageName(packageName: String?) {}

    override fun importClass(aClass: PsiClass) = false

    fun getModuleName(): String? {
        val stub = stub as? VlangFileStub
        val moduleName = stub?.getModuleName()
        if (moduleName != null) {
            return moduleName
        }

        val moduleNamePsi = findChildByClass(VlangModuleClause::class.java) ?: return null
        return moduleNamePsi.name
    }

    private fun getImports(): List<VlangImportSpec> {
        return findChildByClass(VlangImportList::class.java)?.importDeclarationList?.mapNotNull {
            it.importSpec
        } ?: emptyList()
    }

    fun resolveName(name: String): String? {
        val imports = getImports()
        for (import in imports) {
            if (import.importAlias?.identifier?.text == name) {
                return import.getIdentifier().text
            }

            val selectiveImport = import.selectiveImportList?.referenceExpressionList?.any {
                it.getIdentifier().text == name
            } ?: false

            if (selectiveImport) {
                return import.name + "." + name
            }

            val importName = import.name
            if (importName == name) {
                return importName
            }

            if (import.lastPart == name) {
                return importName
            }
        }

        val module = getModuleName() ?: return name

        return "$module.$name"
    }

    fun getFunctions(): List<VlangFunctionDeclaration> {
        return CachedValuesManager.getCachedValue(this) {
            val functions: List<VlangFunctionDeclaration> =
                if (stub != null) getChildrenByType(
                    stub!!,
                    VlangTypes.FUNCTION_DECLARATION,
                    VlangFunctionDeclarationStubElementType.ARRAY_FACTORY
                ) else {
                    VlangPsiImplUtil.goTraverser().children(this).filter(
                        VlangFunctionDeclaration::class.java
                    ).toList()
                }

            CachedValueProvider.Result.create(
                functions,
                this
            )
        }
    }

    fun getMethods(): List<VlangMethodDeclaration> {
        return CachedValuesManager.getCachedValue(
            this
        ) {
            val calc: List<VlangMethodDeclaration> =
                if (stub != null) getChildrenByType(
                    stub!!,
                    VlangTypes.METHOD_DECLARATION,
                    VlangMethodDeclarationStubElementType.ARRAY_FACTORY
                ) else VlangPsiImplUtil.goTraverser().children(this).filter(
                    VlangMethodDeclaration::class.java
                ).toList()
            CachedValueProvider.Result.create(
                calc,
                this
            )
        }
    }

    private fun <E : PsiElement?> getChildrenByType(
        stub: StubElement<out PsiElement>,
        elementType: IElementType,
        f: ArrayFactory<E>
    ): List<E> {
        return listOf(*stub.getChildrenByType(elementType, f))
    }
}
