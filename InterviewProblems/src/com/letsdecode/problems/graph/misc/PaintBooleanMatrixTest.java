package com.letsdecode.problems.graph.misc;

import org.junit.Test;

public class PaintBooleanMatrixTest {

	@Test
	public void test() {
		 boolean matrix[][] = new boolean[4][4];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = Math.random() < 0.5;
			}
		}
		PaintBooleanMatrix paintBooleanMatrix = new PaintBooleanMatrix(matrix);
		paintBooleanMatrix.printMatrix(matrix);
//		matrix = paintBooleanMatrix.paintRecursive(2, 3, matrix[2][3]);
		paintBooleanMatrix.paintIterative_BFS(2, 3, matrix[2][3]);
		System.out.println("");
		paintBooleanMatrix.printMatrix(matrix);
		

	}
}
