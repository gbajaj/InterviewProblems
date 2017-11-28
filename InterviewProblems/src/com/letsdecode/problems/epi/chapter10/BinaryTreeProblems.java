package com.letsdecode.problems.epi.chapter10;

import com.letsdecode.problems.trees.TreeNode;

public class BinaryTreeProblems {
	public boolean isBalanced(TreeNode t) {
		if (_isBalanced(t) == -1) {
			return false;
		}
		return true;

	}

	private int _isBalanced(TreeNode t) {
		if (t == null) {
			return 0;
		}
		int heightLeft = _isBalanced(t.left);
		if (heightLeft == -1) {
			return -1;
		}
		int heightRight = _isBalanced(t.right);
		if (heightRight == -1) {
			return -1;
		}
		if (Math.abs(heightLeft - heightRight) > 1) {
			return -1;
		}
		return 1 + Math.max(heightLeft, heightRight);
	}
}