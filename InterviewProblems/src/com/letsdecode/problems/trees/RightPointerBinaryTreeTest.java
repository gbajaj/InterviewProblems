package com.letsdecode.problems.trees;

import static org.junit.Assert.*;

import org.junit.Test;

public class RightPointerBinaryTreeTest {
	@Test
	public void buildTreeTest() {
		int b[] = { 4, 2, 5, 1, 6, 3, 7 };
		RightPointerBinaryTree tree = new RightPointerBinaryTree();
		RightPointerTreeNode root = tree.buildTree(b, 0, b.length - 1);
		tree.printInOrder(root);
	}

	@Test
	public void test() {
		int b[] = { 4, 2, 5, 1, 6, 3, 7 };
		RightPointerBinaryTree tree = new RightPointerBinaryTree();
		RightPointerTreeNode root = tree.buildTree(b, 0, b.length - 1);
		System.out.println("");
//		tree.printInOrder(root);
		tree.buildRightPointingNodes(root);
		tree.printNodesByLevel(root);
		System.out.println("");
	}
	
	
	@Test
	public void connectSiblings() {
		int b[] = { 4, 2, 5, 1, 6, 3, 7 };
		RightPointerBinaryTree tree = new RightPointerBinaryTree();
		RightPointerTreeNode root = tree.buildTree(b, 0, b.length - 1);
		tree.printInOrder(root);
		tree.connectSiblings(root);
		tree.printNodesByLevel(root);
	}

}
