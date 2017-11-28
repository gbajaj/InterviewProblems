package com.letsdecode.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.SynchronousQueue;

import com.letsdecode.problems.trees.TreeNode;

public class ArrayProblems {
	public int findContigousSubarrayOf0sAnd1s(int a[], int k) {
		int maxi = -1;
		int maxj = -1;
		int zc = 0;
		int i = 0;
		int j = 0;
		while (j < a.length) {
			if (a[j] == 0) {
				zc++;
			}
			if (zc <= k) {
				if (j - i > maxj - maxi) {
					maxi = i;
					maxj = j;
				}
			} else {
				while (zc > k && i <= j) {
					if (a[i] == 0) {
						zc--;
					}
					i++;
				}
			}
			j++;
		}
		if (maxj == -1 && maxi == -1) {
			return 0;
		}
		return maxj + 1 - maxi;
	}

	public int tappingRainWater(int[] water) {
		int ret = 0;
		int sum = 0;
		for (int i = 0; i < water.length - 1;) {
			int e = i + 1;
			int s = i;
			int min = Math.min(water[s], water[e]);
			while (e < water.length) {
				min = Math.min(water[s], water[e]);
				if (water[e] < water[s]) {
					break;
				}
				e++;
			}
			if (e >= water.length) {
				break;
			}
			if (water[e] >= water[s]) {
				while (s < e) {
					sum += water[s] - min;
					s++;
				}
			}
			i = e;
		}
		ret = sum;
		return ret;
	}

	/**
	 * You are given an array of integers. Out of all of the sums of two
	 * elements, return the one closest to 0.
	 * 
	 * Example input [15, 18, 30] Output: 33 Explanation: 15 + 18 give 33, and
	 * no two elements give a sum closer than that to 0
	 *
	 * Example input [-7, -10, 6] Output: -1 Explanation: -7 +6 gives a sum of
	 * -1, no two elements give a sum closer to 0
	 * 
	 * NOTE: Input array is not sorted
	 * 
	 */

