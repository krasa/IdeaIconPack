package krasa.iconpack;

import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.util.IconPathPatcher;
import org.jetbrains.annotations.Nullable;

public class Patcher extends IconPathPatcher {
	static IconPathPatcher delegate = null;

	public Patcher() {
		init();

		IconLoader.installPathPatcher(this);
	}

	public static void init() {
		switch (Version.getVersion()) {
			case Version.DISABLED:
				delegate = null;
				break;
			case Version._2018_files:
				delegate = new IconsDecorator(new IdeaIconPack_2018_1(true));
				break;
			case Version._2018:
				delegate = new IconsDecorator(new IdeaIconPack_2018_1(false));
				break;
			case Version._2016:
				delegate = new IconsDecorator(new IdeaIconPack_2016_2());
				break;
		}
	}

	@Nullable
	@Override
	public String patchPath(String path, ClassLoader classLoader) {
		if (path == null) {
			return null;
		}
		IconPathPatcher delegate = this.delegate;
		if (delegate == null) {
			return null;
		}
		return delegate.patchPath(path, classLoader);
	}

	@Nullable
	@Override
	public ClassLoader getContextClassLoader(String path, ClassLoader originalClassLoader) {
		IconPathPatcher delegate = this.delegate;
		if (delegate == null) {
			return null;
		}
		return delegate.getContextClassLoader(path, originalClassLoader);
	}

	@Nullable
	@Override
	public String patchPath(String path) {
		return null;
	}

	@Nullable
	public Class getContextClass(String path) {
		return null;
	}
}
