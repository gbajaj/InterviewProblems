package com.letsdecode.problems.design.deckofcards.filesystem;

public interface ViewGroup extends View {
	int getChildCount();

	View childAt(int index);

	void addView(View view);

	void addView(View view, int index);

	void removeView(View view);

	void removeViewAt(int index);

}
