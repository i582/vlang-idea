package org.vlang.ide.highlight

import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.intellij.psi.codeStyle.DisplayPriority
import com.intellij.psi.codeStyle.DisplayPrioritySortable
import org.vlang.ide.ui.PluginIcons
import org.vlang.lang.VlangSyntaxHighlighter

// TODO: add all descriptors when ready
class VlangColorsAndFontsPage : ColorSettingsPage, DisplayPrioritySortable {
    companion object {
        private val DESCRIPTORS = arrayOf(
            AttributesDescriptor("Label", VlangHighlightingData.VLANG_LABEL),
        )
    }

    override fun getHighlighter() = VlangSyntaxHighlighter()

    override fun getAdditionalHighlightingTagToDescriptorMap() = mutableMapOf(
        "label" to VlangHighlightingData.VLANG_LABEL,
    )

    override fun getIcon() = PluginIcons.vlang

    override fun getAttributeDescriptors() = DESCRIPTORS

    override fun getColorDescriptors() = arrayOf<ColorDescriptor>()

    override fun getDisplayName() = "V"

    override fun getDemoText() = """
module main

import os
import other { SomeOtherStruct, other_func }

type IntOrString = int | string

// line comment
pub struct PublicStruct {
mut:
    mut_field string
pub:
    pub_filed int
pub mut:
    pub_mut_filed bool
}

/*
 block comment
 */
interface Colorable {
    style style.Style

    method() Color [deprecated: 'use new_method() instead']
    new_method() Color
}

[flag]
enum Color {
    red = 0
    blue = 1
    green
}

union Type {
    str string
    int i64
}

/**
 * Block comment
 * @return blue color
 */
[inline]
fn get_color() Color {
	return .blue
}

struct Undo {
	board Board
	state GameState
}

fn main() {
    print('Hello ${"$"}name!')

    mut undo := []Undo{cap: 4096}
    println(undo)

label:
    str := PublicStruct{}
    str.pub_mut_filed = true
    str.pub_filed = 10

    outer: for i in 0 .. 10 {
        for j in 0 .. 10 {
            break outer
        }
    }

    unsafe {
        goto label
    }
}
    """.trimIndent()

    override fun getPriority() = DisplayPriority.KEY_LANGUAGE_SETTINGS
}
