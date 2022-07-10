package org.vlang.lang.vmod;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static org.vlang.vmod.psi.VmodTokenTypes.*;

%%

%{
  public _VmodLexer() {
    this((java.io.Reader)null);
 }
%}

%class _VmodLexer
%implements FlexLexer, VmodTypes
%unicode
%public

%function advance
%type IElementType

NL = \n
WS = [ \t\f]

LINE_COMMENT = "//" [^\r\n]*
MULTILINE_COMMENT = "/*" ( ([^"*"]|[\r\n])* ("*"+ [^"*""/"] )? )* ("*" | "*"+"/")?

LETTER = [:letter:] | "_"
DIGIT =  [:digit:]

IDENT = {LETTER} ({LETTER} | {DIGIT} )*

STR_SINGLE =   "'"

SINGLE_QUOTE_STRING = {STR_SINGLE} ( [^\'\\] | "\\" ("\\" | {STR_SINGLE} | {ESCAPES} | [0-8xuU] ) )* {STR_SINGLE}

ESCAPES = [abfnrtve] // TODO: need "e"?

%state MAYBE_SEMICOLON

%%

<YYINITIAL> {
{WS}                                      { return WS; }
{NL}+                                     { return NLS; }

{LINE_COMMENT}                            { return LINE_COMMENT; }
{MULTILINE_COMMENT}                       { return MULTILINE_COMMENT; }

{SINGLE_QUOTE_STRING}                     { yybegin(MAYBE_SEMICOLON); return STRING; }

"Module"                                  { return MODULE; }

"{"                                       { return LBRACE; }
"}"                                       { return RBRACE; }

"["                                       { return LBRACK; }
"]"                                       { yybegin(MAYBE_SEMICOLON); return RBRACK; }

"("                                       { return LPAREN; }
")"                                       { yybegin(MAYBE_SEMICOLON); return RPAREN; }

":"                                       { yybegin(MAYBE_SEMICOLON); return COLON; }
","                                       { return COMMA; }

"'"                                       { return SINGLE_QUOTE; }

{IDENT}                                   { yybegin(MAYBE_SEMICOLON); return IDENTIFIER; }

.                                         { return BAD_CHARACTER; }
}

<MAYBE_SEMICOLON> {
{WS}                                      { return WS; }
{NL}                                      { yybegin(YYINITIAL); yypushback(yytext().length()); return SEMICOLON_SYNTHETIC; }
{LINE_COMMENT}                            { return LINE_COMMENT; }
{MULTILINE_COMMENT}                       { return MULTILINE_COMMENT; }
.                                         { yybegin(YYINITIAL); yypushback(yytext().length()); }
}
