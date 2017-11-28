package com.letsdecode.problems.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueeen {
	int n;
	boolean[][] a;
	boolean columnUsed[];
	List<List<String>> list = new ArrayList<>();
	int count = 0;

	public NQueeen(int n) {
		this.n = n;
		a = new boolean[n][n];
		columnUsed = new boolean[n];
	}

	public void call() {
		generate();

	}

	private void generate() {
		subProblem(0);
	}

	private void subProblem(int row) {
		if (row >= n) {
			count++;
//			print(a)
			return;
		}
		for (int col = 0; col < n; col++) {
			if (columnUsed[col] || diagonalsUsed(a, row, col)) {
				continue;
			}
			a[row][col] = true;
			columnUsed[col] = true;
			subProblem(row + 1);
			a[row][col] = false;
			columnUsed[col] = false;
		}
	}

	private boolean diagonalsUsed(boolean[][] a, int row, int col) {
		int i = row - 1;
		int j = col - 1;

		while (i >= 0 && j >= 0) {
			if (a[i][j]) {
				return true;
			}
			i--;
			j--;
		}

		i = row - 1;
		j = col + 1;

		while (i >= 0 && j < n) {
			if (a[i][j]) {
				return true;
			}
			i--;
			j++;
		}
		return false;

	}

	private void print(boolean[][] a) {
		ArrayList<String> l = new ArrayList<>();

		for (int i = 0; i < a.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < a.length; j++) {
				if (a[i][j]) {
					sb.append("Q");
				} else {
					sb.append(".");
				}

			}
			l.add(sb.toString());
		}
		list.add(l);
	}

}
