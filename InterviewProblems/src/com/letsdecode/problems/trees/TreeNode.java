package com.letsdecode.problems.trees;

import java.util.Stack;

public class TreeNode {
	public TreeNode(int val) {
		this.val = val;
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}

	int val;
	public TreeNode left;
	public TreeNode right;

	public Iterator Iterator() {
		return new Iterator(this);

	}

	static class Iterator {
		private TreeNode root;
		TreeNode c = null;
		private Stack<TreeNode> s = new Stack<>();

		public Iterator(TreeNode root) {
			this.root = root;
			c = root;
			while (c != null) {
				s.push(c);
				c = c.left;
			}
			if (s.isEmpty() == false) {
				c = s.pop();
			}
		}

		boolean hasNext() {
			if (c != null) {
				return true;
			}
			return false;
		}

		public TreeNode next() {
			TreeNode ret = c;
			c = c.right;
			if (s.isEmpty() == false || c != null) {
				while (c != null) {
					s.push(c);
					c = c.left;
				}
				c = s.pop();
			}
			return ret;
		}
	}
}
