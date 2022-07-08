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

public class VlangStatementImpl extends VlangCompositeElementImpl implements VlangStatement {

  public VlangStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VlangVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VlangVisitor) accept((VlangVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VlangBlock getBlock() {
    return VlangPsiTreeUtil.getChildOfType(this, VlangBlock.class);
  }

  @Override
  @Nullable
  public VlangConstDeclaration getConstDeclaration() {
    return VlangPsiTreeUtil.getChildOfType(this, VlangConstDeclaration.class);
  }

  @Override
  @Nullable
  public VlangSqlStatemnt getSqlStatemnt() {
    return VlangPsiTreeUtil.getChildOfType(this, VlangSqlStatemnt.class);
  }

  @Override
  @Nullable
  public VlangTypeAliasDeclaration getTypeAliasDeclaration() {
    return VlangPsiTreeUtil.getChildOfType(this, VlangTypeAliasDeclaration.class);
  }

}
