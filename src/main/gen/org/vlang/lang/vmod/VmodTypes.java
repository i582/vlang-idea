// This is a generated file. Not intended for manual editing.
package org.vlang.lang.vmod;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.vlang.vmod.psi.VmodCompositeElementType;
import org.vlang.vmod.psi.VmodTokenType;
import org.vlang.lang.vmod.psi.impl.*;

public interface VmodTypes {

  IElementType ARRAY = new VmodCompositeElementType("ARRAY");
  IElementType ARRAY_ITEM = new VmodCompositeElementType("ARRAY_ITEM");
  IElementType ARRAY_ITEMS = new VmodCompositeElementType("ARRAY_ITEMS");
  IElementType EXPRESSION = new VmodCompositeElementType("EXPRESSION");
  IElementType FIELD = new VmodCompositeElementType("FIELD");
  IElementType FIELDS = new VmodCompositeElementType("FIELDS");
  IElementType FIELD_NAME = new VmodCompositeElementType("FIELD_NAME");
  IElementType MODULE_DECLARATION = new VmodCompositeElementType("MODULE_DECLARATION");

  IElementType COLON = new VmodTokenType(":");
  IElementType COMMA = new VmodTokenType(",");
  IElementType IDENTIFIER = new VmodTokenType("identifier");
  IElementType LBRACE = new VmodTokenType("{");
  IElementType LBRACK = new VmodTokenType("[");
  IElementType LPAREN = new VmodTokenType("(");
  IElementType MODULE = new VmodTokenType("module");
  IElementType RBRACE = new VmodTokenType("}");
  IElementType RBRACK = new VmodTokenType("]");
  IElementType RPAREN = new VmodTokenType(")");
  IElementType SEMICOLON_SYNTHETIC = new VmodTokenType("<NL>");
  IElementType SINGLE_QUOTE = new VmodTokenType("'");
  IElementType STRING = new VmodTokenType("string");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARRAY) {
        return new VmodArrayImpl(node);
      }
      else if (type == ARRAY_ITEM) {
        return new VmodArrayItemImpl(node);
      }
      else if (type == ARRAY_ITEMS) {
        return new VmodArrayItemsImpl(node);
      }
      else if (type == EXPRESSION) {
        return new VmodExpressionImpl(node);
      }
      else if (type == FIELD) {
        return new VmodFieldImpl(node);
      }
      else if (type == FIELDS) {
        return new VmodFieldsImpl(node);
      }
      else if (type == FIELD_NAME) {
        return new VmodFieldNameImpl(node);
      }
      else if (type == MODULE_DECLARATION) {
        return new VmodModuleDeclarationImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
