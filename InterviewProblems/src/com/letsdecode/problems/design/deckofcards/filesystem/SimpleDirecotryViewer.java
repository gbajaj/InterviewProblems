package com.letsdecode.problems.design.deckofcards.filesystem;

import java.util.ArrayList;
import java.util.List;

public class SimpleDirecotryViewer implements ViewGroup {
	List<View> children = new ArrayList<>();
	FileSystemViewController controller;

	SimpleDirecotryViewer(FileSystemViewController fileSystemViewController) {
		this.controller = fileSystemViewController;
//		for (FileModel f : fileModels) {
//			children.add(new BaseFileViewer(f));
//		}

	}

	@Override
	public void layout() {
	}

	@Override
	public void onDraw(Object graphics) {
	}

	@Override
	public boolean onKeyDown(int keyCode, int keyEvent) {
		boolean ret = controller.onKeyDown(keyCode, keyEvent);
		return false;

	}

	@Override
	public boolean onKeyUp(int keyCode, int keyEvent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTouchEvent(Object motionEvent) {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public void onFocusChanged(boolean value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMeasure(int height, int width) {
		// TODO Auto-generated method stub

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

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View childAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addView(View view) {
		children.add(view);

	}

	@Override
	public void addView(View view, int index) {
		children.add(index, view);

	}

	@Override
	public void removeView(View view) {

		children.remove(view);
	}

	@Override
	public void removeViewAt(int index) {
		// TODO Auto-generated method stub

	}

}
