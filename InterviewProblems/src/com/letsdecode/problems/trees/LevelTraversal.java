package com.letsdecode.problems.trees;

import java.util.ArrayList;

public class LevelTraversal {
	private TreeNode root;

	public LevelTraversal(TreeNode n) {
		this.root = n;
	}

	public void call() {
		traverse(root);
	}

	private void traverse(TreeNode n) {
		ArrayList<TreeNode> q = new ArrayList<>();
		q.add(n);
		q.add(null);
		while (q.isEmpty() == false) {
			TreeNode t = q.remove(0);
			if (t != null) {
				System.out.print(t.val + " ");
				addChildren(t, q);
			}
			if (t == null) {
				System.out.println("");
				if (q.isEmpty() == false)
					q.add(null);
			}
		}
	}

	private void addChildren(TreeNode node, ArrayList<TreeNode> q) {
		if (node.left != null) {
			q.add(node.left);
		}
		if (node.right != null) {
			q.add(node.right);
		}
	}

}
