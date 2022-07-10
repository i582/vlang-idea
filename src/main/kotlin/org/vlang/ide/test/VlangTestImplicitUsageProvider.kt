package org.vlang.ide.test

import com.intellij.codeInsight.daemon.ImplicitUsageProvider
import com.intellij.openapi.roots.TestSourcesFilter
import com.intellij.psi.PsiElement
import org.vlang.lang.psi.VlangFunctionDeclaration

/**
 * Marks all test functions as implicitly used.
 */
class VlangTestImplicitUsageProvider : ImplicitUsageProvider {
    override fun isImplicitUsage(element: PsiElement): Boolean {
        if (element !is VlangFunctionDeclaration) {
            return false
        }

        val containingFile = element.containingFile ?: return false

        if (!TestSourcesFilter.isTestSources(containingFile.virtualFile, element.project)) {
            return false
        }

        return true
    }

    override fun isImplicitRead(element: PsiElement) = false

    override fun isImplicitWrite(element: PsiElement) = false
}
