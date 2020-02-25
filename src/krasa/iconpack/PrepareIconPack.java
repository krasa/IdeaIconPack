package krasa.iconpack;

import org.codehaus.plexus.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class PrepareIconPack {
	public static void main(String[] args) throws IOException {
		iconpack_2016_2(args);
		iconpack_2018_1(args);
	}

	private static void iconpack_2018_1(String[] args) throws IOException {
		String dest = "F:\\workspace\\_projekty\\Github\\IdeaIconPack\\src\\iconpack_2018_1";
		copyDiff("F:\\workspace\\_projekty\\Github\\IdeaIconPack\\icons\\idea_181.5087.20", "F:\\workspace\\_projekty\\Github\\IdeaIconPack\\icons\\master_2018_05_28", dest, null);
		IdeaIconPack_2018_1.main(args);
	}

	private static void iconpack_2016_2(String[] args) throws IOException {
		String dest = "F:\\workspace\\_projekty\\Github\\IdeaIconPack\\src\\iconpack_2016_2";

		delete(dest);

		copyDiff("F:\\workspace\\_projekty\\Github\\IdeaIconPack\\icons\\idea_181.5087.20", "F:\\workspace\\_projekty\\Github\\IdeaIconPack\\icons\\master_2018_05_28", dest, null);

		copyDiff("F:\\workspace\\_projekty\\Github\\IdeaIconPack\\icons\\idea_162.2228.15", "F:\\workspace\\_projekty\\Github\\IdeaIconPack\\icons\\master_2018_05_28", dest, null);

		copy2("F:\\workspace\\_projekty\\Github\\IdeaIconPack\\icons\\bulenkov_plugin", dest, null);

		copyDiff("F:\\workspace\\_projekty\\Github\\IdeaIconPack\\icons\\idea_181.5087.20", dest, dest, new Filter() {
			@Override
			boolean include(Path fileOrDir) {
				//they are nicer in IJ 2018
				return nameStartsWith(fileOrDir, "commit", "checkOut", "menu-open", "toolWindowMaven", "mavenLogo");
			}

		});
		IdeaIconPack_2016_2.main(args);
	}

	private static void delete(String dest) throws IOException {
		FileUtils.deleteDirectory(new File(dest));
	}

	private static void copyDiff(String src, String diff, String dest, final Filter filter) throws IOException {
		Path srcDir = Paths.get(src);
		Path diffDir = Paths.get(diff);
		Path dstDir = Paths.get(dest);

		Files.walkFileTree(srcDir, new SimpleFileVisitor<Path>() {
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				return copy(file);
			}

			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				return copy(dir);
			}

			private FileVisitResult copy(Path fileOrDir) throws IOException {
				Path diff = diffDir.resolve(srcDir.relativize(fileOrDir));
				Path dest = dstDir.resolve(srcDir.relativize(fileOrDir));


				if (Files.isDirectory(fileOrDir)) {
					return FileVisitResult.CONTINUE;
				}

				if (exclude(srcDir, fileOrDir)) {
					return FileVisitResult.CONTINUE;
				}


				if (filter != null && !filter.include(fileOrDir)) {
					return FileVisitResult.CONTINUE;
				}

				if (filter != null && filter.skip(fileOrDir)) {
					return FileVisitResult.CONTINUE;
				}

				if (FileUtils.contentEquals(diff.toFile(), fileOrDir.toFile())) {
					return FileVisitResult.CONTINUE;
				}


				if (!Files.exists(dest.getParent())) {
					Files.createDirectories(dest.getParent());
				}


				Files.copy(fileOrDir, dest, StandardCopyOption.REPLACE_EXISTING);
				return FileVisitResult.CONTINUE;
			}
		});


	}

	private static boolean exclude(Path srcDir, Path path) {
		File file = path.toFile();
		String name = file.getName();
		return
			name.contains("_logo")
				|| name.contains("_about")
				|| name.contains("Shadow")
				|| file.getParentFile().getName().equals("shadow")
				|| file.getParentFile().getName().equals("windows")
				|| file.getParentFile().getAbsolutePath().contains("lafs")
				//checkbox and such is loaded all the time and fill the log
				|| file.getParentFile().getAbsolutePath().contains("laf")
			;
	}

	private static void copy2(String s, String dest, Filter filter) throws IOException {
		Path srcDir = Paths.get(s);
		Path dstDir = Paths.get(dest);

		Files.walkFileTree(srcDir, new SimpleFileVisitor<Path>() {
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				return copy(file);
			}

			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				return copy(dir);
			}

			private FileVisitResult copy(Path fileOrDir) throws IOException {
				Path dest = dstDir.resolve(srcDir.relativize(fileOrDir));
				if (Files.isDirectory(fileOrDir)) {
					return FileVisitResult.CONTINUE;
				}

				if (exclude(srcDir, fileOrDir)) {
					return FileVisitResult.CONTINUE;
				}

				if (filter != null && !filter.include(fileOrDir)) {
					return FileVisitResult.CONTINUE;
				}

				if (filter != null && filter.skip(fileOrDir)) {
					return FileVisitResult.CONTINUE;
				}


				if (!Files.exists(dest.getParent())) {
					Files.createDirectories(dest.getParent());
				}

				Files.copy(fileOrDir, dest, StandardCopyOption.REPLACE_EXISTING);
				return FileVisitResult.CONTINUE;
			}
		});
	}

	abstract static class Filter {
		boolean skip(Path fileOrDir) {
			return false;
		}

		boolean include(Path fileOrDir) {
			return true;
		}

		final boolean nameStartsWith(Path fileOrDir, String... names) {
			for (String s: names) {
				if (fileOrDir.getFileName().toString().startsWith(s)) {
					return true;
				}
			}
			return false;
		}
	}


}