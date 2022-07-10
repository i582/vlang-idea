package org.vlang.ide.inspections

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import org.vlang.lang.psi.VlangCallExpr
import org.vlang.lang.psi.VlangReferenceExpression
import org.vlang.lang.psi.VlangVisitor

class VlangUndefinedFunctionInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : VlangVisitor() {
            override fun visitCallExpr(o: VlangCallExpr) {
                val expr = o.expression as? VlangReferenceExpression ?: return
                val ref = expr.reference
                val func = ref.resolve()
                if (func == null) {
                    holder.registerProblem(expr.getIdentifier(), "Undefined function", ProblemHighlightType.GENERIC_ERROR)
                }
            }
        }
    }
}
