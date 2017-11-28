package com.letsdecode.problems.recursion;

public class DiameterOfTree {
	/**
	 * @author gauravb
	 *
	 */
	public static class TreeNode {
		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		public int value = 0;
		private TreeNode left;
		private TreeNode right;
		private int distance;

		public TreeNode(int value, int distance) {
			this.value = value;
			this.distance = distance;
		}
	}

	public TreeNode root;
	private int res;

	public int getRes() {
		return res;
	}

	public DiameterOfTree(TreeNode n) {
		this.root = n;
	}

	public class Result {
		public final int cost;
		public final int distance;

		public Result(int cost, int distance) {
			this.cost = cost;
			this.distance = distance;
		}
	}

	int maxSoFar;

	public void call() {
		int height = getFarthestNode(this.root);
		res = maxSoFar;
		System.out.println(height);
	}

	private int getFarthestNode(TreeNode n) {
		if (n == null) {
			return 0;
		}

		int left = getFarthestNode(n.left);
		int right = getFarthestNode(n.right);

		maxSoFar = Math.max(left+ right, maxSoFar);

		return Math.max(left, right) + n.distance;
	}
}
