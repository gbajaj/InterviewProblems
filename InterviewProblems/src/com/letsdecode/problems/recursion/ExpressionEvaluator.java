package com.letsdecode.problems.recursion;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class ExpressionEvaluator {
	private char A[];
	private char[] tokens;
	private int target;
	private String res[];
	private ArrayList<String> list = new ArrayList<>();

	public String[] getResult() {
		return res;
	}

	public ExpressionEvaluator(final char A[], final char[] tokens, int target) {
		this.A = A;
		this.tokens = tokens;
		this.target = target;
	}

	public void call() {
		char[] arr = new char[A.length + tokens.length + 1];
		generate(A, 0, tokens, arr, 0);
		res = list.toArray(new String[list.size()]);
	}

	private void print(char[] arr, int lastIndex, ArrayList<String> list) {
		String str = "";
		for (int i = 0; i <= lastIndex; i++) {

			if (arr[i] == ',') {
				continue;
			}
			str += arr[i];
		}
		list.add(str + "=" + target);
	}

	private static int evaluate(char[] arr, int offset) {
		Deque<Integer> intermediateOperands = new LinkedList();
		intermediateOperands.addFirst(Integer.parseInt("" + arr[0]));
		// Evaluates '*' first.
		for (int i = 1; i <= offset; i += 2) {
			char oper = arr[i];
			if (oper == '*') {
				intermediateOperands.addFirst(intermediateOperands
						.removeFirst() * Integer.parseInt("" + arr[i + 1]));
			} else if (oper == ',') {
				intermediateOperands
						.addFirst(intermediateOperands.removeFirst() * 10
								+ Integer.parseInt("" + arr[i + 1]));
			} else {
				intermediateOperands
						.addFirst(Integer.parseInt("" + arr[i + 1]));
			}
		}

		// Evaluates '+' second.
		int sum = 0;
		while (!intermediateOperands.isEmpty()) {
			sum += intermediateOperands.removeFirst();
		}
		return sum;
	}

	private void generate(final char A[], int offsetNum, final char[] tokens,
			char arr[], int offset) {
		if (offsetNum == 0 && offsetNum == A.length - 1 && offset == 0) {
			// Single number case
			arr[offset] = A[offsetNum];
			if (evaluate(arr, offset) == target) {
				print(arr, offset, list);
			}
			return;
		} else if (offsetNum != 0 && offsetNum == A.length - 1) {
			arr[offset] = A[offsetNum];
			if (evaluate(arr, offset) == target) {
				print(arr, offset, list);
			}
			return;
		}

		arr[offset] = A[offsetNum];
		for (int j = 0; j < tokens.length; j++) {
			arr[offset + 1] = tokens[j];
			generate(A, offsetNum + 1, tokens, arr, offset + 2);
		}

	}
}
