package org.vlang.vmod.lexer

import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.MergingLexerAdapter
import com.intellij.psi.tree.TokenSet
import org.vlang.lang.vmod._VmodLexer
import org.vlang.vmod.psi.VmodTokenTypes

class VmodLexer : MergingLexerAdapter(
    FlexAdapter(_VmodLexer()),
    TokenSet.orSet(VmodTokenTypes.COMMENTS, VmodTokenTypes.WHITE_SPACES)
)
