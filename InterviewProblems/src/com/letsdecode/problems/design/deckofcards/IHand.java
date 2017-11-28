package com.letsdecode.problems.design.deckofcards;

public interface IHand<T> {
	int count();

	T findCard(Suit suit, CardNumber cardNumber);

	void addCard(T card);

	boolean removeCard(T card);
}
