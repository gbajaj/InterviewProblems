package com.letsdecode.problems.graph.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ComputeEnclosedRegions {
	public static final String W = "W";
	public static final String B = "B";
	String[][] matrix;
	int[][] visited;
	int x;
	int y;
	int[] xa = { 0, 0, 1, -1 };
	int[] ya = { 1, -1, 0, 0 };

	public ComputeEnclosedRegions(String[][] matrix) {
		this.matrix = matrix;
		this.visited = new int[matrix.length][matrix[0].length];
	}

	public void computeRecursiveBFS() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				_computeRecBFS(i, j);
			}
		}
	}

	public boolean _computeRecBFS(int x, int y) {
		visited[x][y] = 1;

		boolean sur = isSurrounded(x, y);
		return sur;
	}

	boolean isSurrounded(int x, int y) {
		boolean surrounded = true;
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			int nx = x + xa[i];
			int ny = y + ya[i];
			if (isValid(nx, ny) == false) {
				surrounded = false;
				break;
			} else if (visited[nx][ny] == -1) {
				surrounded = false;
				break;
			} else if (visited[nx][ny] == 1) {
				continue;
			} else if (isW(nx, ny)) {
				list.add(new Pair(nx, ny));
				surrounded = false;
			}
		}

		for (Pair p : list) {
			surrounded = _computeRecBFS(p.first, p.second);
			if (surrounded == false) {
				break;
			}
		}
		if (surrounded == false) {
			visited[x][y] = -1;
		} else {
			matrix[x][y] = B;
		}

		return surrounded;
	}

	public void computeRecursiveDFS() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				_computeRecDFS(i, j);
			}
		}
	}

	public boolean _computeRecDFS(int x, int y) {
		// if indices not valid then we already touched the boundary
		// return true;
		if (isValid(x, y) == false) {
			return true;
		}

		// if visited had -1 then we already touched the boundary through some
		// other path
		// return true;
		if (visited[x][y] == -1) {
			return true;
		} else if (visited[x][y] == 1) {
			// This path is safe as we never touched the boundary in the past
			// return false
			return false;
		}
		// For now mark this path as visiting assuming that it will not hit the
		// boundary
		visited[x][y] = 1;

		// We hit a neighboring B; great return false
		if (isW(x, y) == false) {
			return false;
		}

		boolean hitBoundry = false;

		for (int i = 0; i < 4; i++) {
			int nx = x + xa[i];
			int ny = y + ya[i];
			hitBoundry = _computeRecDFS(nx, ny);
			if (hitBoundry) {
				visited[x][y] = -1;
				return hitBoundry;
			}
		}
		if (hitBoundry == false) {
			matrix[x][y] = B;
		}
		return hitBoundry;
	}

	private boolean isW(int x, int y) {
		if (matrix[x][y].equals(W)) {
			return true;
		}

		return false;
	}

	public void compute() {
		// Stack<String> s = new Stack<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				_compute(i, j);
			}
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

	private void _compute(int i, int j) {
		Stack<Pair> s = new Stack<>();
		x = i;
		y = j;
		while (s.isEmpty() == false) {
			if (canMove(move.LEFT)) {
				_move(move.LEFT);
				s.push(new Pair(x, y));
			} else if (canMove(move.RIGHT)) {
				_move(move.RIGHT);
				s.push(new Pair(x, y));
			} else if (canMove(move.UP)) {
				_move(move.UP);
				s.push(new Pair(x, y));
			} else if (canMove(move.DOWN)) {
				_move(move.DOWN);
				s.push(new Pair(x, y));
			} else {
				Pair p = s.pop();
				while (s.isEmpty() == false
						&& isValid(p.first, p.second) == false) {
					p = s.pop();
				}
				if (isValid(p.first, p.second)) {

				}

			}

		}
	}

	enum move {
		LEFT, RIGHT, UP, DOWN
	};

	private void _move(move m) {

		switch (m) {
		case LEFT:
			x -= 1;
			break;
		case RIGHT:
			x += 1;
			break;
		case UP:
			y -= 1;
			break;
		case DOWN:
			y += 1;
			break;

		default:
			break;
		}

	}

	private boolean canMove(move m) {
		int nx = -1;
		int ny = -1;

		switch (m) {
		case LEFT:
			nx = x - 1;
			break;
		case RIGHT:
			nx = x + 1;
			break;
		case UP:
			ny = y - 1;
			break;
		case DOWN:
			ny = y + 1;
			break;

		default:
			break;
		}

		return (nx != -1 && ny != -1);

	}

	private boolean isValid(int x, int y) {
		if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length) {
			return true;
		}
		return false;
	}

	public void print() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
