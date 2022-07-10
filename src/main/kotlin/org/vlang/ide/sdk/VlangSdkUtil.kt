package org.vlang.ide.sdk

import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Pair
import com.intellij.openapi.util.SystemInfo
import com.intellij.openapi.util.io.FileUtil
import org.jetbrains.annotations.Contract
import java.io.File
import java.io.IOException

object VlangSdkUtil {
    private val ourVersions = HashMap<Pair<File, Long>, String>()
    private const val VLANG_SDK_KNOWN_PATHS = "VLANG_SDK_KNOWN_PATHS"

    fun getSdkVersion(sdkHomePath: String): String? {
        val versionFile = File("$sdkHomePath/version")
        if (versionFile.isFile) {
            val cachedVersion = ourVersions[Pair.create(
                versionFile,
                versionFile.lastModified()
            )]
            if (cachedVersion != null) return cachedVersion
        }
        val version = readVersionFile(sdkHomePath)
        if (version != null) {
            ourVersions[Pair.create(versionFile, versionFile.lastModified())] = version
            return version
        }
        return null
    }

    private fun readVersionFile(sdkHomePath: String): String? {
        val versionFile = File("$sdkHomePath/version")
        if (versionFile.isFile && versionFile.length() < 100) {
            try {
                return FileUtil.loadFile(versionFile).trim { it <= ' ' }
            } catch (e: IOException) {
                /* ignore */
            }
        }
        return null
    }

    @Contract("null->false")
    fun isVlangSdkHome(path: String?): Boolean {
        return path != null && !path.isEmpty() && File("$path/lib/core/core.dart").isFile
    }

//    fun initVlangSdkControls(
//        project: Project?,
//        dartSdkPathComponent: ComboboxWithBrowseButton,
//        versionLabel: JBLabel
//    ) {
//        dartSdkPathComponent.getComboBox().setEditable(true)
//        addKnownPathsToCombo(dartSdkPathComponent.getComboBox(), VLANG_SDK_KNOWN_PATHS, VlangSdkUtil::isVlangSdkHome)
//        if (SystemInfo.isMac && getItemFromCombo(dartSdkPathComponent.getComboBox()).isEmpty()) {
//            // no need to check folder presence here; even if it doesn't exist - that's the best we can suggest
//            val path = "/usr/local/opt/dart/libexec"
//            dartSdkPathComponent.getComboBox().getEditor().setItem(path)
//        }
//        val sdkHomePath = getItemFromCombo(dartSdkPathComponent.getComboBox())
//        versionLabel.setText(if (sdkHomePath.isEmpty()) "" else getSdkVersion(sdkHomePath))
//        val textComponentAccessor: TextComponentAccessor<JComboBox<*>> = object : TextComponentAccessor<JComboBox<*>?> {
//            override fun getText(component: JComboBox<*>): String {
//                return getItemFromCombo(component)
//            }
//
//            override fun setText(component: JComboBox<*>, text: String) {
//                if (!text.isEmpty() && !isVlangSdkHome(text)) {
//                    val probablySdkPath = "$text/dart-sdk"
//                    if (isVlangSdkHome(probablySdkPath)) {
//                        component.getEditor().setItem(FileUtil.toSystemDependentName(probablySdkPath))
//                        return
//                    }
//                }
//                component.getEditor().setItem(FileUtil.toSystemDependentName(text))
//            }
//        }
//        val browseFolderListener: BrowseFolderActionListener<JComboBox<*>> = BrowseFolderActionListener<T>(
//            VlangBundle.message("button.browse.dialog.title.select.dart.sdk.path"),
//            null, dartSdkPathComponent, project,
//            FileChooserDescriptorFactory.createSingleFolderDescriptor(),
//            textComponentAccessor
//        )
//        dartSdkPathComponent.addActionListener(browseFolderListener)
//        val editorComponent: JTextComponent =
//            dartSdkPathComponent.getComboBox().getEditor().getEditorComponent() as JTextComponent
//        editorComponent.getDocument().addDocumentListener(object : DocumentAdapter() {
//            override fun textChanged(e: DocumentEvent) {
//                val sdkHomePath = getItemFromCombo(dartSdkPathComponent.getComboBox())
//                versionLabel.setText(if (sdkHomePath.isEmpty()) "" else getSdkVersion(sdkHomePath))
//            }
//        })
//    }

//    private fun getItemFromCombo(combo: JComboBox<*>): String {
//        return combo.getEditor().getItem().toString().trim { it <= ' ' }
//    }

    val firstKnownVlangSdkPath: String?
        get() {
            val knownPaths = PropertiesComponent.getInstance().getList(VLANG_SDK_KNOWN_PATHS)
            return if (knownPaths != null && !knownPaths.isEmpty() && isVlangSdkHome(knownPaths[0])) {
                knownPaths[0]
            } else null
        }

//    private fun addKnownPathsToCombo(
//        combo: JComboBox<*>,
//        propertyKey: String,
//        pathChecker: Predicate<in String>
//    ) {
//        val validPathsForUI = SmartList<String>()
//        val currentPath = getItemFromCombo(combo)
//        if (!currentPath.isEmpty()) {
//            validPathsForUI.add(currentPath)
//        }
//        val knownPaths = PropertiesComponent.getInstance().getList(propertyKey)
//        if (knownPaths != null && knownPaths.size > 0) {
//            for (path in knownPaths) {
//                val pathSD = FileUtil.toSystemDependentName(path)
//                if (pathSD != currentPath && pathChecker.test(path)) {
//                    validPathsForUI.add(pathSD)
//                }
//            }
//        }
//        combo.setModel(DefaultComboBoxModel<String>(ArrayUtilRt.toStringArray(validPathsForUI)))
//    }

    fun updateKnownSdkPaths(project: Project, newSdkPath: String) {
        val oldSdk = VlangSdk.getVlangSdk(project)
        val knownPaths = mutableListOf<String>()
        val oldKnownPaths = PropertiesComponent.getInstance().getList(VLANG_SDK_KNOWN_PATHS)
        if (oldKnownPaths != null) {
            knownPaths.addAll(oldKnownPaths)
        }
        if (oldSdk != null) {
            knownPaths.remove(oldSdk.homePath)
            knownPaths.add(0, oldSdk.homePath)
        }
        knownPaths.remove(newSdkPath)
        knownPaths.add(0, newSdkPath)
        PropertiesComponent.getInstance().setList(VLANG_SDK_KNOWN_PATHS, knownPaths)
    }

//    fun getErrorMessageIfWrongSdkRootPath(sdkRootPath: String): String? {
//        if (sdkRootPath.isEmpty()) return VlangBundle.message("error.path.to.sdk.not.specified")
//        val sdkRoot = File(sdkRootPath)
//        if (!sdkRoot.isDirectory) return VlangBundle.message("error.folder.specified.as.sdk.not.exists")
//        return if (!isVlangSdkHome(sdkRootPath)) VlangBundle.message("error.sdk.not.found.in.specified.location") else null
//    }

    fun getVlangExePath(sdk: VlangSdk): String {
        return getVlangExePath(sdk.homePath)
    }

    fun getVlangExePath(sdkRoot: String): String {
        return sdkRoot + if (SystemInfo.isWindows) "/bin/dart.exe" else "/bin/dart"
    }

    fun getPubPath(sdk: VlangSdk): String {
        return getPubPath(sdk.homePath)
    }

    fun getPubPath(sdkRoot: String): String {
        return sdkRoot + if (SystemInfo.isWindows) "/bin/pub.bat" else "/bin/pub"
    }
}