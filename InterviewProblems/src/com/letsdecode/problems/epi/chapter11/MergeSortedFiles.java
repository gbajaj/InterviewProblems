package com.letsdecode.problems.epi.chapter11;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeSortedFiles {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	PriorityQueue<ListNode> q = new PriorityQueue<>(10,
			new Comparator<ListNode>() {
				@Override
				public int compare(ListNode o1, ListNode o2) {
					if (o1.val < o2.val) {
						return -1;
					} else if (o1.val > o2.val) {
						return 1;
					}
					return 0;
				}
			});

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode res = new ListNode(0);

		for (ListNode l : lists) {
			if (l != null) {
				q.add(l);
			}
		}
		ListNode cur = res;
		while (q.isEmpty() == false) {
			ListNode min = q.poll();
			cur.next = min;
			cur = cur.next;
			if (min.next != null) {
				q.add(min.next);
			}
		}
		return res.next;
	}
}
