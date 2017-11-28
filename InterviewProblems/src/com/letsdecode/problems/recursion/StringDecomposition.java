package com.letsdecode.problems.recursion;

import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import sun.security.x509.IssuingDistributionPointExtension;

public class StringDecomposition {
	char[] string;
	ArrayList<String> list = new ArrayList<>();

	public StringDecomposition(String s) {

		this.string = s.toCharArray();
	}

	public void call() {
		decompose(string, list);
	}

	public void callBottomUP() {

	}

	private void decompose(char[] a, ArrayList<String> result) {
//		decompose(a, 0, a.length, l, "");
		String strInput = "abracadabra";
        decompose(strInput.toCharArray(), 0,  strInput.length(), result,
			 "");
        String[] arr = new String[result.size()];
       result.toArray(arr);
		return;
	}

	private void decompose(char[] a, int s, int end, ArrayList<String> l,
			String node) {
		int offset = 0;
		String result = "";
		if (s == end) {
			l.add(node);
		}

		for (int i = s; i < end; i++) {
			if (isPalindrome(a, s, s + offset)) {
				int len = (s + offset + 1) - s;
				String palin = new String(a, s, len);
				decompose(a, s + offset + 1, end, l, node + palin + "|");
			}
			offset++;
		}
	}

	private boolean isPalindrome(char[] a, int i, int j) {
		if (j - i == 0)
			return true;
		while (i <= j) {
			if (a[i] != a[j])
				return false;
			i++;
			j--;
		}
		return true;
	}

	public ArrayList<String> getResult() {
		return list;
	}
}
