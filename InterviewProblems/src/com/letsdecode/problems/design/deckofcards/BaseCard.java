package com.letsdecode.problems.design.deckofcards;

import com.apple.eawt.AppEvent.QuitEvent;

abstract public class BaseCard implements ICard {
	@Override
	public String toString() {
		return "BaseCard [suit=" + suit + ", cardNumber=" + cardNumber
				+ ", value=" + value + "]";
	}

	private Suit suit;
	private CardNumber cardNumber;
	private int value;

	public BaseCard(Suit suit, CardNumber cardNumber, int value) {
		this.suit = suit;
		this.cardNumber = cardNumber;
		this.value = value;
	}

	@Override
	public Suit getSuit() {
		return suit;
	}

	@Override
	public CardNumber getCardNumber() {
		return cardNumber;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public boolean isFaceCard() {
		switch (cardNumber) {
		case KING:
		case QUEEN:
		case JACK:
			return true;
		default:
			break;
		}
		return false;
	}

	@Override
	public boolean isPipCard() {
		switch (cardNumber) {
		case TWO:
		case THREE:
		case FOUR:
		case FIVE:
		case SIX:
		case SEVEN:
		case EIGHT:
		case NINE:
		case TEN:
			return true;
		default:
			break;
		}
		return false;
	}

	@Override
	public boolean isAce() {
		if (cardNumber == CardNumber.ACE) {
			return true;
		}
		return false;

	}

}
