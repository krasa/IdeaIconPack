package krasa.iconpack;

import com.intellij.openapi.util.IconPathPatcher;
import com.intellij.openapi.util.io.FileUtil;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;

/**
 * originally from https://plugins.jetbrains.com/plugin/7285-idea-2016-2-icon-pack
 */
public class IdeaIconPack_2018_1 extends IconPathPatcher {

	public final static HashSet<String> newIcons = new HashSet<>();

	public IdeaIconPack_2018_1() {
	}


	@Nullable
	public String patchPath(String path) {
		String pngPath = path.replace(".svg", ".png");
		return newIcons.contains(pngPath) ? "iconpack_2018_1" + pngPath : null;
	}

	@Nullable
	public Class getContextClass(String path) {
		return this.getClass();
	}
	@Nullable
	@Override
	public String patchPath(String path, ClassLoader classLoader) {
		String pngPath = path.replace(".svg", ".png");
		return newIcons.contains(pngPath) ? "iconpack_2018_1" + pngPath : null;

	}

	@Nullable
	public ClassLoader getContextClassLoader(String path, ClassLoader originalClassLoader) {
		if (newIcons.contains(path.replace(".svg", ".png"))) {
			return this.getClass().getClassLoader();
		} else {
			return null;
		}
	}
	public static void main(String[] args) {
		StringBuilder buf = new StringBuilder("\n");
		buf.append("\n");
		buf.append("\tstatic {\n");
		iterate(new File("F:\\workspace\\_projekty\\Github\\IdeaIconPack\\src\\iconpack_2018_1"), "/", buf);
		buf.append("\t}\n").append("}");

		try {
			File file = new File("F:\\workspace\\_projekty\\Github\\IdeaIconPack\\src\\krasa\\iconpack\\IdeaIconPack_2018_1.java");
			String code = FileUtil.loadTextAndClose(new FileInputStream(file));
			String marker = "!!!Generated code!!!";
			code = code.substring(0, code.lastIndexOf(marker) + marker.length());
			code = code + buf.toString();
			FileUtil.writeToFile(file, code);
		} catch (IOException var5) {
			;
		}

	}

