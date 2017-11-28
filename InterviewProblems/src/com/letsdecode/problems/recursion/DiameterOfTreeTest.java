package com.letsdecode.problems.recursion;

import org.junit.Assert;
import org.junit.Test;

import com.letsdecode.problems.recursion.DiameterOfTree.Result;

public class DiameterOfTreeTest {

	@Test
	public void test() {
		// struct node *root = newNode(1);
		// root->left = newNode(2);
		// root->right = newNode(3);
		// root->left->left = newNode(4);
		// root->left->right = newNode(5);
		DiameterOfTree.TreeNode root = create(1, 0);
		DiameterOfTree.TreeNode temp = null;
		root.setLeft(create(2, 1));
		root.setRight(create(3, 1));

		temp = root.getLeft();
		temp.setLeft(create(4, 1));

		temp = root.getLeft();
		temp.setRight(create(5, 1));
		DiameterOfTree diameterOfTree = new DiameterOfTree(root);
//		diameterOfTree.call();
//		Result result = diameterOfTree.getRes();
//		Assert.assertEquals(2, result.cost);
//		Assert.assertEquals(3, result.distance);

	}

	@Test
	public void test0() {
		DiameterOfTree.TreeNode root = create(1, 0);
		DiameterOfTree diameterOfTree = new DiameterOfTree(root);
		diameterOfTree.call();
		int result = diameterOfTree.getRes();
		Assert.assertEquals(0, result);

	}

	@Test
	public void test1LeafNodiameter() {
		DiameterOfTree.TreeNode root = create(1, 0);
		DiameterOfTree diameterOfTree = new DiameterOfTree(root);
		DiameterOfTree.TreeNode two =  create(2, 5);
		DiameterOfTree.TreeNode eight =  create(8, 8);
		DiameterOfTree.TreeNode seven =  create(7, 8);
		root.setLeft(two);
		two.setRight(eight);
		two.setLeft(seven);
		diameterOfTree.call();
		int result = diameterOfTree.getRes();
		Assert.assertEquals(0, result);

	}
	@Test
	public void testBigTree() {
		/**
		 *											1
		 * 										 /		\
		 * 										/		 \
		 * 									   /		  \
		 *									  2 		   3
		 *									/	\		 /   \
		 *								   /	 \     / 	  \
		 * 								 4		  5   6		  7
		 * 										   			 /  \
		 * 										  			/     \
		 * 												   /	   \
		 * 									              8		    9
		 * 									            /   \	   /  \
		 * 									          /	     \	  /	   \
		 * 											10       11	 12     13
		 * 								   			/		  \
		 * 								 		   /		   \
		 * 										14			   15
		 * 							   			/
		 * 							  		  16
		 * 									/
		 *								   /
		 *								  17
		 */
		
		DiameterOfTree.TreeNode one = create(1, 0);
		DiameterOfTree.TreeNode two =  create(2, 1);
		DiameterOfTree.TreeNode three = create(3, 1);
		DiameterOfTree.TreeNode four =  create(4, 1);
		DiameterOfTree.TreeNode five =  create(5, 1);
		DiameterOfTree.TreeNode six =  create(6, 1);
		DiameterOfTree.TreeNode seven =  create(7, 1);
		DiameterOfTree.TreeNode eight =  create(8, 1);
		DiameterOfTree.TreeNode nine =  create(9, 1);
		DiameterOfTree.TreeNode ten =  create(10, 1);
		DiameterOfTree.TreeNode eleven =  create(11, 1);
		DiameterOfTree.TreeNode tweleve =  create(12, 1);
		DiameterOfTree.TreeNode thirteen=  create(13, 1);
		DiameterOfTree.TreeNode fourTeen =  create(14, 1);
		DiameterOfTree.TreeNode fifTeen =  create(15, 1);
		DiameterOfTree.TreeNode sixTeen =  create(16, 1);
		DiameterOfTree.TreeNode sevenTeen =  create(17, 1);


		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		two.setRight(five);
		three.setLeft(six);
		three.setRight(seven);
	
		seven.setLeft(eight);
		seven.setRight(nine);
		nine.setLeft(tweleve);
		nine.setRight(thirteen);
		eight.setLeft(ten);
		eight.setRight(eleven);
		eleven.setRight(fifTeen);
		ten.setLeft(fourTeen);
		fourTeen.setLeft(sixTeen);
		sixTeen.setLeft(sevenTeen);
		DiameterOfTree diameterOfTree = new DiameterOfTree(one);
		diameterOfTree.call();
		int result = diameterOfTree.getRes();
		Assert.assertEquals(9, result);
//		Assert.assertEquals(7, result.distance);

	}
	
	private DiameterOfTree.TreeNode create(int value, int distance) {
		DiameterOfTree.TreeNode root = new DiameterOfTree.TreeNode(value, distance);
		return root;
	}
}
