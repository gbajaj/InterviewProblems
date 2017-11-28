package com.letsdecode.problems.strings;

import java.util.HashMap;

public class AddSearchWord {
	class Node {
        HashMap<Character, Node> set = new HashMap<Character, Node>();
        boolean endMarker = false;
    }
    Node root;
    /** Initialize your data structure here. */
    public AddSearchWord() {
        root = new Node();
        root.endMarker = true;
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.isEmpty()) return;
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            System.out.println("added "+ c);
            if (cur.set.containsKey(c)) {
                cur = cur.set.get(c);
            } else {
                Node temp = new Node();
                cur.set.put(c, temp);
                cur = temp;
            }
        }
        cur.endMarker = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null) {
            return true;
        }
        return search(word, root);
    }
    
    private boolean search(String word, Node n) {
        if (word.isEmpty() && n.endMarker) {
            return true;
        } else if (word.isEmpty()) {
        	return false;
        }
        Node cur = n;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (c == '.') {
                if (cur.set.isEmpty()) return false;
                boolean result = false;
                for (Character key: cur.set.keySet()) {
                    Node nextNode = cur.set.get(key);
                    result |= search(word.substring(i+1), nextNode);
                    if (result) {
                        return true;
                    }
                }
                return false;
            } else {
	            System.out.println("found " + c + " value " + cur.set.containsKey(c)); 
	            if (cur.set.containsKey(c) == false) {
	                return false;
	            }
	            cur = cur.set.get(c);
	            System.out.println("new cur");
            }
        }
        return cur.endMarker;
    }
}
