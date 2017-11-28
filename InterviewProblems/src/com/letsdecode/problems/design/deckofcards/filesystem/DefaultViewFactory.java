package com.letsdecode.problems.design.deckofcards.filesystem;

public class DefaultViewFactory implements ViewerControllerFactory {

	@Override
	public FileSystemViewController createFileViewController(String viewType) {
		return null;
	}

	@Override
	public View createView(FileModel fileModel, int viewType) {
		return null;
	}

}
