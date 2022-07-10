package org.vlang.lang.vmod.lexer

import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.MergingLexerAdapter
import com.intellij.psi.tree.TokenSet
import org.vlang.lang._VlangLexer
import org.vlang.lang.psi.VlangTokenTypes
import org.vlang.lang.vmod._VmodLexer

class VmodLexer : MergingLexerAdapter(
    FlexAdapter(_VmodLexer()),
    TokenSet.orSet(VlangTokenTypes.COMMENTS, VlangTokenTypes.WHITE_SPACES)
)
