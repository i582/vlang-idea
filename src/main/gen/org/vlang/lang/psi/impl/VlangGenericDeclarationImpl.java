// This is a generated file. Not intended for manual editing.
package org.vlang.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.vlang.lang.psi.VlangPsiTreeUtil;
import static org.vlang.lang.VlangTypes.*;
import org.vlang.lang.psi.*;

public class VlangGenericDeclarationImpl extends VlangCompositeElementImpl implements VlangGenericDeclaration {

  public VlangGenericDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VlangVisitor visitor) {
    visitor.visitGenericDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VlangVisitor) accept((VlangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public VlangGenericDeclarationList getGenericDeclarationList() {
    return notNullChild(VlangPsiTreeUtil.getChildOfType(this, VlangGenericDeclarationList.class));
  }

  @Override
  @NotNull
  public PsiElement getGreater() {
    return notNullChild(findChildByType(GREATER));
  }

  @Override
  @NotNull
  public PsiElement getLess() {
    return notNullChild(findChildByType(LESS));
  }

}
