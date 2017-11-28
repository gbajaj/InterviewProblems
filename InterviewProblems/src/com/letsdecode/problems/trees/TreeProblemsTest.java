package com.letsdecode.problems.trees;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import com.letsdecode.interviewbit.BinarySearch;

public class TreeProblemsTest {

	@Test
	public void printAllPaths() {
		int a[] = { 2, 4, 6, 9, 10, 22 };
		int b[] = { 4, 2, 5, 1, 6, 3, 7 };

		BalancedBST bst = new BalancedBST(b);
		bst.call();
		new TreeProblems(bst.root).printPaths();
	}

	@Test
	public void cloneTree() {
		int b[] = { 4, 2, 5, 1, 6, 3, 7 };
		BalancedBST bst = new BalancedBST(b);
		bst.call();
		TreeProblems t = new TreeProblems(bst.root);
		TreeNode newTree = t.cloneTree(bst.root);
		t.printInOrder(newTree);

	}

	@Test
	public void flipTree() {
		int b[] = { 7, 3, 3, 6, 8, 4, 1 };
		BalancedBST bst = new BalancedBST(b);
		bst.call();
		TreeProblems t = new TreeProblems(bst.root);
		LevelTraversal levelTraversal = new LevelTraversal(bst.root);
		levelTraversal.call();
		t.flipTree(bst.root);
		levelTraversal = new LevelTraversal(bst.root);
		levelTraversal.call();

	}

