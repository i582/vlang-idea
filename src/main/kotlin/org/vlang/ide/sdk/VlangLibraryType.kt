package org.vlang.ide.sdk

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.libraries.LibraryType
import com.intellij.openapi.roots.libraries.NewLibraryConfiguration
import com.intellij.openapi.roots.libraries.PersistentLibraryKind
import com.intellij.openapi.roots.libraries.ui.LibraryEditorComponent
import com.intellij.openapi.roots.libraries.ui.LibraryPropertiesEditor
import com.intellij.openapi.vfs.VirtualFile
import org.vlang.ide.ui.PluginIcons
import javax.swing.JComponent

class VlangLibraryType : LibraryType<VlangPackagesLibraryProperties>(LIBRARY_KIND) {
    override fun getCreateActionName() = null

    override fun createNewLibrary(
        parentComponent: JComponent,
        contextDirectory: VirtualFile?,
        project: Project
    ): NewLibraryConfiguration? {
        return null
    }

    override fun createPropertiesEditor(editorComponent: LibraryEditorComponent<VlangPackagesLibraryProperties?>): LibraryPropertiesEditor? {
        return null
    }

    override fun getIcon(properties: VlangPackagesLibraryProperties?) = PluginIcons.vlang

    companion object {
        const val VLANG_PACKAGES_LIBRARY_NAME = "Vlang Packages"

        val LIBRARY_KIND: PersistentLibraryKind<VlangPackagesLibraryProperties> =
            object : PersistentLibraryKind<VlangPackagesLibraryProperties>("VlangPackagesLibraryType") {
                override fun createDefaultProperties(): VlangPackagesLibraryProperties {
                    return VlangPackagesLibraryProperties()
                }
            }
    }
}
