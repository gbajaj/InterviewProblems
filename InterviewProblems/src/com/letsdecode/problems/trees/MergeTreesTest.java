package com.letsdecode.problems.trees;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MergeTreesTest {

	@Test
	public void test() {
//		int a[] = { 2, 4, 6};
//		int b[] = { 66, 77, 99};
		int a[] = { 2, 4, 6, 9, 10, 22 };
		int b[] = { 66, 77, 99, 100, 109, 200 };

		BalancedBST bst = new BalancedBST(a);
		bst.call();
		TreeNode one = bst.root;
		bst = new BalancedBST(b);

		bst.call();
		TreeNode two = bst.root;

		MergeTrees res = new MergeTrees(one, two);
		res.call();
		TreeNode node = res.getResult();
		LevelTraversal levelTraversal = new LevelTraversal(node);
		levelTraversal.call();
		
//		ArrayList<TreeNode> print = new ArrayList<>();
//		res.getTree(node, print);
//		printTree(print);
	}

	private void printTree(ArrayList<TreeNode> print) {
		for (TreeNode t : print) {
			System.out.print(t.val + " ");
		}
		System.out.println("");
	}
}
