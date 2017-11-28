package com.letsdecode.problems.design.deckofcards;

import java.util.List;
import java.util.Random;

public class DefaultShuffleStrategy<T> implements IShuffleStrategy<T> {

	@Override
	public List<T> shuffle(List<T> cards) {
		int n = cards.size();
		Random random = new Random();
		random.nextInt();
		for (int i = 0; i < n; i++) {
			int change = i + random.nextInt(n - i);
			swap(cards, i, change);
		}
		return null;
	}

	private static <T> void swap(List<T> a, int i, int change) {
		T helper = a.get(i);
		a.set(i, a.get(change));
		a.set(change, helper);
	}
}