	private static void iterate(File dir, String prefix, StringBuilder buf) {
		File[] var3 = dir.listFiles();
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			File file = var3[var5];
			String name = file.getName();
			if (file.isDirectory()) {
				iterate(file, prefix + name + "/", buf);
			} else if (name.endsWith(".png") && !name.contains("@2x") && !name.contains("_dark")) {
				buf.append("\t\tnewIcons.add(\"" + prefix + name + "\");\n");
			}
		}

	}

	// !!!Generated code!!!

	static {
		newIcons.add("/actions/AddMulticaret.png");
		newIcons.add("/actions/annotate.png");
		newIcons.add("/actions/back.png");
		newIcons.add("/actions/browser-externalJavaDoc.png");
		newIcons.add("/actions/cancel.png");
		newIcons.add("/actions/changeView.png");
		newIcons.add("/actions/CheckMulticaret.png");
		newIcons.add("/actions/checkOut.png");
		newIcons.add("/actions/collapseall.png");
		newIcons.add("/actions/commit.png");
		newIcons.add("/actions/compile.png");
		newIcons.add("/actions/copy.png");
		newIcons.add("/actions/delete.png");
		newIcons.add("/actions/diagramDiff.png");
		newIcons.add("/actions/diff.png");
		newIcons.add("/actions/diffWithClipboard.png");
		newIcons.add("/actions/download.png");
		newIcons.add("/actions/dump.png");
		newIcons.add("/actions/edit.png");
		newIcons.add("/actions/editSource.png");
		newIcons.add("/actions/exclude.png");
		newIcons.add("/actions/execute.png");
		newIcons.add("/actions/exit.png");
		newIcons.add("/actions/expandall.png");
		newIcons.add("/actions/export.png");
		newIcons.add("/actions/filter_small.png");
		newIcons.add("/actions/find.png");
		newIcons.add("/actions/findPlain.png");
		newIcons.add("/actions/forceRefresh.png");
		newIcons.add("/actions/forward.png");
		newIcons.add("/actions/gc.png");
		newIcons.add("/actions/GroupByClass.png");
		newIcons.add("/actions/GroupByFile.png");
		newIcons.add("/actions/groupByMethod.png");
		newIcons.add("/actions/GroupByModule.png");
		newIcons.add("/actions/GroupByModuleGroup.png");
		newIcons.add("/actions/GroupByPackage.png");
		newIcons.add("/actions/GroupByPrefix.png");
		newIcons.add("/actions/groupByTestProduction.png");
		newIcons.add("/actions/help.png");
		newIcons.add("/actions/install.png");
		newIcons.add("/actions/lightning.png");
		newIcons.add("/actions/listChanges.png");
		newIcons.add("/actions/menu-cut.png");
		newIcons.add("/actions/menu-find.png");
		newIcons.add("/actions/menu-help.png");
		newIcons.add("/actions/menu-open.png");
		newIcons.add("/actions/menu-paste.png");
		newIcons.add("/actions/menu-replace.png");
		newIcons.add("/actions/menu-saveall.png");
		newIcons.add("/actions/moveDown.png");
		newIcons.add("/actions/moveUp.png");
		newIcons.add("/actions/new.png");
		newIcons.add("/actions/newFolder.png");
		newIcons.add("/actions/nextfile.png");
		newIcons.add("/actions/nextOccurence.png");
		newIcons.add("/actions/pause.png");
		newIcons.add("/actions/popFrame.png");
		newIcons.add("/actions/prevfile.png");
		newIcons.add("/actions/preview.png");
		newIcons.add("/actions/previewDetails.png");
		newIcons.add("/actions/previousOccurence.png");
		newIcons.add("/actions/profile.png");
		newIcons.add("/actions/profileCPU.png");
		newIcons.add("/actions/profileMemory.png");
		newIcons.add("/actions/properties.png");
		newIcons.add("/actions/redo.png");
		newIcons.add("/actions/refresh.png");
		newIcons.add("/actions/RemoveMulticaret.png");
		newIcons.add("/actions/replace.png");
		newIcons.add("/actions/rerun.png");
		newIcons.add("/actions/reset.png");
		newIcons.add("/actions/restart.png");
		newIcons.add("/actions/restartDebugger.png");
		newIcons.add("/actions/resume.png");
		newIcons.add("/actions/rollback.png");
		newIcons.add("/actions/runToCursor.png");
		newIcons.add("/actions/selectall.png");
		newIcons.add("/actions/shortcutFilter.png");
		newIcons.add("/actions/showAsTree.png");
		newIcons.add("/actions/showHiddens.png");
		newIcons.add("/actions/showImportStatements.png");
		newIcons.add("/actions/showReadAccess.png");
		newIcons.add("/actions/showWriteAccess.png");
		newIcons.add("/actions/sortAsc.png");
		newIcons.add("/actions/sortDesc.png");
		newIcons.add("/actions/splitHorizontally.png");
		newIcons.add("/actions/splitVertically.png");
		newIcons.add("/actions/startDebugger.png");
		newIcons.add("/actions/startMemoryProfile.png");
		newIcons.add("/actions/stepOut.png");
		newIcons.add("/actions/stub.png");
		newIcons.add("/actions/suspend.png");
		newIcons.add("/actions/synchronizeFS.png");
		newIcons.add("/actions/toggleSoftWrap.png");
		newIcons.add("/actions/traceInto.png");
		newIcons.add("/actions/traceOver.png");
		newIcons.add("/actions/undo.png");
		newIcons.add("/actions/upload.png");
		newIcons.add("/codeStyle/AddNewSectionRule.png");
		newIcons.add("/codeStyle/Gear.png");
		newIcons.add("/codeStyle/mac/AddNewSectionRule.png");
		newIcons.add("/com/intellij/uiDesigner/icons/toolWindowUIDesigner.png");
//		newIcons.add("/debugger/actions/force_run_to_cursor.png");
//		newIcons.add("/debugger/actions/force_step_into.png");
//		newIcons.add("/debugger/actions/force_step_over.png");
//		newIcons.add("/debugger/addToWatch.png");
//		newIcons.add("/debugger/attachToProcess.png");
//		newIcons.add("/debugger/class_filter.png");
//		newIcons.add("/debugger/db_dep_exception_breakpoint.png");
//		newIcons.add("/debugger/db_dep_field_breakpoint.png");
//		newIcons.add("/debugger/db_dep_line_breakpoint.png");
//		newIcons.add("/debugger/db_dep_method_breakpoint.png");
//		newIcons.add("/debugger/db_disabled_breakpoint.png");
//		newIcons.add("/debugger/db_disabled_breakpoint_process.png");
//		newIcons.add("/debugger/db_disabled_exception_breakpoint.png");
//		newIcons.add("/debugger/db_disabled_field_breakpoint.png");
//		newIcons.add("/debugger/db_disabled_method_breakpoint.png");
//		newIcons.add("/debugger/db_exception_breakpoint.png");
//		newIcons.add("/debugger/db_field_breakpoint.png");
//		newIcons.add("/debugger/db_invalid_breakpoint.png");
//		newIcons.add("/debugger/db_invalid_field_breakpoint.png");
//		newIcons.add("/debugger/db_invalid_method_breakpoint.png");
//		newIcons.add("/debugger/db_method_breakpoint.png");
//		newIcons.add("/debugger/db_muted_breakpoint.png");
//		newIcons.add("/debugger/db_muted_dep_exception_breakpoint.png");
//		newIcons.add("/debugger/db_muted_dep_field_breakpoint.png");
//		newIcons.add("/debugger/db_muted_dep_line_breakpoint.png");
//		newIcons.add("/debugger/db_muted_dep_method_breakpoint.png");
//		newIcons.add("/debugger/db_muted_disabled_breakpoint.png");
//		newIcons.add("/debugger/db_muted_disabled_exception_breakpoint.png");
//		newIcons.add("/debugger/db_muted_disabled_field_breakpoint.png");
//		newIcons.add("/debugger/db_muted_disabled_method_breakpoint.png");
//		newIcons.add("/debugger/db_muted_exception_breakpoint.png");
//		newIcons.add("/debugger/db_muted_field_breakpoint.png");
//		newIcons.add("/debugger/db_muted_invalid_breakpoint.png");
//		newIcons.add("/debugger/db_muted_invalid_field_breakpoint.png");
//		newIcons.add("/debugger/db_muted_invalid_method_breakpoint.png");
//		newIcons.add("/debugger/db_muted_method_breakpoint.png");
//		newIcons.add("/debugger/db_muted_temporary_breakpoint.png");
//		newIcons.add("/debugger/db_muted_verified_breakpoint.png");
//		newIcons.add("/debugger/db_muted_verified_field_breakpoint.png");
//		newIcons.add("/debugger/db_muted_verified_method_breakpoint.png");
//		newIcons.add("/debugger/db_obsolete.png");
//		newIcons.add("/debugger/db_set_breakpoint.png");
//		newIcons.add("/debugger/db_temporary_breakpoint.png");
//		newIcons.add("/debugger/db_verified_breakpoint.png");
//		newIcons.add("/debugger/db_verified_field_breakpoint.png");
//		newIcons.add("/debugger/db_verified_method_breakpoint.png");
//		newIcons.add("/debugger/evaluateExpression.png");
//		newIcons.add("/debugger/killProcess.png");
//		newIcons.add("/debugger/LambdaBreakpoint.png");
//		newIcons.add("/debugger/MultipleBreakpoints.png");
//		newIcons.add("/debugger/muteBreakpoints.png");
//		newIcons.add("/debugger/newWatch.png");
//		newIcons.add("/debugger/restoreLayout.png");
//		newIcons.add("/debugger/showCurrentFrame.png");
//		newIcons.add("/debugger/smartStepInto.png");
//		newIcons.add("/debugger/threads.png");
//		newIcons.add("/debugger/threadStates/io.png");
//		newIcons.add("/debugger/threadStates/locked.png");
//		newIcons.add("/debugger/threadStates/paused.png");
//		newIcons.add("/debugger/threadStates/running.png");
//		newIcons.add("/debugger/viewBreakpoints.png");
//		newIcons.add("/debugger/watch.png");
//		newIcons.add("/debugger/watches.png");
//		newIcons.add("/debugger/watchLastReturnValue.png");
		newIcons.add("/fileTypes/any_type.png");
		newIcons.add("/fileTypes/archive.png");
		newIcons.add("/fileTypes/as.png");
		newIcons.add("/fileTypes/aspectj.png");
		newIcons.add("/fileTypes/config.png");
		newIcons.add("/fileTypes/css.png");
		newIcons.add("/fileTypes/custom.png");
		newIcons.add("/fileTypes/diagram.png");
		newIcons.add("/fileTypes/dtd.png");
		newIcons.add("/fileTypes/facelets.png");
		newIcons.add("/fileTypes/facesConfig.png");
		newIcons.add("/fileTypes/htaccess.png");
		newIcons.add("/fileTypes/html.png");
		newIcons.add("/fileTypes/idl.png");
		newIcons.add("/fileTypes/java.png");
		newIcons.add("/fileTypes/javaClass.png");
		newIcons.add("/fileTypes/javaOutsideSource.png");
		newIcons.add("/fileTypes/javaScript.png");
		newIcons.add("/fileTypes/json.png");
		newIcons.add("/fileTypes/jsp.png");
		newIcons.add("/fileTypes/jspx.png");
		newIcons.add("/fileTypes/manifest.png");
		newIcons.add("/fileTypes/properties.png");
		newIcons.add("/fileTypes/text.png");
		newIcons.add("/fileTypes/typeScript.png");
		newIcons.add("/fileTypes/uiForm.png");
		newIcons.add("/fileTypes/unknown.png");
		newIcons.add("/fileTypes/wsdlFile.png");
		newIcons.add("/fileTypes/xhtml.png");
		newIcons.add("/fileTypes/xml.png");
		newIcons.add("/fileTypes/xsdFile.png");
		newIcons.add("/general/add.png");
		newIcons.add("/general/addFavoritesList.png");
		newIcons.add("/general/addJdk.png");
		newIcons.add("/general/autohideOff.png");
		newIcons.add("/general/autohideOffInactive.png");
		newIcons.add("/general/autohideOffPressed.png");
		newIcons.add("/general/balloon.png");
		newIcons.add("/general/balloonError.png");
		newIcons.add("/general/balloonInformation.png");
		newIcons.add("/general/balloonWarning.png");
		newIcons.add("/general/collapseComponent.png");
		newIcons.add("/general/collapseComponentHover.png");
		newIcons.add("/general/Configure.png");
		newIcons.add("/general/copyHovered.png");
		newIcons.add("/general/createNewProject.png");
		newIcons.add("/general/CreateNewProjectfromExistingFiles.png");
		newIcons.add("/general/debug.png");
		newIcons.add("/general/error.png");
		newIcons.add("/general/errorDialog.png");
		newIcons.add("/general/expandComponent.png");
		newIcons.add("/general/expandComponentHover.png");
		newIcons.add("/general/externalTools.png");
		newIcons.add("/general/filter.png");
		newIcons.add("/general/gearPlain.png");
		newIcons.add("/general/getProjectfromVCS.png");
		newIcons.add("/general/hideToolWindow.png");
		newIcons.add("/general/importProject.png");
		newIcons.add("/general/information.png");
		newIcons.add("/general/informationDialog.png");
		newIcons.add("/general/notificationError.png");
		newIcons.add("/general/notificationInfo.png");
		newIcons.add("/general/notificationWarning.png");
		newIcons.add("/general/openDisk.png");
		newIcons.add("/general/openDiskHover.png");
		newIcons.add("/general/openProject.png");
		newIcons.add("/general/packagesTab.png");
		newIcons.add("/general/pin_tab.png");
		newIcons.add("/general/projectConfigurable.png");
		newIcons.add("/general/projectSettings.png");
		newIcons.add("/general/projectStructure.png");
		newIcons.add("/general/projectTab.png");
		newIcons.add("/general/questionDialog.png");
		newIcons.add("/general/readHelp.png");
		newIcons.add("/general/recursive.png");
		newIcons.add("/general/remove.png");
		newIcons.add("/general/reset.png");
		newIcons.add("/general/runWithCoverage.png");
		newIcons.add("/general/secondaryGroup.png");
		newIcons.add("/general/settings.png");
		newIcons.add("/general/tbHidden.png");
		newIcons.add("/general/tbShown.png");
		newIcons.add("/general/todoDefault.png");
		newIcons.add("/general/todoImportant.png");
		newIcons.add("/general/todoQuestion.png");
		newIcons.add("/general/warning.png");
		newIcons.add("/general/warningDecorator.png");
		newIcons.add("/general/warningDialog.png");
		newIcons.add("/graph/actualZoom.png");
		newIcons.add("/graph/export.png");
		newIcons.add("/graph/fitContent.png");
		newIcons.add("/graph/layout.png");
		newIcons.add("/graph/print.png");
		newIcons.add("/graph/zoomIn.png");
		newIcons.add("/graph/zoomOut.png");
		newIcons.add("/hierarchy/base.png");
		newIcons.add("/hierarchy/callee.png");
		newIcons.add("/hierarchy/caller.png");
		newIcons.add("/hierarchy/class.png");
		newIcons.add("/hierarchy/methodDefined.png");
		newIcons.add("/hierarchy/methodNotDefined.png");
		newIcons.add("/hierarchy/shouldDefineMethod.png");
		newIcons.add("/hierarchy/subtypes.png");
		newIcons.add("/hierarchy/supertypes.png");
		newIcons.add("/icons/add_sdk.png");
		newIcons.add("/icons/branch.png");
		newIcons.add("/icons/cherryPick.png");
		newIcons.add("/icons/clock.png");
		newIcons.add("/icons/CollapseBranches.png");
		newIcons.add("/icons/CollapseMerges.png");
		newIcons.add("/icons/com/jetbrains/python/DataView.png");
		newIcons.add("/icons/com/jetbrains/python/debug/StepIntoMyCode.png");
		newIcons.add("/icons/com/jetbrains/python/pythonConsoleToolWindow.png");
		newIcons.add("/icons/com/jetbrains/python/pythonFile.png");
		newIcons.add("/icons/DeepCompare.png");
		newIcons.add("/icons/ExpandBranches.png");
		newIcons.add("/icons/ExpandMerges.png");
		newIcons.add("/icons/favorite.png");
		newIcons.add("/icons/favoriteOnHover.png");
		newIcons.add("/icons/GearWithDropDown.png");
		newIcons.add("/icons/gradle.png");
		newIcons.add("/icons/gradleNavigate.png");
		newIcons.add("/icons/griffon/griffonToolWindow.png");
		newIcons.add("/icons/incoming.png");
		newIcons.add("/icons/incomingOutgoing.png");
		newIcons.add("/icons/IntelliSort.png");
		newIcons.add("/icons/notFavoriteOnHover.png");
		newIcons.add("/icons/OpenTerminal_13x13.png");
		newIcons.add("/icons/outgoing.png");
		newIcons.add("/icons/sdk_closed.png");
		newIcons.add("/icons/serversToolWindow.png");
		newIcons.add("/icons/ShowHideLongEdges.png");
		newIcons.add("/icons/stream_debugger.png");
		newIcons.add("/icons/toolWindowGradle.png");
		newIcons.add("/ide/emptyFatalError.png");
		newIcons.add("/ide/fatalError-read.png");
		newIcons.add("/ide/fatalError.png");
		newIcons.add("/ide/localScope.png");
		newIcons.add("/ide/notification/close.png");
		newIcons.add("/ide/notification/errorEvents.png");
		newIcons.add("/ide/notification/infoEvents.png");
		newIcons.add("/ide/notification/noEvents.png");
		newIcons.add("/ide/notification/warningEvents.png");
		newIcons.add("/ide/pipette.png");
		newIcons.add("/ide/pipette_rollover.png");
		newIcons.add("/ide/rating.png");
		newIcons.add("/ide/rating1.png");
		newIcons.add("/ide/rating2.png");
		newIcons.add("/ide/rating3.png");
		newIcons.add("/ide/rating4.png");
		newIcons.add("/ide/readonly.png");
		newIcons.add("/ide/readwrite.png");
		newIcons.add("/images/toolWindowMaven.png");
		newIcons.add("/javaee/updateRunningApplication.png");
		newIcons.add("/modules/addContentEntry.png");
		newIcons.add("/modules/addExcludedRoot.png");
		newIcons.add("/modules/edit.png");
		newIcons.add("/modules/editFolder.png");
		newIcons.add("/modules/excludedGeneratedRoot.png");
		newIcons.add("/modules/excludeRoot.png");
		newIcons.add("/modules/generatedFolder.png");
		newIcons.add("/modules/generatedSourceRoot.png");
		newIcons.add("/modules/generatedTestRoot.png");
		newIcons.add("/modules/library.png");
		newIcons.add("/modules/modulesNode.png");
		newIcons.add("/modules/output.png");
		newIcons.add("/modules/resourcesRoot.png");
		newIcons.add("/modules/sourceFolder.png");
		newIcons.add("/modules/sourceRoot.png");
		newIcons.add("/modules/sources.png");
		newIcons.add("/modules/testResourcesRoot.png");
		newIcons.add("/modules/testRoot.png");
		newIcons.add("/modules/testSourceFolder.png");
		newIcons.add("/modules/unmarkWebroot.png");
		newIcons.add("/modules/webRoot.png");
		newIcons.add("/nodes/abstractClass.png");
		newIcons.add("/nodes/abstractException.png");
		newIcons.add("/nodes/abstractMethod.png");
		newIcons.add("/nodes/annotationtype.png");
		newIcons.add("/nodes/anonymousClass.png");
		newIcons.add("/nodes/class.png");
		newIcons.add("/nodes/classInitializer.png");
		newIcons.add("/nodes/copyOfFolder.png");
		newIcons.add("/nodes/enum.png");
		newIcons.add("/nodes/exceptionClass.png");
		newIcons.add("/nodes/field.png");
		newIcons.add("/nodes/folder.png");
		newIcons.add("/nodes/function.png");
		newIcons.add("/nodes/ideaModule.png");
		newIcons.add("/nodes/ideaProject.png");
		newIcons.add("/nodes/interface.png");
		newIcons.add("/nodes/method.png");
		newIcons.add("/nodes/methodReference.png");
		newIcons.add("/nodes/Module.png");
		newIcons.add("/nodes/moduleGroup.png");
		newIcons.add("/nodes/newFolder.png");
		newIcons.add("/nodes/package.png");
		newIcons.add("/nodes/parameter.png");
		newIcons.add("/nodes/pointcut.png");
		newIcons.add("/nodes/ppJar.png");
		newIcons.add("/nodes/ppLib.png");
		newIcons.add("/nodes/ppLibFolder.png");
		newIcons.add("/nodes/property.png");
		newIcons.add("/nodes/propertyRead.png");
		newIcons.add("/nodes/propertyReadStatic.png");
		newIcons.add("/nodes/propertyReadWrite.png");
		newIcons.add("/nodes/propertyReadWriteStatic.png");
		newIcons.add("/nodes/propertyWrite.png");
		newIcons.add("/nodes/propertyWriteStatic.png");
		newIcons.add("/nodes/resourceBundle.png");
		newIcons.add("/nodes/sourceFolder.png");
		newIcons.add("/nodes/static.png");
		newIcons.add("/nodes/TreeClosed.png");
		newIcons.add("/nodes/TreeOpen.png");
		newIcons.add("/nodes/unknownJdk.png");
		newIcons.add("/nodes/upFolder.png");
		newIcons.add("/nodes/variable.png");
		newIcons.add("/nodes/webFolder.png");
		newIcons.add("/objectBrowser/compactEmptyPackages.png");
		newIcons.add("/objectBrowser/flattenModules.png");
		newIcons.add("/objectBrowser/flattenPackages.png");
		newIcons.add("/objectBrowser/showModules.png");
		newIcons.add("/objectBrowser/sortByType.png");
		newIcons.add("/objectBrowser/sorted.png");
		newIcons.add("/objectBrowser/sortedByUsage.png");
		newIcons.add("/objectBrowser/visibilitySort.png");
		newIcons.add("/org/intellij/images/icons/ImagesFileType.png");
		newIcons.add("/org/intellij/images/icons/ThumbnailToolWindow.png");
		newIcons.add("/org/intellij/images/icons/ToggleGrid.png");
		newIcons.add("/org/intellij/images/icons/ToggleTransparencyChessboard.png");
		newIcons.add("/runConfigurations/rerunFailedTests.png");
		newIcons.add("/runConfigurations/scroll_down.png");
		newIcons.add("/runConfigurations/sortbyDuration.png");
		newIcons.add("/toolbar/filterdups.png");
		newIcons.add("/toolbar/folders.png");
		newIcons.add("/toolbarDecorator/add.png");
		newIcons.add("/toolbarDecorator/addBlankLine.png");
		newIcons.add("/toolbarDecorator/addClass.png");
		newIcons.add("/toolbarDecorator/addFolder.png");
		newIcons.add("/toolbarDecorator/addIcon.png");
		newIcons.add("/toolbarDecorator/addJira.png");
		newIcons.add("/toolbarDecorator/addLink.png");
		newIcons.add("/toolbarDecorator/addPackage.png");
		newIcons.add("/toolbarDecorator/addPattern.png");
		newIcons.add("/toolbarDecorator/addRemoteDatasource.png");
		newIcons.add("/toolbarDecorator/addYouTrack.png");
		newIcons.add("/toolbarDecorator/edit.png");
		newIcons.add("/toolbarDecorator/export.png");
		newIcons.add("/toolbarDecorator/import.png");
		newIcons.add("/toolbarDecorator/mac/add.png");
		newIcons.add("/toolbarDecorator/mac/addBlankLine.png");
		newIcons.add("/toolbarDecorator/mac/addClass.png");
		newIcons.add("/toolbarDecorator/mac/addFolder.png");
		newIcons.add("/toolbarDecorator/mac/addIcon.png");
		newIcons.add("/toolbarDecorator/mac/addJira.png");
		newIcons.add("/toolbarDecorator/mac/addLink.png");
		newIcons.add("/toolbarDecorator/mac/addPackage.png");
		newIcons.add("/toolbarDecorator/mac/addPattern.png");
		newIcons.add("/toolbarDecorator/mac/addRemoteDatasource.png");
		newIcons.add("/toolbarDecorator/mac/addYouTrack.png");
		newIcons.add("/toolbarDecorator/mac/edit.png");
		newIcons.add("/toolbarDecorator/mac/moveDown.png");
		newIcons.add("/toolbarDecorator/mac/moveUp.png");
		newIcons.add("/toolbarDecorator/mac/remove.png");
		newIcons.add("/toolbarDecorator/moveDown.png");
		newIcons.add("/toolbarDecorator/moveUp.png");
		newIcons.add("/toolbarDecorator/remove.png");
		newIcons.add("/toolwindows/documentation.png");
		newIcons.add("/toolwindows/problems.png");
		newIcons.add("/toolwindows/toolWindowAnt.png");
		newIcons.add("/toolwindows/toolWindowBuild.png");
		newIcons.add("/toolwindows/toolWindowChanges.png");
		newIcons.add("/toolwindows/toolWindowCoverage.png");
		newIcons.add("/toolwindows/toolWindowCvs.png");
		newIcons.add("/toolwindows/toolWindowDebugger.png");
		newIcons.add("/toolwindows/toolWindowFavorites.png");
		newIcons.add("/toolwindows/toolWindowFind.png");
		newIcons.add("/toolwindows/toolWindowHierarchy.png");
		newIcons.add("/toolwindows/toolWindowInspection.png");
		newIcons.add("/toolwindows/toolWindowMessages.png");
		newIcons.add("/toolwindows/toolWindowModuleDependencies.png");
		newIcons.add("/toolwindows/toolWindowPalette.png");
		newIcons.add("/toolwindows/toolWindowPreview.png");
		newIcons.add("/toolwindows/toolWindowProject.png");
		newIcons.add("/toolwindows/toolWindowRun.png");
		newIcons.add("/toolwindows/toolWindowStructure.png");
		newIcons.add("/toolwindows/toolWindowTodo.png");
		newIcons.add("/toolwindows/webToolWindow.png");
		newIcons.add("/vcs/history.png");
		newIcons.add("/vcs/mergeSourcesTree.png");
		newIcons.add("/vcs/patch.png");
		newIcons.add("/vcs/patch_applied.png");
		newIcons.add("/vcs/push.png");
		newIcons.add("/vcs/Shelve.png");
		newIcons.add("/vcs/shelveSilent.png");
		newIcons.add("/vcs/Unshelve.png");
		newIcons.add("/vcs/unshelveSilent.png");
		newIcons.add("/webreferences/server.png");
		newIcons.add("/welcome/createNewProject.png");
		newIcons.add("/welcome/CreateNewProjectfromExistingFiles.png");
		newIcons.add("/welcome/fromVCS.png");
		newIcons.add("/welcome/importProject.png");
		newIcons.add("/welcome/openProject.png");
	}
}