package org.vlang.vmod

import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler
import org.vlang.vmod.psi.VmodTokenTypes

class VmodQuoteHandler : SimpleTokenSetQuoteHandler(VmodTokenTypes.STRING_LITERALS)
