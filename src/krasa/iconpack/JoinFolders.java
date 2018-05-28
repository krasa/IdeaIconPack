//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package krasa.iconpack;

import org.codehaus.plexus.util.FileUtils;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class JoinFolders {
	public static void main(String[] args) throws IOException {
		String dest = "F:\\workspace\\_projekty\\Github\\IdeaIconPack\\src\\iconpack";


		copyDiff("F:\\workspace\\_projekty\\Github\\IdeaIconPack\\icons\\master_2017_12", "F:\\workspace\\_projekty\\Github\\IdeaIconPack\\icons\\master_2018_05_28", dest);


		copy2("F:\\workspace\\_projekty\\Github\\IdeaIconPack\\icons\\idea11", dest);


	}

	private static void copyDiff(String src, String diff, String dest) throws IOException {
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

				if (isLogo(srcDir, fileOrDir)) {
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

	private static boolean isLogo(Path srcDir, Path file) {
		String name = file.toFile().getName();
		return file.getParent().equals(srcDir) && (name.contains("_logo") || name.contains("_about"));
	}

	private static void copy2(String s, String dest) throws IOException {
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

				if (isLogo(srcDir, fileOrDir)) {
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

}