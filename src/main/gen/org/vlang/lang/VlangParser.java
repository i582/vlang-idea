// This is a generated file. Not intended for manual editing.
package org.vlang.lang;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.vlang.lang.VlangTypes.*;
import static org.vlang.lang.VlangParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class VlangParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return File(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(RANGE_CLAUSE, VAR_DECLARATION),
    create_token_set_(ARRAY_OR_SLICE_TYPE, CHANNEL_TYPE, FUNCTION_TYPE, INTERFACE_TYPE,
      MAP_TYPE, NULLABLE_TYPE, POINTER_TYPE, STRUCT_TYPE,
      TYPE_DECL),
    create_token_set_(ASM_BLOCK_STATEMENT, ASSERT_STATEMENT, ASSIGNMENT_STATEMENT, BREAK_STATEMENT,
      COMPILE_ELSE_STATEMENT, COMPILE_TIME_FOR_STATEMENT, COMPILE_TIME_IF_STATEMENT, CONTINUE_STATEMENT,
      C_FLAG_STATEMENT, C_INCLUDE_STATEMENT, DEFER_STATEMENT, ELSE_STATEMENT,
      FOR_STATEMENT, GOTO_STATEMENT, GO_STATEMENT, IF_STATEMENT,
      INC_DEC_STATEMENT, LANGUAGE_INJECTION_STATEMENT, LOCK_STATEMENT, RETURN_STATEMENT,
      SEND_STATEMENT, SIMPLE_STATEMENT, STATEMENT, UNSAFE_STATEMENT),
    create_token_set_(ADD_EXPR, AND_EXPR, ARRAY_CREATION, AS_EXPRESSION,
      CALL_EXPR, COMPILE_TIME_IF_EXPRESSION, CONDITIONAL_EXPR, CONSTEXPR_IDENTIFIER_EXPRESSION,
      DOT_EXPRESSION, ENUM_FETCH, ERROR_PROPAGATION_EXPRESSION, EXPRESSION,
      FUNCTION_LIT, IF_EXPRESSION, INDEX_OR_SLICE_EXPR, IN_EXPRESSION,
      IS_EXPRESSION, LITERAL, MAP_INIT_EXPR, MATCH_EXPRESSION,
      MUL_EXPR, MUT_EXPRESSION, NOT_IN_EXPRESSION, NOT_IS_EXPRESSION,
      OR_BLOCK_EXPR, OR_EXPR, PARENTHESES_EXPR, RANGE_EXPR,
      REFERENCE_EXPRESSION, SEND_EXPR, STRING_LITERAL, TYPE_INIT_EXPR,
      UNARY_EXPR, UNPACKING_EXPRESSION, UNSAFE_EXPRESSION),
  };

  /* ********************************************************** */
  // '+' | '-' | '|' | '^'
  static boolean AddOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AddOp")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, BIT_OR);
    if (!r) r = consumeToken(b, BIT_XOR);
    return r;
  }

  /* ********************************************************** */
  // TypeDecl
  public static boolean AnonymousFieldDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AnonymousFieldDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANONYMOUS_FIELD_DEFINITION, "<anonymous field definition>");
    r = TypeDecl(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TypeDecl
  public static boolean AnonymousInterfaceDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AnonymousInterfaceDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANONYMOUS_INTERFACE_DEFINITION, "<anonymous interface definition>");
    r = TypeDecl(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '(' [ ExpressionArgList '...'? ','? ] ')'
  public static boolean ArgumentList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT_LIST, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, ArgumentList_1(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [ ExpressionArgList '...'? ','? ]
  private static boolean ArgumentList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList_1")) return false;
    ArgumentList_1_0(b, l + 1);
    return true;
  }

  // ExpressionArgList '...'? ','?
  private static boolean ArgumentList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionArgList(b, l + 1);
    r = r && ArgumentList_1_0_1(b, l + 1);
    r = r && ArgumentList_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '...'?
  private static boolean ArgumentList_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList_1_0_1")) return false;
    consumeToken(b, TRIPLE_DOT);
    return true;
  }

  // ','?
  private static boolean ArgumentList_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // ExpressionWithRecover (',' (ExpressionWithRecover | &']'))*
  public static boolean ArrayCreationList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayCreationList")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_CREATION_LIST, "<array creation list>");
    r = ExpressionWithRecover(b, l + 1);
    p = r; // pin = 1
    r = r && ArrayCreationList_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (',' (ExpressionWithRecover | &']'))*
  private static boolean ArrayCreationList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayCreationList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ArrayCreationList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ArrayCreationList_1", c)) break;
    }
    return true;
  }

  // ',' (ExpressionWithRecover | &']')
  private static boolean ArrayCreationList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayCreationList_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && ArrayCreationList_1_0_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ExpressionWithRecover | &']'
  private static boolean ArrayCreationList_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayCreationList_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionWithRecover(b, l + 1);
    if (!r) r = ArrayCreationList_1_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &']'
  private static boolean ArrayCreationList_1_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayCreationList_1_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, RBRACK);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '[' Expression? ']' TypeDecl
  public static boolean ArrayOrSliceType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayOrSliceType")) return false;
    if (!nextTokenIs(b, LBRACK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_OR_SLICE_TYPE, null);
    r = consumeToken(b, LBRACK);
    p = r; // pin = 1
    r = r && report_error_(b, ArrayOrSliceType_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, RBRACK)) && r;
    r = p && TypeDecl(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // Expression?
  private static boolean ArrayOrSliceType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayOrSliceType_1")) return false;
    Expression(b, l + 1, -1);
    return true;
  }

  /* ********************************************************** */
  // '{' ('}' | (ASM_LINE)* '}')
  public static boolean AsmBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmBlock")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ASM_BLOCK, null);
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && AsmBlock_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // '}' | (ASM_LINE)* '}'
  private static boolean AsmBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmBlock_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RBRACE);
    if (!r) r = AsmBlock_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ASM_LINE)* '}'
  private static boolean AsmBlock_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmBlock_1_1")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = AsmBlock_1_1_0(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (ASM_LINE)*
  private static boolean AsmBlock_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmBlock_1_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, ASM_LINE)) break;
      if (!empty_element_parsed_guard_(b, "AsmBlock_1_1_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // asm volatile? identifier AsmBlock
  public static boolean AsmBlockStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmBlockStatement")) return false;
    if (!nextTokenIs(b, ASM)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ASM_BLOCK_STATEMENT, null);
    r = consumeToken(b, ASM);
    p = r; // pin = 1
    r = r && report_error_(b, AsmBlockStatement_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, IDENTIFIER)) && r;
    r = p && AsmBlock(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // volatile?
  private static boolean AsmBlockStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AsmBlockStatement_1")) return false;
    consumeToken(b, VOLATILE);
    return true;
  }

  /* ********************************************************** */
  // assert Expression
  public static boolean AssertStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssertStatement")) return false;
    if (!nextTokenIs(b, ASSERT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSERT);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, ASSERT_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // '=' | '+=' | '-=' | '|=' | '^=' | '*=' | '/=' | '%=' | '<<=' | '>>=' | '&=' | '&^='
  public static boolean AssignOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_OP, "<assign op>");
    r = consumeToken(b, ASSIGN);
    if (!r) r = consumeToken(b, PLUS_ASSIGN);
    if (!r) r = consumeToken(b, MINUS_ASSIGN);
    if (!r) r = consumeToken(b, BIT_OR_ASSIGN);
    if (!r) r = consumeToken(b, BIT_XOR_ASSIGN);
    if (!r) r = consumeToken(b, MUL_ASSIGN);
    if (!r) r = consumeToken(b, QUOTIENT_ASSIGN);
    if (!r) r = consumeToken(b, REMAINDER_ASSIGN);
    if (!r) r = consumeToken(b, SHIFT_LEFT_ASSIGN);
    if (!r) r = consumeToken(b, SHIFT_RIGHT_ASSIGN);
    if (!r) r = consumeToken(b, BIT_AND_ASSIGN);
    if (!r) r = consumeToken(b, BIT_CLEAR_ASSIGN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // AssignOp (ExpressionList | MapInitExpr)
  public static boolean AssignmentStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignmentStatement")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _LEFT_, ASSIGNMENT_STATEMENT, "<assignment statement>");
    r = AssignOp(b, l + 1);
    p = r; // pin = 1
    r = r && AssignmentStatement_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ExpressionList | MapInitExpr
  private static boolean AssignmentStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignmentStatement_1")) return false;
    boolean r;
    r = ExpressionList(b, l + 1);
    if (!r) r = MapInitExpr(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // '[' AttributeExpression (';' AttributeExpression)* ']'
  public static boolean Attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Attribute")) return false;
    if (!nextTokenIs(b, LBRACK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE, null);
    r = consumeToken(b, LBRACK);
    p = r; // pin = 1
    r = r && report_error_(b, AttributeExpression(b, l + 1));
    r = p && report_error_(b, Attribute_2(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACK) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (';' AttributeExpression)*
  private static boolean Attribute_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Attribute_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Attribute_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Attribute_2", c)) break;
    }
    return true;
  }

  // ';' AttributeExpression
  private static boolean Attribute_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Attribute_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMICOLON);
    r = r && AttributeExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IfAttribute | PlainAttribute
  public static boolean AttributeExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_EXPRESSION, "<attribute expression>");
    r = IfAttribute(b, l + 1);
    if (!r) r = PlainAttribute(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Attribute (semi Attribute)* semi?
  public static boolean Attributes(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Attributes")) return false;
    if (!nextTokenIs(b, LBRACK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTES, null);
    r = Attribute(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, Attributes_1(b, l + 1));
    r = p && Attributes_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (semi Attribute)*
  private static boolean Attributes_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Attributes_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Attributes_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Attributes_1", c)) break;
    }
    return true;
  }

  // semi Attribute
  private static boolean Attributes_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Attributes_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = semi(b, l + 1);
    r = r && Attribute(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // semi?
  private static boolean Attributes_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Attributes_2")) return false;
    semi(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // BlockInner
  public static boolean Block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Block")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BlockInner(b, l + 1);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // '{' ('}' | Statements '}')
  static boolean BlockInner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlockInner")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && BlockInner_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // '}' | Statements '}'
  private static boolean BlockInner_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlockInner_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RBRACE);
    if (!r) r = BlockInner_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Statements '}'
  private static boolean BlockInner_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlockInner_1_1")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = Statements(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // BlockInner
  public static boolean BlockWithConsume(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlockWithConsume")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BlockInner(b, l + 1);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // break LabelRef?
  public static boolean BreakStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BreakStatement")) return false;
    if (!nextTokenIs(b, BREAK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BREAK);
    r = r && BreakStatement_1(b, l + 1);
    exit_section_(b, m, BREAK_STATEMENT, r);
    return r;
  }

  // LabelRef?
  private static boolean BreakStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BreakStatement_1")) return false;
    LabelRef(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // C_FLAG C_FLAG_VALUE
  public static boolean CFlagStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CFlagStatement")) return false;
    if (!nextTokenIs(b, C_FLAG)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, C_FLAG_STATEMENT, null);
    r = consumeTokens(b, 1, C_FLAG, C_FLAG_VALUE);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // C_INCLUDE StringLiteral
  public static boolean CIncludeStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CIncludeStatement")) return false;
    if (!nextTokenIs(b, C_INCLUDE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, C_INCLUDE_STATEMENT, null);
    r = consumeToken(b, C_INCLUDE);
    p = r; // pin = 1
    r = r && StringLiteral(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // chan TypeDecl
  public static boolean ChannelType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ChannelType")) return false;
    if (!nextTokenIs(b, CHAN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CHANNEL_TYPE, null);
    r = consumeToken(b, CHAN);
    p = r; // pin = 1
    r = r && TypeDecl(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ELSE_COMPILE_TIME (CompileTimeIfStatement | Block)
  public static boolean CompileElseStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompileElseStatement")) return false;
    if (!nextTokenIs(b, ELSE_COMPILE_TIME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, COMPILE_ELSE_STATEMENT, null);
    r = consumeToken(b, ELSE_COMPILE_TIME);
    p = r; // pin = 1
    r = r && CompileElseStatement_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // CompileTimeIfStatement | Block
  private static boolean CompileElseStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompileElseStatement_1")) return false;
    boolean r;
    r = CompileTimeIfStatement(b, l + 1);
    if (!r) r = Block(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // FOR_COMPILE_TIME (ForOrRangeClause Block | Block | Expression Block)
  public static boolean CompileTimeForStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompileTimeForStatement")) return false;
    if (!nextTokenIs(b, FOR_COMPILE_TIME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, COMPILE_TIME_FOR_STATEMENT, null);
    r = consumeToken(b, FOR_COMPILE_TIME);
    p = r; // pin = 1
    r = r && CompileTimeForStatement_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ForOrRangeClause Block | Block | Expression Block
  private static boolean CompileTimeForStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompileTimeForStatement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CompileTimeForStatement_1_0(b, l + 1);
    if (!r) r = Block(b, l + 1);
    if (!r) r = CompileTimeForStatement_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ForOrRangeClause Block
  private static boolean CompileTimeForStatement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompileTimeForStatement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ForOrRangeClause(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expression Block
  private static boolean CompileTimeForStatement_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompileTimeForStatement_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1, -1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CompileTimeIfExpression
  public static boolean CompileTimeIfStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompileTimeIfStatement")) return false;
    if (!nextTokenIs(b, IF_COMPILE_TIME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CompileTimeIfExpression(b, l + 1);
    exit_section_(b, m, COMPILE_TIME_IF_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // SimpleStatementOpt Expression? '?'?
  static boolean Condition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Condition")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SimpleStatementOpt(b, l + 1);
    r = r && Condition_1(b, l + 1);
    r = r && Condition_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expression?
  private static boolean Condition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Condition_1")) return false;
    Expression(b, l + 1, -1);
    return true;
  }

  // '?'?
  private static boolean Condition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Condition_2")) return false;
    consumeToken(b, QUESTION);
    return true;
  }

  /* ********************************************************** */
  // SymbolVisibility? const ( ConstSpec | '(' ConstSpecs? ')' )
  public static boolean ConstDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstDeclaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONST_DECLARATION, "<const declaration>");
    r = ConstDeclaration_0(b, l + 1);
    r = r && consumeToken(b, CONST);
    p = r; // pin = 2
    r = r && ConstDeclaration_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // SymbolVisibility?
  private static boolean ConstDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstDeclaration_0")) return false;
    SymbolVisibility(b, l + 1);
    return true;
  }

  // ConstSpec | '(' ConstSpecs? ')'
  private static boolean ConstDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstDeclaration_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ConstSpec(b, l + 1);
    if (!r) r = ConstDeclaration_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' ConstSpecs? ')'
  private static boolean ConstDeclaration_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstDeclaration_2_1")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, LPAREN);
    r = r && ConstDeclaration_2_1_1(b, l + 1);
    p = r; // pin = 2
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ConstSpecs?
  private static boolean ConstDeclaration_2_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstDeclaration_2_1_1")) return false;
    ConstSpecs(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier
  public static boolean ConstDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstDefinition")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, CONST_DEFINITION, r);
    return r;
  }

  /* ********************************************************** */
  // ConstDefinition ( ',' ConstDefinition )*
  static boolean ConstDefinitionList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstDefinitionList")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = ConstDefinition(b, l + 1);
    p = r; // pin = 1
    r = r && ConstDefinitionList_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( ',' ConstDefinition )*
  private static boolean ConstDefinitionList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstDefinitionList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ConstDefinitionList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ConstDefinitionList_1", c)) break;
    }
    return true;
  }

  // ',' ConstDefinition
  private static boolean ConstDefinitionList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstDefinitionList_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && ConstDefinition(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ConstDefinitionList [ ('=' ExpressionList | TypeDecl '=' ExpressionList) ]
  public static boolean ConstSpec(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstSpec")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONST_SPEC, null);
    r = ConstDefinitionList(b, l + 1);
    p = r; // pin = 1
    r = r && ConstSpec_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [ ('=' ExpressionList | TypeDecl '=' ExpressionList) ]
  private static boolean ConstSpec_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstSpec_1")) return false;
    ConstSpec_1_0(b, l + 1);
    return true;
  }

  // '=' ExpressionList | TypeDecl '=' ExpressionList
  private static boolean ConstSpec_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstSpec_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ConstSpec_1_0_0(b, l + 1);
    if (!r) r = ConstSpec_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '=' ExpressionList
  private static boolean ConstSpec_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstSpec_1_0_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, ASSIGN);
    p = r; // pin = 1
    r = r && ExpressionList(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // TypeDecl '=' ExpressionList
  private static boolean ConstSpec_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstSpec_1_0_1")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = TypeDecl(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, ASSIGN));
    r = p && ExpressionList(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ConstSpec (semi ConstSpec)* semi?
  static boolean ConstSpecs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstSpecs")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = ConstSpec(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, ConstSpecs_1(b, l + 1));
    r = p && ConstSpecs_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (semi ConstSpec)*
  private static boolean ConstSpecs_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstSpecs_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ConstSpecs_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ConstSpecs_1", c)) break;
    }
    return true;
  }

  // semi ConstSpec
  private static boolean ConstSpecs_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstSpecs_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = semi(b, l + 1);
    r = r && ConstSpec(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // semi?
  private static boolean ConstSpecs_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstSpecs_2")) return false;
    semi(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // continue LabelRef?
  public static boolean ContinueStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContinueStatement")) return false;
    if (!nextTokenIs(b, CONTINUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONTINUE);
    r = r && ContinueStatement_1(b, l + 1);
    exit_section_(b, m, CONTINUE_STATEMENT, r);
    return r;
  }

  // LabelRef?
  private static boolean ContinueStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContinueStatement_1")) return false;
    LabelRef(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '=' Expression
  public static boolean DefaultFieldValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DefaultFieldValue")) return false;
    if (!nextTokenIs(b, ASSIGN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, DEFAULT_FIELD_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // defer Block
  public static boolean DeferStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DeferStatement")) return false;
    if (!nextTokenIs(b, DEFER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEFER);
    r = r && Block(b, l + 1);
    exit_section_(b, m, DEFER_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // else (IfStatement | Block)
  public static boolean ElseStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ElseStatement")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ELSE_STATEMENT, null);
    r = consumeToken(b, ELSE);
    p = r; // pin = 1
    r = r && ElseStatement_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // IfStatement | Block
  private static boolean ElseStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ElseStatement_1")) return false;
    boolean r;
    r = IfStatement(b, l + 1);
    if (!r) r = Block(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // Attributes? SymbolVisibility? enum identifier '{' EnumFields '}'
  public static boolean EnumDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDeclaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENUM_DECLARATION, "<enum declaration>");
    r = EnumDeclaration_0(b, l + 1);
    r = r && EnumDeclaration_1(b, l + 1);
    r = r && consumeTokens(b, 1, ENUM, IDENTIFIER, LBRACE);
    p = r; // pin = 3
    r = r && report_error_(b, EnumFields(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // Attributes?
  private static boolean EnumDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDeclaration_0")) return false;
    Attributes(b, l + 1);
    return true;
  }

  // SymbolVisibility?
  private static boolean EnumDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDeclaration_1")) return false;
    SymbolVisibility(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier ('=' Expression)?
  public static boolean EnumFieldDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumFieldDeclaration")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENUM_FIELD_DECLARATION, null);
    r = consumeToken(b, IDENTIFIER);
    p = r; // pin = 1
    r = r && EnumFieldDeclaration_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('=' Expression)?
  private static boolean EnumFieldDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumFieldDeclaration_1")) return false;
    EnumFieldDeclaration_1_0(b, l + 1);
    return true;
  }

  // '=' Expression
  private static boolean EnumFieldDeclaration_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumFieldDeclaration_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // EnumFieldDeclaration (semi EnumFieldDeclaration)* semi?
  public static boolean EnumFields(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumFields")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EnumFieldDeclaration(b, l + 1);
    r = r && EnumFields_1(b, l + 1);
    r = r && EnumFields_2(b, l + 1);
    exit_section_(b, m, ENUM_FIELDS, r);
    return r;
  }

  // (semi EnumFieldDeclaration)*
  private static boolean EnumFields_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumFields_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!EnumFields_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "EnumFields_1", c)) break;
    }
    return true;
  }

  // semi EnumFieldDeclaration
  private static boolean EnumFields_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumFields_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = semi(b, l + 1);
    r = r && EnumFieldDeclaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // semi?
  private static boolean EnumFields_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumFields_2")) return false;
    semi(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // NamedExpressionArgList | SimpleExpressionArgList
  static boolean ExpressionArgList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionArgList")) return false;
    boolean r;
    r = NamedExpressionArgList(b, l + 1);
    if (!r) r = SimpleExpressionArgList(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ExpressionWithRecover (',' (ExpressionWithRecover | &')'))*
  static boolean ExpressionList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionList")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = ExpressionWithRecover(b, l + 1);
    p = r; // pin = 1
    r = r && ExpressionList_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (',' (ExpressionWithRecover | &')'))*
  private static boolean ExpressionList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ExpressionList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExpressionList_1", c)) break;
    }
    return true;
  }

  // ',' (ExpressionWithRecover | &')')
  private static boolean ExpressionList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionList_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && ExpressionList_1_0_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ExpressionWithRecover | &')'
  private static boolean ExpressionList_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionList_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionWithRecover(b, l + 1);
    if (!r) r = ExpressionList_1_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &')'
  private static boolean ExpressionList_1_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionList_1_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, RPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !('!' | '?' | '!=' | '%' | '%=' | '&&' | '&' | '&=' | '&^' | '&^=' | '(' | ')' | '*' | '*=' | '+' | '++' | '+=' | ',' | '-' | '--' | '-=' | '...' | '/' | '/=' | ':' | ';' | '<' | '<-' | '<<' | '<<=' | '<=' | '<NL>' | '=' | '==' | '>' | '>=' | '>>' | '>>=' | '[' | ']' | '^' | '^=' | 'type' | '{' | '|' | '|=' | '||' | '}' | break | case | chan | char | const | continue | decimali | default | defer | else | fallthrough | float | floati | for | fn | go | goto | hex | identifier | if | int | interface | oct | return | select | string | raw_string | char | struct | enum | union | switch | var | unsafe | assert | match | asm )
  static boolean ExpressionListRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionListRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !ExpressionListRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '!' | '?' | '!=' | '%' | '%=' | '&&' | '&' | '&=' | '&^' | '&^=' | '(' | ')' | '*' | '*=' | '+' | '++' | '+=' | ',' | '-' | '--' | '-=' | '...' | '/' | '/=' | ':' | ';' | '<' | '<-' | '<<' | '<<=' | '<=' | '<NL>' | '=' | '==' | '>' | '>=' | '>>' | '>>=' | '[' | ']' | '^' | '^=' | 'type' | '{' | '|' | '|=' | '||' | '}' | break | case | chan | char | const | continue | decimali | default | defer | else | fallthrough | float | floati | for | fn | go | goto | hex | identifier | if | int | interface | oct | return | select | string | raw_string | char | struct | enum | union | switch | var | unsafe | assert | match | asm
  private static boolean ExpressionListRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionListRecover_0")) return false;
    boolean r;
    r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, QUESTION);
    if (!r) r = consumeToken(b, NOT_EQ);
    if (!r) r = consumeToken(b, REMAINDER);
    if (!r) r = consumeToken(b, REMAINDER_ASSIGN);
    if (!r) r = consumeToken(b, COND_AND);
    if (!r) r = consumeToken(b, BIT_AND);
    if (!r) r = consumeToken(b, BIT_AND_ASSIGN);
    if (!r) r = consumeToken(b, BIT_CLEAR);
    if (!r) r = consumeToken(b, BIT_CLEAR_ASSIGN);
    if (!r) r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, RPAREN);
    if (!r) r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, MUL_ASSIGN);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, PLUS_PLUS);
    if (!r) r = consumeToken(b, PLUS_ASSIGN);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, MINUS_MINUS);
    if (!r) r = consumeToken(b, MINUS_ASSIGN);
    if (!r) r = consumeToken(b, TRIPLE_DOT);
    if (!r) r = consumeToken(b, QUOTIENT);
    if (!r) r = consumeToken(b, QUOTIENT_ASSIGN);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, LESS);
    if (!r) r = consumeToken(b, SEND_CHANNEL);
    if (!r) r = consumeToken(b, SHIFT_LEFT);
    if (!r) r = consumeToken(b, SHIFT_LEFT_ASSIGN);
    if (!r) r = consumeToken(b, LESS_OR_EQUAL);
    if (!r) r = consumeToken(b, SEMICOLON_SYNTHETIC);
    if (!r) r = consumeToken(b, ASSIGN);
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, GREATER);
    if (!r) r = consumeToken(b, GREATER_OR_EQUAL);
    if (!r) r = consumeToken(b, SHIFT_RIGHT);
    if (!r) r = consumeToken(b, SHIFT_RIGHT_ASSIGN);
    if (!r) r = consumeToken(b, LBRACK);
    if (!r) r = consumeToken(b, RBRACK);
    if (!r) r = consumeToken(b, BIT_XOR);
    if (!r) r = consumeToken(b, BIT_XOR_ASSIGN);
    if (!r) r = consumeToken(b, TYPE_);
    if (!r) r = consumeToken(b, LBRACE);
    if (!r) r = consumeToken(b, BIT_OR);
    if (!r) r = consumeToken(b, BIT_OR_ASSIGN);
    if (!r) r = consumeToken(b, COND_OR);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, BREAK);
    if (!r) r = consumeToken(b, CASE);
    if (!r) r = consumeToken(b, CHAN);
    if (!r) r = consumeToken(b, CHAR);
    if (!r) r = consumeToken(b, CONST);
    if (!r) r = consumeToken(b, CONTINUE);
    if (!r) r = consumeToken(b, DECIMALI);
    if (!r) r = consumeToken(b, DEFAULT);
    if (!r) r = consumeToken(b, DEFER);
    if (!r) r = consumeToken(b, ELSE);
    if (!r) r = consumeToken(b, FALLTHROUGH);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, FLOATI);
    if (!r) r = consumeToken(b, FOR);
    if (!r) r = consumeToken(b, FN);
    if (!r) r = consumeToken(b, GO);
    if (!r) r = consumeToken(b, GOTO);
    if (!r) r = consumeToken(b, HEX);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, IF);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, INTERFACE);
    if (!r) r = consumeToken(b, OCT);
    if (!r) r = consumeToken(b, RETURN);
    if (!r) r = consumeToken(b, SELECT);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, RAW_STRING);
    if (!r) r = consumeToken(b, CHAR);
    if (!r) r = consumeToken(b, STRUCT);
    if (!r) r = consumeToken(b, ENUM);
    if (!r) r = consumeToken(b, UNION);
    if (!r) r = consumeToken(b, SWITCH);
    if (!r) r = consumeToken(b, VAR);
    if (!r) r = consumeToken(b, UNSAFE);
    if (!r) r = consumeToken(b, ASSERT);
    if (!r) r = consumeToken(b, MATCH);
    if (!r) r = consumeToken(b, ASM);
    return r;
  }

  /* ********************************************************** */
  // Expression
  static boolean ExpressionOrTypeWithRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionOrTypeWithRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = Expression(b, l + 1, -1);
    exit_section_(b, l, m, r, false, VlangParser::ExpressionListRecover);
    return r;
  }

  /* ********************************************************** */
  // Expression !':'
  static boolean ExpressionWithRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionWithRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = Expression(b, l + 1, -1);
    r = r && ExpressionWithRecover_1(b, l + 1);
    exit_section_(b, l, m, r, false, VlangParser::ExpressionListRecover);
    return r;
  }

  // !':'
  private static boolean ExpressionWithRecover_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionWithRecover_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, COLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (FieldDefinitionList shared? TypeDecl | AnonymousFieldDefinition) DefaultFieldValue? Attribute? Tag?
  public static boolean FieldDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_DECLARATION, "<field declaration>");
    r = FieldDeclaration_0(b, l + 1);
    r = r && FieldDeclaration_1(b, l + 1);
    r = r && FieldDeclaration_2(b, l + 1);
    r = r && FieldDeclaration_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // FieldDefinitionList shared? TypeDecl | AnonymousFieldDefinition
  private static boolean FieldDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldDeclaration_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FieldDeclaration_0_0(b, l + 1);
    if (!r) r = AnonymousFieldDefinition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FieldDefinitionList shared? TypeDecl
  private static boolean FieldDeclaration_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldDeclaration_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FieldDefinitionList(b, l + 1);
    r = r && FieldDeclaration_0_0_1(b, l + 1);
    r = r && TypeDecl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // shared?
  private static boolean FieldDeclaration_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldDeclaration_0_0_1")) return false;
    consumeToken(b, SHARED);
    return true;
  }

  // DefaultFieldValue?
  private static boolean FieldDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldDeclaration_1")) return false;
    DefaultFieldValue(b, l + 1);
    return true;
  }

  // Attribute?
  private static boolean FieldDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldDeclaration_2")) return false;
    Attribute(b, l + 1);
    return true;
  }

  // Tag?
  private static boolean FieldDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldDeclaration_3")) return false;
    Tag(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // FieldName (',' FieldName)*
  static boolean FieldDefinitionList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldDefinitionList")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = FieldName(b, l + 1);
    p = r; // pin = 1
    r = r && FieldDefinitionList_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (',' FieldName)*
  private static boolean FieldDefinitionList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldDefinitionList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!FieldDefinitionList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FieldDefinitionList_1", c)) break;
    }
    return true;
  }

  // ',' FieldName
  private static boolean FieldDefinitionList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldDefinitionList_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && FieldName(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // FieldInitializationKeyValueList | FieldInitializationValueList
  public static boolean FieldInitialization(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldInitialization")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_INITIALIZATION, "<field initialization>");
    r = FieldInitializationKeyValueList(b, l + 1);
    if (!r) r = FieldInitializationValueList(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Expression
  public static boolean FieldInitializationKey(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldInitializationKey")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_INITIALIZATION_KEY, "<field initialization key>");
    r = Expression(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FieldInitializationKey ':' Expression
  static boolean FieldInitializationKeyValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldInitializationKeyValue")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = FieldInitializationKey(b, l + 1);
    r = r && consumeToken(b, COLON);
    p = r; // pin = 2
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ((FieldInitializationKeyValue | UnpackingExpression) semi)+ semi?
  public static boolean FieldInitializationKeyValueList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldInitializationKeyValueList")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FIELD_INITIALIZATION_KEY_VALUE_LIST, "<field initialization key value list>");
    r = FieldInitializationKeyValueList_0(b, l + 1);
    p = r; // pin = 1
    r = r && FieldInitializationKeyValueList_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ((FieldInitializationKeyValue | UnpackingExpression) semi)+
  private static boolean FieldInitializationKeyValueList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldInitializationKeyValueList_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FieldInitializationKeyValueList_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!FieldInitializationKeyValueList_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FieldInitializationKeyValueList_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (FieldInitializationKeyValue | UnpackingExpression) semi
  private static boolean FieldInitializationKeyValueList_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldInitializationKeyValueList_0_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = FieldInitializationKeyValueList_0_0_0(b, l + 1);
    p = r; // pin = 1
    r = r && semi(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // FieldInitializationKeyValue | UnpackingExpression
  private static boolean FieldInitializationKeyValueList_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldInitializationKeyValueList_0_0_0")) return false;
    boolean r;
    r = FieldInitializationKeyValue(b, l + 1);
    if (!r) r = UnpackingExpression(b, l + 1);
    return r;
  }

  // semi?
  private static boolean FieldInitializationKeyValueList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldInitializationKeyValueList_1")) return false;
    semi(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // Expression
  static boolean FieldInitializationValue(PsiBuilder b, int l) {
    return Expression(b, l + 1, -1);
  }

  /* ********************************************************** */
  // FieldInitializationValue (',' FieldInitializationValue)* ','?
  public static boolean FieldInitializationValueList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldInitializationValueList")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FIELD_INITIALIZATION_VALUE_LIST, "<field initialization value list>");
    r = FieldInitializationValue(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, FieldInitializationValueList_1(b, l + 1));
    r = p && FieldInitializationValueList_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (',' FieldInitializationValue)*
  private static boolean FieldInitializationValueList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldInitializationValueList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!FieldInitializationValueList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FieldInitializationValueList_1", c)) break;
    }
    return true;
  }

  // ',' FieldInitializationValue
  private static boolean FieldInitializationValueList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldInitializationValueList_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && FieldInitializationValue(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ','?
  private static boolean FieldInitializationValueList_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldInitializationValueList_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // ReferenceExpression
  public static boolean FieldLookup(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldLookup")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ReferenceExpression(b, l + 1);
    exit_section_(b, m, FIELD_LOOKUP, r);
    return r;
  }

  /* ********************************************************** */
  // identifier {
  // //  stubClass="org.vlang.lang.stubs.GoFieldDefinitionStub"
  // }
  public static boolean FieldName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && FieldName_1(b, l + 1);
    exit_section_(b, m, FIELD_NAME, r);
    return r;
  }

  // {
  // //  stubClass="org.vlang.lang.stubs.GoFieldDefinitionStub"
  // }
  private static boolean FieldName_1(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // MemberModifiers? FieldDeclaration? (semi Fields)* semi?
  static boolean Fields(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Fields")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = Fields_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, Fields_1(b, l + 1));
    r = p && report_error_(b, Fields_2(b, l + 1)) && r;
    r = p && Fields_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // MemberModifiers?
  private static boolean Fields_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Fields_0")) return false;
    MemberModifiers(b, l + 1);
    return true;
  }

  // FieldDeclaration?
  private static boolean Fields_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Fields_1")) return false;
    FieldDeclaration(b, l + 1);
    return true;
  }

  // (semi Fields)*
  private static boolean Fields_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Fields_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Fields_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Fields_2", c)) break;
    }
    return true;
  }

  // semi Fields
  private static boolean Fields_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Fields_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = semi(b, l + 1);
    r = r && Fields(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // semi?
  private static boolean Fields_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Fields_3")) return false;
    semi(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ModuleClause? ImportList? TopLevelDeclaration*
  static boolean File(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "File")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = File_0(b, l + 1);
    r = r && File_1(b, l + 1);
    r = r && File_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ModuleClause?
  private static boolean File_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "File_0")) return false;
    ModuleClause(b, l + 1);
    return true;
  }

  // ImportList?
  private static boolean File_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "File_1")) return false;
    ImportList(b, l + 1);
    return true;
  }

  // TopLevelDeclaration*
  private static boolean File_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "File_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!TopLevelDeclaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "File_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // SimpleStatement? ';' Expression? ';' SimpleStatement?
  public static boolean ForClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForClause")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOR_CLAUSE, "<for clause>");
    r = ForClause_0(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    r = r && ForClause_2(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    r = r && ForClause_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SimpleStatement?
  private static boolean ForClause_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForClause_0")) return false;
    SimpleStatement(b, l + 1);
    return true;
  }

  // Expression?
  private static boolean ForClause_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForClause_2")) return false;
    Expression(b, l + 1, -1);
    return true;
  }

  // SimpleStatement?
  private static boolean ForClause_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForClause_4")) return false;
    SimpleStatement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LabelRef ':'
  public static boolean ForLabel(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForLabel")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = LabelRef(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, FOR_LABEL, r);
    return r;
  }

  /* ********************************************************** */
  // ForClause | RangeClause
  static boolean ForOrRangeClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForOrRangeClause")) return false;
    boolean r;
    r = ForClause(b, l + 1);
    if (!r) r = RangeClause(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ForLabel? for (ForOrRangeClause Block | Block | Expression Block)
  public static boolean ForStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement")) return false;
    if (!nextTokenIs(b, "<for statement>", FOR, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FOR_STATEMENT, "<for statement>");
    r = ForStatement_0(b, l + 1);
    r = r && consumeToken(b, FOR);
    p = r; // pin = for|ForOrRangeClause
    r = r && ForStatement_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ForLabel?
  private static boolean ForStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_0")) return false;
    ForLabel(b, l + 1);
    return true;
  }

  // ForOrRangeClause Block | Block | Expression Block
  private static boolean ForStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ForStatement_2_0(b, l + 1);
    if (!r) r = Block(b, l + 1);
    if (!r) r = ForStatement_2_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ForOrRangeClause Block
  private static boolean ForStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_2_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = ForOrRangeClause(b, l + 1);
    p = r; // pin = for|ForOrRangeClause
    r = r && Block(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // Expression Block
  private static boolean ForStatement_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStatement_2_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1, -1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Attributes? SymbolVisibility? fn identifier Signature BlockWithConsume?
  public static boolean FunctionDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DECLARATION, "<function declaration>");
    r = FunctionDeclaration_0(b, l + 1);
    r = r && FunctionDeclaration_1(b, l + 1);
    r = r && consumeTokens(b, 2, FN, IDENTIFIER);
    p = r; // pin = 4
    r = r && report_error_(b, Signature(b, l + 1));
    r = p && FunctionDeclaration_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // Attributes?
  private static boolean FunctionDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclaration_0")) return false;
    Attributes(b, l + 1);
    return true;
  }

  // SymbolVisibility?
  private static boolean FunctionDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclaration_1")) return false;
    SymbolVisibility(b, l + 1);
    return true;
  }

  // BlockWithConsume?
  private static boolean FunctionDeclaration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclaration_5")) return false;
    BlockWithConsume(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // fn Signature
  public static boolean FunctionType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType")) return false;
    if (!nextTokenIs(b, FN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_TYPE, null);
    r = consumeToken(b, FN);
    p = r; // pin = 1
    r = r && Signature(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // Attributes? BUILTIN_GLOBAL identifier '=' Expression
  public static boolean GlobalVariableDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GlobalVariableDeclaration")) return false;
    if (!nextTokenIs(b, "<global variable declaration>", BUILTIN_GLOBAL, LBRACK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, GLOBAL_VARIABLE_DECLARATION, "<global variable declaration>");
    r = GlobalVariableDeclaration_0(b, l + 1);
    r = r && consumeTokens(b, 2, BUILTIN_GLOBAL, IDENTIFIER, ASSIGN);
    p = r; // pin = 3
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // Attributes?
  private static boolean GlobalVariableDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GlobalVariableDeclaration_0")) return false;
    Attributes(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // go Expression
  public static boolean GoStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GoStatement")) return false;
    if (!nextTokenIs(b, GO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GO);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, GO_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // goto LabelRef
  public static boolean GotoStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GotoStatement")) return false;
    if (!nextTokenIs(b, GOTO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GOTO);
    r = r && LabelRef(b, l + 1);
    exit_section_(b, m, GOTO_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // if '!'? identifier '?'?
  public static boolean IfAttribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfAttribute")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IF_ATTRIBUTE, null);
    r = consumeToken(b, IF);
    p = r; // pin = 1
    r = r && report_error_(b, IfAttribute_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, IDENTIFIER)) && r;
    r = p && IfAttribute_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // '!'?
  private static boolean IfAttribute_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfAttribute_1")) return false;
    consumeToken(b, NOT);
    return true;
  }

  // '?'?
  private static boolean IfAttribute_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfAttribute_3")) return false;
    consumeToken(b, QUESTION);
    return true;
  }

  /* ********************************************************** */
  // IfExpression
  public static boolean IfStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IfExpression(b, l + 1);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // as identifier
  public static boolean ImportAlias(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportAlias")) return false;
    if (!nextTokenIs(b, AS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 2, AS, IDENTIFIER);
    exit_section_(b, m, IMPORT_ALIAS, r);
    return r;
  }

  /* ********************************************************** */
  // import ImportSpec
  public static boolean ImportDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportDeclaration")) return false;
    if (!nextTokenIs(b, IMPORT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_DECLARATION, null);
    r = consumeToken(b, IMPORT);
    p = r; // pin = 1
    r = r && ImportSpec(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // (ImportDeclaration semi)+
  public static boolean ImportList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportList")) return false;
    if (!nextTokenIs(b, IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ImportList_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!ImportList_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ImportList", c)) break;
    }
    exit_section_(b, m, IMPORT_LIST, r);
    return r;
  }

  // ImportDeclaration semi
  private static boolean ImportList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportList_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = ImportDeclaration(b, l + 1);
    p = r; // pin = 1
    r = r && semi(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ImportString ('.' ImportString)* (SelectiveImportList | ImportAlias)?
  public static boolean ImportSpec(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportSpec")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ImportString(b, l + 1);
    r = r && ImportSpec_1(b, l + 1);
    r = r && ImportSpec_2(b, l + 1);
    exit_section_(b, m, IMPORT_SPEC, r);
    return r;
  }

  // ('.' ImportString)*
  private static boolean ImportSpec_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportSpec_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ImportSpec_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ImportSpec_1", c)) break;
    }
    return true;
  }

  // '.' ImportString
  private static boolean ImportSpec_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportSpec_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && ImportString(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (SelectiveImportList | ImportAlias)?
  private static boolean ImportSpec_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportSpec_2")) return false;
    ImportSpec_2_0(b, l + 1);
    return true;
  }

  // SelectiveImportList | ImportAlias
  private static boolean ImportSpec_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportSpec_2_0")) return false;
    boolean r;
    r = SelectiveImportList(b, l + 1);
    if (!r) r = ImportAlias(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // identifier
  static boolean ImportString(PsiBuilder b, int l) {
    return consumeToken(b, IDENTIFIER);
  }

  /* ********************************************************** */
  // Expression ('++' | '--')
  public static boolean IncDecStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IncDecStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INC_DEC_STATEMENT, "<inc dec statement>");
    r = Expression(b, l + 1, -1);
    r = r && IncDecStatement_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '++' | '--'
  private static boolean IncDecStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IncDecStatement_1")) return false;
    boolean r;
    r = consumeToken(b, PLUS_PLUS);
    if (!r) r = consumeToken(b, MINUS_MINUS);
    return r;
  }

  /* ********************************************************** */
  // Expression SliceExprBodyInner?
  static boolean IndexExprBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IndexExprBody")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1, -1);
    r = r && IndexExprBody_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SliceExprBodyInner?
  private static boolean IndexExprBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IndexExprBody_1")) return false;
    SliceExprBodyInner(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // Attributes? SymbolVisibility? InterfaceType
  public static boolean InterfaceDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTERFACE_DECLARATION, "<interface declaration>");
    r = InterfaceDeclaration_0(b, l + 1);
    r = r && InterfaceDeclaration_1(b, l + 1);
    r = r && InterfaceType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Attributes?
  private static boolean InterfaceDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceDeclaration_0")) return false;
    Attributes(b, l + 1);
    return true;
  }

  // SymbolVisibility?
  private static boolean InterfaceDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceDeclaration_1")) return false;
    SymbolVisibility(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (FieldDefinitionList TypeDecl) Attribute? Tag?
  public static boolean InterfaceFieldDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceFieldDeclaration")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = InterfaceFieldDeclaration_0(b, l + 1);
    r = r && InterfaceFieldDeclaration_1(b, l + 1);
    r = r && InterfaceFieldDeclaration_2(b, l + 1);
    exit_section_(b, m, INTERFACE_FIELD_DECLARATION, r);
    return r;
  }

  // FieldDefinitionList TypeDecl
  private static boolean InterfaceFieldDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceFieldDeclaration_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FieldDefinitionList(b, l + 1);
    r = r && TypeDecl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Attribute?
  private static boolean InterfaceFieldDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceFieldDeclaration_1")) return false;
    Attribute(b, l + 1);
    return true;
  }

  // Tag?
  private static boolean InterfaceFieldDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceFieldDeclaration_2")) return false;
    Tag(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // MemberModifiers? (InterfaceFieldDeclaration | InterfaceMethodDeclaration | AnonymousInterfaceDefinition)? (semi InterfaceMembers)* semi?
  static boolean InterfaceMembers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceMembers")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = InterfaceMembers_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, InterfaceMembers_1(b, l + 1));
    r = p && report_error_(b, InterfaceMembers_2(b, l + 1)) && r;
    r = p && InterfaceMembers_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // MemberModifiers?
  private static boolean InterfaceMembers_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceMembers_0")) return false;
    MemberModifiers(b, l + 1);
    return true;
  }

  // (InterfaceFieldDeclaration | InterfaceMethodDeclaration | AnonymousInterfaceDefinition)?
  private static boolean InterfaceMembers_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceMembers_1")) return false;
    InterfaceMembers_1_0(b, l + 1);
    return true;
  }

  // InterfaceFieldDeclaration | InterfaceMethodDeclaration | AnonymousInterfaceDefinition
  private static boolean InterfaceMembers_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceMembers_1_0")) return false;
    boolean r;
    r = InterfaceFieldDeclaration(b, l + 1);
    if (!r) r = InterfaceMethodDeclaration(b, l + 1);
    if (!r) r = AnonymousInterfaceDefinition(b, l + 1);
    return r;
  }

  // (semi InterfaceMembers)*
  private static boolean InterfaceMembers_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceMembers_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!InterfaceMembers_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "InterfaceMembers_2", c)) break;
    }
    return true;
  }

  // semi InterfaceMembers
  private static boolean InterfaceMembers_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceMembers_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = semi(b, l + 1);
    r = r && InterfaceMembers(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // semi?
  private static boolean InterfaceMembers_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceMembers_3")) return false;
    semi(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier Signature Attribute? Tag?
  public static boolean InterfaceMethodDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceMethodDeclaration")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && Signature(b, l + 1);
    r = r && InterfaceMethodDeclaration_2(b, l + 1);
    r = r && InterfaceMethodDeclaration_3(b, l + 1);
    exit_section_(b, m, INTERFACE_METHOD_DECLARATION, r);
    return r;
  }

  // Attribute?
  private static boolean InterfaceMethodDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceMethodDeclaration_2")) return false;
    Attribute(b, l + 1);
    return true;
  }

  // Tag?
  private static boolean InterfaceMethodDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceMethodDeclaration_3")) return false;
    Tag(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // interface identifier? '{' InterfaceMembers? '}'
  public static boolean InterfaceType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceType")) return false;
    if (!nextTokenIs(b, INTERFACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INTERFACE_TYPE, null);
    r = consumeToken(b, INTERFACE);
    p = r; // pin = 1
    r = r && report_error_(b, InterfaceType_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LBRACE)) && r;
    r = p && report_error_(b, InterfaceType_3(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // identifier?
  private static boolean InterfaceType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceType_1")) return false;
    consumeToken(b, IDENTIFIER);
    return true;
  }

  // InterfaceMembers?
  private static boolean InterfaceType_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceType_3")) return false;
    InterfaceMembers(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (Literal | ReferenceExpression) ':' Expression
  public static boolean KeyValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyValue")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, KEY_VALUE, "<key value>");
    r = KeyValue_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, COLON));
    r = p && Expression(b, l + 1, -1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // Literal | ReferenceExpression
  private static boolean KeyValue_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyValue_0")) return false;
    boolean r;
    r = Literal(b, l + 1);
    if (!r) r = ReferenceExpression(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KeyValue ((semi | ',') KeyValue)* (semi | ',')?
  public static boolean KeyValues(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyValues")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, KEY_VALUES, "<key values>");
    r = KeyValue(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, KeyValues_1(b, l + 1));
    r = p && KeyValues_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ((semi | ',') KeyValue)*
  private static boolean KeyValues_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyValues_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!KeyValues_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "KeyValues_1", c)) break;
    }
    return true;
  }

  // (semi | ',') KeyValue
  private static boolean KeyValues_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyValues_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KeyValues_1_0_0(b, l + 1);
    r = r && KeyValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // semi | ','
  private static boolean KeyValues_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyValues_1_0_0")) return false;
    boolean r;
    r = semi(b, l + 1);
    if (!r) r = consumeToken(b, COMMA);
    return r;
  }

  // (semi | ',')?
  private static boolean KeyValues_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyValues_2")) return false;
    KeyValues_2_0(b, l + 1);
    return true;
  }

  // semi | ','
  private static boolean KeyValues_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeyValues_2_0")) return false;
    boolean r;
    r = semi(b, l + 1);
    if (!r) r = consumeToken(b, COMMA);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean LabelRef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LabelRef")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, LABEL_REF, r);
    return r;
  }

  /* ********************************************************** */
  // LANGUAGE_INJECTION (semi LANGUAGE_INJECTION)*
  public static boolean LanguageInjectionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LanguageInjectionStatement")) return false;
    if (!nextTokenIs(b, LANGUAGE_INJECTION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LANGUAGE_INJECTION_STATEMENT, null);
    r = consumeToken(b, LANGUAGE_INJECTION);
    p = r; // pin = 1
    r = r && LanguageInjectionStatement_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (semi LANGUAGE_INJECTION)*
  private static boolean LanguageInjectionStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LanguageInjectionStatement_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!LanguageInjectionStatement_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "LanguageInjectionStatement_1", c)) break;
    }
    return true;
  }

  // semi LANGUAGE_INJECTION
  private static boolean LanguageInjectionStatement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LanguageInjectionStatement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = semi(b, l + 1);
    r = r && consumeToken(b, LANGUAGE_INJECTION);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ExpressionList
  public static boolean LeftHandExprList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LeftHandExprList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LEFT_HAND_EXPR_LIST, "<left hand expr list>");
    r = ExpressionList(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (lock | rlock) Expression Block
  public static boolean LockStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LockStatement")) return false;
    if (!nextTokenIs(b, "<lock statement>", LOCK, RLOCK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LOCK_STATEMENT, "<lock statement>");
    r = LockStatement_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, Expression(b, l + 1, -1));
    r = p && Block(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // lock | rlock
  private static boolean LockStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LockStatement_0")) return false;
    boolean r;
    r = consumeToken(b, LOCK);
    if (!r) r = consumeToken(b, RLOCK);
    return r;
  }

  /* ********************************************************** */
  // '{' KeyValues '}'
  public static boolean MapInitExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapInitExpr")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && KeyValues(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, MAP_INIT_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // 'map' '[' TypeDecl ']' TypeDecl
  public static boolean MapType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapType")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MAP_TYPE, "<map type>");
    r = consumeToken(b, "map");
    r = r && consumeToken(b, LBRACK);
    p = r; // pin = 2
    r = r && report_error_(b, TypeDecl(b, l + 1));
    r = p && report_error_(b, consumeToken(b, RBRACK)) && r;
    r = p && TypeDecl(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // MatchExpressionList Block semi
  public static boolean MatchArm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchArm")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATCH_ARM, "<match arm>");
    r = MatchExpressionList(b, l + 1);
    r = r && Block(b, l + 1);
    p = r; // pin = 2
    r = r && semi(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // (MatchArm | MatchElseArmClause)*
  public static boolean MatchArms(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchArms")) return false;
    Marker m = enter_section_(b, l, _NONE_, MATCH_ARMS, "<match arms>");
    while (true) {
      int c = current_position_(b);
      if (!MatchArms_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MatchArms", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // MatchArm | MatchElseArmClause
  private static boolean MatchArms_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchArms_0")) return false;
    boolean r;
    r = MatchArm(b, l + 1);
    if (!r) r = MatchElseArmClause(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // else Block semi
  public static boolean MatchElseArmClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchElseArmClause")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATCH_ELSE_ARM_CLAUSE, null);
    r = consumeToken(b, ELSE);
    p = r; // pin = 1
    r = r && report_error_(b, Block(b, l + 1));
    r = p && semi(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // Expression (',' Expression)*
  static boolean MatchExpressionList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchExpressionList")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = Expression(b, l + 1, -1);
    p = r; // pin = 1
    r = r && MatchExpressionList_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (',' Expression)*
  private static boolean MatchExpressionList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchExpressionList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!MatchExpressionList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MatchExpressionList_1", c)) break;
    }
    return true;
  }

  // ',' Expression
  private static boolean MatchExpressionList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchExpressionList_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // mut | pub | shared | BUILTIN_GLOBAL
  public static boolean MemberModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberModifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MEMBER_MODIFIER, "<member modifier>");
    r = consumeToken(b, MUT);
    if (!r) r = consumeToken(b, PUB);
    if (!r) r = consumeToken(b, SHARED);
    if (!r) r = consumeToken(b, BUILTIN_GLOBAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // MemberModifier (MemberModifier)* ':'
  public static boolean MemberModifiers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberModifiers")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MEMBER_MODIFIERS, "<member modifiers>");
    r = MemberModifier(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, MemberModifiers_1(b, l + 1));
    r = p && consumeToken(b, COLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (MemberModifier)*
  private static boolean MemberModifiers_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberModifiers_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!MemberModifiers_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MemberModifiers_1", c)) break;
    }
    return true;
  }

  // (MemberModifier)
  private static boolean MemberModifiers_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberModifiers_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MemberModifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ReferenceExpression ArgumentList
  public static boolean MethodCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodCall")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ReferenceExpression(b, l + 1);
    r = r && ArgumentList(b, l + 1);
    exit_section_(b, m, METHOD_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // Attributes? SymbolVisibility? fn Receiver MethodName Signature BlockWithConsume?
  public static boolean MethodDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodDeclaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, METHOD_DECLARATION, "<method declaration>");
    r = MethodDeclaration_0(b, l + 1);
    r = r && MethodDeclaration_1(b, l + 1);
    r = r && consumeToken(b, FN);
    r = r && Receiver(b, l + 1);
    r = r && MethodName(b, l + 1);
    p = r; // pin = 5
    r = r && report_error_(b, Signature(b, l + 1));
    r = p && MethodDeclaration_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // Attributes?
  private static boolean MethodDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodDeclaration_0")) return false;
    Attributes(b, l + 1);
    return true;
  }

  // SymbolVisibility?
  private static boolean MethodDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodDeclaration_1")) return false;
    SymbolVisibility(b, l + 1);
    return true;
  }

  // BlockWithConsume?
  private static boolean MethodDeclaration_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodDeclaration_6")) return false;
    BlockWithConsume(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier | AddOp | MulOp | RelOp
  public static boolean MethodName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodName")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_NAME, "<method name>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = AddOp(b, l + 1);
    if (!r) r = MulOp(b, l + 1);
    if (!r) r = RelOp(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // MethodCall | FieldLookup
  static boolean MethodOrField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodOrField")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    r = MethodCall(b, l + 1);
    if (!r) r = FieldLookup(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // Attributes? module identifier semi
  public static boolean ModuleClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModuleClause")) return false;
    if (!nextTokenIs(b, "<module clause>", LBRACK, MODULE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MODULE_CLAUSE, "<module clause>");
    r = ModuleClause_0(b, l + 1);
    r = r && consumeTokens(b, 1, MODULE, IDENTIFIER);
    p = r; // pin = 2
    r = r && semi(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // Attributes?
  private static boolean ModuleClause_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModuleClause_0")) return false;
    Attributes(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '*' | '/' | '%' | '<<' | '>>' | '&' | '&^'
  static boolean MulOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MulOp")) return false;
    boolean r;
    r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, QUOTIENT);
    if (!r) r = consumeToken(b, REMAINDER);
    if (!r) r = consumeToken(b, SHIFT_LEFT);
    if (!r) r = consumeToken(b, SHIFT_RIGHT);
    if (!r) r = consumeToken(b, BIT_AND);
    if (!r) r = consumeToken(b, BIT_CLEAR);
    return r;
  }

  /* ********************************************************** */
  // identifier ':' (Expression | UnpackingExpression)
  static boolean NamedArgumentExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedArgumentExpr")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeTokens(b, 2, IDENTIFIER, COLON);
    p = r; // pin = 2
    r = r && NamedArgumentExpr_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // Expression | UnpackingExpression
  private static boolean NamedArgumentExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedArgumentExpr_2")) return false;
    boolean r;
    r = Expression(b, l + 1, -1);
    if (!r) r = UnpackingExpression(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // NamedArgumentExpr ((semi | ',') (NamedArgumentExpr | &')'))*
  static boolean NamedExpressionArgList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedExpressionArgList")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = NamedArgumentExpr(b, l + 1);
    p = r; // pin = 1
    r = r && NamedExpressionArgList_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ((semi | ',') (NamedArgumentExpr | &')'))*
  private static boolean NamedExpressionArgList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedExpressionArgList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!NamedExpressionArgList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "NamedExpressionArgList_1", c)) break;
    }
    return true;
  }

  // (semi | ',') (NamedArgumentExpr | &')')
  private static boolean NamedExpressionArgList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedExpressionArgList_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = NamedExpressionArgList_1_0_0(b, l + 1);
    p = r; // pin = 1
    r = r && NamedExpressionArgList_1_0_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // semi | ','
  private static boolean NamedExpressionArgList_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedExpressionArgList_1_0_0")) return false;
    boolean r;
    r = semi(b, l + 1);
    if (!r) r = consumeToken(b, COMMA);
    return r;
  }

  // NamedArgumentExpr | &')'
  private static boolean NamedExpressionArgList_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedExpressionArgList_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = NamedArgumentExpr(b, l + 1);
    if (!r) r = NamedExpressionArgList_1_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &')'
  private static boolean NamedExpressionArgList_1_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedExpressionArgList_1_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, RPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '?' TypeDecl?
  public static boolean NullableType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NullableType")) return false;
    if (!nextTokenIs(b, QUESTION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, NULLABLE_TYPE, null);
    r = consumeToken(b, QUESTION);
    p = r; // pin = 1
    r = r && NullableType_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // TypeDecl?
  private static boolean NullableType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NullableType_1")) return false;
    TypeDecl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // VarModifiers? identifier
  public static boolean ParamDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAM_DEFINITION, "<param definition>");
    r = ParamDefinition_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // VarModifiers?
  private static boolean ParamDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDefinition_0")) return false;
    VarModifiers(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ParamDefinition &(!('.' | ')')) (',' ParamDefinition)*
  static boolean ParamDefinitionListNoPin(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDefinitionListNoPin")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ParamDefinition(b, l + 1);
    r = r && ParamDefinitionListNoPin_1(b, l + 1);
    r = r && ParamDefinitionListNoPin_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(!('.' | ')'))
  private static boolean ParamDefinitionListNoPin_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDefinitionListNoPin_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = ParamDefinitionListNoPin_1_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !('.' | ')')
  private static boolean ParamDefinitionListNoPin_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDefinitionListNoPin_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !ParamDefinitionListNoPin_1_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '.' | ')'
  private static boolean ParamDefinitionListNoPin_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDefinitionListNoPin_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, RPAREN);
    return r;
  }

  // (',' ParamDefinition)*
  private static boolean ParamDefinitionListNoPin_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDefinitionListNoPin_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ParamDefinitionListNoPin_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ParamDefinitionListNoPin_2", c)) break;
    }
    return true;
  }

  // ',' ParamDefinition
  private static boolean ParamDefinitionListNoPin_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamDefinitionListNoPin_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ParamDefinition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ParamDefinitionListNoPin? '...'? TypeDecl | TypeDecl
  public static boolean ParameterDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER_DECLARATION, "<parameter declaration>");
    r = ParameterDeclaration_0(b, l + 1);
    if (!r) r = TypeDecl(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ParamDefinitionListNoPin? '...'? TypeDecl
  private static boolean ParameterDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterDeclaration_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ParameterDeclaration_0_0(b, l + 1);
    r = r && ParameterDeclaration_0_1(b, l + 1);
    r = r && TypeDecl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ParamDefinitionListNoPin?
  private static boolean ParameterDeclaration_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterDeclaration_0_0")) return false;
    ParamDefinitionListNoPin(b, l + 1);
    return true;
  }

  // '...'?
  private static boolean ParameterDeclaration_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterDeclaration_0_1")) return false;
    consumeToken(b, TRIPLE_DOT);
    return true;
  }

  /* ********************************************************** */
  // ParameterDeclaration (',' (ParameterDeclaration | &')'))*
  static boolean ParameterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = ParameterDeclaration(b, l + 1);
    p = r; // pin = 1
    r = r && ParameterList_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (',' (ParameterDeclaration | &')'))*
  private static boolean ParameterList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ParameterList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ParameterList_1", c)) break;
    }
    return true;
  }

  // ',' (ParameterDeclaration | &')')
  private static boolean ParameterList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && ParameterList_1_0_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ParameterDeclaration | &')'
  private static boolean ParameterList_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ParameterDeclaration(b, l + 1);
    if (!r) r = ParameterList_1_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &')'
  private static boolean ParameterList_1_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, RPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '(' [ (ParameterList ','?| TypeListNoPin) ] ')'
  public static boolean Parameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameters")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PARAMETERS, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, Parameters_1(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [ (ParameterList ','?| TypeListNoPin) ]
  private static boolean Parameters_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameters_1")) return false;
    Parameters_1_0(b, l + 1);
    return true;
  }

  // ParameterList ','?| TypeListNoPin
  private static boolean Parameters_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameters_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Parameters_1_0_0(b, l + 1);
    if (!r) r = TypeListNoPin(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ParameterList ','?
  private static boolean Parameters_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameters_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ParameterList(b, l + 1);
    r = r && Parameters_1_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean Parameters_1_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameters_1_0_0_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // (identifier | unsafe | int | string | StringLiteral) (':' (identifier | StringLiteral))?
  public static boolean PlainAttribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PlainAttribute")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PLAIN_ATTRIBUTE, "<plain attribute>");
    r = PlainAttribute_0(b, l + 1);
    r = r && PlainAttribute_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier | unsafe | int | string | StringLiteral
  private static boolean PlainAttribute_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PlainAttribute_0")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, UNSAFE);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = StringLiteral(b, l + 1);
    return r;
  }

  // (':' (identifier | StringLiteral))?
  private static boolean PlainAttribute_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PlainAttribute_1")) return false;
    PlainAttribute_1_0(b, l + 1);
    return true;
  }

  // ':' (identifier | StringLiteral)
  private static boolean PlainAttribute_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PlainAttribute_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && PlainAttribute_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier | StringLiteral
  private static boolean PlainAttribute_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PlainAttribute_1_0_1")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = StringLiteral(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ('&' | '&&')+ TypeDecl
  public static boolean PointerType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PointerType")) return false;
    if (!nextTokenIs(b, "<pointer type>", BIT_AND, COND_AND)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _COLLAPSE_, POINTER_TYPE, "<pointer type>");
    r = PointerType_0(b, l + 1);
    p = r; // pin = 1
    r = r && TypeDecl(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('&' | '&&')+
  private static boolean PointerType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PointerType_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PointerType_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!PointerType_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PointerType_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // '&' | '&&'
  private static boolean PointerType_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PointerType_0_0")) return false;
    boolean r;
    r = consumeToken(b, BIT_AND);
    if (!r) r = consumeToken(b, COND_AND);
    return r;
  }

  /* ********************************************************** */
  // in Expression | VarDefinitionList in Expression
  public static boolean RangeClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RangeClause")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RANGE_CLAUSE, "<range clause>");
    r = RangeClause_0(b, l + 1);
    if (!r) r = RangeClause_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // in Expression
  private static boolean RangeClause_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RangeClause_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VarDefinitionList in Expression
  private static boolean RangeClause_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RangeClause_1")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = VarDefinitionList(b, l + 1);
    r = r && consumeToken(b, IN);
    p = r; // pin = 2
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '(' (VarModifiers? identifier ReceiverTail | ReceiverTail) ')'
  public static boolean Receiver(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Receiver")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RECEIVER, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, Receiver_1(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // VarModifiers? identifier ReceiverTail | ReceiverTail
  private static boolean Receiver_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Receiver_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Receiver_1_0(b, l + 1);
    if (!r) r = ReceiverTail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VarModifiers? identifier ReceiverTail
  private static boolean Receiver_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Receiver_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Receiver_1_0_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && ReceiverTail(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VarModifiers?
  private static boolean Receiver_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Receiver_1_0_0")) return false;
    VarModifiers(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TypeDecl ','?
  static boolean ReceiverTail(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReceiverTail")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TypeDecl(b, l + 1);
    r = r && ReceiverTail_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean ReceiverTail_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReceiverTail_1")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // '==' | '!=' | '<' | '<=' | '>' | '>='
  static boolean RelOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelOp")) return false;
    boolean r;
    r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, NOT_EQ);
    if (!r) r = consumeToken(b, LESS);
    if (!r) r = consumeToken(b, LESS_OR_EQUAL);
    if (!r) r = consumeToken(b, GREATER);
    if (!r) r = consumeToken(b, GREATER_OR_EQUAL);
    return r;
  }

  /* ********************************************************** */
  // '(' TypeListNoPin ')' | TypeDecl | Parameters
  public static boolean Result(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Result")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RESULT, "<result>");
    r = Result_0(b, l + 1);
    if (!r) r = TypeDecl(b, l + 1);
    if (!r) r = Parameters(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '(' TypeListNoPin ')'
  private static boolean Result_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Result_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && TypeListNoPin(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // return ExpressionList?
  public static boolean ReturnStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStatement")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && ReturnStatement_1(b, l + 1);
    exit_section_(b, m, RETURN_STATEMENT, r);
    return r;
  }

  // ExpressionList?
  private static boolean ReturnStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStatement_1")) return false;
    ExpressionList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '{' ReferenceExpression (',' ReferenceExpression)* '}'
  public static boolean SelectiveImportList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SelectiveImportList")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SELECTIVE_IMPORT_LIST, null);
    r = consumeToken(b, LBRACE);
    r = r && ReferenceExpression(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, SelectiveImportList_2(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (',' ReferenceExpression)*
  private static boolean SelectiveImportList_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SelectiveImportList_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!SelectiveImportList_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SelectiveImportList_2", c)) break;
    }
    return true;
  }

  // ',' ReferenceExpression
  private static boolean SelectiveImportList_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SelectiveImportList_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ReferenceExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '<-' Expression
  public static boolean SendStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SendStatement")) return false;
    if (!nextTokenIs(b, SEND_CHANNEL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _LEFT_, SEND_STATEMENT, null);
    r = consumeToken(b, SEND_CHANNEL);
    p = r; // pin = 1
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // Parameters Result?
  public static boolean Signature(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Signature")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SIGNATURE, null);
    r = Parameters(b, l + 1);
    p = r; // pin = 1
    r = r && Signature_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // Result?
  private static boolean Signature_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Signature_1")) return false;
    Result(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ExpressionOrTypeWithRecover (',' (ExpressionOrTypeWithRecover | &')'))*
  static boolean SimpleExpressionArgList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleExpressionArgList")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionOrTypeWithRecover(b, l + 1);
    r = r && SimpleExpressionArgList_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' (ExpressionOrTypeWithRecover | &')'))*
  private static boolean SimpleExpressionArgList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleExpressionArgList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!SimpleExpressionArgList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SimpleExpressionArgList_1", c)) break;
    }
    return true;
  }

  // ',' (ExpressionOrTypeWithRecover | &')')
  private static boolean SimpleExpressionArgList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleExpressionArgList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && SimpleExpressionArgList_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ExpressionOrTypeWithRecover | &')'
  private static boolean SimpleExpressionArgList_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleExpressionArgList_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionOrTypeWithRecover(b, l + 1);
    if (!r) r = SimpleExpressionArgList_1_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &')'
  private static boolean SimpleExpressionArgList_1_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleExpressionArgList_1_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, RPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VarDeclaration
  //   | IncDecStatement
  //   | (LeftHandExprList AssignmentStatement? | SendStatement)
  public static boolean SimpleStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, SIMPLE_STATEMENT, "<simple statement>");
    r = VarDeclaration(b, l + 1);
    if (!r) r = IncDecStatement(b, l + 1);
    if (!r) r = SimpleStatement_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LeftHandExprList AssignmentStatement? | SendStatement
  private static boolean SimpleStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleStatement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SimpleStatement_2_0(b, l + 1);
    if (!r) r = SendStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LeftHandExprList AssignmentStatement?
  private static boolean SimpleStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleStatement_2_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = LeftHandExprList(b, l + 1);
    p = r; // pin = LeftHandExprList
    r = r && SimpleStatement_2_0_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // AssignmentStatement?
  private static boolean SimpleStatement_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleStatement_2_0_1")) return false;
    AssignmentStatement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // [SimpleStatement ';'?]
  static boolean SimpleStatementOpt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleStatementOpt")) return false;
    SimpleStatementOpt_0(b, l + 1);
    return true;
  }

  // SimpleStatement ';'?
  private static boolean SimpleStatementOpt_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleStatementOpt_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SimpleStatement(b, l + 1);
    r = r && SimpleStatementOpt_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ';'?
  private static boolean SimpleStatementOpt_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleStatementOpt_0_1")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  /* ********************************************************** */
  // &'..' '..' Expression
  static boolean SliceExprBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SliceExprBody")) return false;
    if (!nextTokenIs(b, RANGE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SliceExprBody_0(b, l + 1);
    r = r && consumeToken(b, RANGE);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'..'
  private static boolean SliceExprBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SliceExprBody_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, RANGE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SliceExprBody
  static boolean SliceExprBodyInner(PsiBuilder b, int l) {
    return SliceExprBody(b, l + 1);
  }

  /* ********************************************************** */
  // ConstDeclaration
  //   | SimpleStatement
  //   | LockStatement
  //   | GoStatement
  //   | ReturnStatement
  //   | BreakStatement
  //   | ContinueStatement
  //   | GotoStatement
  //   | Block
  //   | CompileTimeIfStatement
  //   | IfStatement
  //   | UnsafeStatement
  //   | ForStatement
  //   | CompileTimeForStatement
  //   | AssertStatement
  //   | CFlagStatement
  //   | CIncludeStatement
  //   | LanguageInjectionStatement
  //   | TypeAliasDeclaration
  //   | AsmBlockStatement
  // //| SelectStatement
  //   | DeferStatement
  public static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, STATEMENT, "<statement>");
    r = ConstDeclaration(b, l + 1);
    if (!r) r = SimpleStatement(b, l + 1);
    if (!r) r = LockStatement(b, l + 1);
    if (!r) r = GoStatement(b, l + 1);
    if (!r) r = ReturnStatement(b, l + 1);
    if (!r) r = BreakStatement(b, l + 1);
    if (!r) r = ContinueStatement(b, l + 1);
    if (!r) r = GotoStatement(b, l + 1);
    if (!r) r = Block(b, l + 1);
    if (!r) r = CompileTimeIfStatement(b, l + 1);
    if (!r) r = IfStatement(b, l + 1);
    if (!r) r = UnsafeStatement(b, l + 1);
    if (!r) r = ForStatement(b, l + 1);
    if (!r) r = CompileTimeForStatement(b, l + 1);
    if (!r) r = AssertStatement(b, l + 1);
    if (!r) r = CFlagStatement(b, l + 1);
    if (!r) r = CIncludeStatement(b, l + 1);
    if (!r) r = LanguageInjectionStatement(b, l + 1);
    if (!r) r = TypeAliasDeclaration(b, l + 1);
    if (!r) r = AsmBlockStatement(b, l + 1);
    if (!r) r = DeferStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !('!' | '?' | '&' | '(' | '*' | '+' | '-' | ';' | '<-' | '^' | 'type' | '{' | '|' | '|=' | '||' | '}' | break | case | char | const | continue | decimali | default | defer | else | fallthrough | float | floati | for | fn | pub | mut | shared | go | goto | hex | identifier | if | int | interface | oct | return | select | string | raw_string | char | struct | union | switch | var | unsafe | assert | match | lock | rlock | asm | FOR_COMPILE_TIME | IF_COMPILE_TIME | ELSE_COMPILE_TIME | BUILTIN_GLOBAL | C_INCLUDE | C_FLAG | LANGUAGE_INJECTION)
  static boolean StatementRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !StatementRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '!' | '?' | '&' | '(' | '*' | '+' | '-' | ';' | '<-' | '^' | 'type' | '{' | '|' | '|=' | '||' | '}' | break | case | char | const | continue | decimali | default | defer | else | fallthrough | float | floati | for | fn | pub | mut | shared | go | goto | hex | identifier | if | int | interface | oct | return | select | string | raw_string | char | struct | union | switch | var | unsafe | assert | match | lock | rlock | asm | FOR_COMPILE_TIME | IF_COMPILE_TIME | ELSE_COMPILE_TIME | BUILTIN_GLOBAL | C_INCLUDE | C_FLAG | LANGUAGE_INJECTION
  private static boolean StatementRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementRecover_0")) return false;
    boolean r;
    r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, QUESTION);
    if (!r) r = consumeToken(b, BIT_AND);
    if (!r) r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, SEND_CHANNEL);
    if (!r) r = consumeToken(b, BIT_XOR);
    if (!r) r = consumeToken(b, TYPE_);
    if (!r) r = consumeToken(b, LBRACE);
    if (!r) r = consumeToken(b, BIT_OR);
    if (!r) r = consumeToken(b, BIT_OR_ASSIGN);
    if (!r) r = consumeToken(b, COND_OR);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, BREAK);
    if (!r) r = consumeToken(b, CASE);
    if (!r) r = consumeToken(b, CHAR);
    if (!r) r = consumeToken(b, CONST);
    if (!r) r = consumeToken(b, CONTINUE);
    if (!r) r = consumeToken(b, DECIMALI);
    if (!r) r = consumeToken(b, DEFAULT);
    if (!r) r = consumeToken(b, DEFER);
    if (!r) r = consumeToken(b, ELSE);
    if (!r) r = consumeToken(b, FALLTHROUGH);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, FLOATI);
    if (!r) r = consumeToken(b, FOR);
    if (!r) r = consumeToken(b, FN);
    if (!r) r = consumeToken(b, PUB);
    if (!r) r = consumeToken(b, MUT);
    if (!r) r = consumeToken(b, SHARED);
    if (!r) r = consumeToken(b, GO);
    if (!r) r = consumeToken(b, GOTO);
    if (!r) r = consumeToken(b, HEX);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, IF);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, INTERFACE);
    if (!r) r = consumeToken(b, OCT);
    if (!r) r = consumeToken(b, RETURN);
    if (!r) r = consumeToken(b, SELECT);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, RAW_STRING);
    if (!r) r = consumeToken(b, CHAR);
    if (!r) r = consumeToken(b, STRUCT);
    if (!r) r = consumeToken(b, UNION);
    if (!r) r = consumeToken(b, SWITCH);
    if (!r) r = consumeToken(b, VAR);
    if (!r) r = consumeToken(b, UNSAFE);
    if (!r) r = consumeToken(b, ASSERT);
    if (!r) r = consumeToken(b, MATCH);
    if (!r) r = consumeToken(b, LOCK);
    if (!r) r = consumeToken(b, RLOCK);
    if (!r) r = consumeToken(b, ASM);
    if (!r) r = consumeToken(b, FOR_COMPILE_TIME);
    if (!r) r = consumeToken(b, IF_COMPILE_TIME);
    if (!r) r = consumeToken(b, ELSE_COMPILE_TIME);
    if (!r) r = consumeToken(b, BUILTIN_GLOBAL);
    if (!r) r = consumeToken(b, C_INCLUDE);
    if (!r) r = consumeToken(b, C_FLAG);
    if (!r) r = consumeToken(b, LANGUAGE_INJECTION);
    return r;
  }

  /* ********************************************************** */
  // Statement (semi | &'}')
  static boolean StatementWithSemi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementWithSemi")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = Statement(b, l + 1);
    p = r; // pin = 1
    r = r && StatementWithSemi_1(b, l + 1);
    exit_section_(b, l, m, r, p, VlangParser::StatementRecover);
    return r || p;
  }

  // semi | &'}'
  private static boolean StatementWithSemi_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementWithSemi_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = semi(b, l + 1);
    if (!r) r = StatementWithSemi_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'}'
  private static boolean StatementWithSemi_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementWithSemi_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // StatementWithSemi*
  static boolean Statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statements")) return false;
    while (true) {
      int c = current_position_(b);
      if (!StatementWithSemi(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Statements", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // string | raw_string | char
  public static boolean StringLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringLiteral")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING_LITERAL, "<string literal>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, RAW_STRING);
    if (!r) r = consumeToken(b, CHAR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Attributes? SymbolVisibility? StructType
  public static boolean StructDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_DECLARATION, "<struct declaration>");
    r = StructDeclaration_0(b, l + 1);
    r = r && StructDeclaration_1(b, l + 1);
    r = r && StructType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Attributes?
  private static boolean StructDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructDeclaration_0")) return false;
    Attributes(b, l + 1);
    return true;
  }

  // SymbolVisibility?
  private static boolean StructDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructDeclaration_1")) return false;
    SymbolVisibility(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // struct identifier? '{' Fields? '}'
  public static boolean StructType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructType")) return false;
    if (!nextTokenIs(b, STRUCT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_TYPE, null);
    r = consumeToken(b, STRUCT);
    p = r; // pin = 1
    r = r && report_error_(b, StructType_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LBRACE)) && r;
    r = p && report_error_(b, StructType_3(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // identifier?
  private static boolean StructType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructType_1")) return false;
    consumeToken(b, IDENTIFIER);
    return true;
  }

  // Fields?
  private static boolean StructType_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructType_3")) return false;
    Fields(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // pub | BUILTIN_GLOBAL
  public static boolean SymbolVisibility(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SymbolVisibility")) return false;
    if (!nextTokenIs(b, "<symbol visibility>", BUILTIN_GLOBAL, PUB)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SYMBOL_VISIBILITY, "<symbol visibility>");
    r = consumeToken(b, PUB);
    if (!r) r = consumeToken(b, BUILTIN_GLOBAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // StringLiteral
  public static boolean Tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Tag")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TAG, "<tag>");
    r = StringLiteral(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ConstDeclaration
  //   | FunctionDeclaration
  //   | MethodDeclaration
  //   | StructDeclaration
  //   | EnumDeclaration
  //   | InterfaceDeclaration
  //   | UnionDeclaration
  //   | GlobalVariableDeclaration
  //   | CompileTimeIfStatement
  //   | CompileTimeForStatement
  //   | CIncludeStatement
  //   | CFlagStatement
  //   | LanguageInjectionStatement
  //   | TypeAliasDeclaration
  static boolean TopDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopDeclaration")) return false;
    boolean r;
    r = ConstDeclaration(b, l + 1);
    if (!r) r = FunctionDeclaration(b, l + 1);
    if (!r) r = MethodDeclaration(b, l + 1);
    if (!r) r = StructDeclaration(b, l + 1);
    if (!r) r = EnumDeclaration(b, l + 1);
    if (!r) r = InterfaceDeclaration(b, l + 1);
    if (!r) r = UnionDeclaration(b, l + 1);
    if (!r) r = GlobalVariableDeclaration(b, l + 1);
    if (!r) r = CompileTimeIfStatement(b, l + 1);
    if (!r) r = CompileTimeForStatement(b, l + 1);
    if (!r) r = CIncludeStatement(b, l + 1);
    if (!r) r = CFlagStatement(b, l + 1);
    if (!r) r = LanguageInjectionStatement(b, l + 1);
    if (!r) r = TypeAliasDeclaration(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // !<<eof>> TopDeclaration semi
  static boolean TopLevelDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDeclaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = TopLevelDeclaration_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, TopDeclaration(b, l + 1));
    r = p && semi(b, l + 1) && r;
    exit_section_(b, l, m, r, p, VlangParser::TopLevelDeclarationRecover);
    return r || p;
  }

  // !<<eof>>
  private static boolean TopLevelDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDeclaration_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !(';' | 'type' | const | fn | pub | BUILTIN_GLOBAL | var | struct | enum | interface | union | import | C_INCLUDE | C_FLAG | FOR_COMPILE_TIME | IF_COMPILE_TIME | LANGUAGE_INJECTION | '[')
  static boolean TopLevelDeclarationRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDeclarationRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !TopLevelDeclarationRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ';' | 'type' | const | fn | pub | BUILTIN_GLOBAL | var | struct | enum | interface | union | import | C_INCLUDE | C_FLAG | FOR_COMPILE_TIME | IF_COMPILE_TIME | LANGUAGE_INJECTION | '['
  private static boolean TopLevelDeclarationRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDeclarationRecover_0")) return false;
    boolean r;
    r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, TYPE_);
    if (!r) r = consumeToken(b, CONST);
    if (!r) r = consumeToken(b, FN);
    if (!r) r = consumeToken(b, PUB);
    if (!r) r = consumeToken(b, BUILTIN_GLOBAL);
    if (!r) r = consumeToken(b, VAR);
    if (!r) r = consumeToken(b, STRUCT);
    if (!r) r = consumeToken(b, ENUM);
    if (!r) r = consumeToken(b, INTERFACE);
    if (!r) r = consumeToken(b, UNION);
    if (!r) r = consumeToken(b, IMPORT);
    if (!r) r = consumeToken(b, C_INCLUDE);
    if (!r) r = consumeToken(b, C_FLAG);
    if (!r) r = consumeToken(b, FOR_COMPILE_TIME);
    if (!r) r = consumeToken(b, IF_COMPILE_TIME);
    if (!r) r = consumeToken(b, LANGUAGE_INJECTION);
    if (!r) r = consumeToken(b, LBRACK);
    return r;
  }

  /* ********************************************************** */
  // SymbolVisibility? 'type' identifier '=' TypeUnionList
  public static boolean TypeAliasDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeAliasDeclaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TYPE_ALIAS_DECLARATION, "<type alias declaration>");
    r = TypeAliasDeclaration_0(b, l + 1);
    r = r && consumeTokens(b, 1, TYPE_, IDENTIFIER, ASSIGN);
    p = r; // pin = 2
    r = r && TypeUnionList(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // SymbolVisibility?
  private static boolean TypeAliasDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeAliasDeclaration_0")) return false;
    SymbolVisibility(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TypeLit
  //   | TypeName
  public static boolean TypeDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDecl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, TYPE_DECL, "<type decl>");
    r = TypeLit(b, l + 1);
    if (!r) r = TypeName(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TypeDecl ( ',' TypeDecl )* ','?
  public static boolean TypeListNoPin(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeListNoPin")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_LIST_NO_PIN, "<type list no pin>");
    r = TypeDecl(b, l + 1);
    r = r && TypeListNoPin_1(b, l + 1);
    r = r && TypeListNoPin_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( ',' TypeDecl )*
  private static boolean TypeListNoPin_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeListNoPin_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!TypeListNoPin_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TypeListNoPin_1", c)) break;
    }
    return true;
  }

  // ',' TypeDecl
  private static boolean TypeListNoPin_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeListNoPin_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && TypeDecl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean TypeListNoPin_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeListNoPin_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // ArrayOrSliceType
  //   | PointerType
  //   | NullableType
  //   | FunctionType
  //   | MapType
  //   | ChannelType
  //   | StructType
  //   | InterfaceType
  static boolean TypeLit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeLit")) return false;
    boolean r;
    r = ArrayOrSliceType(b, l + 1);
    if (!r) r = PointerType(b, l + 1);
    if (!r) r = NullableType(b, l + 1);
    if (!r) r = FunctionType(b, l + 1);
    if (!r) r = MapType(b, l + 1);
    if (!r) r = ChannelType(b, l + 1);
    if (!r) r = StructType(b, l + 1);
    if (!r) r = InterfaceType(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // TypeReferenceExpression ('.' TypeReferenceExpression)*
  static boolean TypeName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TypeReferenceExpression(b, l + 1);
    r = r && TypeName_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('.' TypeReferenceExpression)*
  private static boolean TypeName_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeName_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!TypeName_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TypeName_1", c)) break;
    }
    return true;
  }

  // '.' TypeReferenceExpression
  private static boolean TypeName_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeName_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && TypeReferenceExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean TypeReferenceExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeReferenceExpression")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, TYPE_REFERENCE_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // TypeDecl ('|' TypeDecl)*
  public static boolean TypeUnionList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeUnionList")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TYPE_UNION_LIST, "<type union list>");
    r = TypeDecl(b, l + 1);
    p = r; // pin = 1
    r = r && TypeUnionList_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('|' TypeDecl)*
  private static boolean TypeUnionList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeUnionList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!TypeUnionList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TypeUnionList_1", c)) break;
    }
    return true;
  }

  // '|' TypeDecl
  private static boolean TypeUnionList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeUnionList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BIT_OR);
    r = r && TypeDecl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '+' | '-' | '!' | '^' | '*' | '&' | '&&' | '<-'
  static boolean UnaryOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryOp")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, BIT_XOR);
    if (!r) r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, BIT_AND);
    if (!r) r = consumeToken(b, COND_AND);
    if (!r) r = consumeToken(b, SEND_CHANNEL);
    return r;
  }

  /* ********************************************************** */
  // Attributes? SymbolVisibility? union identifier? '{' Fields? '}'
  public static boolean UnionDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnionDeclaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, UNION_DECLARATION, "<union declaration>");
    r = UnionDeclaration_0(b, l + 1);
    r = r && UnionDeclaration_1(b, l + 1);
    r = r && consumeToken(b, UNION);
    p = r; // pin = 3
    r = r && report_error_(b, UnionDeclaration_3(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LBRACE)) && r;
    r = p && report_error_(b, UnionDeclaration_5(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // Attributes?
  private static boolean UnionDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnionDeclaration_0")) return false;
    Attributes(b, l + 1);
    return true;
  }

  // SymbolVisibility?
  private static boolean UnionDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnionDeclaration_1")) return false;
    SymbolVisibility(b, l + 1);
    return true;
  }

  // identifier?
  private static boolean UnionDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnionDeclaration_3")) return false;
    consumeToken(b, IDENTIFIER);
    return true;
  }

  // Fields?
  private static boolean UnionDeclaration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnionDeclaration_5")) return false;
    Fields(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '...' Expression
  public static boolean UnpackingExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnpackingExpression")) return false;
    if (!nextTokenIs(b, TRIPLE_DOT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, UNPACKING_EXPRESSION, null);
    r = consumeToken(b, TRIPLE_DOT);
    p = r; // pin = 1
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // UnsafeExpression
  public static boolean UnsafeStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnsafeStatement")) return false;
    if (!nextTokenIs(b, UNSAFE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = UnsafeExpression(b, l + 1);
    exit_section_(b, m, UNSAFE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // VarDefinitionList ':=' (ExpressionList | MapInitExpr)
  public static boolean VarDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDeclaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VAR_DECLARATION, "<var declaration>");
    r = VarDefinitionList(b, l + 1);
    r = r && consumeToken(b, VAR_ASSIGN);
    p = r; // pin = 2
    r = r && VarDeclaration_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ExpressionList | MapInitExpr
  private static boolean VarDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDeclaration_2")) return false;
    boolean r;
    r = ExpressionList(b, l + 1);
    if (!r) r = MapInitExpr(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // VarModifiers? identifier
  public static boolean VarDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_DEFINITION, "<var definition>");
    r = VarDefinition_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // VarModifiers?
  private static boolean VarDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDefinition_0")) return false;
    VarModifiers(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // VarDefinition (',' VarDefinition)*
  static boolean VarDefinitionList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDefinitionList")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = VarDefinition(b, l + 1);
    p = r; // pin = 1
    r = r && VarDefinitionList_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (',' VarDefinition)*
  private static boolean VarDefinitionList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDefinitionList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!VarDefinitionList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VarDefinitionList_1", c)) break;
    }
    return true;
  }

  // ',' VarDefinition
  private static boolean VarDefinitionList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDefinitionList_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && VarDefinition(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // (mut | shared)*
  public static boolean VarModifiers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarModifiers")) return false;
    Marker m = enter_section_(b, l, _NONE_, VAR_MODIFIERS, "<var modifiers>");
    while (true) {
      int c = current_position_(b);
      if (!VarModifiers_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VarModifiers", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // mut | shared
  private static boolean VarModifiers_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarModifiers_0")) return false;
    boolean r;
    r = consumeToken(b, MUT);
    if (!r) r = consumeToken(b, SHARED);
    return r;
  }

  /* ********************************************************** */
  // '<NL>' | ';' | <<eof>>
  static boolean semi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "semi")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMICOLON_SYNTHETIC);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression root: Expression
  // Operator priority table:
  // 0: POSTFIX(OrBlockExpr)
  // 1: BINARY(OrExpr)
  // 2: BINARY(AndExpr)
  // 3: BINARY(ConditionalExpr)
  // 4: BINARY(AddExpr)
  // 5: BINARY(MulExpr)
  // 6: PREFIX(UnaryExpr)
  // 7: BINARY(SendExpr)
  // 8: BINARY(RangeExpr)
  // 9: ATOM(TypeInitExpr)
  // 10: ATOM(UnsafeExpression)
  // 11: ATOM(MatchExpression)
  // 12: ATOM(IfExpression)
  // 13: ATOM(CompileTimeIfExpression)
  // 14: ATOM(ArrayCreation)
  // 15: BINARY(InExpression)
  // 16: BINARY(NotInExpression)
  // 17: BINARY(IsExpression)
  // 18: BINARY(NotIsExpression)
  // 19: BINARY(AsExpression)
  // 20: ATOM(ReferenceExpression) POSTFIX(CallExpr) POSTFIX(IndexOrSliceExpr) ATOM(Literal)
  //    ATOM(FunctionLit)
  // 21: ATOM(EnumFetch)
  // 22: PREFIX(MutExpression)
  // 23: POSTFIX(DotExpression)
  // 24: POSTFIX(ErrorPropagationExpression)
  // 25: ATOM(ConstexprIdentifierExpression)
  // 26: ATOM(ParenthesesExpr)
  public static boolean Expression(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    addVariant(b, "<expression>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expression>");
    r = UnaryExpr(b, l + 1);
    if (!r) r = TypeInitExpr(b, l + 1);
    if (!r) r = UnsafeExpression(b, l + 1);
    if (!r) r = MatchExpression(b, l + 1);
    if (!r) r = IfExpression(b, l + 1);
    if (!r) r = CompileTimeIfExpression(b, l + 1);
    if (!r) r = ArrayCreation(b, l + 1);
    if (!r) r = ReferenceExpression(b, l + 1);
    if (!r) r = Literal(b, l + 1);
    if (!r) r = FunctionLit(b, l + 1);
    if (!r) r = EnumFetch(b, l + 1);
    if (!r) r = MutExpression(b, l + 1);
    if (!r) r = ConstexprIdentifierExpression(b, l + 1);
    if (!r) r = ParenthesesExpr(b, l + 1);
    p = r;
    r = r && Expression_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean Expression_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "Expression_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 0 && OrBlockExpr_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, OR_BLOCK_EXPR, r, true, null);
      }
      else if (g < 1 && consumeTokenSmart(b, COND_OR)) {
        r = Expression(b, l, 1);
        exit_section_(b, l, m, OR_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, COND_AND)) {
        r = Expression(b, l, 2);
        exit_section_(b, l, m, AND_EXPR, r, true, null);
      }
      else if (g < 3 && RelOp(b, l + 1)) {
        r = Expression(b, l, 3);
        exit_section_(b, l, m, CONDITIONAL_EXPR, r, true, null);
      }
      else if (g < 4 && AddOp(b, l + 1)) {
        r = Expression(b, l, 4);
        exit_section_(b, l, m, ADD_EXPR, r, true, null);
      }
      else if (g < 5 && MulOp(b, l + 1)) {
        r = Expression(b, l, 5);
        exit_section_(b, l, m, MUL_EXPR, r, true, null);
      }
      else if (g < 7 && consumeTokenSmart(b, SEND_CHANNEL)) {
        r = Expression(b, l, 7);
        exit_section_(b, l, m, SEND_EXPR, r, true, null);
      }
      else if (g < 8 && RangeExpr_0(b, l + 1)) {
        r = Expression(b, l, 8);
        exit_section_(b, l, m, RANGE_EXPR, r, true, null);
      }
      else if (g < 15 && consumeTokenSmart(b, IN)) {
        r = Expression(b, l, 15);
        exit_section_(b, l, m, IN_EXPRESSION, r, true, null);
      }
      else if (g < 16 && consumeTokenSmart(b, NOT_IN)) {
        r = Expression(b, l, 16);
        exit_section_(b, l, m, NOT_IN_EXPRESSION, r, true, null);
      }
      else if (g < 17 && consumeTokenSmart(b, IS)) {
        r = Expression(b, l, 17);
        exit_section_(b, l, m, IS_EXPRESSION, r, true, null);
      }
      else if (g < 18 && consumeTokenSmart(b, NOT_IS)) {
        r = Expression(b, l, 18);
        exit_section_(b, l, m, NOT_IS_EXPRESSION, r, true, null);
      }
      else if (g < 19 && consumeTokenSmart(b, AS)) {
        r = Expression(b, l, 19);
        exit_section_(b, l, m, AS_EXPRESSION, r, true, null);
      }
      else if (g < 20 && ArgumentList(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, CALL_EXPR, r, true, null);
      }
      else if (g < 20 && IndexOrSliceExpr_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, INDEX_OR_SLICE_EXPR, r, true, null);
      }
      else if (g < 23 && DotExpression_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, DOT_EXPRESSION, r, true, null);
      }
      else if (g < 24 && consumeTokenSmart(b, QUESTION)) {
        r = true;
        exit_section_(b, l, m, ERROR_PROPAGATION_EXPRESSION, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // or Block
  private static boolean OrBlockExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OrBlockExpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, OR);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  public static boolean UnaryExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryExpr")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = UnaryOp(b, l + 1);
    p = r;
    r = p && Expression(b, l, 6);
    exit_section_(b, l, m, UNARY_EXPR, r, p, null);
    return r || p;
  }

  // ('..' | '...') !']'
  private static boolean RangeExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RangeExpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = RangeExpr_0_0(b, l + 1);
    r = r && RangeExpr_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '..' | '...'
  private static boolean RangeExpr_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RangeExpr_0_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, RANGE);
    if (!r) r = consumeTokenSmart(b, TRIPLE_DOT);
    return r;
  }

  // !']'
  private static boolean RangeExpr_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RangeExpr_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeTokenSmart(b, RBRACK);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TypeDecl '{' ( '}' | FieldInitialization '}')
  public static boolean TypeInitExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeInitExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_INIT_EXPR, "<type init expr>");
    r = TypeDecl(b, l + 1);
    r = r && consumeToken(b, LBRACE);
    r = r && TypeInitExpr_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '}' | FieldInitialization '}'
  private static boolean TypeInitExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeInitExpr_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, RBRACE);
    if (!r) r = TypeInitExpr_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FieldInitialization '}'
  private static boolean TypeInitExpr_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeInitExpr_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FieldInitialization(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // unsafe Block
  public static boolean UnsafeExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnsafeExpression")) return false;
    if (!nextTokenIsSmart(b, UNSAFE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, UNSAFE_EXPRESSION, null);
    r = consumeTokenSmart(b, UNSAFE);
    p = r; // pin = 1
    r = r && Block(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // match Expression '{' MatchArms '}'
  public static boolean MatchExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchExpression")) return false;
    if (!nextTokenIsSmart(b, MATCH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATCH_EXPRESSION, null);
    r = consumeTokenSmart(b, MATCH);
    p = r; // pin = 1
    r = r && report_error_(b, Expression(b, l + 1, -1));
    r = p && report_error_(b, consumeToken(b, LBRACE)) && r;
    r = p && report_error_(b, MatchArms(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // if Condition Block ElseStatement?
  public static boolean IfExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfExpression")) return false;
    if (!nextTokenIsSmart(b, IF)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IF_EXPRESSION, null);
    r = consumeTokenSmart(b, IF);
    p = r; // pin = 1
    r = r && report_error_(b, Condition(b, l + 1));
    r = p && report_error_(b, Block(b, l + 1)) && r;
    r = p && IfExpression_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ElseStatement?
  private static boolean IfExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfExpression_3")) return false;
    ElseStatement(b, l + 1);
    return true;
  }

  // IF_COMPILE_TIME Condition Block CompileElseStatement?
  public static boolean CompileTimeIfExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompileTimeIfExpression")) return false;
    if (!nextTokenIsSmart(b, IF_COMPILE_TIME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, COMPILE_TIME_IF_EXPRESSION, null);
    r = consumeTokenSmart(b, IF_COMPILE_TIME);
    p = r; // pin = 1
    r = r && report_error_(b, Condition(b, l + 1));
    r = p && report_error_(b, Block(b, l + 1)) && r;
    r = p && CompileTimeIfExpression_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // CompileElseStatement?
  private static boolean CompileTimeIfExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompileTimeIfExpression_3")) return false;
    CompileElseStatement(b, l + 1);
    return true;
  }

  // '[' ArrayCreationList? (']' '!'?)
  public static boolean ArrayCreation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayCreation")) return false;
    if (!nextTokenIsSmart(b, LBRACK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_CREATION, null);
    r = consumeTokenSmart(b, LBRACK);
    p = r; // pin = 1
    r = r && report_error_(b, ArrayCreation_1(b, l + 1));
    r = p && ArrayCreation_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ArrayCreationList?
  private static boolean ArrayCreation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayCreation_1")) return false;
    ArrayCreationList(b, l + 1);
    return true;
  }

  // ']' '!'?
  private static boolean ArrayCreation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayCreation_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, RBRACK);
    r = r && ArrayCreation_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '!'?
  private static boolean ArrayCreation_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayCreation_2_1")) return false;
    consumeTokenSmart(b, NOT);
    return true;
  }

  // identifier
  public static boolean ReferenceExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReferenceExpression")) return false;
    if (!nextTokenIsSmart(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, IDENTIFIER);
    exit_section_(b, m, REFERENCE_EXPRESSION, r);
    return r;
  }

  // ('[' | HASH_LBRACK) (SliceExprBody | IndexExprBody) '..'? ']'
  private static boolean IndexOrSliceExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IndexOrSliceExpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IndexOrSliceExpr_0_0(b, l + 1);
    r = r && IndexOrSliceExpr_0_1(b, l + 1);
    r = r && IndexOrSliceExpr_0_2(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' | HASH_LBRACK
  private static boolean IndexOrSliceExpr_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IndexOrSliceExpr_0_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, LBRACK);
    if (!r) r = consumeTokenSmart(b, HASH_LBRACK);
    return r;
  }

  // SliceExprBody | IndexExprBody
  private static boolean IndexOrSliceExpr_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IndexOrSliceExpr_0_1")) return false;
    boolean r;
    r = SliceExprBody(b, l + 1);
    if (!r) r = IndexExprBody(b, l + 1);
    return r;
  }

  // '..'?
  private static boolean IndexOrSliceExpr_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IndexOrSliceExpr_0_2")) return false;
    consumeTokenSmart(b, RANGE);
    return true;
  }

  // int
  //   | float
  //   | floati
  //   | decimali
  //   | hex
  //   | oct
  //   | bin
  //   | StringLiteral
  //   | char
  public static boolean Literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, LITERAL, "<literal>");
    r = consumeTokenSmart(b, INT);
    if (!r) r = consumeTokenSmart(b, FLOAT);
    if (!r) r = consumeTokenSmart(b, FLOATI);
    if (!r) r = consumeTokenSmart(b, DECIMALI);
    if (!r) r = consumeTokenSmart(b, HEX);
    if (!r) r = consumeTokenSmart(b, OCT);
    if (!r) r = consumeTokenSmart(b, BIN);
    if (!r) r = StringLiteral(b, l + 1);
    if (!r) r = consumeTokenSmart(b, CHAR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // fn Signature Block
  public static boolean FunctionLit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionLit")) return false;
    if (!nextTokenIsSmart(b, FN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_LIT, null);
    r = consumeTokenSmart(b, FN);
    p = r; // pin = 1
    r = r && report_error_(b, Signature(b, l + 1));
    r = p && Block(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // '.' identifier
  public static boolean EnumFetch(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumFetch")) return false;
    if (!nextTokenIsSmart(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokensSmart(b, 2, DOT, IDENTIFIER);
    exit_section_(b, m, ENUM_FETCH, r);
    return r;
  }

  public static boolean MutExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MutExpression")) return false;
    if (!nextTokenIsSmart(b, MUT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, MUT);
    p = r;
    r = p && Expression(b, l, 22);
    exit_section_(b, l, m, MUT_EXPRESSION, r, p, null);
    return r || p;
  }

  // '.' MethodOrField
  private static boolean DotExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DotExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, DOT);
    r = r && MethodOrField(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '@' identifier
  public static boolean ConstexprIdentifierExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstexprIdentifierExpression")) return false;
    if (!nextTokenIsSmart(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokensSmart(b, 2, AT, IDENTIFIER);
    exit_section_(b, m, CONSTEXPR_IDENTIFIER_EXPRESSION, r);
    return r;
  }

  // '(' /*<<enterMode "PAR">>*/ Expression /*<<exitModeSafe "PAR">>*/')'
  public static boolean ParenthesesExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParenthesesExpr")) return false;
    if (!nextTokenIsSmart(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PARENTHESES_EXPR, null);
    r = consumeTokenSmart(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, Expression(b, l + 1, -1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

}
