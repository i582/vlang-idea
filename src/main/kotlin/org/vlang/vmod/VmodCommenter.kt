package org.vlang.vmod

import com.intellij.lang.Commenter

class VmodCommenter : Commenter {
    override fun getLineCommentPrefix() = "//"

    override fun getBlockCommentPrefix() = "/*"

    override fun getBlockCommentSuffix() = "*/"

    override fun getCommentedBlockCommentPrefix() = "/**"

    override fun getCommentedBlockCommentSuffix() = "*/"
}
