package org.vlang.ide.test.configuration

import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.ConfigurationFromContext
import com.intellij.execution.actions.LazyRunConfigurationProducer
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationTypeUtil
import com.intellij.openapi.roots.TestSourcesFilter
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement
import org.vlang.ide.test.VlangTestSourcesFilter
import org.vlang.lang.psi.VlangFile
import org.vlang.lang.psi.VlangModuleClause

class VlangTestConfigurationProducer : LazyRunConfigurationProducer<VlangTestConfiguration>() {
    override fun getConfigurationFactory(): ConfigurationFactory =
        ConfigurationTypeUtil.findConfigurationType(VlangTestConfigurationType.ID)!!
            .configurationFactories[0]

    override fun isConfigurationFromContext(
        configuration: VlangTestConfiguration,
        context: ConfigurationContext
    ): Boolean {
        val element = context.location?.psiElement ?: return false
        val parent = element.parent ?: return false
        val containingFile = element.containingFile ?: return false
        if (containingFile !is VlangFile) {
            return false
        }

        if (!TestSourcesFilter.isTestSources(containingFile.virtualFile, element.project)) {
            return false
        }

        if (parent is VlangModuleClause) {
            val moduleName = parent.identifier!!.text
            return configuration.testModule == moduleName
        }

        return configuration.testFile == containingFile.virtualFile.path && configuration.testModule.isEmpty()
    }

    override fun setupConfigurationFromContext(
        configuration: VlangTestConfiguration,
        context: ConfigurationContext,
        sourceElement: Ref<PsiElement>
    ): Boolean {
        val element = sourceElement.get()
        val parent = element.parent ?: return false
        val containingFile = element.containingFile ?: return false
        if (containingFile !is VlangFile) {
            return false
        }

        if (!TestSourcesFilter.isTestSources(containingFile.virtualFile, element.project)) {
            return false
        }

        if (parent is VlangModuleClause) {
            val moduleName = parent.identifier!!.text
            configuration.name = "V Test $moduleName"
            configuration.testModule = moduleName
            configuration.testFile = containingFile.virtualFile.path

            return true
        }

        configuration.name = "V Test ${containingFile.name}"
        configuration.testFile = containingFile.virtualFile.path

        return true
    }

    override fun shouldReplace(self: ConfigurationFromContext, other: ConfigurationFromContext) =
        other.configuration !is VlangTestConfiguration
}
