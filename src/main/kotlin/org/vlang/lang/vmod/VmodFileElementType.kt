package org.vlang.lang.vmod

import com.intellij.psi.tree.IFileElementType

class VmodFileElementType: IFileElementType("VLANG_FILE", VmodLanguage.INSTANCE) {
    companion object {
        val INSTANCE = VmodFileElementType()
    }
}
