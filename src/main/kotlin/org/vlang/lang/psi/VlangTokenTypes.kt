package org.vlang.lang.psi

import com.intellij.psi.tree.TokenSet
import org.vlang.lang.VlangTypes.*

object VlangTokenTypes {
    @JvmField
    val LINE_COMMENT = VlangTokenType("VLANG_LINE_COMMENT")

    @JvmField
    val MULTILINE_COMMENT = VlangTokenType("VLANG_MULTILINE_COMMENT")

    @JvmField
    val ASM_LINE_COMMENT = VlangTokenType("ASM_LINE_COMMENT")

    @JvmField
    val WS = VlangTokenType("VLANG_WHITESPACE")

    @JvmField
    val NLS = VlangTokenType("VLANG_WS_NEW_LINES")

    val COMMENTS = TokenSet.create(LINE_COMMENT, MULTILINE_COMMENT, VlangDocTokenTypes.DOC_COMMENT, ASM_LINE_COMMENT)
    val STRING_LITERALS = TokenSet.create(STRING, RAW_STRING, CHAR)
    val NUMBERS = TokenSet.create(
        INT,
        FLOAT,
        FLOATI,
        DECIMALI,
        FLOATI,
        HEX,
        OCT,
        BIN
    )

    val KEYWORDS = TokenSet.create(
        BREAK,
        CASE,
        CHAN,
        CONST,
        CONTINUE,
        DEFAULT,
        DEFER,
        ELSE,
        FALLTHROUGH,
        FOR,
        FN,
        GO,
        GOTO,
        IF,
        IMPORT,
        INTERFACE,
        MODULE,
        IN,
        NOT_IN,
        RETURN,
        SELECT,
        STRUCT,
        SWITCH,
        TYPE_,
        PUB,
        AS,
        MUT,
        IF_COMPILE_TIME,
        ELSE_COMPILE_TIME,
        UNSAFE,
        BUILTIN_GLOBAL,
        ASSERT,
        ENUM,
        MATCH,
        C_INCLUDE,
        C_FLAG,
        OR,
        IS,
        NOT_IS,
        FOR_COMPILE_TIME,
        UNION,
        LOCK,
        RLOCK,
        SHARED,
        ASM,
        VOLATILE,
    )

    val OPERATORS = TokenSet.create(
        EQ,
        ASSIGN,
        NOT_EQ,
        NOT,
        PLUS_PLUS,
        PLUS_ASSIGN,
        PLUS,
        MINUS_MINUS,
        MINUS_ASSIGN,
        MINUS,
        COND_OR,
        BIT_OR_ASSIGN,
        BIT_OR,
        BIT_CLEAR_ASSIGN,
        BIT_CLEAR,
        COND_AND,
        BIT_AND_ASSIGN,
        BIT_AND,
        SHIFT_LEFT_ASSIGN,
        SHIFT_LEFT,
        SEND_CHANNEL,
        LESS_OR_EQUAL,
        LESS,
        BIT_XOR_ASSIGN,
        BIT_XOR,
        MUL_ASSIGN,
        MUL,
        QUOTIENT_ASSIGN,
        QUOTIENT,
        REMAINDER_ASSIGN,
        REMAINDER,
        SHIFT_RIGHT_ASSIGN,
        SHIFT_RIGHT,
        GREATER_OR_EQUAL,
        GREATER,
        VAR_ASSIGN
    )

    val WHITE_SPACES = TokenSet.create(WS, NLS)
}
