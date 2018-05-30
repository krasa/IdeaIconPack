package krasa.iconpack;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class MyConfigurable implements Configurable {
	private GUI gui;

	@Nls(capitalization = Nls.Capitalization.Title)
	@Override
	public String getDisplayName() {
		return "Legacy Icon Pack";
	}

	@Nullable
	@Override
	public JComponent createComponent() {
		if (gui == null) {
			gui = new GUI();
		}
		return gui.root;
	}

	@Override
	public boolean isModified() {
		return gui.isModified();
	}

	@Override
	public void apply() throws ConfigurationException {
		gui.apply();
	}
}
