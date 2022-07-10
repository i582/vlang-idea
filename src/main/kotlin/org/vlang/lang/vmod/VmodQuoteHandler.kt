package org.vlang.lang.vmod

import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler
import org.vlang.lang.vmod.psi.VmodTokenTypes

class VmodQuoteHandler : SimpleTokenSetQuoteHandler(VmodTokenTypes.STRING_LITERALS)
