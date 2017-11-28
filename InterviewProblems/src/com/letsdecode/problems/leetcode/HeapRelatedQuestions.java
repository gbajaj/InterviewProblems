package com.letsdecode.problems.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class HeapRelatedQuestions {
	class Pair {
		final int key;
		final int count;

		public Pair(int key, int count) {
			this.key = key;
			this.count = count;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + key;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (key != other.key)
				return false;
			return true;
		}

		private HeapRelatedQuestions getOuterType() {
			return HeapRelatedQuestions.this;
		}

	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		ArrayList<Integer> res = new ArrayList<>();
		HashMap<Integer, Pair> map = new HashMap<>();
		PriorityQueue<Pair> q = new PriorityQueue<>(k, new Comparator<Pair>() {
			public int compare(Pair o1, Pair o2) {
				return o1.count - o2.count;
			};
		});

		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			Pair p = map.get(nums[i]);
			if (p == null) {
				p = new Pair(nums[i], 1);
			} else {
				p = new Pair(nums[i], p.count + 1);
			}
			map.put(nums[i], p);
			if (set.contains(p.key)) {
				q.remove(new Pair(p.key, 0));
				q.add(p);
				set.add(p.key);
			} else {
				if (q.isEmpty() || q.size() < k) {
					q.add(p);
					set.add(p.key);
				} else {
					Pair peek = q.peek();
					if (peek.count < p.count) {
						q.remove(peek);
						set.remove(peek.key);
						q.add(p);
						set.add(p.key);
					}
				}
			}
		}
		while (q.isEmpty() == false) {
			res.add(q.poll().key);
		}
		int i = 0;
		int j = res.size() - 1;
		while (i < j) {
			int temp = res.get(i);
			res.set(i, res.get(j));
			res.set(j, temp);
			i++;
			j--;
		}

		return res;
	}
}
