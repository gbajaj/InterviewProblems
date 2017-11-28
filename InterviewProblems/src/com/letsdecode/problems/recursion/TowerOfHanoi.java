package com.letsdecode.problems.recursion;

public class TowerOfHanoi {
	private int[] A;
	private int[] B;
	private int[] C;
	private int disks;

	public TowerOfHanoi(int[] A, int[] B, int[] C, int disks) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.disks = disks;
	}

	public void call() {
		TOH(disks - 1, A, B, C);
	}

	int[] getResult() {
		return B;
	}

	int i = 0;

	private void TOH(int disks, int[] source, int[] dest, int[] sparse) {
		if (disks < 0)
			return;
		TOH(disks - 1, source, sparse, dest);
		// move nth disk from source to dest, using
		dest[disks] = source[disks];
		TOH(disks - 1, sparse, dest, source);
	}
}
