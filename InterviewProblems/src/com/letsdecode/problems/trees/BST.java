package com.letsdecode.problems.trees;

import com.letsdecode.problems.Problem;

public class BST extends Problem<Boolean> {
	public boolean isBST(TreeNode t) {
		if (t == null) {
			return true;
		}
		boolean circuit = true;
		if (t.left != null) {
			if (t.left.val > t.val)
				return false;
			circuit = isBST(t.left);
		}
		if (circuit && t.right != null) {
			if (t.right.val < t.val)
				return false;

			circuit = isBST(t.right);
		}
		return circuit;
	}

	public TreeNode constructBSTFromPreoder(int pre[]) {
		return _constructBSTFromPreoder(pre, 0, pre.length - 1);
	}

	private TreeNode _constructBSTFromPreoder(int pre[], int s, int e) {
		if (e < s) {
			return null;
		}
		TreeNode n = new TreeNode(pre[s]);
		int i = s+1;
		while (i <= e && pre[i] < pre[s]) {
			i++;
		}
		n.left = _constructBSTFromPreoder(pre, s+1, i-1);
		n.right = _constructBSTFromPreoder(pre, i, e);
		return n;
	}
}
