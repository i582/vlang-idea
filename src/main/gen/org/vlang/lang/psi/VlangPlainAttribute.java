// This is a generated file. Not intended for manual editing.
package org.vlang.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VlangPlainAttribute extends VlangCompositeElement {

  @NotNull
  List<VlangStringLiteral> getStringLiteralList();

  @Nullable
  PsiElement getAsmIdentifier();

  @Nullable
  PsiElement getColon();

  @Nullable
  PsiElement getIdentifier();

  @Nullable
  PsiElement getInt();

  @Nullable
  PsiElement getString();

  @Nullable
  PsiElement getUnsafe();

}
