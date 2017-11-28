package com.letsdecode.problems.epi.chapter8;

import static org.junit.Assert.*;

import org.junit.Test;

import ListAndQueues.LinkedList;

public class LinkedListProblemsTest {

	@Test
	public void test() {
		LinkedListProblems l1 = new LinkedListProblems();
		int a[] = { 1, 4, 6, 8, 9 };
		l1.head = l1.create(a);

		LinkedListProblems l2 = new LinkedListProblems();
		int b[] = { 2, 3, 7, 10 };
		l2.head = l2.create(b);

		LinkedListProblems res = new LinkedListProblems();
//		res.head = res.mergeSortedList(l1.head, null);
		res.head = res.mergeSortedList(l1.head, l2.head);
		res.print(res.head);
		
	}
	
	@Test
	public void reverseInKgroups() {
		LinkedListProblems l1 = new LinkedListProblems();
		int a[] = { 1, 4, 6, 8, 9 };
		l1.head = l1.create(a);
		l1.head = l1.reverseKGroup(l1.head, 3);
		l1.print(l1.head);
		
	}

}
