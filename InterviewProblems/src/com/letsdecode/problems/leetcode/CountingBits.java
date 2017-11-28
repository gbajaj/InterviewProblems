package com.letsdecode.problems.leetcode;

public class CountingBits {
	  int a[] = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 
			  1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5};
	    public int[] countBits(int num) {
	        int res[] = new int[num+1]; 
	        for (int i = 0; i<=num; i++) {
	            res[i]=getCount (i);
	        }
	        return res;
	    }

	    private int getCount(int c) {
	    	return getCount16(c) + getCount16(c >>> 16);
	    }
	    private int getCount16(int c) {
	    	return getCount8(c) + getCount8(c >>>8);
	    }
	    private int getCount8(int c) {
	        return a[(byte)c & 0x00000000000000F]
	        + a[(byte)c >> 4 & 0x00000000000000F];
	    }

	    
}
