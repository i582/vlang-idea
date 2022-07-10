package org.vlang.vmod.psi

import com.intellij.psi.tree.TokenSet
import org.vlang.lang.vmod.VmodTypes.*

object VmodTokenTypes {
    @JvmField
    val LINE_COMMENT = VmodTokenType("VLANG_LINE_COMMENT")

    @JvmField
    val MULTILINE_COMMENT = VmodTokenType("VLANG_MULTILINE_COMMENT")

    @JvmField
    val WS = VmodTokenType("VLANG_WHITESPACE")

    @JvmField
    val NLS = VmodTokenType("VLANG_WS_NEW_LINES")

    val COMMENTS = TokenSet.create(LINE_COMMENT, MULTILINE_COMMENT)

    val STRING_LITERALS = TokenSet.create(STRING, SINGLE_QUOTE)

    val KEYWORDS = TokenSet.create(
        MODULE
    )

    val WHITE_SPACES = TokenSet.create(WS, NLS)
}
