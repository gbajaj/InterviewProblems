package com.letsdecode.problems.dynamic;

import java.util.HashSet;
import java.util.LinkedList;

public class LongestPathToSkiDown {
	public LongestPathToSkiDown(int a[][]) {
		this.a = a;
		this.m = new int[a.length][a[0].length];
	}

	int a[][];// mountain elevation
	int m[][];
	public static final int xa[] = { 0, 0, -1, 1 };
	public static final int ya[] = { 1, -1, 0, 0 };
	HashSet<String> recPath;

	class ElevationPath {
		LinkedList<String> path = new LinkedList<>();
		int cost;
		int startElevation = Integer.MIN_VALUE;
	}

	LinkedList<String> findPath() {
		ElevationPath pre = new ElevationPath();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				recPath = new HashSet<String>();
				ElevationPath res = startExploring(i, j);
				recPath.add("" + i + "" + j);
				if (res.path.size() > pre.path.size()
						|| res.path.size() == pre.path.size()
						&& res.startElevation > pre.startElevation) {
					pre = res;
				}
			}
		}
		print();
		return pre.path;
	}

	private void print() {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(m[i][j] + " " );
			}
			System.out.println("");
		}
		
	}

	ElevationPath startExploring(int i, int j) {
		int value = a[i][j];
		ElevationPath el = new ElevationPath();
		el.startElevation = value;
		int cost = startExploringHelper(i, j, el.path);
		el.cost = cost;
		return el;
	}

	int startExploringHelper(int x, int y, LinkedList<String> path) {

		if (a[x][y] == 0) {
			m[x][y] = 1;
			return 1;
		}
		if (m[x][y] < 0) {
			return Integer.MIN_VALUE;
		}
		if (m[x][y] > 0) {
			return m[x][y];
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 4; i++) {
			int nx = x + xa[i];
			int ny = y + ya[i];
			if (isValid(x, y, nx, ny)) {
				int val = 1 + startExploringHelper(nx, ny, path);
				if (val < 0) {
					m[nx][ny] = Integer.MIN_VALUE;
					continue;
				}
				max = Math.max(max, val);
			}
		}
		path.addFirst("" + max);
		m[x][y] = max;
		return m[x][y];
	}

	private boolean isValid(int x, int y, int nx, int ny) {
		if (nx >= 0 && nx < a.length && ny >= 0 && ny < a[nx].length) {
			if (a[nx][ny] <= a[x][y]
					&& recPath.contains("" + nx + "" + ny) == false) {
				return true;
			}
		}
		return false;
	}
}