	@Test
	public void treeToList() {
		// int b[] = { 1, 2, 3};
		int b[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		BalancedBST bst = new BalancedBST(b);
		bst.call();
		TreeProblems t = new TreeProblems(bst.root);
		// TreeNode p = t.treeToListOptimized(bst.root);
		TreeNode p = t.treeToList(bst.root);
		TreeNode end = p.left;
		while (true) {
			System.out.print(p.val + " ");
			if (p == end)
				break;
			p = p.right;

		}
	}

	@Test
	public void construcg() {
		int[] in = { 10, 30, 40, 50, 60, 70, 90 };
		int[] pre = { 50, 30, 10, 40, 70, 60, 90 };
		TreeProblems t = new TreeProblems(null);
		TreeNode res = t.buildTree(in, pre, 0, in.length - 1);
		// TreeNode res = t.rebuildTree(pre, in, 0, in.length-1 );
		new LevelTraversal(res).call();
		// System.out.print(" ");
	}

	@Test
	public void testLeastCommonAncestorWithBothKeysPresent() {
		int[] a = { 10, 30, 40, 50, 60, 70, 90, 100, 120, 130, 140 };
		BalancedBST bst = new BalancedBST(a);
		bst.call();
		TreeProblems t = new TreeProblems(null);
		TreeNode res = t.leastCommonAncestorWithBothKeysPresent(bst.root, 30,
				600);
		if (res != null) {
			System.out.println(" LCA is " + res.val);
		} else {
			System.out.println("LCA is NOT PRESENT");
		}

		new LevelTraversal(bst.root).call();
		// System.out.print(" ");
	}

	@Test
	public void isBstTest() {
		// int b[] = { 2147483647};
		// int b[] = { 1,1};
		int[] b = { 10, 30, 40, 50, 60, 70, 90, 100, 120, 130, 140 };
		BalancedBST bst = new BalancedBST(b);
		bst.call();
		TreeProblems t = new TreeProblems(null);
		boolean res = t.isBST(bst.root);
		System.out.println(res);

	}

	@Test
	public void univalSubTreesTest() {
		int[] b = { 5, 5, 5, 5, 5, 5 };
		int[] count = { 0 };
		BalancedBST bst = new BalancedBST(b);
		bst.call();
		TreeProblems t = new TreeProblems(null);
		boolean res = t.univalSubTrees(bst.root, count);
		Assert.assertEquals(count[0], 6);
		Assert.assertTrue(res);
		int[] c = { 5, 1, 5, 5, 5, 5 };
		bst = new BalancedBST(c);
		bst.call();
		t = new TreeProblems(null);
		count[0] = 0;
		res = t.univalSubTrees(bst.root, count);
		Assert.assertFalse(res);
		Assert.assertEquals(count[0], 4);
	}

	@Test
	public void inorderIterativeTest() {
		int[] b = { 1, 2, 3, 4, 5, 6, 7, 8 };

		BalancedBST bst = new BalancedBST(b);
		bst.call();
		TreeProblems t = new TreeProblems(null);
		t.inorderIterative(bst.root);

	}

	@Test
	public void inorderIterator() {
		// int[] b = { 1, 2, 3, 4, 5, 6, 7, 8 };
		// int[] b = { 2, 7, 5, 6, 11, 2, 5, 4, 9 };
		int[] b = { 4, 2, 5, 1, 6, 3, 7 };
		BalancedBST bst = new BalancedBST(b);
		bst.call();
		TreeProblems t = new TreeProblems(null);
		TreeNode.Iterator it = bst.root.Iterator();
		while (it.hasNext()) {
			TreeNode temp = it.next();

			System.out.print(" " + temp.val);
		}
	}

	@Test
	public void postorderIterativeTest() {
		// int[] b = { 1, 2, 3, 4};
		// int[] b = { 2, 7, 5, 6, 11, 2, 5, 4, 9 };
//		int[] b = { 4, 2, 5, 1, 6, 3, 7 };
		int[] b = { 1, 2};

		BalancedBST bst = new BalancedBST(b);
		bst.call();
		TreeProblems t = new TreeProblems(null);
		t.postorderIterative(bst.root);

	}

	@Test
	public void boundryTraversal() {
		int[] b = { 4, 2, 5, 1, 6, 3, 7 };
		int out[] = { 1, 2, 4, 5, 6, 7, 3 };
		ArrayList<Integer> expected = new ArrayList<>();
		for (Integer o : out) {
			expected.add(o);
		}
		BalancedBST bst = new BalancedBST(b);
		bst.call();
		TreeProblems t = new TreeProblems(null);
		ArrayList<TreeNode> list = t.boundryTraversal(bst.root);
		ArrayList<Integer> outList = new ArrayList<>();

		Iterator<TreeNode> it = list.iterator();
		while (it.hasNext()) {
			outList.add(it.next().val);
		}
		Assert.assertEquals(expected, outList);
	}

	@Test
	public void findAllPathsTest() {
		int[] b = { 2, 3, -2, 2, 5, 4, -2, 3 };
		int[] a = new int[b.length];

		BalancedBST bst = new BalancedBST(b);
		bst.call();

		TreeProblems t = new TreeProblems(null);
		t.findAllPaths(bst.root, 5, -1, -1, a);

	}

	@Test
	public void findPathsTest() {
		int[] b = { 2, 3, -2, 2, 5, 4, -2, 3 };
		int[] a = new int[b.length];

		BalancedBST bst = new BalancedBST(b);
		bst.call();

		TreeProblems t = new TreeProblems(null);
		t.findPaths(bst.root, 2, 0, -1, a);
	}

	@Test
	public void findBinaySum() {
		int[] b = { 0, 1, 0, 1, 1, 0, 1, 1 };

		BalancedBST bst = new BalancedBST(b);
		bst.call();

		TreeProblems t = new TreeProblems(null);
		int[] result = new int[2];
		t.findBinaySum(bst.root, result);
		System.out.println(result[0]);

	}

	@Test
	public void findRootToLeafSumTest() {
		int[] b = { 2, 3, -2, 2, 5, 4, -2, 4 };

		BalancedBST bst = new BalancedBST(b);
		bst.call();

		TreeProblems t = new TreeProblems(null);
		Assert.assertTrue(t.findRootToLeafSum(bst.root, 7));
		Assert.assertTrue(t.findRootToLeafSum(bst.root, 3));
		Assert.assertTrue(t.findRootToLeafSum(bst.root, 11));
		Assert.assertTrue(t.findRootToLeafSum(bst.root, 8));
		Assert.assertFalse(t.findRootToLeafSum(bst.root, 55));

	}

	@Test
	public void findKthNodeInOrderTest() {
		int[] b = { 2, 3, -2, 2, 5, 4, -2, 4 };

		BalancedBST bst = new BalancedBST(b);
		bst.call();

		TreeProblems t = new TreeProblems(null);
		int a[] = { 9 };
		TreeNode node = t.findKthNode(bst.root, a);
		System.out.println(node.val);
	}

	@Test
	public void myPostOrder() {
		int[] b = { 4, 2, 5, 1, 6, 3, 7 };
		BalancedBST bst = new BalancedBST(b);
		bst.call();

		TreeProblems t = new TreeProblems(null);
		t.myPostOrder(bst.root);

	}

	@Test
	public void buildTreeFromInAndPre() {
		int[] in = { 4, 2, 5};
		int[] pre = { 2, 4, 5 };

		TreeProblems t = new TreeProblems(null);
		TreeNode n = t.buildTreeFromInAndPre(in, pre, 0, in.length - 1);
		System.out.println(n.val);

	}

	@Test
	public void buildTreee() {
		int[] in = { 2, 1};
		int[] post = { 2, 1};

		TreeProblems t = new TreeProblems(null);
		TreeNode n = t.buildTreee(in, post, 0, in.length - 1);
		System.out.println(n.val);

	}
	
	@Test
	public void buildTreeFromPreorderMarkers() {
		int[] pre = {2, 1, -1, -1, 3};

		TreeProblems t = new TreeProblems(null);
		TreeNode n = t.buildTreeFromPreorderMarkers(pre, new int[1]);
		System.out.println(n.val);

	}
	@Test
	public void buildLeetCodeTree() {
//		int[] list = {5,4,8,11,-1,13,4,7,2,-1,-1,5,1};
		int[] list = {1,-2,-3,1,3,-2,Integer.MIN_VALUE,-1};
				
				
		TreeProblems t = new TreeProblems(null);
		TreeNode n = t.buildLeetCodeTree(list);
		System.out.println(t.pathSum(n, 0));
	
	}
	
	
}
