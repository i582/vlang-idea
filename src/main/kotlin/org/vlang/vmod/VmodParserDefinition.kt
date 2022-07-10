package org.vlang.vmod

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import org.vlang.lang.vmod.VmodParser
import org.vlang.lang.vmod.VmodTypes
import org.vlang.vmod.lexer.VmodLexer
import org.vlang.vmod.psi.VmodFile
import org.vlang.vmod.psi.VmodTokenTypes

class VmodParserDefinition : ParserDefinition {
    override fun createLexer(project: Project) = VmodLexer()

    override fun createParser(project: Project) = VmodParser()

    override fun getWhitespaceTokens() = VmodTokenTypes.WHITE_SPACES

    override fun getCommentTokens() = VmodTokenTypes.COMMENTS

    override fun getStringLiteralElements() = VmodTokenTypes.STRING_LITERALS

    override fun getFileNodeType() = VmodFileElementType.INSTANCE

    override fun createFile(viewProvider: FileViewProvider) = VmodFile(viewProvider)

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode) = SpaceRequirements.MAY

    override fun createElement(node: ASTNode): PsiElement = VmodTypes.Factory.createElement(node)
}
