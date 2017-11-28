package com.letsdecode.problems.epi.chapter8;

import javax.swing.JEditorPane;

import com.letsdecode.problems.epi.chapter8.LinkedListProblems.Node;

public class LinkedListProblems {
	public Node head;

	class Node {
		int val;
		public Node next;

		public Node() {
		}

		public Node(int val) {
			this.val = val;
		}
	}

	public Node create(int a[]) {
		Node temp = new Node(0);
		Node cur = temp;
		for (int i = 0; i < a.length; i++) {
			cur.next = new Node(a[i]);
			cur = cur.next;
		}
		return temp.next;
	}

	public void print(Node head) {
		System.out.println();
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	public Node mergeSortedList(Node head1, Node head2) {
		Node result = new Node();
		if (head1 == null) {
			result.next = head2;
		} else if (head2 == null) {
			result.next = head1;
		}
		Node cur = result;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				cur.next = head1;
				head1 = head1.next;
			} else if (head1.val > head2.val) {
				cur.next = head2;
				head2 = head2.next;
			} else {
				cur.next = head1;
				cur = cur.next;
				head1 = head1.next;
				cur.next = head2;
				head2 = head2.next;
			}
			cur = cur.next;
		}
		while (head1 != null) {
			cur.next = head1;
			head1 = head1.next;
			cur = cur.next;
		}
		while (head2 != null) {
			cur.next = head2;
			head2 = head2.next;
			cur = cur.next;
		}
		return result.next;
	}
	
	 public Node reverseKGroup(Node head, int k) {
	        if (k < 2) return head;
	        Node dummy = new Node(0);
	        dummy.next = head;
	        Node pre = dummy;
	        Node next = null;
	        Node last;
	        Node cur = dummy.next;
	        while (cur != null) {
	            int i = 0;
	            Node newFront = cur;
	            Node p = null;
	            Node q = null;
	            Node r = cur;
	            while (i < k && r != null) {
	                q = r;
	                r = r.next;
	                q.next = p;
	                p = q;
	                i++;
	            }
	            pre.next = q;
	            pre = cur;
	            cur.next = r;
	            cur = r;
	            System.out.println(pre.val);
	        }
	        return dummy.next;
	    }
}
