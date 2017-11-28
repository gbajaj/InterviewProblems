package com.letsdecode.problems.design.deckofcards;

import java.util.ArrayList;
import java.util.List;

public class CardDec<T> implements ICardDec<T> {
	private List<T> cards;
	private IShuffleStrategy<T> shuffleStrategy = new DefaultShuffleStrategy<>();

	public CardDec(final List<T> cards, IShuffleStrategy<T> shuffleStrategy) {
		this.cards = cards;
		this.shuffleStrategy = shuffleStrategy;
	}

	@Override
	public T getNextCard() throws IllegalStateException {
		return this.cards.remove(0);
	}

	@Override
	public List<T> getCards(int n) throws IllegalStateException {
		if (n > cards.size())
			throw new IllegalStateException();
		List<T> out = new ArrayList<>();
		int i = 0;
		while (i < n) {
			out.add(cards.get(0));
			i++;
		}
		return out;
	}

	@Override
	public int getCount() {
		return cards.size();
	}

	@Override
	public void shuffle() {
		shuffleStrategy.shuffle(cards);
	}

}
