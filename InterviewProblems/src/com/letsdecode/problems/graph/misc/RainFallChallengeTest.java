package com.letsdecode.problems.graph.misc;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class RainFallChallengeTest {

	@Test
	public void test() {
		// int[][] a = { { 1, 5, 2 }, { 2, 4, 7 }, { 3, 6, 9 } };

		int[][] a = { { 1, 0, 2, 5, 8 }, { 2, 3, 4, 7, 9 }, { 3, 5, 7, 8, 9 },
				{ 1, 2, 5, 4, 3 }, { 3, 3, 5, 2, 1 } };
		RainFallChallenge rainFallChallenge = new RainFallChallenge(5, a);
		rainFallChallenge.buildGraph(a);
		// rainFallChallenge.printGraphByVal();
		rainFallChallenge.buildBasins();
//		rainFallChallenge.inAndOut();
		ArrayList<RainFallChallenge.Node> list = rainFallChallenge
				.arrangeByParent();
		rainFallChallenge.addLabel(list);
		rainFallChallenge.printByLabel();

	}
}
