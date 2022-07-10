package com.vk.admstorm.configuration.kbench

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.dsl.builder.*
import com.intellij.ui.dsl.gridLayout.HorizontalAlign
import org.vlang.ide.run.VlangRunConfiguration
import javax.swing.JComponent
import javax.swing.JPanel

open class VlangRunConfigurationEditor(private val project: Project) : SettingsEditor<VlangRunConfiguration>() {
    data class Model(
        var scriptName: String = "",
        var additionalParameters: String = "",
    )

    private lateinit var mainPanel: DialogPanel
    private val model = Model()

    override fun resetEditorFrom(demoRunConfiguration: VlangRunConfiguration) {
        model.scriptName = demoRunConfiguration.scriptName
        model.additionalParameters = demoRunConfiguration.additionalParameters

        mainPanel.reset()
    }

    override fun applyEditorTo(demoRunConfiguration: VlangRunConfiguration) {
        mainPanel.apply()

        demoRunConfiguration.scriptName = model.scriptName
        demoRunConfiguration.additionalParameters = model.additionalParameters
    }

    override fun createEditor(): JComponent = component()

    private fun component(): JPanel {
        mainPanel = panel {
            row("Script name:") {
                textFieldWithBrowseButton(
                    "Select V script name",
                    project,
                    FileChooserDescriptorFactory.createSingleFileDescriptor()
                )
                    .horizontalAlign(HorizontalAlign.FILL)
                    .bindText(model::scriptName)
            }.bottomGap(BottomGap.SMALL)

            row("Additional parameters:") {
                textField()
                    .horizontalAlign(HorizontalAlign.FILL)
                    .bindText(model::additionalParameters)
            }.bottomGap(BottomGap.SMALL)
        }

        return mainPanel
    }
}
