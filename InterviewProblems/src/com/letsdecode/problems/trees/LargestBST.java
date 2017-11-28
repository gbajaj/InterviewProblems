package com.letsdecode.problems.trees;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class LargestBST {
	TreeNode root;
	int maxCount = 0;
	TreeNode retRoot;
	public LargestBST (TreeNode node) {
		root = node;
	}
	class SubtreeResult {
		public int min = Integer.MIN_VALUE;
		public int max = Integer.MAX_VALUE;
		int count = 0;

		public SubtreeResult() {

		}

		public SubtreeResult(int min, int max, int count) {
			this.min = min;
			this.max = max;
			this.count += count;
		}
	}

	public void call() {
		findLargetsSubTree(root);
		System.out.println(maxCount + " " + (retRoot != null ? retRoot.val
				: "No Result Found"));
	}

	private SubtreeResult findLargetsSubTree(TreeNode node) {
		if (node == null) {
			return null;
		}
		SubtreeResult result = null;
		SubtreeResult leftResult;
		SubtreeResult rightResult;
		if (node.left == null && node.right == null) {
			result = new SubtreeResult(node.val, node.val, 1);
		} else if (node.left != null && node.right != null) {
			rightResult = findLargetsSubTree(node.right);
			leftResult = findLargetsSubTree(node.left);
			if (rightResult == null || leftResult == null)
				return null;
			//Both the chidren nodes are present
			if (node.val < rightResult.min && node.val > leftResult.max) {
				result = new SubtreeResult(leftResult.min, rightResult.max,
						rightResult.count + leftResult.count + 1);
			}
		} else if (node.right != null) {
			rightResult = findLargetsSubTree(node.right);

			if (rightResult == null || node.val >= rightResult.min) {
				return null;
			}

			result = new SubtreeResult(node.val, rightResult.max,
					rightResult.count + 1);
		} else if (node.left != null) {
			leftResult = findLargetsSubTree(node.left);
			if (leftResult == null || node.val <= leftResult.max) {
				return null;
			}

			result = new SubtreeResult(leftResult.min, node.val,
					leftResult.count + 1);
		}
		if (result != null) {
			if (result.count + 1 > maxCount) {
				maxCount = result.count;
				retRoot = node;
			}

		}

		return result;
	}
}
