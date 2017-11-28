package com.letsdecode.problems.graph.knight;

import org.junit.Test;

public class KnightsTourTest {

	@Test
	public void test() {
		KnightsTour knightsTour = new KnightsTour();
		knightsTour.findExitHelper(0, 0, 3, 6, 1);
		//Print the board
		for (int i = 0; i < knightsTour.a.length; i++) {
			for (int j = 0; j < knightsTour.a[0].length; j++) {
				System.out.print(knightsTour.a[i][j] + " "); 
			}
			System.out.println();
			
		}
		
	}

}
