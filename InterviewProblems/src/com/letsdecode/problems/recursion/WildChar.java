package com.letsdecode.problems.recursion;

import java.util.ArrayList;

public class WildChar {
	private String input;
	private char wildChar;
	public ArrayList<String> res;

	public WildChar(String input, char wildChar) {
		this.input = input;
		this.wildChar = wildChar;
	}

	public void call() {
		res = wildChar(input);
		System.out.println(res);
	}

	public ArrayList<String> getResult() {
		return res;
	}

	private ArrayList<String> wildChar(String input) {
		ArrayList<String> list = new ArrayList<>();
		if (input == null || input.isEmpty()) {
			return list;
		}
		int i = input.indexOf(wildChar);
		if (i == -1) {
			// if there is not wild char then return the input as it is
			list.add(input);
			return list;
		}
		String prefix = input.substring(0, i);
		String one = prefix + "1";
		String two = prefix + "0";
		ArrayList<String> res = list;
		list.add(one);
		list.add(two);

		// check if wild char is the last one; if yes skip it
		if (i < input.length() - 1) {
			// Recurse for rest of the string after current wild char
			ArrayList<String> out = wildChar(input.substring(i + 1));
			if (out != null) {
				res = new ArrayList<>();
				for (int j = 0; j < list.size(); j++) {
					String temp = list.get(j);
					for (String post : out) {
						// Append the prefix with all the generated strings
						res.add(temp + post);
					}
				}
			}
		}

		return res;

	}
}
