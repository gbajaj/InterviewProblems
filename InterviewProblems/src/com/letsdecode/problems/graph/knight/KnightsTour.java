package com.letsdecode.problems.graph.knight;


public class KnightsTour {
	int xa[] = { 2, 2, -2, -2, 1, 1, -1, -1 };

	int ya[] = { 1, -1, 1, -1, 2, -2, 2, -2 };

	public int a[][] = new int[8][8];

	public int findExitHelper(int x, int y, int tx, int ty, int move) {
		if (move == 8 * 8) {
			return 10000;
		}
		if (x == tx && y == ty) {
			return 0;
		}
		Integer min = 10000;
		for (int i = 0; i < xa.length; i++) {
			int nx = x + xa[i];
			int ny = y + ya[i];
			if (isValidMove(nx, ny)) {// Is next move a valid location
				if (a[nx][ny] != 0) {
					// if next move has already been calculated then check which
					// one is minimum from the current cell
					min = Math.min(min, 1 + a[nx][ny]);
				} else {
					// if next move is not already calculated the go calculate
					int cal = 1 + findExitHelper(nx, ny, tx, ty, 1 + move);
					min = Math.min(min,
							cal);
				}
			}
		}
		a[x][y] = min;
		return min;
	}

	boolean isValidMove(int x, int y) {
		if (x < 0 || y < 0 || x > 7 || y > 7) {
			return false;
		}
		return true;
	}
}
