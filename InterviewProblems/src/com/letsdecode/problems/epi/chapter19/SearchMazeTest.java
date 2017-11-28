package com.letsdecode.problems.epi.chapter19;

import static org.junit.Assert.*;

import org.junit.Test;

import com.letsdecode.problems.graph.misc.SearchAMaze;

public class SearchMazeTest {

	@Test
	public void testIterative() {
		 boolean matrix[][] = new boolean[4][4];
		 for (int i = 0; i < matrix.length; i++) {
		 for (int j = 0; j < matrix[i].length; j++) {
		 matrix[i][j] = Math.random() < 0.5;
		 }
		 }
		 SearchMaze searchAMaze = new SearchMaze(matrix);
		searchAMaze.printMatrix(matrix);
		boolean path = searchAMaze.isIterative();
		System.out.println(path ? "Yes" : "No");

	}
	

}
