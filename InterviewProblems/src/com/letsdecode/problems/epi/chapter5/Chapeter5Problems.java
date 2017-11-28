package com.letsdecode.problems.epi.chapter5;

public class Chapeter5Problems {

	public int computeParity(long n) {
		long x = n;
		x ^= x >> 32;
		x ^= x >> 16;
		x ^= x >> 8;
		x ^= x >> 4;
		x &= 0xf;// we only need last 4 bits
		int table = 0x6996 >> x;
		return table & 0x1;
	}

	/******************/

	public void duchNationFlagProblem(int a[], int pi) {
		if (pi >= a.length)
			throw new IllegalArgumentException();
		int smaller = 0;
		int equal = 0;
		int larger = a.length - 1;
		int pivot = a[pi];
		while (equal <= larger) {
			if (a[equal] < pivot) {
				swap(smaller, equal, a);
				smaller++;
				equal++;
			} else if (a[equal] == pivot) {
				equal++;
			} else {
				swap(equal, larger--, a);
			}
		}
	}

	void swap(int i, int j, int a[]) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/******************/

	public int computeTheMaxDifference(int a[]) {
		int capacity = 0;
		int minHeight = 0;
		int maxHeight = 0;
		for (int height : a) {
			capacity = Math.max(capacity, height - minHeight);
			minHeight = Math.min(minHeight, height);
		}
		return capacity;
	}

	/**********************/
	public double myPow(double x, int a) {
		boolean neg = false;
		long n = a;
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		double res = 1.0;
		while (n > 0) {
			long test = (n & 0x01);
			if (test > 0) {
				res *= x;
			}
			x *= x;
			n >>= 1;
		}
		return res;
	}

	public String convertBase(String s, int base1, int base2) {
		int decimal = getDecimal(s, base1);
		return decimalConversion(decimal, base2);
	}

	public String decimalConversion(int x, int base) {
		boolean isNeg = false;
		StringBuilder s = new StringBuilder();
		if (x < 0) {
			isNeg = true;
			x = -x;
		}

		do {
			int r = x % base;
			char t = (char) (r >= 10 ? 'A' + r - 10 : '0' + r);
			s.append(t);
			x /= base;
		} while (x > 0);
		if (isNeg)
			s.append('-');
		return s.reverse().toString();
	}

	public int getDecimal(String s, int base) {
		int res = 0;
		boolean isNeg = false;
		if (s.charAt(0) == '-') {
			isNeg = true;
		}
		int start = isNeg ? 1 : 0;
		for (int i = start; i < s.length(); i++) {
			res *= base;
			res += Character.isDigit(s.charAt(i)) ? s.charAt(i) - '0' : s
					.charAt(i) - 'A' + 10;
		}

		return res;
	}
}
