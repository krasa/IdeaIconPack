package krasa.iconpack;

public final class FileOnlyIconFilter extends SimpleIconPathPatcher {
	private final SimpleIconPathPatcher pathPatcher;

	public FileOnlyIconFilter(SimpleIconPathPatcher pathPatcher) {
		this.pathPatcher = pathPatcher;
	}

	@Override
	public String redirectIconPath(String iconPath) {
		if ((!iconPath.startsWith("/action/")) && (iconPath.startsWith("/fileTypes/") ||
				iconPath.startsWith("/modules/") ||
				iconPath.startsWith("/nodes/") ||
				// Plugin can locate icons in an arbitrary folder.
				iconPath.endsWith("FileType.png") || iconPath.endsWith("FileType.svg") ||
				iconPath.endsWith("FileType@2x.png") || iconPath.endsWith("FileType@2x.svg") ||
				iconPath.endsWith("File.png") || iconPath.endsWith("File.svg") ||
				iconPath.endsWith("File@2x.png") || iconPath.endsWith("File@2x.svg"))) {
			return pathPatcher.redirectIconPath(iconPath);
		}

		return null;
	}
}
