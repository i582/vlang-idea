package org.vlang.ide.test

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ProjectFileIndex
import com.intellij.openapi.roots.TestSourcesFilter
import com.intellij.openapi.vfs.VirtualFile

class VlangTestSourcesFilter : TestSourcesFilter() {
    override fun isTestSource(file: VirtualFile, project: Project): Boolean {
        if (!file.isInLocalFileSystem) {
            return false
        }

        val fileIndex = ProjectFileIndex.getInstance(project)
        if (!fileIndex.isInContent(file)) {
            return false
        }

        if (!file.name.endsWith("_test.v")) {
            return false
        }

        return true
    }
}
