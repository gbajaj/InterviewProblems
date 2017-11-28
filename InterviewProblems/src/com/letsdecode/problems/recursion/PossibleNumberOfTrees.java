package com.letsdecode.problems.recursion;

/**
 * https://www.quora.com/Given-n-how-many-structurally-unique-BSTs-binary-search
 * -trees-that-store-values-1-to-n-are-there The number of binary search trees
 * visualized as
 * 
 * Number of binary search trees = (Number of ways root can be choosen)* (Number
 * of Left binary search sub-trees) * (Number of Right binary search sub-trees)
 * Now, since there are "n" nodes in BST and let, the number of BST be
 * represented by C(n) for n elements.
 * 
 * We can find the number of BSTs recursively as : choose 1 as root, no element
 * on the left sub-tree. n-1 elements on the right sub-tree. Choose 2 as root, 1
 * element on the left sub-tree. n-2 elements on the right sub-tree. Choose 3 as
 * root, 2 element on the left sub-tree. n-3 elements on the right sub-tree.
 * 
 * Similarly, for i-th element as the root, i-1 elements on the left and n-i on
 * the right.
 * 
 * These sub-trees are also BSTs so we can write :
 * 
 * C(n) = C(0)C(n-1) + C(1)C(n-2) + .....+ C(i-1)C(n-i)..... + C(n-1)C(0)
 * 
 * C(0) = 1, as there is exactly 1 way to make a BST with 0 nodes. C(1) = 1, as
 * there is exactly 1 way to make a BST with 1 node.
 * 
 * C(n)=∑i=1nC(i−1)C(n−i)
 **/

public class PossibleNumberOfTrees {
	public int res;
	public int n;

	public PossibleNumberOfTrees(int n) {
		this.n = n;
	}

	public void call() {
		res = countTrees(n);
	}

	private int countTrees(int iNodeCount) {
		int res = 0;
		if (iNodeCount <= 1) {
			return 1;
		}
		for (int i = 0; i < iNodeCount; i++) {
			res += countTrees(i) * countTrees(iNodeCount - i - 1);
		}

		return res;
	}
}
