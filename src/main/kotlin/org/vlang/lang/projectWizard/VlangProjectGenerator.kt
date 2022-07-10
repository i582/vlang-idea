package org.vlang.lang.projectWizard

import com.intellij.ide.util.projectWizard.WebProjectTemplate
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.module.Module
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ModifiableModelsProvider
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.vfs.VirtualFile
import org.vlang.ide.ui.PluginIcons
import javax.swing.Icon

//class VlangProjectWizardData(val dartSdkPath: String, val template: VlangProjectTemplate)
//
//class VlangProjectGenerator : WebProjectTemplate<VlangProjectWizardData>(),
//    Comparable<VlangProjectGenerator> {
//
//    fun getId(): String {
//        return "Vlang"
//    }
//
//    override fun getName(): String {
//        return "Vlang Project Generator"
//    }
//
//    override fun getDescription(): String {
//        return "Vlang Project Generator Description"
//    }
//
//    override fun getIcon(): Icon {
//        return PluginIcons.vlang
//    }
//
//    override fun createPeer(): GeneratorPeer<DartProjectWizardData> {
//        return DartGeneratorPeer()
//    }
//
//    override fun generateProject(
//        project: Project,
//        baseDir: VirtualFile,
//        data: DartProjectWizardData,
//        module: Module
//    ) {
//        ApplicationManager.getApplication().runWriteAction {
//            val modifiableModel: ModifiableRootModel =
//                ModifiableModelsProvider.getInstance().getModuleModifiableModel(module)
//            DartModuleBuilder.setupProject(modifiableModel, baseDir, data)
//            ModifiableModelsProvider.getInstance().commitModuleModifiableModel(modifiableModel)
//        }
//    }
//
//    override operator fun compareTo(generator: DartProjectGenerator): Int {
//        return name.compareTo(generator.name)
//    }
//}
