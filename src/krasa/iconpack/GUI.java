package krasa.iconpack;

import javax.swing.*;

public class GUI {
	private JRadioButton disable;
	private JRadioButton from2016;
	private JRadioButton from2018;
	private JRadioButton from2018files;
	public JPanel root;

	public GUI() {
		switch (Version.getVersion()) {
			case Version.DISABLED:
				disable.setSelected(true);
				break;
			case Version._2016:
				from2016.setSelected(true);
				break;
			case Version._2018:
				from2018.setSelected(true);
				break;
			case Version._2018_files:
				from2018files.setSelected(true);
				break;
		}
	}

	public boolean isModified() {
		return Version.getVersion() != selectedVersion();
	}

	private int selectedVersion() {
		if (disable.isSelected()) {
			return Version.DISABLED;
		}
		if (from2016.isSelected()) {
			return Version._2016;
		}
		if (from2018.isSelected()) {
			return Version._2018;
		}
		if (from2018files.isSelected()) {
			return Version._2018_files;
		}
		return Version.DEFAULT_VALUE;
	}

	public void apply() {
		Version.setVersion(selectedVersion());
	}
}
