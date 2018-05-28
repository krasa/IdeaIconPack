//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package krasa.iconpack;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class JoinFolders {
	public static void main(String[] args) throws IOException {
		String root = "F:\\workspace\\_projekty\\Github\\IdeaIconPack";
		String dest = root + "\\src\\iconpack";
		
		copy2(root + "\\icons\\idea2017_12", dest);
		copy2(root + "\\icons\\idea11", dest);
	}

	private static void copy2(String s, String dest) throws IOException {
		Path srcDir = Paths.get(s);
		Path dstDir = Paths.get(dest);

		Files.walkFileTree(srcDir, new SimpleFileVisitor<Path>() {
		    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs ) throws IOException {
		        return copy(file);
		    }
		    public FileVisitResult preVisitDirectory( Path dir, BasicFileAttributes attrs ) throws IOException {
		        return copy(dir);
		    }
		    private FileVisitResult copy( Path fileOrDir ) throws IOException {
				Path dest = dstDir.resolve(srcDir.relativize(fileOrDir));
				if (Files.exists(dest) && Files.isDirectory(dest)) {
					return FileVisitResult.CONTINUE;
				}
				Files.copy( fileOrDir, dest, StandardCopyOption.REPLACE_EXISTING );
		        return FileVisitResult.CONTINUE;
		    }
		});
	}

}