package ListAndQueues;

import static org.junit.Assert.*;

import java.awt.print.Printable;

import junit.framework.Assert;

import org.junit.Test;

import ListAndQueues.LinkedList.Node;

public class LinkedListTest {

	@Test
	public void test() {
		LinkedList l = new LinkedList();
		int a[] = { 1, 2, 3, 4, 5, 6 };
		l.head = l.create(a);
		l.print(l.head);

		l.head = l.reverse(l.head);
		l.print(l.head);
	}

	@Test
	public void zipTest() {
		LinkedList l = new LinkedList();
		int a[] = { 1, 2, 3, 4, 5, 6 };
		l.head = l.create(a);
		l.print(l.head);
		l.zip(l.head);
		l.print(l.head);

	}

	@Test
	public void mergeSortedList() {
		LinkedList l1 = new LinkedList();
		int a[] = { 1, 4, 6, 8, 9 };
		l1.head = l1.create(a);

		LinkedList l2 = new LinkedList();
		int b[] = { 2, 3, 7, 10 };
		l2.head = l2.create(b);

		LinkedList res = new LinkedList();
		res.head = res.mergeSortedList(l1.head, l2.head);
		res.print(res.head);

	}
	@Test
	public void middle() {
		int a[] = { 5, 1, 21, 3, 45, 15};
		LinkedList l1 = new LinkedList();
		l1.head = l1.create(a);
		System.out.println(l1.middle(l1.head).val);
	}

	@Test
	public void mergeSort() {
		LinkedList l1 = new LinkedList();
		int a[] = { 50, 60, 30, 23, 1, 3, 4, 2, 5 };
		l1.head = l1.create(a);

		l1.head = l1.mergeSort(l1.head);
		l1.print(l1.head);

	}
	
	@Test
	public void reverseListByGroup() {
		LinkedList l1 = new LinkedList();
		int a[] = { 50, 60, 30, 23, 1, 3, 4, 2, 5 };
		l1.head = l1.create(a);

		l1.head = l1.reverListByGroups(l1.head, 3);
		l1.print(l1.head);

	}
	
	@Test
	public void reverseFindMedianInCircular() {
		LinkedList l1 = new LinkedList();
		int a[] = { 50, 60,70, 80, 90};
//		int a[] = { 50, 60, 30, 23, 1, 3, 4, 2, 5 };
		l1.head = l1.create(a);
		Node head = l1.head;
		while (head.next != null) {
			head = head.next;
		}
		if (head != null) {
			head.next = l1.head;
		}

		int val  = l1.reverseFindMedianInCircular(l1.head);
		System.out.println(val);
//		l1.print(l1.head);

	}
	
	@Test
	public void countNodes() {
		LinkedList l1 = new LinkedList();
		int a[] = { 50, 60,70, 80, 90};
		l1.head = l1.create(a);
		
		Assert.assertEquals(l1.countNodes(l1.head), 5);

	}
	
	@Test
	public void reachNthNodeAfter() {
		LinkedList l1 = new LinkedList();
		int a[] = { 50, 60,70, 80, 90};
		l1.head = l1.create(a);
		
		System.out.println(l1.skipNNodes(l1.head, 2).val);

	}

	@Test
	public void evenOddMerge() {
		LinkedList l1 = new LinkedList();
		int a[] = { 50, 60,70, 80, 90};
		l1.head = l1.create(a);
		
		l1.head = l1.evenOddMerge(l1.head);
		l1.print(l1.head);
	}
	
	@Test
	public void subtract() {
		LinkedList l1 = new LinkedList();
		int a[] = { 50, 60,70, 80};
		l1.head = l1.create(a);
		l1.subtract(l1.head);
		l1.print(l1.head);
	}
}
