package com.letsdecode.problems.trees;

import java.util.ArrayList;
import java.util.Stack;

public class TreeProblems {
	public TreeNode root;

	public TreeProblems(TreeNode root) {
		this.root = root;
	}

	public TreeNode cloneTree(TreeNode t) {
		if (t == null) {
			return null;
		}
		TreeNode n = new TreeNode(t.val);
		n.left = cloneTree(t.left);
		n.right = cloneTree(t.right);
		return n;
	}

	public void flipTree(TreeNode t) {
		if (t == null) {
			return;
		}
		flipTree(t.left);
		flipTree(t.right);

		TreeNode temp = t.left;
		t.left = t.right;
		t.right = temp;

	}

	// //=++++++++++++++UTIL FUNCTIONS++++++++++++++++++
	public void printInOrder(TreeNode t) {
		if (t == null) {
			return;
		}
		printInOrder(t.left);
		System.out.print(t.val + " ");
		printInOrder(t.right);
	}

	// //=++++++++++++++UTIL FUNCTIONS++++++++++++++++++
	public void printPreOrder(TreeNode t, ArrayList<Integer> a) {
		if (t == null) {
			return;
		}
		a.add(t.val);
		printPreOrder(t.left, a);
		printPreOrder(t.right, a);
	}

	public void printPreOrder(TreeNode t) {
		if (t == null) {
			return;
		}
		System.out.print(t.val + " ");
		printPreOrder(t.left);
		printPreOrder(t.right);
	}

	public void printPaths() {
		printAllPathsRecursive(this.root, new ArrayList<Integer>());
	}

