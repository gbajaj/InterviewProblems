package com.letsdecode.problems.epi.chapter14;

import java.util.ArrayList;
import java.util.List;

public class SortingProblems {
	public List<String> intersectionOfArrays(String[] a, String[] b) {
		ArrayList<String> res = new ArrayList<>();
		for (int i = 0, j = 0; i < a.length && j < b.length;) {
			if (a[i].compareTo(b[j]) < 0) {
				i++;
			} else if (b[j].compareTo(a[i]) > 0) {
				j++;
			} else if (a[i].compareTo(b[j]) == 0) {
				res.add(a[i]);
				i++;
				j++;
			}
		}
		return res;
	}

}
