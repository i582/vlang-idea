// This is a generated file. Not intended for manual editing.
package org.vlang.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VlangStructType extends VlangTypeDecl {

  @Nullable
  VlangFieldDeclaration getFieldDeclaration();

  @Nullable
  VlangMemberModifiers getMemberModifiers();

  @Nullable
  PsiElement getLbrace();

  @Nullable
  PsiElement getRbrace();

  @Nullable
  PsiElement getIdentifier();

  @NotNull
  PsiElement getStruct();

}
