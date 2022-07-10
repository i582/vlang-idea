package org.vlang.ide.sdk

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.OrderRootType
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.roots.libraries.Library
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar
import com.intellij.openapi.util.text.StringUtil
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.psi.util.CachedValueProvider
import com.intellij.psi.util.CachedValuesManager
import com.intellij.util.ArrayUtil
import com.intellij.util.containers.ContainerUtil
import java.util.*

class VlangSdk(
    val homePath: String,
    val version: String
) {
    companion object {
        const val VLANG_SDK_LIB_NAME = "Vlang SDK"
        private const val UNKNOWN_VERSION = "unknown"

        fun getVlangSdk(project: Project): VlangSdk? {
            return CachedValuesManager.getManager(project).getCachedValue(project) {
                val sdk =
                    findVlangSdkAmongLibraries(LibraryTablesRegistrar.getInstance().getLibraryTable(project).libraries)
                        ?: return@getCachedValue CachedValueProvider.Result<VlangSdk>(
                            null,
                            ProjectRootManager.getInstance(project)
                        )
                val dependencies: MutableList<Any?> = ArrayList(3)
                dependencies.add(ProjectRootManager.getInstance(project))
                ContainerUtil.addIfNotNull(
                    dependencies,
                    LocalFileSystem.getInstance().findFileByPath(sdk.homePath + "/version")
                )
                ContainerUtil.addIfNotNull(
                    dependencies,
                    LocalFileSystem.getInstance().findFileByPath(sdk.homePath + "/lib/core/core.dart")
                )
                CachedValueProvider.Result(sdk, ArrayUtil.toObjectArray(dependencies))
            }
        }

        private fun findVlangSdkAmongLibraries(libs: Array<Library>): VlangSdk? {
            for (library in libs) {
                if (VLANG_SDK_LIB_NAME == library.name) {
                    return getSdkByLibrary(library)
                }
            }
            return null
        }

        fun getSdkByLibrary(library: Library): VlangSdk? {
            val roots = library.getFiles(OrderRootType.CLASSES)
            val dartCoreRoot = VlangLibraryPresentationProvider.findVlangCoreRoot(Arrays.asList(*roots))
            if (dartCoreRoot != null) {
                val homePath = dartCoreRoot.parent.parent.path
                val version = StringUtil.notNullize(VlangSdkUtil.getSdkVersion(homePath), UNKNOWN_VERSION)
                return VlangSdk(homePath, version)
            }
            return null
        }
    }
}