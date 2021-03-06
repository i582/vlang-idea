package org.vlang.lang.stubs.index

import com.intellij.openapi.project.Project
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StringStubIndexExtension
import com.intellij.psi.stubs.StubIndex
import com.intellij.psi.stubs.StubIndexKey
import com.intellij.util.Processor
import com.intellij.util.indexing.IdFilter
import org.vlang.lang.VlangFileElementType
import org.vlang.lang.psi.VlangFunctionDeclaration
import org.vlang.lang.psi.VlangStructDeclaration

class VlangStructIndex : StringStubIndexExtension<VlangStructDeclaration>() {
    companion object {
        val KEY = StubIndexKey.createIndexKey<String, VlangStructDeclaration>("vlang.struct")

        fun find(
            name: String,
            project: Project,
            scope: GlobalSearchScope?,
            idFilter: IdFilter?
        ): Collection<VlangStructDeclaration> {
            return StubIndex.getElements(KEY, name, project, scope, idFilter, VlangStructDeclaration::class.java)
        }

        fun process(
            name: String,
            project: Project,
            scope: GlobalSearchScope?,
            idFilter: IdFilter?,
            processor: Processor<VlangStructDeclaration>
        ): Boolean {
            return StubIndex.getInstance().processElements(
                KEY, name, project, scope, idFilter,
                VlangStructDeclaration::class.java, processor
            )
        }

        fun getAll(project: Project): List<VlangStructDeclaration> {
            val result = mutableListOf<VlangStructDeclaration>()
            for (key in StubIndex.getInstance().getAllKeys(KEY, project)) {
                val els = StubIndex.getElements(
                    KEY,
                    key,
                    project,
                    GlobalSearchScope.allScope(project),
                    null,
                    VlangStructDeclaration::class.java
                )
                result.addAll(els)
            }

            return result
        }
    }

    override fun getVersion() = VlangFileElementType.VERSION + 3

    override fun getKey() = KEY
}
