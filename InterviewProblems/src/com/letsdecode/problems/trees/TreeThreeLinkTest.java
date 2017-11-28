package com.letsdecode.problems.trees;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.letsdecode.problems.trees.TreeThreeLink.TreeNode;

public class TreeThreeLinkTest {

	@Test
	public void test() {
		TreeThreeLink tree = new TreeThreeLink();
		int a[] = { 2, 5, 7, 9, 20, 56, 76, 23 };
		tree.createTree(a);
		ArrayList<TreeNode> list = new ArrayList<>();
		tree.traverseInorder(list, tree.root);
		tree.traverse(list);
		TreeNode t = tree.findLca(list.get(0), list.get(6));
		System.out.println("root" + tree.root.value);
		System.out.println(""+ t!=null?t.value: "null");

		t = tree.findLcaOrderH(null, null);
		System.out.println("root" + tree.root.value);
		System.out.println(""+ (t!=null?t.value: "null"));

//		TreeNode ll = tree.inorderSuccessor(list.get(5));
//		System.out.println("In order successor : "
//				+ ((ll != null) ? ll.value : "null"));
	}

	@Test
	public void preorderTraversal() {
		TreeThreeLink tree = new TreeThreeLink();
		int a[] = { 2, 5, 7, 9, 20, 56, 76, 23 };
		tree.createTree(a);
		tree.preOrderTraversal(tree.root);
		System.out.println();
	}

	@Test
	public void inorderTraversal() {
		TreeThreeLink tree = new TreeThreeLink();
		int a[] = { 2, 5, 7, 9, 20, 56, 76, 23 };
		tree.createTree(a);
		tree.inorderTraversal(tree.root);
		System.out.println();
	}

	@Test
	public void inorderTraversalO1() {
		TreeThreeLink tree = new TreeThreeLink();
		int a[] = { 2, 5, 7, 9, 20, 56, 76, 23 };
		tree.createTree(a);
		tree.inorderTraversalO1(tree.root);

	}
	@Test
	public void inorderTraversalO1Variation() {
		TreeThreeLink tree = new TreeThreeLink();
		int a[] = { 2, 5, 7, 9, 20, 56, 76, 23 };
		tree.createTree(a);
		tree.inorderTraversalO1Variation(tree.root);

	}

}
