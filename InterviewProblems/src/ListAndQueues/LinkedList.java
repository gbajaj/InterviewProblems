package ListAndQueues;

import org.junit.Test;

public class LinkedList {
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

	public Node middle(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public Node mid(Node head) {
		Node slow = head;
		Node fast = head;
		Node pre = slow;
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
			pre = slow;
			slow = slow.next;
		}
		return pre;
	}

	public Node mergeSortedList(Node h1, Node h2) {
		if (h1 == null)
			return h2;
		else if (h2 == null)
			return h1;

		Node temp = new Node(0);
		Node cur = temp;

		while (h1 != null && h2 != null) {
			if (h1.val < h2.val) {
				cur.next = h1;
				h1 = h1.next;
			} else {
				cur.next = h2;
				h2 = h2.next;
			}
			cur = cur.next;
		}

		while (h1 != null) {
			cur.next = h1;
			h1 = h1.next;
			cur = cur.next;
		}
		while (h2 != null) {
			cur.next = h2;
			h2 = h2.next;
			cur = cur.next;
		}
		return temp.next;
	}

	public Node mergeSort(Node head) {
		if (head == null || head.next == null)
			return head;
		Node mid = mid(head);
		Node second = mid.next;
		mid.next = null;
		Node first = mergeSort(head);
		second = mergeSort(second);
		return mergeSortedList(first, second);
	}

	public Node reverse(Node head) {
		Node p = null, q = null, r = head;
		while (r != null) {
			q = r;
			r = r.next;
			q.next = p;
			p = q;
		}
		return q;
	}

	public void zip(Node head) {

		if (head == null)
			return;

		Node slow = head;
		Node fast = head;
		Node prev = null;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}

		if (prev != null) {
			Node secondHalf = prev.next;
			prev.next = null;
			Node halfHead = reverse(secondHalf);
			Node cur = head.next;
			while (cur != null && halfHead != null) {
				head.next = halfHead;
				Node pre = halfHead;
				halfHead = halfHead.next;
				pre.next = cur;
				head = cur;
				cur = cur.next;
			}
			head.next = halfHead;
		}

	}

	public Node reverListByGroups(Node head, int n) {
		return reverListByCount(head, n);
	}

	public Node reverListByCount(Node head, int n) {
		Node p = null, q = null, r = head;
		int count = 0;
		while (r != null && count < n) {
			q = r;
			r = r.next;
			q.next = p;
			p = q;
			count++;
		}
		if (r != null) {
			head.next = reverListByCount(r, n);
		}
		return q;
	}

	public int reverseFindMedianInCircular(Node head) {
		int ret = -1;
		Node fast = head;
		Node slow = head;
		if (head == null)
			return -1;
		if (head == head.next) {
			return head.val;
		}

		fast = head.next;
		int count = 2;
		while (fast.next != head) {
			count++;
			slow = slow.next;
			fast = fast.next;
			if (fast.next == head) {
				break;
			}
			count++;
			fast = fast.next;

		}
		if (count % 2 == 0) {
			ret = (slow.val + slow.next.val) / 2;
		} else {
			ret = slow.val;
		}
		return ret;
	}

	public int countNodes(Node node) {
		if (node == null)
			return 0;
		int count = 1;
		while (node.next != null) {
			count++;
			node = node.next;
		}
		return count;
	}

	// public Node reachNNodesAfter (Node node, int n) {
	// if (n <= 0) return node;
	//
	// while(n > 0) {
	// n--;
	// if (node == null) break;
	//
	// node = node.next;
	// }
	// if (n == 0) return node;
	//
	// throw new IllegalStateException("List is not big enough");
	// }

	public Node skipNNodes(Node node, int n) {
		if (n <= 0)
			return node;
		int i = 0;
		while (i < n) {
			i++;
			if (node == null)
				break;

			node = node.next;
		}
		if (i == n)
			return node;

		throw new IllegalStateException("List is not big enough");
	}

	public Node getIntersectionNode(Node headA, Node headB) {
		if (headA == null || headB == null)
			return null;
		Node last1 = headA;
		Node last2 = headB;

		int count1 = 1;
		while (last1.next != null) {
			count1++;
			last1 = last1.next;
		}

		int count2 = 1;
		while (last2.next != null) {
			count2++;
			last2 = last2.next;
		}
		if (last1 != last2) {
			return null;
		}

		Node head1 = headA; // bigger list
		Node head2 = headB;
		int diff = count1 - count2;
		if (count2 > count1) {
			head1 = headB; // bigger list
			head2 = headA;
			diff = count2 - count1;
		}
		int i = 0;
		while (i < diff) {
			i++;
			head1 = head1.next;
		}

		while (head1 != head2) {
			head1 = head1.next;
			head2 = head2.next;
		}
		return head1;
	}

	public Node evenOddMerge(Node head) {
		if (head == null)
			return head;
		Node evenHead = new Node();
		Node oddHead = new Node();
		Node even = evenHead;
		Node odd = oddHead;
		while (head != null) {
			even.next = head;
			head = head.next;
			even = even.next;
			if (head != null) {
				odd.next = head;
				head = head.next;
				odd = odd.next;
			}
		}
		even.next = oddHead.next;
		odd.next = null;
		return evenHead.next;
	}

	public Node subtract(Node a) {
		if (a == null)
			return null;
		if (a.next == null)
			return a;
		if (a.next.next == null) {
			a.val = a.next.val - a.val;
			return a;
		}
		Node slow = a;
		Node fast = a;
		Node pre = null;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			pre = slow;
			slow = slow.next;
		}
		Node sec = pre.next;
		pre.next = null;
		sec = reverse(sec);
		Node cur = a;
		Node secHead = sec;
		while (cur != null) {
			cur.val = secHead.val - cur.val;
			cur = cur.next;
			secHead = secHead.next;
		}
		sec = reverse(sec);
		pre.next = sec;
		return a;
	}

}
