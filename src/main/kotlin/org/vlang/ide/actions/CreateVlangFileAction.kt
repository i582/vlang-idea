package org.vlang.ide.actions

import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import org.vlang.ide.ui.PluginIcons

class CreateVlangFileAction : CreateFileFromTemplateAction(
    "V File",
    "Create new V file",
    PluginIcons.vlang
) {
    override fun isAvailable(dataContext: DataContext): Boolean {
        val project = CommonDataKeys.PROJECT.getData(dataContext)
        return super.isAvailable(dataContext) && project != null
    }

    override fun getActionName(dir: PsiDirectory, newName: String, tpl: String) = "Create V File '$newName'"

    override fun buildDialog(
        project: Project,
        directory: PsiDirectory,
        builder: CreateFileFromTemplateDialog.Builder
    ) {
        builder
            .setTitle("New V File")
            .addKind("V File", PluginIcons.vlang, "V File")
            .addKind("V Simple Application", PluginIcons.vlang, "V Simple Application")
    }
}
