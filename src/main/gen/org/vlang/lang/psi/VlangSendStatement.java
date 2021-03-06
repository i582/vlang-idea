// This is a generated file. Not intended for manual editing.
package org.vlang.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VlangSendStatement extends VlangStatement {

  @Nullable
  VlangExpression getExpression();

  @Nullable
  VlangLabel getLabel();

  @Nullable
  VlangStatement getStatement();

  @NotNull
  PsiElement getSendChannel();

  //WARNING: getSendExpression(...) is skipped
  //matching getSendExpression(VlangSendStatement, ...)
  //methods are not found in VlangPsiImplUtil

}
