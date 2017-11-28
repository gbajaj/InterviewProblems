package com.letsdecode.problems.trees;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class BSTTest {

	@Test
	public void test() {
		// int a [] = {8, 10, 12, 15, 16, 20, 25};
		int a[] = { 2, 1 };
		// BalancedBST bst = new BalancedBST(a);
		// bst.call();
		TreeNode root = getNode(10);
		root.left = getNode(5);
		root.right = getNode(15);
		root.right.left = getNode(6);
		root.right.right = getNode(20);
		boolean res = new BST().isBST(root);
		Assert.assertTrue(res);
	}

	TreeNode getNode(int n) {
		return new TreeNode(n);
	}

	@Test
	public void constructBST() {
		int a[] = { 1, 3, 4, 6, 8, 10, 15 };
		BalancedBST bst = new BalancedBST(a);
		bst.call();
		TreeProblems treeProblems = new TreeProblems(bst.root);
		ArrayList<Integer> list = new ArrayList<>();
		treeProblems.printPreOrder(treeProblems.root, list);
		int b[] = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			b[i] = list.get(i);
		}

		TreeNode tn = new BST().constructBSTFromPreoder(b);
		treeProblems = new TreeProblems(tn);
		treeProblems.printPreOrder(tn);
		//
		// Assert.assertTrue(res);

	}
}
