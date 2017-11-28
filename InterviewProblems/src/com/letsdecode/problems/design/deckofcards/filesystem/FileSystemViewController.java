package com.letsdecode.problems.design.deckofcards.filesystem;

public interface FileSystemViewController {

	boolean onKeyDown(int keyCode, int keyEvent);

	boolean onKeyUp(int keyCode, int keyEvent);

	boolean onTouchEvent(Object motionEvent);

	View initilize(String filePath);
}
