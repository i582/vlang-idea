// This is a generated file. Not intended for manual editing.
package org.vlang.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import org.vlang.lang.stubs.VlangEnumDeclarationStub;

public interface VlangEnumDeclaration extends VlangNamedElement, StubBasedPsiElement<VlangEnumDeclarationStub> {

  @Nullable
  VlangAttributes getAttributes();

  @Nullable
  VlangEnumFields getEnumFields();

  @Nullable
  VlangGenericDeclaration getGenericDeclaration();

  @Nullable
  VlangSymbolVisibility getSymbolVisibility();

  @Nullable
  PsiElement getLbrace();

  @Nullable
  PsiElement getRbrace();

  @NotNull
  PsiElement getEnum();

  @Nullable
  PsiElement getIdentifier();

  @NotNull
  String getName();

}
