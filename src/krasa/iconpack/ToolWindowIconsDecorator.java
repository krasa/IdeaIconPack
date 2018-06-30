package krasa.iconpack;

import com.intellij.openapi.util.IconPathPatcher;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.Map;

public final class ToolWindowIconsDecorator extends IconPathPatcher {
	private final Map icons;
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
		this.icons = MapsKt.mapOf(new Pair[]{TuplesKt.to("CMakeToolWindow.svg", "/ToolWindowIcons/CIDR/clion/resources/icons/CMakeToolWindow.svg"),
			TuplesKt.to("toolWindowProject_AS.svg", "/ToolWindowIcons/community/android/adt-branding/src/artwork/toolWindowProject_AS.svg"),
			TuplesKt.to("androidToolWindow.svg", "/ToolWindowIcons/community/android/artwork/resources/icons/androidToolWindow.svg"),
			TuplesKt.to("toolWindowWarning.svg", "/ToolWindowIcons/community/android/artwork/resources/icons/toolwindows/toolWindowWarning.svg"),
			TuplesKt.to("toolWindowBuild.svg", "/ToolWindowIcons/community/platform/icons/src/toolwindows/toolWindowBuild.svg"),
			TuplesKt.to("toolWindowChanges.svg", "/ToolWindowIcons/community/platform/icons/src/toolwindows/toolWindowChanges.svg"),
			TuplesKt.to("toolWindowDebugger.svg", "/ToolWindowIcons/community/platform/icons/src/toolwindows/toolWindowDebugger.svg"),
			TuplesKt.to("toolWindowFavorites.svg", "/ToolWindowIcons/community/platform/icons/src/toolwindows/toolWindowFavorites.svg"),
			TuplesKt.to("toolWindowProfiler.svg", "/ToolWindowIcons/community/platform/icons/src/toolwindows/toolWindowProfiler.svg"),
			TuplesKt.to("toolWindowRun.svg", "/ToolWindowIcons/community/platform/icons/src/toolwindows/toolWindowRun.svg"),
			TuplesKt.to("toolWindowStructure.svg", "/ToolWindowIcons/community/platform/icons/src/toolwindows/toolWindowStructure.svg"),
			TuplesKt.to("serversToolWindow.svg", "/ToolWindowIcons/community/platform/remote-servers/impl/resources/icons/serversToolWindow.svg"),
			TuplesKt.to("griffonToolWindow.svg", "/ToolWindowIcons/community/plugins/groovy/groovy-psi/resources/icons/griffon/griffonToolWindow.svg"),
			TuplesKt.to("toolWindowMaven.svg", "/ToolWindowIcons/community/plugins/maven/src/main/resources/images/toolWindowMaven.svg"),
			TuplesKt.to("pythonConsoleToolWindow.svg", "/ToolWindowIcons/community/python/resources/icons/com/jetbrains/python/pythonConsoleToolWindow.svg"),
			TuplesKt.to("dart_13.svg", "/ToolWindowIcons/contrib/Dart/resources/icons/dart_13.svg"),
			TuplesKt.to("pubServeToolWindow.svg", "/ToolWindowIcons/contrib/Dart/resources/icons/pubServeToolWindow.svg"),
			TuplesKt.to("toolWindowDatabase.svg", "/ToolWindowIcons/dbe/database/api/resources/icons/toolWindowDatabase.svg"),
			TuplesKt.to("toolwindowDatabaseChanges.svg", "/ToolWindowIcons/dbe/database/api/resources/icons/toolwindowDatabaseChanges.svg"),
			TuplesKt.to("toolWindowSQLGenerator.svg", "/ToolWindowIcons/dbe/database/api/resources/icons/toolWindowSQLGenerator.svg"),
			TuplesKt.to("hibConsoleToolWindow.svg", "/ToolWindowIcons/plugins/frameworks/hibernate/hibernate-core/src/resources/icons/hibConsoleToolWindow.svg"),
			TuplesKt.to("batchToolWindow.svg", "/ToolWindowIcons/plugins/javaee/batch/batch-core/src/resources/icons/batchToolWindow.svg"),
			TuplesKt.to("cdiToolWindow.svg", "/ToolWindowIcons/plugins/javaee/cdi/cdi-core/src/resources/icons/cdiToolWindow.svg"),
			TuplesKt.to("ejbToolWindow.svg", "/ToolWindowIcons/plugins/javaee/core/javaee-impl/source/resources/icons/ejbToolWindow.svg"),
			TuplesKt.to("javaeeToolWindow.svg", "/ToolWindowIcons/plugins/javaee/core/javaee-impl/source/resources/icons/javaeeToolWindow.svg"),
			TuplesKt.to("jpaToolWindow.svg", "/ToolWindowIcons/plugins/javaee/core/javaee-impl/source/resources/icons/jpaToolWindow.svg"),
			TuplesKt.to("jsfToolWindow.svg", "/ToolWindowIcons/plugins/javaee/jsf/jsf-core/src/resources/icons/jsfToolWindow.svg"),
			TuplesKt.to("webSocketFrameworkToolWindow.svg", "/ToolWindowIcons/plugins/javaee/web-socket/websocket/src/resources/icons/webSocketFrameworkToolWindow.svg"),
			TuplesKt.to("grunt_toolwindow.svg", "/ToolWindowIcons/plugins/JavaScriptLanguage/src/icons/buildTools/grunt/grunt_toolwindow.svg"),
			TuplesKt.to("gulp_toolwindow.svg", "/ToolWindowIcons/plugins/JavaScriptLanguage/src/icons/buildTools/gulp_toolwindow.svg"),
			TuplesKt.to("npm_13.svg", "/ToolWindowIcons/plugins/JavaScriptLanguage/src/icons/buildTools/npm/npm_13.svg"),
			TuplesKt.to("OpenV8HeapSnapshot_ToolWin.svg", "/ToolWindowIcons/plugins/NodeJS/src/com/jetbrains/nodejs/icons/OpenV8HeapSnapshot_ToolWin.svg"),
			TuplesKt.to("OpenV8ProfilingLog_ToolWin.svg", "/ToolWindowIcons/plugins/NodeJS/src/com/jetbrains/nodejs/icons/OpenV8ProfilingLog_ToolWin.svg"),
			TuplesKt.to("v8_ToolWin.svg", "/ToolWindowIcons/plugins/NodeJS/src/com/jetbrains/nodejs/icons/v8_ToolWin.svg"),
			TuplesKt.to("springToolWindow.svg", "/ToolWindowIcons/plugins/spring/spring-api/resources/icons/springToolWindow.svg"),
			TuplesKt.to("ConcurrencyDiagramToolwindow.svg", "/ToolWindowIcons/python/concurrency-visualiser/resources/icons/ConcurrencyDiagramToolwindow.svg")});
	}
}