	public void printAllPathsRecursive(TreeNode root, ArrayList<Integer> list) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		printAllPathsRecursive(root.left, list);
		printAllPathsRecursive(root.right, list);
		if (root.left == null && root.right == null) {
			print(list);
		}
		list.remove(list.size() - 1);
	}

	private void print(ArrayList<Integer> list) {
		for (Integer a : list) {
			System.out.print(a + " ");
		}
		System.out.println("");
	}

	// public TreeNode treeToListOptimized(TreeNode root) {
	// TreeNode temp = new TreeNode(0);
	// temp.left = root;
	//
	// TreeNode head = treeToListOptimized(root, null, temp);
	// head.left = temp.left;
	// temp
	// }
	public TreeNode treeToListOptimized(TreeNode root, TreeNode prev,
			TreeNode tail) {
		TreeNode ret = root;
		TreeNode right = null;
		if (root.right != null) {
			right = root.right;
			if (tail != null) {
				tail.left = right;
			}
		}
		if (root.left != null) {
			TreeNode left = treeToListOptimized(root.left, root, null);
			left.right = root;
			root.right = prev;
			if (prev != null) {
				prev.left = root;
			}
			left.left = null;
			ret = left;
		}
		if (right != null) {
			TreeNode successor = treeToListOptimized(right, root, tail);
			if (prev != null) {
				root.left = prev;
				prev.right = root;
			}

			root.right = successor;
			successor.left = root;

		}
		return ret;
	}

	public TreeNode treeToList(TreeNode root) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			root.left = root;
			root.right = root;
			return root;
		} else if (root.left != null && root.right != null) {
			TreeNode leftSideLeftCorner = treeToList(root.left);
			TreeNode leftSideRightCorner = leftSideLeftCorner.left;

			TreeNode rightSideLeftCorner = treeToList(root.right);
			TreeNode rightSideRightCorner = rightSideLeftCorner.left;

			leftSideRightCorner.right = root;
			root.left = leftSideRightCorner;

			rightSideLeftCorner.left = root;
			root.right = rightSideLeftCorner;

			leftSideLeftCorner.left = rightSideRightCorner;
			rightSideRightCorner.right = leftSideLeftCorner;

			return leftSideLeftCorner;
		} else if (root.left != null) {
			TreeNode leftCorner = treeToList(root.left);
			TreeNode rightCorner = leftCorner.left;
			root.right = leftCorner;
			root.left = rightCorner;
			rightCorner.left = root;
			leftCorner.left = root;
			return leftCorner;
		} else {
			TreeNode leftCorner = treeToList(root.right);
			TreeNode rightCorner = leftCorner.left;

			root.left = rightCorner;
			root.right = leftCorner;
			leftCorner.left = root;

			rightCorner.right = root;
			return root;
		}
	}

	int pick = 0;

	public TreeNode buildTree(int[] inorder, int[] preorder, int start, int end) {

		if (start > end)
			return null;
		// if (pick >preorder.length-1) return null;
		TreeNode node = new TreeNode(preorder[pick]);
		pick++;

		if (start == end)
			return node;
		int index = findIndex(start, end, inorder, node.val);
		node.left = buildTree(inorder, preorder, start, index - 1);
		node.right = buildTree(inorder, preorder, index + 1, end);
		return node;
	}

	int findIndex(int s, int e, int[] inorder, int val) {
		for (int i = s; i <= e; i++) {
			int j = inorder[i];
			if (j == val) {
				return i;
			}
		}
		return -1;
	}

	int l = 0;

	public TreeNode rebuildTree(int[] pre, int[] in, int i, int j) {
		TreeNode ret = null;
		if (i > j) {
			return ret;
		}
		ret = new TreeNode(in[l]);
		l++;
		if (i == j)
			return ret;
		int mid = findInd(in, i, j, pre[l]);

		ret.left = rebuildTree(pre, in, i, mid - 1);
		ret.right = rebuildTree(pre, in, mid + 1, j);
		return ret;
	}

	int findInd(int[] in, int i, int j, int f) {
		for (int s = i; s <= j; s++) {
			if (in[s] == f) {
				return s;
			}
		}
		return -1;
	}

	/*
	 * Time complexity of the above solution is O(n) as the method does a simple
	 * tree traversal in bottom up fashion. Note that the above method assumes
	 * that keys are present in Binary Tree. If one key is present and other is
	 * absent, then it returns the present key as LCA (Ideally should have
	 * returned NULL).
	 */

	public TreeNode leastCommonAncestorWithBothKeysPresent(TreeNode root,
			int v1, int v2) {
		if (root == null) {
			return null;
		}

		if (root.val == v1 || root.val == v2) {
			return root;
		}
		TreeNode left = leastCommonAncestorWithBothKeysPresent(root.left, v1,
				v2);
		TreeNode right = leastCommonAncestorWithBothKeysPresent(root.right, v1,
				v2);

		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}

	public boolean isBST(TreeNode root) {

		return false;
	}

	public boolean isBST(TreeNode root, long min, long max) {
		if (root == null)
			return true;
		if (root.val > min && root.val < max) {

			// equals are supported
			return isBST(root.left, min, root.val)
					&& isBST(root.right, root.val, max);
		}
		return false;
	}

	public boolean univalSubTrees(TreeNode root, int[] count) {

		if (root == null) {
			return true;
		}

		boolean l = univalSubTrees(root.left, count);
		boolean r = univalSubTrees(root.right, count);
		if (l && r) {
			if (root.left == null && root.right == null) {
				// leaf// always unival
				count[0]++;
				return true;
			} else if (root.left != null && root.right != null) {
				// Both nodes present check if both matches the root;
				if (root.left.val == root.val && root.right.val == root.val) {
					count[0]++;
					return true;
				}
			} else if (root.left != null) {
				if (root.left.val == root.val) {
					count[0]++;
					return true;
				}
			} else if (root.right != null) {
				if (root.right.val == root.val) {
					count[0]++;
					return true;
				}
			}
		}

		return false;

	}

	/**
	 * Print all paths for the target sum
	 * 
	 */
	public void findPaths(TreeNode root, int target, int level, int startlevel,
			int[] a) {
		if (root == null) {
			return;
		}

		a[level] = root.val;
		if (target - root.val == 0) {
			for (int i = startlevel; i <= level; i++) {
				System.out.print(" " + a[i]);
			}
			System.out.println("");
		}
		findPaths(root.left, target - root.val, level + 1, startlevel, a);
		findPaths(root.right, target - root.val, level + 1, startlevel, a);
		a[level] = 0;
	}

	/**
	 * 
	 */
	public void findAllPaths(TreeNode root, int target, int level,
			int startLevel, int[] a) {
		if (root == null)
			return;
		findAllPaths(root.left, target, level + 1, startLevel + 1, a);
		findPaths(root, target, level + 1, startLevel + 1, a);
		findAllPaths(root.right, target, level + 1, startLevel + 1, a);
	}

	/**
	 * 
	 * @param root
	 */
	public void inorderIterative(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> s = new Stack<>();
		TreeNode c = root;
		while (s.isEmpty() == false || c != null) {
			if (c != null) {
				s.push(c);
				c = c.left;
			} else {
				c = s.pop();
				System.out.print(" " + c.val);
				c = c.right;
			}
		}
	}

	public void postorderIterative(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> s = new Stack<>();
		TreeNode c = root;
		TreeNode visited = null;
		// Set<TreeNode> set = new HashSet<>();

		while (s.isEmpty() == false || c != null) {

			if (c != null) {
				s.push(c);
				c = c.left;
			} else {
				c = s.pop();
				// if (set.contains(c)) {
				if (c.right == null || c.right == visited) {
					System.out.print(" " + c.val);
					visited = c;
					// set.remove(c);
					c = null;
				} else {
					s.push(c);
					// set.add(c);
					c = c.right;
				}
			}
		}

	}

	public ArrayList<TreeNode> boundryTraversal(TreeNode node) {
		ArrayList<TreeNode> list = new ArrayList<>();
		if (node != null) {
			list.add(node);
			leftBranch(node.left, true, list);
			rightBranch(node.right, true, list);
		}
		return list;
	}

	private void leftBranch(TreeNode node, boolean leftBranch,
			ArrayList<TreeNode> list) {
		if (node == null) {
			return;
		}

		if (leftBranch || node.isLeaf()) {
			list.add(node);
		}
		leftBranch(node.left, leftBranch, list);
		leftBranch(node.right, node.left == null ? true : false, list);
	}

	private void rightBranch(TreeNode node, boolean rightBranch,
			ArrayList<TreeNode> list) {
		if (node == null) {
			return;
		}

		leftBranch(node.left, node.right == null ? true : false, list);
		leftBranch(node.right, rightBranch, list);
		if (rightBranch || node.isLeaf()) {
			list.add(node);
		}
	}

	/**
	 * Find sum of all the paths from root-to-leaf where value of each node is a
	 * binary bit
	 * 
	 * @param n
	 * @param a
	 */
	public void findBinaySum(TreeNode n, int[] a) {
		if (n == null) {
			return;
		}
		int val = (n.val > 0 ? 0x1 : 0x0);
		a[1] = ((a[1] << 1) | val);
		if (n.left == null && n.right == null) {
			a[0] += a[1];
		} else {
			findBinaySum(n.left, a);
			findBinaySum(n.right, a);
		}
		a[1] >>= 1;
	}

	/*
	 * Find if root to leaf path as a unique sum
	 */
	public boolean findRootToLeafSum(TreeNode n, int sum) {
		if (n == null)
			return false;
		if (n.left == null && n.right == null) {
			if (n.val == sum) {
				return true;
			}
		}
		return findRootToLeafSum(n.left, sum - n.val)
				|| findRootToLeafSum(n.right, sum - n.val);
	}

	public void myPostOrder(TreeNode n) {
		if (n == null) {
			return;
		}
		Stack<TreeNode> s = new Stack<>();
		s.push(n);
		TreeNode lvn = null;
		while (s.isEmpty() == false) {
			if (n != null) {
				n = n.left;
				if (n != null) {
					s.push(n);
				}
			} else {
				TreeNode temp = s.peek();
				if (temp.right == null || temp.right == lvn) {
					System.out.print(temp.val + " ");
					lvn = temp;
					s.pop();
				} else {
					n = temp.right;
					s.push(n);
				}
			}
		}
	}

	public TreeNode findKthNode(TreeNode n, int a[]) {
		if (n == null)
			return null;
		TreeNode ret = findKthNode(n.left, a);
		a[0]--;
		if (a[0] == 0) {
			return n;
		}

		if (ret == null && a[0] > 0) {
			ret = findKthNode(n.right, a);
		}
		return ret;
	}

	int k = 0;

	public TreeNode buildTreeFromInAndPre(int[] in, int[] pre, int i, int j) {
		if (i > j) {
			return null;
		}
		int val = pre[k];
		k++;
		TreeNode n = new TreeNode(val);
		int l = find(in, i, j, val);
		n.left = buildTreeFromInAndPre(in, pre, i, l - 1);
		n.right = buildTreeFromInAndPre(in, pre, l + 1, j);
		return n;
	}

	int find(int[] in, int i, int j, int val) {
		int l = 0;
		for (; l <= j; l++) {
			if (in[l] == val) {
				break;
			}
		}
		return l;

	}

	int m = 1;

	public TreeNode buildTreee(int[] inorder, int[] postorder, int start,
			int end) {

		if (start > end)
			return null;

		TreeNode node = new TreeNode(postorder[m]);

		int index = find(inorder, start, end, node.val);
		if (index == -1) {
			return null;
		}
		m--;
		node.right = buildTreee(inorder, postorder, index + 1, end);
		node.left = buildTreee(inorder, postorder, start, index - 1);

		return node;
	}

	public TreeNode buildTreeFromPreorderMarkers(int[] preorder, int b[]) {
		int i = b[0];
		if (i >= preorder.length) {
			return null;
		}
		int val = preorder[i];
		b[0]++;
		TreeNode n = null;
		if (val != -1) {
			n = new TreeNode(val);
			n.left = buildTreeFromPreorderMarkers(preorder, b);
			n.right = buildTreeFromPreorderMarkers(preorder, b);
		}
		return n;

	}
	
	boolean isPowerOf2(int n) {
		if (n == 0) return false;
		return (n & n-1) == 0;
	}
	public TreeNode buildLeetCodeTree(int[] nodes) {
		if (nodes.length <= 0) {
			return null;
		}
				
		int c = (int) Math.log(nodes.length);
		c++;
		if (isPowerOf2(nodes.length) == false && nodes.length > 0) {
			c++;
		}
		TreeNode root = new TreeNode(nodes[0]);
		ArrayList<TreeNode> l = new ArrayList<>();
		l.add(root);
		System.out.println(root.val);
		int d = 1;
		for (int i = 1; i < c; i++) {
			ArrayList<TreeNode> o = new ArrayList<>();
			for (int j = 0; j < Math.pow(2, i-1); j++) {
				TreeNode temp = l.get(j);
				if (temp == null) continue;
				temp.left = (nodes[d] == Integer.MIN_VALUE)? null: new TreeNode(nodes[d]);
				System.out.print((temp.left == null? "null ": nodes[d]) +", ");
				o.add(temp.left);
				d++;
				if (d < nodes.length) {
					temp.right = (nodes[d] == Integer.MIN_VALUE)? null: new TreeNode(nodes[d]);
					System.out.print(temp.right == null? "null ": nodes[d] +", ");
					o.add(temp.right);
				}
				d++;
			}
			System.out.println("");
			l.clear();
			l = o;
		}
		return root;
	}
	
    public int pathSum(TreeNode root, int sum) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        return pathSum(root, sum, a, 0);
    }
    public int pathSum(TreeNode root, int sum, ArrayList<Integer> a, int rs) {
        if (root == null) {
            return 0 ;
        }
        int runningSum = root.val+rs;
        int ret = 0;
        if (sum == runningSum) {
            ret = 1;
        }
        a.add(root.val);
        int temp= runningSum;
        for (int i =0;i < a.size();i++) {
            temp -=a.get(i);
            if (temp == sum && sum != 0 ) {
                ret++;
            }
        }
        ret += pathSum(root.left, sum, a, runningSum) +
            pathSum(root.right, sum, a, runningSum) ;
        a.remove(a.size() - 1);
        return ret;
    }
}
