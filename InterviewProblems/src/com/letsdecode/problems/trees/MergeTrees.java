package com.letsdecode.problems.trees;

import java.util.ArrayList;

import com.letsdecode.problems.Problem;

public class MergeTrees extends Problem<TreeNode> {
	TreeNode t1;
	TreeNode t2;

	public MergeTrees(TreeNode t1, TreeNode t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	public void call() {
		ArrayList<TreeNode> one = new ArrayList<>();
		ArrayList<TreeNode> two = new ArrayList<>();
		getTree(t1, one);
		getTree(t2, two);
		ArrayList<TreeNode> res = merge(one, two);
		TreeNode t = buildTree(res, 0, res.size() - 1);
		result = t;
	}

	private TreeNode buildTree(ArrayList<TreeNode> res, int i, int j) {
		TreeNode n = null;
		if (i <= j) {
			int mid = i + (j - i) / 2;
			TreeNode tr = res.get(mid);
			tr.left = buildTree(res, i, mid - 1);
			tr.right = buildTree(res, mid + 1, j);
			n = tr;
		}
		return n;
	}

	private ArrayList<TreeNode> merge(ArrayList<TreeNode> one,
			ArrayList<TreeNode> two) {
		ArrayList<TreeNode> res = new ArrayList<>(one.size() + two.size());
		int i = 0;
		int j = 0;
		while (i < one.size() && j < two.size()) {
			TreeNode l = one.get(i);
			TreeNode r = two.get(j);
			if (l.val < r.val) {
				res.add(l);
				i++;
			} else {
				res.add(r);
				j++;
			}
		}

		while (i < one.size()) {
			TreeNode l = one.get(i);
			res.add(l);
			i++;
		}
		while (j < two.size()) {
			TreeNode r = two.get(j);
			res.add(r);
			j++;
		}
		return res;
	}

	public void getTree(TreeNode root, ArrayList<TreeNode> out) {
		if (root == null) {
			return;
		}
		getTree(root.left, out);
		out.add(root);
		getTree(root.right, out);
		root.left = null;
		root.right = null;
	}

	public TreeNode getResult() {
		return result;
	}
}
