package com.letsdecode.problems.sorting;

import java.awt.print.Printable;
import java.security.Principal;

public class CountingSort {
	int A[];
	int B[];
	int out[];

	public int[] getOut() {
		return out;
	}

	public CountingSort(int a[]) {
		A = a;
	}

	public void sort() {
		print(A);
		B = new int[A.length + 1];
		for (int i = 0; i < A.length; i++) {
			B[A[i]]++;
		}
		print(B);
		for (int i = 1; i < B.length; i++) {
			B[i] = B[i] + B[i - 1];
		}
		print(B);
		out = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			out[B[A[i]]-1] = A[i];
			B[A[i]]--;
		}
		print(B);
		print(out);
	}

	private void print(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
