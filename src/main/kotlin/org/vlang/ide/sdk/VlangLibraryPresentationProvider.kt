package org.vlang.ide.sdk

import com.intellij.openapi.roots.libraries.DummyLibraryProperties
import com.intellij.openapi.roots.libraries.LibraryKind
import com.intellij.openapi.roots.libraries.LibraryPresentationProvider
import com.intellij.openapi.vfs.VirtualFile
import org.vlang.ide.ui.PluginIcons

class VlangLibraryPresentationProvider : LibraryPresentationProvider<DummyLibraryProperties?>(KIND) {
    override fun getIcon(properties: DummyLibraryProperties?) = PluginIcons.vlang

    override fun detect(classesRoots: List<VirtualFile>): DummyLibraryProperties? {
        if (findVlangCoreRoot(classesRoots) == null) {
            return null
        }

        return DummyLibraryProperties.INSTANCE
    }

    companion object {
        private val KIND = LibraryKind.create("vlang")

        fun findVlangCoreRoot(classesRoots: List<VirtualFile>): VirtualFile? {
            for (root in classesRoots) {
                if (root.isInLocalFileSystem &&
                    root.isDirectory &&
                    root.path.endsWith("/lib/core") && root.findChild("core.dart") != null
                ) {
                    return root
                }
            }
            return null
        }
    }
}
