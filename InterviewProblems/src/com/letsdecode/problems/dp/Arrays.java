package com.letsdecode.problems.dp;

public class Arrays {
	public int houseRobber(int[] a, int i) {
		int first = 0;
		int second = 0;
		if (i < a.length) {
			first = a[i];
		} else {
			return first;
		}

		if (i + 1 < a.length) {
			second = a[i + 1];
			first += houseRobber(a, i + 2);
			second += houseRobber(a, i + 3);
		}
		return Math.max(first, second);
	}

	public int houseRobberDP(int[] a) {
		int t[] = new int[a.length + 2];
		for (int i = 2; i < t.length; i++) {
			t[i] = Math.max(a[i - 2] + t[i - 2], t[i - 1]);
		}

		return Math.max(t[t.length - 2], t[t.length - 1]);
	}

	public int houseRobberVariables(int[] a) {
		int pre = 0;
		int first = 0;
		int second = 0;
		for (int i = 0; i < a.length; i++) {
			second = Math.max(pre + a[i], first);
			pre = first;
			first = second;
		}

		return Math.max(first, second);
	}

	public int houseRobberABMax(int[] arr) {
		int a = 0;
		int b = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				a += arr[i];
				a = Math.max(a, b);
			} else if (i % 2 == 1) {
				b += arr[i];
				b = Math.max(a, b);
			}
		}

		return Math.max(a, b);
	}

	public int houseRobberTwo_ABMax(int[] arr) {
		int a = 0;
		int b = 0;
		int maxLen = arr.length;
		if (arr.length == 1) {
			return arr[0];
		}
		for (int i = 0; i < maxLen - 1; i++) {
			if (i % 2 == 0) {
				a += arr[i];
				a = Math.max(a, b);
			} else if (i % 2 == 1) {
				b += arr[i];
				b = Math.max(a, b);
			}
		}
		int first = Math.max(a, b);
		;
		a = 0;
		b = 0;
		for (int i = 1; i < maxLen; i++) {
			if (i % 2 == 0) {
				a += arr[i];
				a = Math.max(a, b);
			} else if (i % 2 == 1) {
				b += arr[i];
				b = Math.max(a, b);
			}
		}
		int second = Math.max(a, b);
		return Math.max(first, second);
	}

	public int houseRobberTwoRec(int[] a) {
		return Math.max(houseRobberTwo_(a, 0), houseRobberTwo_(a, 1));
	}

	public int houseRobberTwo_(int[] a, int i) {
		int first = 0;
		int second = 0;
		if (i < a.length) {
			first = a[i];
		} else {
			return first;
		}

		if (i + 1 < a.length) {
			second = a[i + 1];
			first += houseRobberTwo_(a, i + 2);
			second += houseRobberTwo_(a, i + 3);
		}
		return Math.max(first, second);
	}

	public int houseRobberTwo_ABSmarter(int[] arr) {
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		if (arr.length == 1) {
			return arr[0];
		}
		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length - 1) {
				if (i % 2 == 0) {
					a += arr[i];
					a = Math.max(a, b);
				} else if (i % 2 == 1) {
					b += arr[i];
					b = Math.max(a, b);
				}
			}
			if (i > 0) {
				if (i % 2 == 0) {
					c += arr[i];
					c = Math.max(c, d);
				} else if (i % 2 == 1) {
					d += arr[i];
					d = Math.max(d, c);
				}
			
			}
		}
		return  Math.max(Math.max(c, d),Math.max(a, b));
	}
}
