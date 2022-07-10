// This is a generated file. Not intended for manual editing.
package org.vlang.lang.vmod.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import org.vlang.vmod.psi.VmodCompositeElement;

public class VmodVisitor extends PsiElementVisitor {

  public void visitArray(@NotNull VmodArray o) {
    visitCompositeElement(o);
  }

  public void visitArrayItem(@NotNull VmodArrayItem o) {
    visitCompositeElement(o);
  }

  public void visitArrayItems(@NotNull VmodArrayItems o) {
    visitCompositeElement(o);
  }

  public void visitExpression(@NotNull VmodExpression o) {
    visitCompositeElement(o);
  }

  public void visitField(@NotNull VmodField o) {
    visitCompositeElement(o);
  }

  public void visitFieldName(@NotNull VmodFieldName o) {
    visitCompositeElement(o);
  }

  public void visitFields(@NotNull VmodFields o) {
    visitCompositeElement(o);
  }

  public void visitModuleDeclaration(@NotNull VmodModuleDeclaration o) {
    visitCompositeElement(o);
  }

  public void visitCompositeElement(@NotNull VmodCompositeElement o) {
    visitElement(o);
  }

}
