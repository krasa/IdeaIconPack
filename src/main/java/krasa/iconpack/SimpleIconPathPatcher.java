package krasa.iconpack;

import com.intellij.openapi.util.IconPathPatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class SimpleIconPathPatcher extends IconPathPatcher {
	public SimpleIconPathPatcher() {}

	@Override
	@SuppressWarnings("UnstableApiUsage")
	public final @Nullable String patchPath(@NotNull String path) {
		return this.redirectIconPath(path);
	}

	@Override
	@SuppressWarnings("UnstableApiUsage")
	public final Class<?> getContextClass(@NotNull String path) {
		return SimpleIconPathPatcher.class;
	}

	@Nullable
	public final String patchPath(String path, @Nullable ClassLoader classLoader) {
		return this.redirectIconPath(path);
	}
	@Nullable
	public final ClassLoader getContextClassLoader(@Nullable String path, @Nullable ClassLoader originalClassLoader) {
		return SimpleIconPathPatcher.class.getClassLoader();
	}

	public abstract String redirectIconPath(String iconPath);
}
