package krasa.iconpack;

import com.intellij.ide.util.PropertiesComponent;

public class Version {
	public static final int DISABLED = 0;
	public static final int _2016 = 1;
	public static final int _2018 = 2;
	public static final int _2018_files = 3;
	public static final int DEFAULT_VALUE = _2016;

	static int getVersion() {
		return PropertiesComponent.getInstance().getInt("krasa.IdeaIconPack", DEFAULT_VALUE);
	}

	public static void setVersion(int selectedVersion) {
		PropertiesComponent.getInstance().setValue("krasa.IdeaIconPack", selectedVersion, DEFAULT_VALUE);
	}
}
