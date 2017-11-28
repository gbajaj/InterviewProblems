package com.letsdecode.problems.trees;

import com.letsdecode.problems.trees.TreeThreeLink.TreeNode;

public class LockingBinaryTree {

	class LockableTreeNode {
		private LockableTreeNode parent;
		private LockableTreeNode left;
		private LockableTreeNode right;
		int value;
		boolean sl;
		boolean hl;
	}

	public boolean tryLock(LockableTreeNode n) {
		if (n == null)
			return false;
		if (n.hl || n.sl) {
			return false;
		}
		n.hl = true;
		softLock(n.parent);
		return true;
	}

	private void softLock(LockableTreeNode n) {
		if (n == null)
			return;
		while (n != null) {
			if (n.sl) {
				return;
			}
			n.sl = true;
			n = n.parent;
		}
	}

	private boolean tryUnLock(LockableTreeNode n) {
		if (n == null) {
			return false;
		}
		if (n.hl) {
			n.hl = false;
			softUnLock(n.parent);
			return true;
		}
		return !n.sl;
	}
	
	private void softUnLock(LockableTreeNode n) {
		if (n == null)
			return;
		while (n != null) {
			n.sl = false;
			n = n.parent;
		}
	}
}
