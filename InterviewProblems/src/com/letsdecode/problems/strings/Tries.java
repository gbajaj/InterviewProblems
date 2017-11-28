package com.letsdecode.problems.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.letsdecode.problems.trees.TreeNode;

public class Tries {
	TrieNode root;

	public Tries() {
		root = new TrieNode("");
		root.leaf = true;
	}

	class TrieNode {
		public TrieNode(String c) {
			this.c = c;
		}

		String c;
		HashMap<String, TrieNode> children = new HashMap<>();
		boolean leaf = false;
	}

	public void insert(String str) {
		HashMap<String, TrieNode> children = root.children;
		for (int i = 0; i < str.length(); i++) {
			TrieNode t = null;
			if (children.containsKey("" + str.charAt(i))) {
				t = children.get("" + str.charAt(i));
			} else {
				t = new TrieNode("" + str.charAt(i));
				children.put("" + str.charAt(i), t);
			}
			children = t.children;
			if (i == str.length() - 1) {
				t.leaf = true;
			}
		}
	}

	public boolean search(String word) {
		TrieNode node = searchNode(word);
		if (node != null && node.leaf) {
			return true;
		}
		return false;
	}

	public boolean startsWith(String word) {
		return searchNode(word) != null;// return true if found any prefix
	}

	public TrieNode searchNode(String str) {
		if (str.equals(root.c)) {
			return root;
		}
		HashMap<String, TrieNode> children = root.children;
		TrieNode t = null;
		for (int i = 0; i < str.length(); i++) {

			if (children.containsKey("" + str.charAt(i))) {
				t = children.get("" + str.charAt(i));
				children = t.children;
			} else {
				return null;
			}
		}
		return t;
	}

	public void printTries() {
		System.out.print(root.c);
		printTries(root);
	}

	public void printTries(TrieNode t) {
		HashMap<String, TrieNode> children = t.children;
		System.out.print(t.c);
		if (t.leaf) {
			System.out.println();
		}
		for (Entry<String, TrieNode> e : children.entrySet()) {
			printTries(e.getValue());
		}
	}
}
