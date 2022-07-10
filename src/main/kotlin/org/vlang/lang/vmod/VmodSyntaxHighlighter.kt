package org.vlang.lang.vmod

import com.intellij.ide.highlighter.JavaHighlightingColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.vlang.lang.vmod.lexer.VmodLexer
import org.vlang.lang.vmod.psi.VmodTokenTypes

class VmodSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer() = VmodLexer()

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        val attr = when {
            VmodTokenTypes.STRING_LITERALS.contains(tokenType) -> JavaHighlightingColors.STRING
            VmodTokenTypes.KEYWORDS.contains(tokenType) -> JavaHighlightingColors.KEYWORD
            VmodTokenTypes.COMMENTS.contains(tokenType) -> JavaHighlightingColors.LINE_COMMENT
            else -> null
        }

        return if (attr == null) emptyArray() else arrayOf(attr)
    }
}
