package org.vlang.ide.test.configuration

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.dsl.builder.*
import com.intellij.ui.dsl.gridLayout.HorizontalAlign
import org.vlang.ide.run.VlangRunConfiguration
import javax.swing.JComponent
import javax.swing.JPanel

open class VlangTestConfigurationEditor(private val project: Project) : SettingsEditor<VlangTestConfiguration>() {
    data class Model(
        var testFile: String = "",
        var additionalParameters: String = "",
    )

    private lateinit var mainPanel: DialogPanel
    private val model = Model()

    override fun resetEditorFrom(demoRunConfiguration: VlangTestConfiguration) {
        model.testFile = demoRunConfiguration.testFile
        model.additionalParameters = demoRunConfiguration.additionalParameters

        mainPanel.reset()
    }

    override fun applyEditorTo(demoRunConfiguration: VlangTestConfiguration) {
        mainPanel.apply()

        demoRunConfiguration.testFile = model.testFile
        demoRunConfiguration.additionalParameters = model.additionalParameters
    }

    override fun createEditor(): JComponent = component()

    private fun component(): JPanel {
        mainPanel = panel {
            row("Test file:") {
                textFieldWithBrowseButton(
                    "Select V test name",
                    project,
                    FileChooserDescriptorFactory.createSingleFileDescriptor()
                )
                    .horizontalAlign(HorizontalAlign.FILL)
                    .bindText(model::testFile)
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
