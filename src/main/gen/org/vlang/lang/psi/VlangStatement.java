// This is a generated file. Not intended for manual editing.
package org.vlang.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VlangStatement extends VlangCompositeElement {

  @Nullable
  VlangBlock getBlock();

  @Nullable
  VlangConstDeclaration getConstDeclaration();

  @Nullable
  VlangSqlStatemnt getSqlStatemnt();

  @Nullable
  VlangTypeAliasDeclaration getTypeAliasDeclaration();

  //WARNING: processDeclarations(...) is skipped
  //matching processDeclarations(VlangStatement, ...)
  //methods are not found in VlangPsiImplUtil

}
