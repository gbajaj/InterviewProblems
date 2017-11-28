package com.letsdecode.problems.design.deckofcards;

import java.util.List;

public class BaseHand<T> implements IHand<T> {
	List<T> collection;

	@Override
	public int count() {
		return collection.size();
	}

	@Override
	public T findCard(Suit suit, CardNumber cardNumber) {
		T card = null;
		return card;
	}

	@Override
	public void addCard(T card) {
		collection.add(card);
	}

	@Override
	public boolean removeCard(T card) {
		return collection.remove(card);
	}
}
