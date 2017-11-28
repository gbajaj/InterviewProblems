package com.letsdecode.problems.graph.misc;

import java.util.LinkedList;
import java.util.Queue;

public class PaintBooleanMatrix {
	boolean[][] matrix;
	boolean[][] visited;

	public PaintBooleanMatrix(boolean[][] matrix) {
		this.matrix = matrix;
		this.visited = new boolean[matrix.length][matrix[0].length];
	}

	int[] xa = { 0, 0, 1, -1 };
	int[] ya = { 1, -1, 0, 0 };

	public void printMatrix(boolean[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}

	class Pair {
		public Pair(int x, int y) {
			first = x;
			second = y;
		}

		int first;
		int second;
	}

	public void paintIterative_BFS(int x, int y, boolean color) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		while (q.isEmpty() == false) {
			Pair p = q.poll();
			matrix[p.first][p.second] = !color;
			for (int k = 0; k < 4; k++) {
				int nx = p.first + xa[k];
				int ny = p.second + ya[k];
				if (isValid(nx, ny, color)) {
					q.add(new Pair(nx, ny));
				}
			}
		}
	}

	public boolean[][] paintRecursive(int x, int y, boolean color) {
		if (isValid(x, y, color) == false || isVisited(x, y)) {
			return matrix;
		}
		setVisited(x, y);
		matrix[x][y] = !color;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				for (int k = 0; k < 4; k++) {
					int nx = x + xa[k];
					int ny = y + ya[k];
					paintRecursive(nx, ny, color);
				}

			}
		}
		return this.matrix;
	}

	private boolean isValid(int x, int y, boolean color) {
		if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
				&& matrix[x][y] == color) {
			return true;
		}
		return false;
	}

	private boolean isVisited(int x, int y) {
		return this.visited[x][y];
	}

	private void setVisited(int x, int y) {
		this.visited[x][y] = true;
	}
}
