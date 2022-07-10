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

public class VmodArrayImpl extends VmodCompositeElementImpl implements VmodArray {

  public VmodArrayImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VmodVisitor visitor) {
    visitor.visitArray(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VmodVisitor) accept((VmodVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VmodArrayItems getArrayItems() {
    return findChildByClass(VmodArrayItems.class);
  }

  @Override
  @NotNull
  public PsiElement getLbrack() {
    return findNotNullChildByType(LBRACK);
  }

  @Override
  @NotNull
  public PsiElement getRbrack() {
    return findNotNullChildByType(RBRACK);
  }

}
