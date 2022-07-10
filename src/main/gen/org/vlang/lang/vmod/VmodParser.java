// This is a generated file. Not intended for manual editing.
package org.vlang.lang.vmod;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.vlang.lang.vmod.VmodTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class VmodParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
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

  /* ********************************************************** */
  // '[' ArrayItems? ']'
  public static boolean Array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Array")) return false;
    if (!nextTokenIs(b, LBRACK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && Array_1(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, m, ARRAY, r);
    return r;
  }

  // ArrayItems?
  private static boolean Array_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Array_1")) return false;
    ArrayItems(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // string
  public static boolean ArrayItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayItem")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, ARRAY_ITEM, r);
    return r;
  }

  /* ********************************************************** */
  // ArrayItem semi? (',' ArrayItem semi?)* ','?
  public static boolean ArrayItems(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayItems")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_ITEMS, null);
    r = ArrayItem(b, l + 1);
    r = r && ArrayItems_1(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, ArrayItems_2(b, l + 1));
    r = p && ArrayItems_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // semi?
  private static boolean ArrayItems_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayItems_1")) return false;
    semi(b, l + 1);
    return true;
  }

  // (',' ArrayItem semi?)*
  private static boolean ArrayItems_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayItems_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ArrayItems_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ArrayItems_2", c)) break;
    }
    return true;
  }

  // ',' ArrayItem semi?
  private static boolean ArrayItems_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayItems_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ArrayItem(b, l + 1);
    r = r && ArrayItems_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // semi?
  private static boolean ArrayItems_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayItems_2_0_2")) return false;
    semi(b, l + 1);
    return true;
  }

  // ','?
  private static boolean ArrayItems_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayItems_3")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // string | Array
  public static boolean Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    if (!nextTokenIs(b, "<expression>", LBRACK, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = consumeToken(b, STRING);
    if (!r) r = Array(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FieldName ':' Expression
  public static boolean Field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Field")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FieldName(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, FIELD, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean FieldName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, FIELD_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // Field (semi Field)*
  public static boolean Fields(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Fields")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Field(b, l + 1);
    r = r && Fields_1(b, l + 1);
    exit_section_(b, m, FIELDS, r);
    return r;
  }

  // (semi Field)*
  private static boolean Fields_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Fields_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Fields_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Fields_1", c)) break;
    }
    return true;
  }

  // semi Field
  private static boolean Fields_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Fields_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = semi(b, l + 1);
    r = r && Field(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ModuleDeclaration
  static boolean File(PsiBuilder b, int l) {
    return ModuleDeclaration(b, l + 1);
  }

  /* ********************************************************** */
  // module '{' Fields? semi '}'
  public static boolean ModuleDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModuleDeclaration")) return false;
    if (!nextTokenIs(b, MODULE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MODULE, LBRACE);
    r = r && ModuleDeclaration_2(b, l + 1);
    r = r && semi(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, MODULE_DECLARATION, r);
    return r;
  }

  // Fields?
  private static boolean ModuleDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModuleDeclaration_2")) return false;
    Fields(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '<NL>' | ';' | <<eof>>
  static boolean semi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "semi")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMICOLON_SYNTHETIC);
    if (!r) r = consumeToken(b, ";");
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
