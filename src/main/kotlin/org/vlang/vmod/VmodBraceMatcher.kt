package org.vlang.vmod

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import org.vlang.lang.vmod.VmodTypes

class VmodBraceMatcher : PairedBraceMatcher {
    override fun getPairs() = arrayOf(
        BracePair(VmodTypes.LBRACE, VmodTypes.RBRACE, true),
        BracePair(VmodTypes.LBRACK, VmodTypes.RBRACK, true),
        BracePair(VmodTypes.LPAREN, VmodTypes.RPAREN, true)
    )

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?) = true

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int) = openingBraceOffset
}
