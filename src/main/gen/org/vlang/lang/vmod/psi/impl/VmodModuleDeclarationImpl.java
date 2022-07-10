// This is a generated file. Not intended for manual editing.
package org.vlang.lang.vmod.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.vlang.lang.vmod.VmodTypes.*;
import org.vlang.vmod.psi.impl.VmodCompositeElementImpl;
import org.vlang.lang.vmod.psi.*;

public class VmodModuleDeclarationImpl extends VmodCompositeElementImpl implements VmodModuleDeclaration {

  public VmodModuleDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VmodVisitor visitor) {
    visitor.visitModuleDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VmodVisitor) accept((VmodVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VmodFields getFields() {
    return findChildByClass(VmodFields.class);
  }

  @Override
  @NotNull
  public PsiElement getLbrace() {
    return findNotNullChildByType(LBRACE);
  }

  @Override
  @NotNull
  public PsiElement getRbrace() {
    return findNotNullChildByType(RBRACE);
  }

  @Override
  @Nullable
  public PsiElement getSemicolonSynthetic() {
    return findChildByType(SEMICOLON_SYNTHETIC);
  }

  @Override
  @NotNull
  public PsiElement getModule() {
    return findNotNullChildByType(MODULE);
  }

}
