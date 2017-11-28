package com.letsdecode.problems.design.deckofcards.filesystem;

import java.util.List;

public class FileModelsCollection {
	List<FileModel> collection;
	int currentSelectedIndex = -1;
	int lastSelectedSelectedIndex = -1;

	public FileModelsCollection(List<FileModel> collection) {
		this.collection = collection;
	}

	public void selectPrevious() {
		/**
		 * change FileModel Object
		 */
	}
	public void selectNext() {
		lastSelectedSelectedIndex = currentSelectedIndex;
		int nextIndex = (currentSelectedIndex + 1) % collection.size();
		if (collection.size() > 0) {
			if (lastSelectedSelectedIndex != nextIndex
					&& lastSelectedSelectedIndex > 0
					&& lastSelectedSelectedIndex < collection.size()) {
				FileModel model = collection.get(lastSelectedSelectedIndex);
				model.selected = false;
			}
			FileModel model = collection.get(nextIndex);
			if (model != null) {
				model.selected = true;
				currentSelectedIndex = nextIndex;
			}
		}
	}
}
