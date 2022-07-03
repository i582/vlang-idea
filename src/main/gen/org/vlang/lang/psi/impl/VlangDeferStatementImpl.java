// This is a generated file. Not intended for manual editing.
package org.vlang.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.vlang.lang.psi.VlangBlock;
import org.vlang.lang.psi.VlangDeferStatement;
import org.vlang.lang.psi.VlangPsiTreeUtil;
import org.vlang.lang.psi.VlangVisitor;

import static org.vlang.lang.VlangTypes.DEFER;

public class VlangDeferStatementImpl extends VlangStatementImpl implements VlangDeferStatement {

  public VlangDeferStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull VlangVisitor visitor) {
    visitor.visitDeferStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VlangVisitor) accept((VlangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public VlangBlock getBlock() {
    return notNullChild(VlangPsiTreeUtil.getChildOfType(this, VlangBlock.class));
  }

  @Override
  @NotNull
  public PsiElement getDefer() {
    return notNullChild(findChildByType(DEFER));
  }

}