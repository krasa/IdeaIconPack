package krasa.iconpack;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.function.Consumer;

public class CopyIconsFromIntelliJ {
	public static void main(String[] args) throws IOException {
		String from = "F:\\workspace\\_projekty\\Github\\intellij-community";
		String here = "F:\\workspace\\_projekty\\Github\\IdeaIconPack\\icons\\master_2018_05_28";

		Files.walk(Paths.get(from)).filter(s -> {
			String s1 = s.toString();
			return s1.endsWith(".png") && !s1.contains("\\out\\") && !s1.contains("\\.idea\\");
		}).forEach(new Consumer<Path>() {
			@Override
			public void accept(Path path) {
				String s = path.toString();

				String s1 = StringUtils.substringAfterLast(s, "\\resources\\");
				if (s1.isEmpty()) {
					s1 = StringUtils.substringAfterLast(s, "\\src\\");
				}
				if (!s1.isEmpty()) {
					Path target = Paths.get(here, s1);
					System.err.println(target.toAbsolutePath());
					try {
						if (!Files.exists(target.getParent())) {
							Files.createDirectories(target.getParent());
						}
						Files.copy(path, target, StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			}
		});
	}
}