package com.letsdecode.problems.recursion;


public class ExpressionGenerator {
	private char A[];
	private char[] tokens;
	private int target;
	public void getResult() {
	}

	public ExpressionGenerator(final char A[], final char[] tokens, int target) {
		this.A = A;
		this.tokens = tokens;
		this.target = target;
	}

	public void call() {
		char[] arr = new char[A.length + tokens.length + 1];
		generate(A, 0, tokens, arr, 0);
	}

	private void print(char[] arr, int lastIndex) {
		for (int i = 0; i <= lastIndex; i++) {
			System.out.print(arr[i]);
		}
	}

	private void generate(final char A[], int offsetNum, final char[] tokens,
			char arr[], int offset) {
		if (offsetNum == 0 && offsetNum == A.length - 1 && offset == 0) {
			// Single number case
			arr[offset] = A[offsetNum];
			print(arr, offset);
			System.out.println();
			return;
		} else if (offsetNum != 0 && offsetNum == A.length - 1) {
			arr[offset] = A[offsetNum];
			print(arr, offset);
			System.out.println();
			return;
		}

		arr[offset] = A[offsetNum];
		for (int j = 0; j < tokens.length; j++) {
			int nextOffset = 1;
			if (tokens[j] != ',') {
				arr[offset + 1] = tokens[j];
				nextOffset = 2;
			}
			generate(A, offsetNum + 1, tokens, arr, offset + nextOffset);
		}
	}
}
