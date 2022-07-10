package org.vlang.ide.sdk

import com.intellij.openapi.roots.libraries.LibraryProperties
import com.intellij.util.xmlb.XmlSerializerUtil
import com.intellij.util.xmlb.annotations.MapAnnotation
import java.util.*

class VlangPackagesLibraryProperties : LibraryProperties<VlangPackagesLibraryProperties>() {
    @get:MapAnnotation(surroundWithTag = false)
    var packageNameToDirsMap: Map<String, List<String>> = TreeMap()

    override fun getState() = this

    override fun loadState(state: VlangPackagesLibraryProperties) {
        XmlSerializerUtil.copyBean(state, this)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as VlangPackagesLibraryProperties

        if (packageNameToDirsMap != other.packageNameToDirsMap) return false

        return true
    }

    override fun hashCode(): Int = packageNameToDirsMap.hashCode()
}
