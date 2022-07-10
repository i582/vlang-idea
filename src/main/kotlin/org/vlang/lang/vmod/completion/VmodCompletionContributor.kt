package org.vlang.lang.vmod.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import org.vlang.lang.VlangTypes
import org.vlang.lang.psi.VlangEnumDeclaration
import org.vlang.lang.psi.VlangFunctionDeclaration
import org.vlang.lang.psi.VlangStructDeclaration
import org.vlang.lang.psi.VlangTypeAliasDeclaration
import org.vlang.lang.psi.VlangUnionDeclaration
import org.vlang.lang.stubs.index.*
import org.vlang.lang.vmod.VmodTypes

class VmodCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement(VmodTypes.IDENTIFIER),
            FieldsCompletionProvider()
        )
    }

    private class FieldsCompletionProvider : CompletionProvider<CompletionParameters>() {
        override fun addCompletions(
            parameters: CompletionParameters,
            context: ProcessingContext,
            result: CompletionResultSet
        ) {
            for (field in FIELDS) {
                result.addElement(
                    LookupElementBuilder.create(field)
                        .bold()
                        .withInsertHandler(FieldInsertHandler(field))
                )
            }
        }

        class FieldInsertHandler(private val field: String) : InsertHandler<LookupElement> {
            override fun handleInsert(context: InsertionContext, item: LookupElement) {
                val caretOffset = context.editor.caretModel.offset

                val insertValue = if (field == "dependencies") {
                    "[]"
                } else {
                    "''"
                }

                context.document.insertString(caretOffset, ": $insertValue")
                context.editor.caretModel.moveToOffset(caretOffset + 3)
            }
        }

        companion object {
            val FIELDS = listOf(
                "name",
                "author",
                "version",
                "repo_url",
                "vcs",
                "tags",
                "description",
                "license",
                "dependencies",
            )
        }
    }
}
