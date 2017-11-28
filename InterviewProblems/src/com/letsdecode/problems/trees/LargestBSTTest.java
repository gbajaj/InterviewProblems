package com.letsdecode.problems.trees;

import static org.junit.Assert.*;

import org.junit.Test;

public class LargestBSTTest {

	@Test
	public void test() {
		int a[] = { 12, 14, 16, 15, 16, 17, 18, 1, 2, 3, 4, 5, 6, 7, 8, 9, 20};
//		int a[] = { 20,35, 50};
		BalancedBST bst = new BalancedBST(a);
		bst.call();
		LargestBST lBst = new LargestBST(bst.root);
		lBst.call();
	}

}
