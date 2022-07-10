package org.vlang.vmod.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.ResolveState
import com.intellij.psi.scope.PsiScopeProcessor
import org.vlang.vmod.psi.VmodCompositeElement

open class VmodCompositeElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), VmodCompositeElement {
    override fun toString(): String {
        return node.elementType.toString()
    }

    override fun processDeclarations(
        processor: PsiScopeProcessor,
        state: ResolveState,
        lastParent: PsiElement?,
        place: PsiElement
    ): Boolean {
        if (!processor.execute(this, state)) return false
        return false
    }
}
