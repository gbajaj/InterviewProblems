package com.letsdecode.problems.trees;

import static org.junit.Assert.*;

import org.junit.Test;

public class BalancedBSTTest {

	@Test
	public void test() {
		
		int a [] = {8, 10, 12, 15, 16, 20, 25};
		BalancedBST bst = new BalancedBST(a);
		bst.call();
	}

}
