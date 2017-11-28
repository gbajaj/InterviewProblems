package com.letsdecode.problems.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Arrays {
	public static boolean isEqual(char[] arr1, char[] arr2) {
		int i = 0, j = 0;
		for (; i < arr1.length && j < arr2.length; i++, j++) {
			if (arr1[i] != arr2[j]) {
				return false;
			}
		}
		if (i < arr1.length || j < arr2.length) {
			return false;
		}
		return true;
	}

	public static boolean isEqual(int[] arr1, int[] arr2) {
		int i = 0, j = 0;
		for (; i < arr1.length && j < arr2.length; i++, j++) {
			if (arr1[i] != arr2[j]) {
				return false;
			}
		}
		if (i < arr1.length || j < arr2.length) {
			return false;
		}
		return true;
	}

	public static int[] toArrays(List<Integer> list) {
		int[] res = new int[list.size()];
		Iterator<Integer> it = list.iterator();
		int i = 0;
		while (it.hasNext()) {
			res[i] = it.next();
			i++;

		}
		return res;
	}

	public static int[] toArray(String[] integers) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < integers.length; i++) {
			Integer a = Integer.parseInt(integers[i]);
			if (a != null) {
				list.add(a);
			}
		}
		return toArrays(list);
	}

}
