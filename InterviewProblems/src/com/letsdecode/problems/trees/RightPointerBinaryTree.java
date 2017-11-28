package com.letsdecode.problems.trees;

import com.letsdecode.problems.Problem;

public class RightPointerBinaryTree extends Problem<RightPointerTreeNode> {
	RightPointerTreeNode root;

	public RightPointerBinaryTree() {
	}

	public RightPointerBinaryTree(RightPointerTreeNode root) {
		this.root = root;
	}

	public void call() {
		buildRightPointingNodes(this.root);
		result = root;
	}

	public void printNodesByLevel(RightPointerTreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println("");
		RightPointerTreeNode first = null;
		for (RightPointerTreeNode p = root; p != null; p = p.next) {
			System.out.print(p.val + " ");
			if (first == null) {
				if (p.left != null) {
					first = p.left;
				} else if (p.right != null) {
					first = p.right;
				}
			}
		}
		printNodesByLevel(first);
	}

	public void buildRightPointingNodes(final RightPointerTreeNode root) {
		if (root == null) {
			return;
		}
		RightPointerTreeNode first = null;
		RightPointerTreeNode prev = null;
		for (RightPointerTreeNode p = root; p != null; p = p.next) {
			if (p.left != null) {
				if (first == null) {
					first = p.left;
				}
				if (prev != null) {
					prev.next = p.left;
				}
				prev = p.left;
			}
			if (p.right != null) {
				if (first == null) {
					first = p.right;
				}
				if (prev != null) {
					prev.next = p.right;
				}
				prev = p.right;
			}
		}

		buildRightPointingNodes(first);
	}

	public RightPointerTreeNode buildTree(int[] a, int i, int j) {
		RightPointerTreeNode n = null;
		if (i <= j) {
			int mid = i + (j - i) / 2;
			RightPointerTreeNode tr = new RightPointerTreeNode(a[mid]);
			tr.left = buildTree(a, i, mid - 1);
			tr.right = buildTree(a, mid + 1, j);
			n = tr;
		}
		return n;
	}

	public void printInOrder(RightPointerTreeNode t) {
		if (t == null) {
			return;
		}
		printInOrder(t.left);
		System.out.print(t.val + " ");
		printInOrder(t.right);
	}

	public void connectSiblings(RightPointerTreeNode root) {
		_connectSiblings(root.left, root);
	}
	/**
	 * Much clearer version of buildRightPointingNodes
	 * 
	 * @param node
	 * @param p
	 */
	private void _connectSiblings(RightPointerTreeNode node,
			RightPointerTreeNode p) {
		if (node == null) {
			return;
		}
		RightPointerTreeNode head = null;
		RightPointerTreeNode tail = null;
		while (p != null) {
			RightPointerTreeNode list = getSiblingsList(p);
			if (head == null) {
				head = list;
			}
			if (tail == null) {
				tail = getTail(list);
			} else {
				tail = append(tail, list);
			}
			p = p.next;
		}
		if (head != null) {
			_connectSiblings(head.left, head);
		}

	}

	/**
	 * Utility method of fetching the tail from a list of nodes.
	 * 
	 * @param node
	 *            point the tail of the list
	 * @return
	 */
	private RightPointerTreeNode getTail(RightPointerTreeNode node) {
		RightPointerTreeNode tail = null;
		if (node != null) {
			while (node.next != null) {
				node = node.next;
			}
			tail = node;
		}
		return tail;
	}

	/**
	 * Appends new list to the tail and return the new tail returns the same
	 * tail if list is null;
	 * 
	 * @param tail
	 *            tail to append new list to
	 * @param head
	 *            pointing to the list
	 * @return new or same tail
	 */
	private RightPointerTreeNode append(RightPointerTreeNode tail,
			RightPointerTreeNode head) {
		if (head == null)
			return tail;
		tail.next = head;
		while (head.next != null) {
			head = head.next;
		}
		return head;
	}

	/**
	 * connects siblings are returns the list of them
	 * @param p
	 * @return
	 */
	private RightPointerTreeNode getSiblingsList(RightPointerTreeNode p) {
		if (p.left != null) {
			p.left.next = p.right;
			return p.left;
		}
		return p.right;
	}
}
