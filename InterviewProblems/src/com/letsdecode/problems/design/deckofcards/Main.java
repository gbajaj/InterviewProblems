package com.letsdecode.problems.design.deckofcards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static String CARD_GUESS_GAME = "CardGuessGame";
	CardDec<ICard> cardDec;

	public boolean initGame(String gameType) {
		if (CARD_GUESS_GAME.equals(gameType)) {
			List<ICard> cards = buildSimpleCards();
			cardDec = new CardDec<ICard>(cards,
					new DefaultShuffleStrategy<ICard>());
			cardDec.shuffle();
			System.out.println("TOTAL CARDS " + cardDec.getCount());
			return true;
		}
		return false;
	}

	public void playGame() throws IOException {
		System.out.println("Welcome to the Card Guess Game!");
		System.out.println("Please enter a valie input e.g. DIAMOND 9");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input;
		while ((input = br.readLine()) != null) {
			String[] a = input.split(" ");
			if (a.length != 2) {
				System.out.println("Invalid Input! Try Again!");
				continue;
			}
			a[0] = a[0].trim();
			a[1] = a[1].trim();
			try {
				Suit suit = Suit.valueOf(a[0]);
				CardNumber cardNumber = CardNumber.valueOf(a[1]);
				ICard card = cardDec.getNextCard();
				if (card.getSuit() == suit
						&& card.getCardNumber() == cardNumber) {
					System.out.println("You WON!");
					break;
				} else {
					System.out.println("Try Again!");
				}
				if (cardDec.getCount() <=0) {
					System.out.println("You LOST!");
				}

			} catch (Exception e) {
				System.out.println("Invalid Input! Try Again!");
				continue;
			}

			System.out.println("You entered " + input);
		}
	}

	List<ICard> buildSimpleCards() {
		List<ICard> cards = new ArrayList<>();
		for (Suit s : Suit.values()) {
			if (s == Suit.JOCKER)
				continue;
			for (CardNumber nu : CardNumber.values()) {
				cards.add(new SimpleCard(s, nu, 1));
			}
		}
		return cards;
	}
}
