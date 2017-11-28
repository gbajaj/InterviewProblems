package com.letsdecode.problems.design.deckofcards;

import java.util.List;

public interface IShuffleStrategy<T> {
	List<T> shuffle(List<T> cards);
}
