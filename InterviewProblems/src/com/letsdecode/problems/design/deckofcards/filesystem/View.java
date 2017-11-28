package com.letsdecode.problems.design.deckofcards.filesystem;

public interface View {
	void layout();
	void onDraw(Object graphics);
	
	boolean  onKeyDown(int keyCode, int keyEvent);
	boolean onKeyUp(int keyCode, int keyEvent);
	boolean  onTouchEvent(Object motionEvent);

	void onFocusChanged(boolean value);
	void onMeasure(int height, int width);
	void onAttachedToWindow();
	void onDetachedFromWindow();

	void setVisibility();
	boolean hasFocus();
}
