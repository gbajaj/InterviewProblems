package com.letsdecode.problems.design.deckofcards.filesystem;

public interface ViewerControllerFactory {
	FileSystemViewController createFileViewController(String viewType);
	View createView(FileModel fileModel, int viewType);
}
