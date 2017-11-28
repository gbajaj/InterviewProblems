package com.letsdecode.problems.design.deckofcards.filesystem;

public class BaseFileViewer implements View {
	FileModel fileModel;
	
	BaseFileViewer(FileModel fileModel) {
		this.fileModel = fileModel;
	}

	@Override
	public void layout() {
	}

	@Override
	public void onDraw(Object graphics) {
	}

	@Override
	public boolean onKeyDown(int keyCode, int keyEvent) {
		return false;
	}

	@Override
	public boolean onKeyUp(int keyCode, int keyEvent) {
		return false;
	}

	@Override
	public boolean onTouchEvent(Object motionEvent) {
		return false;
	}

	@Override
	public void onFocusChanged(boolean value) {
	}

	@Override
	public void onMeasure(int height, int width) {
	}

	@Override
	public void onAttachedToWindow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDetachedFromWindow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setVisibility() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasFocus() {
		// TODO Auto-generated method stub
		return false;
	}
}
