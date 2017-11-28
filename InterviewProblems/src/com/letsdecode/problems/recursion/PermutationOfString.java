package com.letsdecode.problems.recursion;

public class PermutationOfString {
	char[] a;

	public PermutationOfString(String in) {
		this.a = in.toCharArray();
	}

	public void call() {
		permute(a, 0);
	}

	private void permute(char[] a, int index) {
		if (index >= a.length) {
			System.out.println(a);
			return;
		}
		for (int i = index; i < a.length; i++) {
			swap(a, index, i);
			permute(a, index + 1);
			swap(a, index, i);
		}
	}

	private void swap(char[] a, int i, int j) {
		char c = a[i];
		a[i] = a[j];
		a[j] = c;
	}
}
