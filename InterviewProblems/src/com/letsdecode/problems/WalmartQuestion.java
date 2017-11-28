package com.letsdecode.problems;

import java.util.Arrays;
import java.util.Collections;

public class WalmartQuestion {
	public int findSolutions(int[] a, int m) {
		Arrays.sort(a);
		int i = 0;
		int j = a.length - 1;
		while (i < j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}

		int totalCost = 0;
		int start = 0;
		int height = a[start];
		for (i = 1; i < m; i++) {
			totalCost += (height - a[i]);
		}
		start++;
		int diff = height - a[start];
		int finalCost = totalCost;
		for (i = m; i < a.length; i++) {
			totalCost -= diff * (m - 1);
			totalCost += a[start] - a[i];
			if (totalCost < finalCost) {
				finalCost = totalCost;
			}
			diff = a[start] - a[start+1];
			start++;
			 
		}
		return finalCost;
	}
}
