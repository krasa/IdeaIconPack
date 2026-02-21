package krasa.iconpack;

import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.util.IconPathPatcher;
import org.jetbrains.annotations.Nullable;

public class Patcher extends SimpleIconPathPatcher {
	static SimpleIconPathPatcher delegate = null;

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
				delegate = new FileOnlyIconFilter(new IconsDecorator(new IdeaIconPack_2018_1()));
				break;
			case Version._2018:
				delegate = new IconsDecorator(new IdeaIconPack_2018_1());
				break;
			case Version._2016:
				delegate = new IconsDecorator(new IdeaIconPack_2016_2());
				break;
		}
	}

	@Override
	public String redirectIconPath(String iconPath) {
		SimpleIconPathPatcher delegate = Patcher.delegate;
		return delegate == null ? null :
				delegate.redirectIconPath(iconPath);
	}

}
