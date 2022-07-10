package org.vlang.ide.highlight

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey

object VlangHighlightingData {
    val VLANG_LABEL =
        TextAttributesKey.createTextAttributesKey("VLANG_LABEL", DefaultLanguageHighlighterColors.LABEL)

    val VLANG_FUNCTION_NAME =
        TextAttributesKey.createTextAttributesKey(
            "VLANG_FUNCTION_NAME",
            DefaultLanguageHighlighterColors.FUNCTION_DECLARATION
        )

    val VLANG_PUBLIC_FUNCTION_NAME =
        TextAttributesKey.createTextAttributesKey(
            "VLANG_PUBLIC_FUNCTION_NAME",
            DefaultLanguageHighlighterColors.FUNCTION_DECLARATION
        )
}
