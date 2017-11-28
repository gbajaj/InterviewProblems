package com.letsdecode.problems.leetcode;

public class BitManipulation {
	public int reverseBits(int n) {
		int maskLeft = 0x80000000;
		int maskRight = 0x1;
		int shift = 31;
		for (int i = 0; i < 16; i++) {
			int temp = (n & maskRight) << shift;
			temp |= (n & maskLeft) >>> shift;
			n ^= ((n & maskRight) | (n & maskLeft));
			n |= temp;
			maskRight <<=1;
			maskLeft >>>=1;
			shift -= 2;
		}
		return n;
	}
}
