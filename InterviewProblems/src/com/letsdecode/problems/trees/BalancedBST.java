package com.letsdecode.problems.trees;

import java.util.ArrayList;

import com.letsdecode.problems.Problem;

public class BalancedBST{
	
	int[] in;

	public BalancedBST(int[] a) {
		this.in = a;
	}

	public TreeNode root = null;

	public void call() {
		TreeNode t = buildTree(in, 0, in.length - 1);
		root = t;
	}

	private TreeNode buildTree(int[] a, int i, int j) {
		TreeNode n = null;
		if (i <= j) {
			int mid = i + (j - i) / 2;
			TreeNode tr = new TreeNode(a[mid]);
			tr.left = buildTree(a, i, mid - 1);
			tr.right = buildTree(a, mid + 1, j);
			n = tr;
		}
		return n;
	}


}
