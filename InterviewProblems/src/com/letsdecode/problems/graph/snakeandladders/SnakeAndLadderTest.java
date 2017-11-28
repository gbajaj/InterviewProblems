package com.letsdecode.problems.graph.snakeandladders;

import static org.junit.Assert.*;

import org.junit.Test;

public class SnakeAndLadderTest {

	@Test
	public void test() {
		SnakeAndLadderBuilder snakeAndLadderBuilder = new SnakeAndLadderBuilder();
		snakeAndLadderBuilder.build();
		System.out.println(new SnakeAndLadder(snakeAndLadderBuilder.map, 36)
				.findSteps());
	}

	@Test
	public void test2() {
		SnakeAndLadderBuilder snakeAndLadderBuilder = new SnakeAndLadderBuilder();
		snakeAndLadderBuilder.build2();
		System.out.println(new SnakeAndLadder(snakeAndLadderBuilder.map, 30)
				.findSteps());
	}

}
