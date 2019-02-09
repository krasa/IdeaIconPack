package krasa.iconpack;

import com.intellij.openapi.util.IconPathPatcher;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.HashMap;

public final class ToolWindowIconsDecorator extends IconPathPatcher {
	public final static HashMap<String, String> icons = new HashMap<>();
	private final IconPathPatcher pathPatcher;

	@Nullable
	public String patchPath(String path, @Nullable ClassLoader classLoader) {
		String s = pathPatcher.patchPath(path, classLoader);
		if (s == null) {
			s = (String) this.icons.get((new File(path)).getName());
		}
		return s;
	}

	@Nullable
	public ClassLoader getContextClassLoader(@Nullable String path, @Nullable ClassLoader originalClassLoader) {
		return ToolWindowIconsDecorator.class.getClassLoader();
	}

	public ToolWindowIconsDecorator(IconPathPatcher patcher) {
		this.pathPatcher = patcher;
		icons.put("CMakeToolWindow.svg", "/ToolWindowIcons/CIDR/clion/resources/icons/CMakeToolWindow.svg");
		icons.put("toolWindowProject_AS.svg", "/ToolWindowIcons/community/android/adt-branding/src/artwork/toolWindowProject_AS.svg");
		icons.put("androidToolWindow.svg", "/ToolWindowIcons/community/android/artwork/resources/icons/androidToolWindow.svg");
		icons.put("toolWindowWarning.svg", "/ToolWindowIcons/community/android/artwork/resources/icons/toolwindows/toolWindowWarning.svg");
		icons.put("toolWindowBuild.svg", "/ToolWindowIcons/community/platform/icons/src/toolwindows/toolWindowBuild.svg");
		icons.put("toolWindowChanges.svg", "/ToolWindowIcons/community/platform/icons/src/toolwindows/toolWindowChanges.svg");
		icons.put("toolWindowDebugger.svg", "/ToolWindowIcons/community/platform/icons/src/toolwindows/toolWindowDebugger.svg");
		icons.put("toolWindowFavorites.svg", "/ToolWindowIcons/community/platform/icons/src/toolwindows/toolWindowFavorites.svg");
		icons.put("toolWindowProfiler.svg", "/ToolWindowIcons/community/platform/icons/src/toolwindows/toolWindowProfiler.svg");
		icons.put("toolWindowRun.svg", "/ToolWindowIcons/community/platform/icons/src/toolwindows/toolWindowRun.svg");
		icons.put("toolWindowStructure.svg", "/ToolWindowIcons/community/platform/icons/src/toolwindows/toolWindowStructure.svg");
		icons.put("serversToolWindow.svg", "/ToolWindowIcons/community/platform/remote-servers/impl/resources/icons/serversToolWindow.svg");
		icons.put("griffonToolWindow.svg", "/ToolWindowIcons/community/plugins/groovy/groovy-psi/resources/icons/griffon/griffonToolWindow.svg");
		icons.put("toolWindowMaven.svg", "/ToolWindowIcons/community/plugins/maven/src/main/resources/images/toolWindowMaven.svg");
		icons.put("pythonConsoleToolWindow.svg", "/ToolWindowIcons/community/python/resources/icons/com/jetbrains/python/pythonConsoleToolWindow.svg");
		icons.put("dart_13.svg", "/ToolWindowIcons/contrib/Dart/resources/icons/dart_13.svg");
		icons.put("pubServeToolWindow.svg", "/ToolWindowIcons/contrib/Dart/resources/icons/pubServeToolWindow.svg");
		icons.put("toolWindowDatabase.svg", "/ToolWindowIcons/dbe/database/api/resources/icons/toolWindowDatabase.svg");
		icons.put("toolwindowDatabaseChanges.svg", "/ToolWindowIcons/dbe/database/api/resources/icons/toolwindowDatabaseChanges.svg");
		icons.put("toolWindowSQLGenerator.svg", "/ToolWindowIcons/dbe/database/api/resources/icons/toolWindowSQLGenerator.svg");
		icons.put("hibConsoleToolWindow.svg", "/ToolWindowIcons/plugins/frameworks/hibernate/hibernate-core/src/resources/icons/hibConsoleToolWindow.svg");
		icons.put("batchToolWindow.svg", "/ToolWindowIcons/plugins/javaee/batch/batch-core/src/resources/icons/batchToolWindow.svg");
		icons.put("cdiToolWindow.svg", "/ToolWindowIcons/plugins/javaee/cdi/cdi-core/src/resources/icons/cdiToolWindow.svg");
		icons.put("ejbToolWindow.svg", "/ToolWindowIcons/plugins/javaee/core/javaee-impl/source/resources/icons/ejbToolWindow.svg");
		icons.put("javaeeToolWindow.svg", "/ToolWindowIcons/plugins/javaee/core/javaee-impl/source/resources/icons/javaeeToolWindow.svg");
		icons.put("jpaToolWindow.svg", "/ToolWindowIcons/plugins/javaee/core/javaee-impl/source/resources/icons/jpaToolWindow.svg");
		icons.put("jsfToolWindow.svg", "/ToolWindowIcons/plugins/javaee/jsf/jsf-core/src/resources/icons/jsfToolWindow.svg");
		icons.put("webSocketFrameworkToolWindow.svg", "/ToolWindowIcons/plugins/javaee/web-socket/websocket/src/resources/icons/webSocketFrameworkToolWindow.svg");
		icons.put("grunt_toolwindow.svg", "/ToolWindowIcons/plugins/JavaScriptLanguage/src/icons/buildTools/grunt/grunt_toolwindow.svg");
		icons.put("gulp_toolwindow.svg", "/ToolWindowIcons/plugins/JavaScriptLanguage/src/icons/buildTools/gulp_toolwindow.svg");
		icons.put("npm_13.svg", "/ToolWindowIcons/plugins/JavaScriptLanguage/src/icons/buildTools/npm/npm_13.svg");
		icons.put("OpenV8HeapSnapshot_ToolWin.svg", "/ToolWindowIcons/plugins/NodeJS/src/com/jetbrains/nodejs/icons/OpenV8HeapSnapshot_ToolWin.svg");
		icons.put("OpenV8ProfilingLog_ToolWin.svg", "/ToolWindowIcons/plugins/NodeJS/src/com/jetbrains/nodejs/icons/OpenV8ProfilingLog_ToolWin.svg");
		icons.put("v8_ToolWin.svg", "/ToolWindowIcons/plugins/NodeJS/src/com/jetbrains/nodejs/icons/v8_ToolWin.svg");
		icons.put("springToolWindow.svg", "/ToolWindowIcons/plugins/spring/spring-api/resources/icons/springToolWindow.svg");
		icons.put("ConcurrencyDiagramToolwindow.svg", "/ToolWindowIcons/python/concurrency-visualiser/resources/icons/ConcurrencyDiagramToolwindow.svg");
	}
}
