package com.letsdecode.problems.graph.misc;

import java.util.HashSet;
import java.util.LinkedList;

public class TransformOneStringToAnother {
	class Pair {
		public Pair(String x, int y) {
			first = x;
			second = y;
		}

		String first;
		int second;
	}

	String source;
	String target;
	HashSet<String> dic;

	public TransformOneStringToAnother(String source, String target,
			HashSet<String> dic) {
		this.source = source;
		this.target = target;
		this.dic = dic;
	}

	/*
	 * Algo 2: From source, change each character at a time and compare with T
	 * Remember steps
	 */
	HashSet<String> seen = new HashSet<>();
	int productionSequence() {
		// ArrayList<String> sequence = new ArrayList<>();
		LinkedList<Pair> q = new LinkedList<>();
		q.push(new Pair(source, 0));
		int level = 0;
		while (q.isEmpty() == false) {
			Pair f = q.removeFirst();
			if (f.first.equals(target)) {
				return f.second;
			}
			String str = f.first;
			seen.add(str);
			level++;
			for (int i = 0; i < str.length(); i++) {
				for (int j = 0; j < 26; j++) {
					String pre = str.substring(0, i);
					String mid = "" + (char) ('a' + j);
					String suffix = str.substring(i + 1, str.length());
					String t = pre + mid + suffix;
					if (dic.contains(t) && seen.contains(t) == false) {
						q.push(new Pair(t, level));
					}
				}
			}
		}
		return -1;
	}
	/*
	 * Algo 1: Sort entire dictionary (O(n log n)) Create a undirected graph
	 * from the dic ( O(n)) Traverse form start to goal
	 */

}
