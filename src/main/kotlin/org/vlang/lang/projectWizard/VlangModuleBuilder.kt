package org.vlang.lang.projectWizard

import com.intellij.ide.util.projectWizard.*
import com.intellij.ide.wizard.AbstractNewProjectWizardStep
import com.intellij.ide.wizard.GitNewProjectWizardStep
import com.intellij.ide.wizard.NewProjectWizardBaseData
import com.intellij.openapi.Disposable
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ModalityState
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.module.*
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.startup.StartupManager
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.components.JBTextField
import com.intellij.ui.dsl.builder.Panel
import org.vlang.ide.ui.PluginIcons
import java.io.IOException
import javax.swing.JComponent
import javax.swing.JLabel

class VlangModuleBuilder : ModuleBuilder(), ModuleBuilderListener {
    override fun getPresentableName() = "V Project"

    override fun getName() = "V Project"

    override fun getDescription() = "Simple V project"

    override fun getNodeIcon() = PluginIcons.vlang

    override fun getWeight() = 2100

    override fun getModuleType() = ModuleType.EMPTY

    override fun getCustomOptionsStep(context: WizardContext, parentDisposable: Disposable): ModuleWizardStep {
        return VlangModuleWizardStep(this)
    }

//    override fun createStep(context: WizardContext) =
//        RootNewProjectWizardStep(context).chain(
//            ::newProjectWizardBaseStepWithoutGap,
//            ::GitNewProjectWizardStep,
//            ::TemplateNewProjectWizardStep,
//        )

    override fun getAdditionalFields(): MutableList<WizardInputField<*>> {
       val field =  BasePackageParameterFactory().createField("other") ?: return mutableListOf()
        return mutableListOf(
            field
        )
    }

    override fun moduleCreated(module: Module) {
        println(module)
    }

    override fun setupRootModel(modifiableRootModel: ModifiableRootModel) {
        val contentEntry = doAddContentEntry(modifiableRootModel)
        val baseDir = contentEntry?.file ?: return

        setupProject(modifiableRootModel, baseDir)
    }

//    override fun getModuleType(): ModuleType<*> {
//        return WebModuleTypeBase.getInstance()
//    }

    private fun setupProject(
        modifiableRootModel: ModifiableRootModel,
        baseDir: VirtualFile
    ) {
        ApplicationManager.getApplication().invokeLater {
            ApplicationManager.getApplication().runWriteAction {
                try {
                    val filesToOpen = VlangProjectTemplate()
                        .generateProject("", modifiableRootModel.module, baseDir)

                    if (!filesToOpen.isEmpty()) {
                        scheduleFilesOpening(modifiableRootModel.module, filesToOpen)
                    }
                } catch (ignore: IOException) {
                }
            }
        }
    }

    private fun scheduleFilesOpening(module: Module, files: Collection<VirtualFile>) {
        runWhenNonModalIfModuleNotDisposed(module) {
            val manager = FileEditorManager.getInstance(module.project)
            files.forEach { file ->
                manager.openFile(file, true)
            }
        }
    }

    private fun runWhenNonModalIfModuleNotDisposed(module: Module, runnable: Runnable) {
        // runnable must not be executed immediately because the new project model might be not yet committed, so Dart SDK won't be found
        // In WebStorm we get already initialized project at this point, but in IntelliJ IDEA - not yet initialized.
        if (module.project.isInitialized) {
            ApplicationManager.getApplication().invokeLater(runnable, ModalityState.NON_MODAL, module.disposed)
            return
        }
        StartupManager.getInstance(module.project).runWhenProjectIsInitialized {
            if (ApplicationManager.getApplication().currentModalityState === ModalityState.NON_MODAL) {
                runnable.run()
            } else {
                ApplicationManager.getApplication()
                    .invokeLater(runnable, ModalityState.NON_MODAL) {
                        module.isDisposed
                    }
            }
        }
    }

//    override fun createStep(context: WizardContext): NewProjectWizardStep {
//        return object : NewProjectWizardStep {
//            override val context: WizardContext
//                get() = context
//            override val data: UserDataHolder
//                get() = UserDataHolderBase()
//            override val keywords: NewProjectWizardStep.Keywords
//                get() = NewProjectWizardStep.Keywords()
//            override val propertyGraph: PropertyGraph
//                get() = PropertyGraph()
//
//        }
//    }

//    override fun createWizardSteps(context: WizardContext, provider: ModulesProvider): Array<ModuleWizardStep> {
//        return arrayOf(object : ModuleWizardStep() {
//            override fun getComponent(): JComponent {
//                return JLabel("Put your content here")
//            }
//
//            override fun updateDataModel() {}
//        })
//    }
}

class TemplateNewProjectWizardStep(
    parent: GitNewProjectWizardStep
) : AbstractNewProjectWizardStep(parent),
    NewProjectWizardBaseData by parent {

    override fun setupUI(builder: Panel) {

    }

    override fun setupProject(project: Project) {

    }
}

class VlangModuleWizardStep(private val builder: VlangModuleBuilder) : ModuleWizardStep() {
    override fun getComponent(): JComponent {
        return JLabel("Provide some setting here")
    }

    override fun updateDataModel() {

    }
}

class VlangModuleType : ModuleType<VlangModuleBuilder>(ID) {
    override fun createModuleBuilder() = VlangModuleBuilder()

    override fun getName() = "V Project"

    override fun getDescription() = "Simple V project"

    override fun getNodeIcon(b: Boolean) = PluginIcons.vlang

    companion object {
        private const val ID = "VLANG_MODULE_TYPE"

        val instance: VlangModuleType
            get() = ModuleTypeManager.getInstance().findByID(ID) as VlangModuleType
    }
}
