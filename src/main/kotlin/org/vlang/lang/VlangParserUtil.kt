package org.vlang.lang

import com.intellij.lang.PsiBuilder
import com.intellij.lang.parser.GeneratedParserUtilBase
import com.intellij.openapi.util.Key
import gnu.trove.TObjectIntHashMap

object VlangParserUtil : GeneratedParserUtilBase() {
    private val MODES_KEY = Key.create<TObjectIntHashMap<String>>("MODES_KEY")

    private fun getParsingModes(builder: PsiBuilder): TObjectIntHashMap<String> {
        var flags = builder.getUserData(MODES_KEY)
        if (flags == null) {
            flags = TObjectIntHashMap<String>()
            builder.putUserData(MODES_KEY, flags)
        }
        return flags
    }

//    fun consumeBlock(builder: PsiBuilder, level: Int): Boolean {
//        val file = builder.getUserDataUnprotected(FileContextUtil.CONTAINING_FILE_KEY)
//        val data = file?.getUserData(IndexingDataKeys.VIRTUAL_FILE)
//            ?: return false
//        var i = 0
//        val m = builder.mark()
//        do {
//            val type = builder.tokenType
//            if (type === VlangTypes.TYPE_ && nextIdentifier(builder)) { // don't count a.(type), only type <ident>
//                m.rollbackTo()
//                return false
//            }
//            i += if (type === VlangTypes.LBRACE) 1 else if (type === VlangTypes.RBRACE) -1 else 0
//            builder.advanceLexer()
//        } while (i > 0 && !builder.eof())
//        val result = i == 0
//        if (result) {
//            m.drop()
//        } else {
//            m.rollbackTo()
//        }
//        return result
//    }
//
//    private fun nextIdentifier(builder: PsiBuilder): Boolean {
//        var e: IElementType
//        var i = 0
//        while (builder.rawLookup(++i).also { e = it!! } === VlangParserDefinition.WS || e === VlangParserDefinition.NLS) {
//        }
//        return e === VlangTypes.IDENTIFIER
//    }
//
//    fun emptyImportList(builder: PsiBuilder?, level: Int): Boolean {
//        val marker = getCurrentMarker((if (builder is PsiBuilderAdapter) builder.delegate else builder)!!)
//        marker?.setCustomEdgeTokenBinders(WhitespacesBinders.GREEDY_LEFT_BINDER, null)
//        return true
//    }

    @JvmStatic
    fun isModeOn(builder: PsiBuilder, level: Int, mode: String?): Boolean {
        return getParsingModes(builder)[mode] > 0
    }

//    fun withOn(builder: PsiBuilder, level_: Int, mode: String, parser: GeneratedParserUtilBase.Parser): Boolean {
//        return withImpl(builder, level_, mode, true, parser, parser)
//    }

    @JvmStatic
    fun withOff(
        builder: PsiBuilder,
        level_: Int,
        parser: Parser,
        vararg modes: String
    ): Boolean {
        val map = getParsingModes(builder)
        val prev = TObjectIntHashMap<String>()
        for (mode in modes) {
            val p = map[mode]
            if (p > 0) {
                map.put(mode, 0)
                prev.put(mode, p)
            }
        }
        val result: Boolean = parser.parse(builder, level_)
        prev.forEachEntry { mode: String?, p: Int ->
            map.put(mode, p)
            true
        }
        return result
    }

    //    private fun withImpl(
//        builder: PsiBuilder,
//        level_: Int,
//        mode: String,
//        onOff: Boolean,
//        whenOn: GeneratedParserUtilBase.Parser,
//        whenOff: GeneratedParserUtilBase.Parser
//    ): Boolean {
//        val map = getParsingModes(builder)
//        val prev = map[mode]
//        val change = prev and 1 == 0 == onOff
//        if (change) map.put(mode, prev shl 1 or if (onOff) 1 else 0)
//        val result: Boolean = (if (change) whenOn else whenOff).parse(builder, level_)
//        if (change) map.put(mode, prev)
//        return result
//    }
//
    @JvmStatic
    fun isModeOff(builder: PsiBuilder, level: Int, mode: String?): Boolean {
        return getParsingModes(builder)[mode] == 0
    }

//    fun prevIsType(builder: PsiBuilder, level: Int): Boolean {
//        val marker = builder.latestDoneMarker
//        val type = marker?.tokenType
//        return type === VlangTypes.ARRAY_OR_SLICE_TYPE || type === VlangTypes.MAP_TYPE || type === VlangTypes.STRUCT_TYPE
//    }
//
//    fun keyOrValueExpression(builder: PsiBuilder, level: Int): Boolean {
//        val m: PsiBuilder.Marker = GeneratedParserUtilBase.enter_section_(builder)
//        var r: Boolean = VlangParser.Expression(builder, level + 1, -1)
//        if (!r) r = VlangParser.LiteralValue(builder, level + 1)
//        val type: IElementType = if (r && builder.tokenType === VlangTypes.COLON) VlangTypes.KEY else VlangTypes.VALUE
//        GeneratedParserUtilBase.exit_section_(builder, m, type, r)
//        return r
//    }

    @JvmStatic
    fun enterMode(builder: PsiBuilder, level: Int, mode: String?): Boolean {
        val flags = getParsingModes(builder)
        if (!flags.increment(mode)) flags.put(mode, 1)
        return true
    }

    private fun exitMode(builder: PsiBuilder, level: Int, mode: String, safe: Boolean): Boolean {
        val flags = getParsingModes(builder)
        val count = flags[mode]
        if (count == 1) {
            flags.remove(mode)
        } else if (count > 1) {
            flags.put(mode, count - 1)
        } else if (!safe) {
            builder.error("Could not exit inactive '" + mode + "' mode at offset " + builder.currentOffset)
        }
        return true
    }

    @JvmStatic
    fun exitMode(builder: PsiBuilder, level: Int, mode: String): Boolean {
        return exitMode(builder, level, mode, safe = false)
    }

    @JvmStatic
    fun exitModeSafe(builder: PsiBuilder, level: Int, mode: String): Boolean {
        return exitMode(builder, level, mode, safe = true)
    }

//    fun isBuiltin(builder: PsiBuilder, level: Int): Boolean {
//        val marker = builder.latestDoneMarker ?: return false
//        val text = builder.originalText.subSequence(marker.startOffset, marker.endOffset).toString().trim { it <= ' ' }
//        return "make" == text || "new" == text
//    }
//
//    private fun getCurrentMarker(builder: PsiBuilder): PsiBuilder.Marker? {
//        try {
//            for (field in builder.javaClass.declaredFields) {
//                if ("MyList" == field.type.simpleName) {
//                    field.isAccessible = true
//                    return ContainerUtil.getLastItem(
//                        field[builder] as List<PsiBuilder.Marker>
//                    )
//                }
//            }
//        } catch (ignored: Exception) {
//        }
//        return null
//    }
//
//    fun nextTokenIsSmart(builder: PsiBuilder?, token: IElementType?): Boolean {
//        return GeneratedParserUtilBase.nextTokenIsFast(
//            builder,
//            token
//        ) || GeneratedParserUtilBase.ErrorState.get(builder).completionState != null
//    }
//
//    fun nextTokenIsSmart(builder: PsiBuilder?, vararg tokens: IElementType?): Boolean {
//        return GeneratedParserUtilBase.nextTokenIsFast(builder, *tokens) || GeneratedParserUtilBase.ErrorState.get(
//            builder
//        ).completionState != null
//    }
}