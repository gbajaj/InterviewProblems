package com.letsdecode.problems.strings.reverseIndex;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class Trie {
	Character c;
	boolean isTerminal = false;
	TreeMap<Character, Trie> children = new TreeMap<>();
	ArrayList<Integer> positions = new ArrayList<>();

	public Trie() {
	}

	public Trie(Character c) {
		this.c = c;
	}

	private Trie getNode(Trie root, String word) {
		Trie current = root;
		if (word.isEmpty())
			return root;

		for (int i = 0; i < word.length(); i++) {
			Character c = word.charAt(i);
			Trie next = current.children.get(c);
			if (next == null) {
				next = new Trie(c);
				current.children.put(c, next);
			}
			current = next;
			if (i == word.length() - 1) {
				current.isTerminal = true;
			}
		}
		return current;
	}

	private Trie search(Trie root, String word) {
		if (word.isEmpty())
			return root;
		Trie current = root;
		for (int i = 0; i < word.length(); i++) {
			Character c = word.charAt(i);
			current = current.children.get(c);
			if (current == null) {
				return null;
			}
		}
		return current;
	}

	public Trie serch(String word) {
		return search(this, word);
	}

	public Trie getNode(String word) {
		return getNode(this, word);
	}

	public void print(Trie root, String prefix) {
		if (prefix == null) {
			prefix = "";
		}

		Set<Character> keys = root.children.keySet();

		if (root.isTerminal) {
			System.out.println(prefix + printPositions(root.positions));
			prefix = " " + prefix;
		}
		for (Character key : keys) {
			Trie t = root.children.get(key);
			print(t, prefix + t.c);
		}

	}

	String printPositions(ArrayList<Integer> poss) {
		String str = "[";
		for (int i = 0; i < poss.size(); i++) {
			str += poss.get(i);
			if (i != poss.size() - 1) {
				str += ", ";
			}
		}
		str += "]";

		return str;
	}

}
