package com.letsdecode.problems.epi.chapter18;

public class DynamicProgrammingProblems {
	public int combinations(int score, int a[], int comb[]) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			int res = score - a[i];
			count += _combinations(score, a, comb);
		}
		return count;

	}

	public int _combinations(int score, int a[], int comb[]) {
		int count = 0;
		if (score == 0) {
			return 1;
		}
		int n = 0;
		for (int i = 0; i < a.length; i++) {
			int res = score - a[i];
			if (res < 0) {
				continue;
			} else if (res == 0) {
				comb[i]++;
				return 1;
			} else if (res > 0) {
				n = _combinations(res, a, comb);
				if (n > 0) {
					count++;
				}
			}
		}
		return count;

	}

	public void ampleCity(int[] gas, int miles[]) {
		int len = gas.length;
		int m = 0;
		int milesTotalCapacity = 0;
		int left = 0;
		int i = 12;
		while(true) {
			milesTotalCapacity += (gas[i] * 20);
			m += miles[i];
			milesTotalCapacity -= miles[i];
			System.out.println("i :" + i + " : " + milesTotalCapacity);
			i = ((i + 1) % len);
			if (i == 12)
				break;
		}

		System.out.println("\nMiles : " + m);
		System.out.println("capacity : " + milesTotalCapacity);

	}
}
