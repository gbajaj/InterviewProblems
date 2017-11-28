package com.letsdecode.problems.epi.chapter6;

import java.util.Vector;

public class Chapter6Problems {
	public void incrementBigIntergre(Vector<Integer> vec) {
		int carry = 1;
		int i = vec.size() - 1;
		for (; i >= 0; i--) {
			int val = vec.get(i);
			if (vec.get(i) + carry > 9) {
				vec.set(i, 9);
			} else {
				vec.set(i, val + 1);
				break;
			}
		}

		if (i == -1) {
			vec.add(0, 1);
		}
	}
}
