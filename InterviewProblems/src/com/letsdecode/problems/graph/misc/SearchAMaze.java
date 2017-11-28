package com.letsdecode.problems.graph.misc;

import java.util.Stack;

public class SearchAMaze {
	boolean[][] matrix;
	boolean[][] visited;
	int tx;
	int ty;

	public SearchAMaze(boolean[][] matrix, int x, int y) {
		this.matrix = matrix;
		this.visited = new boolean[matrix.length][matrix[0].length];
		this.tx = x;
		this.ty = y;
	}

	int[] xa = { 0, -1 };
	int[] ya = { 1, 0 };

	public void printMatrix(boolean[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public boolean isPathRecursive(int x, int y) {

		return _isPathRecursive(x + xa[0], y + ya[0])
				|| _isPathRecursive(x + xa[1], y + ya[1]);
	}

	public boolean _isPathRecursive(int x, int y) {
		if (tx == x && ty == y) {
			return true;
		}
		if (isValid(x, y) == false) {
			return false;
		}
		boolean found = false;
		for (int k = 0; k < 2; k++) {
			int nx = x + xa[k];
			int ny = y + ya[k];
			found = _isPathRecursive(nx, ny);
			if (found) {
				break;
			}
		}
		if (found) {
			return true;
		}

		return false;
	}

	boolean isValid(int x, int y) {
		if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
				&& matrix[x][y] || (x == tx && y == ty)) {
			return true;
		}
		return false;
	}

	class Pair {
		public Pair(int x, int y) {
			first = x;
			second = y;
		}

		int first;
		int second;
	}

	int x;
	int y;

	public boolean iterative() {
		Stack<Pair> s = new Stack();
		this.visited = new boolean[matrix.length][matrix[0].length];
		Pair start = new Pair(3, 0);
		s.add(getUp(start));
		s.add(getRight(start));
		while (s.isEmpty() == false) {
			Pair node = s.pop();

			if (isNotBoundry(node) && isVisited(node) == false) {
				if (isTarget(node)) {
					return true;
				}
				if (isBlocked(node)) {
					continue;
				}
				s.push(getUp(node));
				s.push(getRight(node));
			}
		}

		return false;
	}

	boolean isBlocked(Pair p) {
		return matrix[p.first][p.second] == false;
	}

	boolean isVisited(Pair p) {
		return visited[p.first][p.second];

	}

	boolean isNotBoundry(Pair p) {
		if (p.first >= 0 && p.first < matrix.length && p.second >= 0
				&& p.second < matrix[p.first].length) {
			return true;
		}
		return false;
	}

	boolean isTarget(Pair p) {
		if (p.first == 0 && p.second == matrix[p.first].length - 1) {
			return true;
		}
		return false;
	}

	Pair getUp(Pair p) {
		return new Pair(p.first - 1, p.second);
	}

	Pair getRight(Pair p) {
		return new Pair(p.first, p.second + 1);
	}

}