	public int findClosestToZero(int a[]) {
		int retVal = 0;
		if (a.length < 2) {
			throw new IllegalArgumentException(
					"Input array should be atleast of size 2");
		}

		int l = 0;
		int m = 1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				int sum = Math.abs(a[i] + a[j]);
				if (sum < min) {
					min = sum;
					l = i;
					m = j;
				}

			}
		}
		retVal = a[l] + a[m];
		return retVal;
	}

	/**
	 * You are given an array of integers. Out of all of the sums of two
	 * elements, return the one closest to 0.
	 *
	 * Example input [15, 18, 30] Output: 33 Explanation: 15 + 18 give 33, and
	 * no two elements give a sum closer than that to 0
	 *
	 * Example input [-7, -10, 6] Output: -1 Explanation: -7 +6 gives a sum of
	 * -1, no two elements give a sum closer to 0
	 * 
	 * NOTE: Input array is Sorted
	 * 
	 */

	public int findClosestToZeroWithSortedArray(int a[]) {
		int retVal = 0;
		if (a.length < 2) {
			throw new IllegalArgumentException(
					"Input array should be atleast of size 2");
		}

		int min = Integer.MAX_VALUE;
		int i = 0;
		int j = a.length - 1;
		int l = 0;
		int m = 1;
		if (a[0] >= 0) {
			return a[i] + a[j];
		} else if (a[0] < 0 && a[a.length - 1] <= 0) {
			return a[a.length - 2] + a[a.length - 1];
		} else {
			while (i < j) {
				int sum = Math.abs(a[i] + a[j]);
				if (Math.abs(a[i] + a[j]) < min || sum == 0) {
					min = sum;
					l = i;
					m = j;
				}

				if (sum < 0) {
					i++;
				} else {
					j--;
				}

			}
		}
		retVal = a[l] + a[m];
		return retVal;
	}

	public void printMatrixDiagonals(int[][] matrix) {
		int c = 0;
		int count = matrix.length + matrix[0].length - 1;
		int i = 0, j = 0;

		while (c < count) {
			printDiagonal(i, j, matrix);
			if (i < matrix.length - 1) {
				i++;
			} else if (j < matrix[0].length - 1) {
				j++;
			}

			c++;
		}

	}

	private void printDiagonal(int i, int j, int[][] m) {
		// System.out.println(i + " " + j);
		while (i >= 0 && j < m[0].length) {
			System.out.print(m[i][j] + " ");
			i--;
			j++;
		}
		System.out.println("");
	}

	public int arrangeCoins(int n) {
		int res = 0;
		long l = 1;
		long h = n;
		while (l <= h) {
			long m = l + (h - l) / 2;
			if ((long) (m * (m + 1)) / 2 <= (long) n) {
				res = (int) m;
				l = m + 1;
			} else {
				h = m - 1;
			}
		}
		return res;
	}

	public int[] searchRange(int[] a, int t) {
		int[] o = new int[2];
		o[0] = o[1] = -1;
		int l = 0;
		int h = a.length - 1;

		while (l <= h) {
			int m = l + (h - l) / 2;
			if (a[m] == t) {
				o[0] = o[1] = m;
				l = 0;
				h = m;
				int temp = m;
				while (l <= h) {
					m = l + (h - l) / 2;
					if (a[m] == t) {
						o[0] = m;
						h = m - 1;
					} else if (a[m] < t) {
						l = m + 1;
					}
				}
				l = temp;
				h = a.length - 1;
				while (l <= h) {
					m = l + (h - l) / 2;
					if (a[m] == t) {
						o[1] = m;
						l = m + 1;
					} else if (a[m] > t) {
						h = m - 1;
					}
				}
				break;
			} else if (t < a[m]) {
				h = m - 1;
			} else {
				l = m + 1;
			}
		}
		return o;

	}

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	};

	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		if (intervals.size() <= 0) {
			return intervals;
		}

		List<Interval> ret = new ArrayList<>();

		ret.add(intervals.get(0));

		for (int i = 1; i < intervals.size(); i++) {
			Interval p = ret.get(ret.size() - 1);
			Interval c = intervals.get(i);
			if (c.start <= p.end) {
				p.end = c.end > p.end ? c.end : p.end;
			} else {
				ret.add(c);
			}
		}
		return ret;
	}

	List<List<Integer>> l = new ArrayList<>();

	public List<List<Integer>> combine(int n, int k) {
		if (n > 0 && k >= 1) {
			combine(n, k, 1, new ArrayList<Integer>());
		}
		return l;
	}

	public void combine(int n, int k, int i, ArrayList<Integer> ll) {
		if (ll.size() == k) {
			ArrayList<Integer> tt = new ArrayList<>();
			tt.addAll(ll);
			l.add(tt);
			return;
		}
		if (i > n) {
			return;
		}

		ll.add(i);// 1, 2, 3, 4
		combine(n, k, i + 1, ll);
		ll.remove(ll.size() - 1);
		combine(n, k, i + 1, ll);
	}

	int n[];

	public void NumArray(int[] nums) {
		n = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			n[i + 1] = nums[i] + n[i];
		}
	}

	public int sumRange(int i, int j) {
		return n[j + 1] - n[i];
	}

	public int totalHammingDistance(int[] nums) {
		int mask = 0x1;
		int total = 0;
		for (int i = 0; i < 32; i++) {
			int bitcount = 0;
			for (int j = 0; j < nums.length; j++) {
				if ((nums[j] & (mask << i)) != 0) {
					bitcount++;
				}
			}
			total += bitcount * (nums.length - bitcount);
		}
		return total;
	}

	class Pair {
		long val;
		long index;

		Pair(int v, int i) {
			this.val = v;
			this.index = i;
		}
	}

	public boolean containsNearbyAlmostDuplicate(int[] a, int k, int t) {
		int len = a.length;
		Pair[] pair = new Pair[len];
		for (int i = 0; i < len; i++) {
			pair[i] = new Pair(a[i], i);
		}

		Arrays.sort(pair, new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				return (int) (p1.val - p2.val);
			}
		});

		// int i = 0;
		// int j = a.length - 1;
		// while (i < j) {
		// if (Math.abs(pair[i].val - pair[j].val) <= t &&
		// Math.abs(pair[i].index - pair[j].index) <= k) {
		// return true;
		//
		// } else {
		// if (Math.abs(pair[i + 1].val - pair[j].val) < Math
		// .abs(pair[i].val - pair[j - 1].val)) {
		// i++;
		// } else {
		// j--;
		// }
		// }
		//
		// }
		// for (int i = 0;i < a.length; i++) {

		// for (int j = i + 1; j < a.length && j <= i + k; j++) {
		// if (Math.abs((long)a[i] - (long)a[j]) <= t) {
		// return true;
		// }
		// }
		// }
		return false;
	}

	int findTarget(int[] a, int target) {
		return _findTarget(a, 0, target, 0, new String());
	}

	int _findTarget(int[] a, int i, int target, int val, String s) {
		int ret = 0;
		if (i == a.length) {
			if (val == target) {
				return 1;
			}
			return 0;
		}
		// System.out.print("," +a[i]);
		return _findTarget(a, i + 1, target, val + a[i], s)
				+ _findTarget(a, i + 1, target, val - a[i], s);
	}

	List<List<Integer>> rett = new ArrayList<>();
	HashSet<Integer> set = new HashSet<>();

	List<List<Integer>> subSet(int nums[]) {
		for (int i = 0; i < nums.length; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(nums[i]);
			list(nums, i + 1, temp);
		}
		return rett;
	}

	void list(int nums[], int j, List<Integer> s) {
		if (s != null && s.size() > 1) {
			if (set.contains(s.hashCode()) == false) {
				rett.add(new ArrayList<>(s));
				set.add(s.hashCode());
			}

		}
		for (int i = j; i < nums.length; i++) {
			if (nums[i] >= s.get(s.size() - 1)) {
				s.add(nums[i]);
				list(nums, i + 1, s);
				s.remove(s.size() - 1);
			}
		}
	}

	public static class RandomizedCollection {
		HashMap<Integer, Set<Integer>> loc = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		Random r = new Random();

		/** Initialize your data structure here. */
		public RandomizedCollection() {

		}

		/**
		 * Inserts a value to the collection. Returns true if the collection did
		 * not already contain the specified element.
		 */
		public boolean insert(int val) {
			if (loc.containsKey(val)) {
				loc.get(val).add(list.size());
				list.add(val);
				return false;
			} else {
				HashSet<Integer> a = new HashSet<>();
				a.add(list.size());
				loc.put(val, a);
				list.add(val);
			}
			return true;
		}

		/**
		 * Removes a value from the collection. Returns true if the collection
		 * contained the specified element.
		 */
		public boolean remove(int val) {
			if (loc.containsKey(val)) {
				Set<Integer> a = loc.get(val);// all indexes
				int index = a.iterator().next();
				a.remove(index);// remove first index
				if (index == list.size() - 1) {
					if (a.size() == 0) {
						list.remove(index);
						loc.remove(val);
					}
				} else {
					int lastElement = list.get(list.size() - 1);// Get last
																// element
					loc.get(lastElement).remove(list.size() - 1);// Remove last
																	// element
																	// index
																	// from its
																	// bucket

					list.set(index, lastElement);// Replace last element from
													// the val
					list.remove(list.size() - 1);// remove the last emlement
													// from the list;
					loc.get(lastElement).add(index);// add new index for the
													// last element in its
													// bucket
				}
				return true;
			}
			return false;
		}

		/** Get a random element from the collection. */
		public int getRandom() {
			return list.get(r.nextInt(list.size()));
		}
	}

	/**
	 * Your RandomizedCollection object will be instantiated and called as such:
	 * RandomizedCollection obj = new RandomizedCollection(); boolean param_1 =
	 * obj.insert(val); boolean param_2 = obj.remove(val); int param_3 =
	 * obj.getRandom();
	 */

	public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
		int len = (a * 2) - 1;
		ArrayList<ArrayList<Integer>> out = new ArrayList<>(len);

		for (int i = 0; i < len; i++) {
			out.add(new ArrayList<Integer>(Collections.nCopies(len, 0)));
		}

		if (a <= 0) {
			return out;
		}
		int k = (a * 2) - 2;
		int val = a;
		int r = len - 1;
		for (int i = 0; i <= k; i++) {
			ArrayList<Integer> t = out.get(i);
			// Top
			for (int c = i; c <= k; c++) {
				t.set(c, val);
			}
			// Right
			for (int l = i + 1; l <= r; l++) {
				out.get(l).set(k, val);
			}
			k--;
			for (int c = k; c >= i; c--) {
				out.get(r).set(c, val);
			}

			r--;
			for (int l = r; l > i; l--) {
				out.get(l).set(i, val);
			}
			val--;
		}
		return out;
	}

	public int kthsmallest(final List<Integer> a, int k) {
		if (a.size() < k) {
			return 1;
		}
		Collections.sort(a);
		return a.get(k - 1);

	}

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
		if (a != null && a.size() == 0) {
			return null;
		}
		Collections.sort(a);
		ArrayList<ArrayList<Integer>> out = new ArrayList<>();
		_permute(a, 0, out);
		return out;
	}

	public void _permute(ArrayList<Integer> a, int index,
			ArrayList<ArrayList<Integer>> out) {
		if (index >= a.size()) {
			ArrayList<Integer> t = new ArrayList<>();
			t.addAll(a);
			out.add(t);
			return;
		}
		for (int i = index; i < a.size(); i++) {
			if (index != i && i > 0 && a.get(i) == a.get(i - 1)) {
				continue;
			}
			swap(a, i, index);
			_permute(a, index + 1, out);
			swap(a, i, index);
		}

	}

	private void swap(ArrayList<Integer> a, int i, int j) {
		int temp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, temp);

	}
}
