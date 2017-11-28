package ListAndQueues;

import java.util.Random;

//Java implementation of http://igoro.com/archive/skip-lists-are-fascinating/
public class SkipList {
	class Node {
		Node next[];
		int value;

		public Node(int value, int levels) {
			this.value = value;
			this.next = new Node[levels];
		}
	}

	private Random random = new Random();
	private static final int MAX_NUMBER_OF_LEVELS = 33;

	// This is head node with maximum numbers of levels allowed
	private Node head = new Node(0, MAX_NUMBER_OF_LEVELS);

	// maximum number of levels so far;
	private int levels = 1; // lets start wit 1;

	public void insert(int value) {
		// We have to do 2 things here
		// 1st: Decide how many levels this new node would have in order to
		// connect to connect
		// with the future node
		// 2nd: Connect current node with all the previous nodes

		// lets do the 1st: generate a random number and figure out how many
		// levels new node
		// would have
		int level = 0;// Eventually level has to be at least 1 for the new node
		int randNumber = random.nextInt();
		while ((randNumber & 0x1) == 1) {
			level++;
			if (level == levels) {
				levels++;
				break;// no need to go further as this is maximum level so far
			}
			randNumber >>= 1;// keep shifting to the right unless we encounter
								// the first zero
		}

		// For new node level has to be at least 1 as discussed above
		Node newNode = new Node(value, level + 1);
		Node cur = head;

		for (int i = levels - 1; i >= 0; i--) {
			// Find the closest node on level i
			while (cur.next[i] != null) {
				if (cur.next[i].value > value) {
					// found the right node for current level;
					// Lets break to check if this needs be connected with the
					// newNode
					break;
				}
				// go to the next level
				cur = cur.next[i];
			}
			// if the newNode has at least i levels then connect with the
			// previous node
			if (i <= level) {
				// previous's next is newNode's next
				newNode.next[i] = cur.next[i];
				// previous's next is newNode
				cur.next[i] = newNode;
			}
		}
	}

	public boolean contains(int value) {
		Node cur = head;
		for (int i = levels - 1; i >= 0; i--) {
			while (cur.next[i] != null) {
				if (cur.next[i].value > value) {
					// found the node with less then or equal to the value
					break;
				}
				if (cur.next[i].value == value) {
					return true;
				}
				cur = cur.next[i];
			}
		}
		return false;
	}

	public boolean remove(int value) {
		boolean found = false;
		Node cur = head;
		for (int i = levels - 1; i >= 0; i--) {
			while (cur.next[i] != null) {
				if (cur.next[i].value == value) {
					cur.next[i] = cur.next[i].next[i];
					// Break the inner loop
					break;
				}

				if (cur.next[i].value > value) {
					// next node has bigger value than we are looking for
					// lets go to the lower level
					break;
				}
				cur = cur.next[i];
			}
		}
		return found;
	}

	public void printValues() {
		Node cur = head.next[0];
		while (cur != null) {
			System.out.println(cur.value);
			cur = cur.next[0];
		}
	}
}
