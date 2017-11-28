package com.letsdecode.problems.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TreeThreeLink {
	TreeNode root;

	public static class TreeNode {
		protected TreeNode parent;
		private TreeNode left;
		private TreeNode right;
		int value;
		boolean visited;
	}

	public TreeNode createTree(int[] values) {
		root = build(values, 0, values.length - 1);
		return root;
	}

	public void inorderTraversalO1(TreeNode n) {
		if (n == null) {
			return;
		}
		// Don't break until a node and its right side has been visited
		while (n.visited == false && (n.right != null && n.right.visited)) {

			// If left not already visited; reach out to the left most node
			while (n.left != null && n.left.visited == false) {
				n = n.left;
			}

			// if this is non visited node; visit
			if (n.visited == false) {
				// When we come up from the right subtree we might encounter an
				// already

				n.visited = true;
				System.out.print(n.value + " ");
			}
			// if current node has a unvisited right node; goto right subtree;
			if (n.right != null && n.right.visited == false) {
				n = n.right;
			} else {
				// We know that current node is visited;
				// We also know that right node has already been visited;
				// time to go up
				if (n.parent != null) {
					n = n.parent;
				}
			}
		}
		System.out.println("");
	}

	public void preOrderTraversal(TreeNode n) {
		Stack<TreeNode> s = new Stack<>();
		while (n != null || s.isEmpty() == false) {
			if (n == null) {
				n = s.pop();
				n = n.right;
			} else {
				System.out.print(n.value + " ");
				s.push(n);
				n = n.left;
			}
		}
	}

	public void inorderTraversal(TreeNode n) {
		Stack<TreeNode> s = new Stack<>();
		while (n != null || s.isEmpty() == false) {
			if (n == null) {
				n = s.pop();
				System.out.print(n.value + " ");
				n = n.right;
			} else {
				s.push(n);
				n = n.left;
			}
		}
	}

	public void inorderTraversalO1Variation(TreeNode n) {
		if (n == null) {
			return;
		}
		// Don't break until a node and its right side has been visited
		while (n.visited == false) {

			// If left not already visited; reach out to the left most node
			while (n.left != null && n.left.visited == false) {
				n = n.left;
			}

			// if this is non visited node; visit
			if (n.visited == false) {
				// When we come up from the right subtree we might encounter an
				// already

				n.visited = true;
				System.out.print(n.value + " ");
			}
			// if current node has a unvisited right node; goto right subtree;
			if (n.right != null && n.right.visited == false) {
				n = n.right;
			} else {
				// Keep going up until we
				// 1) hit root node
				// 2) an unvisited node
				// 3) an unvisited right node
				while (n.parent != null
						|| (n.parent != null && n.right != null && n.right.visited)) {
					n = n.parent;
					if (n != null && n.visited == false) {
						break;
					}
				}
			}
		}
		System.out.println("");
	}

	public TreeNode inorderSuccessor(TreeNode root) {
		TreeNode retVal = null;
		if (root == null)
			return retVal;
		if (root.right != null) {
			root = root.right;
			while (root.left != null) {
				root = root.left;
			}
		} else {
			retVal = root.parent;
			while (retVal.left != root && retVal != null) {
				root = retVal;
				retVal = root.parent;

			}
		}
		return retVal;
	}

	private TreeNode build(int[] values, int i, int j) {
		if (i > j)
			return null;
		int mid = i + (j - i) / 2;
		TreeNode treeNode = new TreeNode();
		treeNode.value = values[mid];
		treeNode.left = build(values, i, mid - 1);
		treeNode.right = build(values, mid + 1, j);
		if (treeNode.left != null) {
			treeNode.left.parent = treeNode;
		}
		if (treeNode.right != null) {
			treeNode.right.parent = treeNode;
		}
		return treeNode;
	}

	public void traverseInorder(ArrayList<TreeNode> list, TreeNode root) {
		if (root == null) {
			return;
		}
		traverseInorder(list, root.left);
		list.add(root);
		traverseInorder(list, root.right);
	}

	public void traverse(ArrayList<TreeNode> list) {

		for (TreeNode n : list) {
			System.out.print(n.value + " ");
		}
		System.out.println();
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public TreeNode findLcaOrderH(TreeNode a, TreeNode b) {
		if (a == null && b == null) {
			return null;
		}
		if (a == null || b == null) {
			return a != null ? a : b;
		}
		if (a == b) {
			return a;
		}
		int depthOf_a = depth(a);
		int depthOf_b = depth(b);
		if (depthOf_a > depthOf_b) {
			int diff = depthOf_a - depthOf_b;
			while (diff > 0) {
				diff--;
				a = a.parent;
			}
		} else if (depthOf_b > depthOf_a) {
			int diff = depthOf_b - depthOf_a;
			while (diff > 0) {
				b = b.parent;
				diff--;
			}
		}
		while (a != null && b != null && a != b) {
			a = a.parent;
			b = b.parent;
		}
		if (a == b) {
			return a;
		}
		return null;
	}

	private int depth(TreeNode a) {
		int c = -1;
		while (a != null) {
			c++;
			a = a.parent;
		}
		return c;
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public TreeNode findLca(TreeNode a, TreeNode b) {
		if (a == null && b == null) {
			return null;
		}
		if (a == null || b == null) {
			return a != null ? a : b;
		}
		if (a == b) {
			return a;
		}
		Set<TreeNode> set = new HashSet<>();
		set.add(a);
		set.add(b);
		while (a != null || b != null) {
			if (a != null) {
				a = a.parent;
				if (a != null) {
					if (set.contains(a)) {
						return a;
					}
					set.add(a);
				}
			}
			if (b != null) {
				b = b.parent;
				if (b != null) {
					if (set.contains(b)) {
						return b;
					}
					set.add(b);
				}
			}
		}

		return null;
	}
}
