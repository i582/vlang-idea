// This is a generated file. Not intended for manual editing.
package org.vlang.lang.vmod.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import org.vlang.vmod.psi.VmodCompositeElement;

public interface VmodModuleDeclaration extends VmodCompositeElement {

  @Nullable
  VmodFields getFields();

  @NotNull
  PsiElement getLbrace();

  @NotNull
  PsiElement getRbrace();

  @Nullable
  PsiElement getSemicolonSynthetic();

  @NotNull
  PsiElement getModule();

}
