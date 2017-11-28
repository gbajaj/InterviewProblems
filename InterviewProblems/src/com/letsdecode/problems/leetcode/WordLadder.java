package com.letsdecode.problems.leetcode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

import javax.security.auth.Subject;


public class WordLadder {
	class Word {
		String word;
		int distance;

		public Word(String s, int i) {
			word = s;
			distance = i;
		}
	}

	public int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {
		LinkedList<Word> list = new LinkedList<>();
		if (beginWord == null || beginWord.isEmpty())
			return 0;
		if (beginWord == endWord)
			return 0;
		if (beginWord.equals(endWord))
			return 0;
		list.add(new Word(beginWord, 1));
		HashSet<String> visited = new HashSet<>();
		visited.add(beginWord);
		while (list.isEmpty() == false) {
			Word front = list.removeFirst();
			String cur = front.word;
			int dis = front.distance;
			for (int i = 0; i < cur.length(); i++) {
				for (int j = 0; j < 26; j++) {
					String adj = cur.substring(0,  i)
							+ (char)('a' + j) + cur.substring(i+1);
					if (adj.equals(endWord)) {
						return dis + 1;
					}
					if (wordList.contains(adj) == false) {
						continue;
					}
					if (visited.contains(adj) == false) {
						visited.add(adj);
						list.add(new Word(adj, dis + 1));
					}
				}
			}
		}
		return 0;
	}
	
	Comparator<Integer>  c1  = new Comparator<Integer>() {
        public int compare(Integer a, Integer b) {
            return a - b;
        }
    };
	Comparator<Integer>  c2  = new Comparator<Integer>() {
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    };
 
    PriorityQueue<Integer> max = null;
//    public MedianFinder() {
    PriorityQueue<Integer> min =  new PriorityQueue<Integer>(10, c1);
//    }

}
