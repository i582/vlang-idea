package org.vlang.ide

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.module.ModuleUtilCore
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ModuleRootModificationUtil
import com.intellij.openapi.roots.OrderRootType
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar
import com.intellij.openapi.startup.StartupActivity
import com.intellij.psi.search.FilenameIndex
import com.intellij.psi.search.GlobalSearchScope

class VlangStartupActivity : StartupActivity {
    override fun runActivity(project: Project) {
        ApplicationManager.getApplication().runWriteAction {
            val table = LibraryTablesRegistrar.getInstance().getLibraryTable(project)
            val lib = table.createLibrary("Standard library")
            lib.modifiableModel.addRoot("/Users/petrmakhnev/v/vlib", OrderRootType.SOURCES)
            lib.modifiableModel.commit()

            val vmodFiles = FilenameIndex.getVirtualFilesByName("v.mod", GlobalSearchScope.projectScope(project))
            val vmodFile = vmodFiles.firstOrNull() ?: return@runWriteAction
            val module = ModuleUtilCore.findModuleForFile(vmodFile, project) ?: return@runWriteAction
            ModuleRootModificationUtil.addDependency(module, lib)
        }
    }

}
