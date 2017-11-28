package com.letsdecode.problems.design.deckofcards;

import java.io.IOException;

import org.junit.Test;

public class MainTest {

	@Test
	public void test() {
		Main m = new Main();
		m.initGame(Main.CARD_GUESS_GAME);
		try {
			m.playGame();
		} catch (IOException e) {
			System.out.println("GAME EXITED WITH ERROR");
		}
	}

}
