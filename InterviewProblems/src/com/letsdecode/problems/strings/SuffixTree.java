package com.letsdecode.problems.strings;

public class SuffixTree {
	public void printSubstrins(String input) {
		input += "$";
		for (int i = 0; i <= input.length() - 1; i++) {
			System.out.println(input.substring(i, input.length()));
		}
	}

}
