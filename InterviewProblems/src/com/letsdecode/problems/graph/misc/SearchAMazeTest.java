package com.letsdecode.problems.graph.misc;

import org.junit.Test;

public class SearchAMazeTest {

	@Test
	public void test() {
		boolean matrix[][] = new boolean[4][4];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = Math.random() < 0.8;
			}
		}
		SearchAMaze searchAMaze = new SearchAMaze(matrix, 0, 3);
		searchAMaze.printMatrix(matrix);
		// matrix = paintBooleanMatrix.paintRecursive(2, 3, matrix[2][3]);
		boolean path = searchAMaze.isPathRecursive(3, 0);
		System.out.println(path ? "Yes" : "No");
		searchAMaze.printMatrix(matrix);

	}

	@Test
	public void testIterative() {
		 boolean matrix[][] = new boolean[4][4];
		 for (int i = 0; i < matrix.length; i++) {
		 for (int j = 0; j < matrix[i].length; j++) {
		 matrix[i][j] = Math.random() < 0.8;
		 }
		 }
//		boolean matrix[][] = { { true, true, false, true },
//				{ true, true, true, true }, { true, true, true, true },
//				{ false, false, true, true } };
		SearchAMaze searchAMaze = new SearchAMaze(matrix, 0, 3);
		searchAMaze.printMatrix(matrix);
		boolean path = searchAMaze.iterative();
		System.out.println(path ? "Yes" : "No");

	}
}
