package com.letsdecode.problems.epi.chapter19;

import java.util.Stack;

public class SearchMaze {
	boolean[][] matrix = new boolean[4][4];
	boolean[][] visited;
	public SearchMaze(boolean[][] matrix) {
		this.matrix = matrix;
	}

	class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	boolean isIterative() {
		Stack<Pair> s = new Stack<>();
		Pair start = new Pair(matrix.length - 1, 0);
		visited = new boolean[matrix.length][matrix[0].length];
		s.push(getUp(start));
		s.push(getRight(start));
		while (s.isEmpty() == false) {
			Pair p = s.pop();
			if (isValid(p) && isVisited(p) == false) {
				visited[p.x][p.y] = true;
				if (isTarget(p)) {
					return true;
				}
				if (isBlocked(p)) {
					continue;
				}
				s.push(getUp(p));
				s.push(getRight(p));

			}
		}
		return false;
	}

	boolean isBlocked(Pair p) {
		return matrix[p.x][p.y] == false;
	}

	boolean isVisited(Pair p) {
		return visited[p.x][p.y];
	}

	boolean isTarget(Pair p) {
		if (p.x == 0 && p.y == matrix[0].length - 1) {
			return true;
		}
		return false;
	}

	Pair getUp(Pair p) {
		return new Pair(p.x - 1, p.y);
	}

	Pair getRight(Pair p) {
		return new Pair(p.x, p.y + 1);
	}

	boolean isValid(Pair p) {
		if (p.x >= 0 && p.x < matrix.length && p.y >= 0
				&& p.y < matrix[p.x].length) {
			return true;
		}
		return false;

	}
	public void printMatrix(boolean[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}

}

