package org.vlang.lang.vmod.psi

import com.intellij.psi.tree.IElementType
import org.vlang.lang.vmod.VmodLanguage

class VmodTokenType(debugName: String) : IElementType(debugName, VmodLanguage.INSTANCE) {
    override fun toString() = "VmodTokenType." + super.toString()
}
