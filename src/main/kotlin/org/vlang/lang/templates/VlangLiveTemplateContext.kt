package org.vlang.lang.templates

import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType

class VlangLiveTemplateContext : TemplateContextType("VLANG", "V Lang") {
    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        return templateActionContext.file.name.endsWith(".v")
    }
}
