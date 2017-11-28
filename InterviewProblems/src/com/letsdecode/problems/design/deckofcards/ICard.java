package com.letsdecode.problems.design.deckofcards;

public interface ICard {
	Suit getSuit();

	CardNumber getCardNumber();

	int getValue();

	boolean isFaceCard();

	boolean isPipCard();

	boolean isAce();

}
