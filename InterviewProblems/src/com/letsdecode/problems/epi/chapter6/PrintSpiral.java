package com.letsdecode.problems.epi.chapter6;

public class PrintSpiral {
	public void printSpiral(int A[][]) {
		int i = 0;
		int j = 0;
		int size = A.length - 1;
		while (size >= 0) {
			print(A, i, j, size);
			i++;
			j++;
			size -= 2;
		}
	}

	private void print(int A[][], int i, int j, int size) {

		for (int s = j; s <= j + size; s++) {
			System.out.print(A[i][s] + " ");
		}

		for (int s = i + 1; s <= i + size; s++) {
			System.out.print(A[s][j + size] + " ");
		}

		for (int s = j + size - 1; s >= j; s--) {
			System.out.print(A[i + size][s] + " ");
		}

		for (int s = i + size - 1; s >= i + 1; s--) {
			System.out.print(A[s][j] + " ");
		}

	}
}
