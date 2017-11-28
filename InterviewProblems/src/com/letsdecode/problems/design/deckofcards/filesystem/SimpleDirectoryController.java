package com.letsdecode.problems.design.deckofcards.filesystem;

public class SimpleDirectoryController implements FileSystemViewController {
	FileModelsCollection collection;
	SimpleDirecotryViewer simpleDirectoryView;

	public SimpleDirectoryController(FileModelsCollection collection,
			SimpleDirecotryViewer simpleDirectoryView) {
		this.collection = collection;
		this.simpleDirectoryView = simpleDirectoryView;
	}

	@Override
	public boolean onKeyDown(int keyCode, int keyEvent) {
		collection.selectNext();
		return false;
	}

	@Override
	public boolean onKeyUp(int keyCode, int keyEvent) {
		collection.selectPrevious();
		simpleDirectoryView.onDraw(graphics);
		return false;
	}

	@Override
	public boolean onTouchEvent(Object motionEvent) {
		return false;
	}

	@Override
	public View initilize(String filePath) {
		return null;
	}

}
