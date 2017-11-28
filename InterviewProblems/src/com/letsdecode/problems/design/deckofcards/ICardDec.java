package com.letsdecode.problems.design.deckofcards;

import java.util.List;

public interface ICardDec<T> {
	T getNextCard();

	List<T> getCards(int n);

	int getCount();
	
	void shuffle();

}
