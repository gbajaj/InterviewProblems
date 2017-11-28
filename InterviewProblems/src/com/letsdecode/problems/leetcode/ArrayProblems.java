package com.letsdecode.problems.leetcode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ArrayProblems {

	public void dutchFlag(int a[], int pivot) {
		if (a.length == 0) {
			return;
		}

		int i = 0;
		int j = 0;
		int k = a.length - 1;

		while (j <= k) {
			if (a[j] > pivot) {
				swap(a, j, k);
				k--;
			} else if (a[j] < pivot) {
				swap(a, i, j);
				i++;
				j++;
			} else {
				j++;
			}
		}
	}

	public boolean boardGameWinnable(int a[]) {
		boolean res = false;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			max = Math.max(i + a[i], max);
			if (max >= a.length - 1) {
				res = true;
				break;
			} else if (i == max) {
				break;
			}
		}
		return res;
	}

	public int maxProfit(int[] a) {
		int bi = 0;
		int si = 0;
		int m1 = 0;
		int m2 = 0;
		int preSi = -1;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[i - 1]) {
				si = i;
				if (i == a.length - 1 || (i + 1 < a.length && a[i + 1] < a[i])) {
					int sum = a[si] - a[bi];
					if (sum > m1) {
						m2 = m1;
						m1 = sum;
					} else if (sum > m2) {
						m2 = Math.max(m2, sum);
					}
				}
			} else if (a[i] < a[i - 1]) {
				bi = i;
			}
		}
		return m1 + m2;
	}

	public int firstMissingPositive(int[] nums) {
		int ret = 0;
		for (int i = 0; i < nums.length;) {
			if (nums[i] > 0 && nums[i] < nums.length
					&& nums[nums[i] - 1] != nums[i]) {
				swap(nums, i, nums[i] - 1);
			} else {
				i++;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}

	public int removeElement(int[] nums, int val) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}
		for (int k = i; k < nums.length; k++) {
			nums[k] = 0;
		}
		return i;
	}

	public String productOfTwoArrays(String num1, String num2) {
		if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
			return null;
		}

		char[] a = reverse(num1);
		char[] b = reverse(num2);
		int res = 0;
		char[] out = new char[a.length + b.length];
		for (int i = 0; i < out.length; i++) {
			out[i] = '0';
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				char toAdd = (char) (out[i + j] - '0');
				res = (a[i] - '0') * (b[j] - '0') + toAdd;
				out[i + j] = (char) ('0' + res % 10);
				out[i + j + 1] = (char) ((out[i + j + 1] - '0') + ('0' + res / 10));
			}
		}
		reverse(out);
		int last = indexFromNonZero(out);
		if (last == out.length) {
			return "0";
		}
		return new String(out, last, (out.length - last));
	}

	// =================//

	public byte[] incrementABigInteger(byte[] a) {
		byte[] out = a;
		if (a.length == 0) {
			return out;
		}
		int carry = 1;
		int res = 0;
		for (int i = a.length - 1; i >= 0; i--) {
			res = carry + a[i];
			a[i] = (byte) (res == 10 ? 0 : res);
			if (res < 10) {
				break;
			}
		}
		if (res == 10) {
			out = new byte[a.length + 1];
			out[0] = 1;
			System.arraycopy(a, 0, out, 1, a.length);
		}
		return out;
	}

	private void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public int[] productOfArrayExceptSelf(int[] a) {
		int[] res = new int[a.length];
		res[0] = 1;
		for (int i = 1; i < a.length; i++) {
			res[i] = a[i - 1] * res[i - 1];
		}
		int right = 1;
		for (int i = a.length - 1; i >= 0; i--) {
			res[i] *= right;
			right *= a[i];
		}

		return res;
	}

	public int bestTimeToBuyAndSellStock(int[] a) {
		int buyi = 0;
		int max = 0;
		int min = 0;
		for (int i = 0; i < a.length; i++) {

			if ((a[i] - a[buyi]) <= min) {
				buyi = i;
			} else if ((a[i] - a[buyi]) >= max) {
				max = a[i] - a[buyi];
			}
		}
		return max;
	}

	public int bestTimeToBuyAndSellStock2(int[] a) {
		int sum = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[i - 1]) {
				sum += a[i] - a[i - 1];
			}
		}
		return sum;
	}

	public void print(int[] a) {
		System.out.println("");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	int indexFromNonZero(char[] a) {
		int i = 0;
		while (i < a.length) {
			if (a[i] != '0') {
				break;
			}
			i++;
		}
		return i;
	}

	char[] reverse(String a) {
		char[] o = new char[a.length()];
		int i = 0;
		int j = a.length() - 1;
		char[] s = a.toCharArray();
		while (i < j) {
			char c = s[i];
			s[i] = s[j];
			s[j] = c;
			i++;
			j--;
		}
		return s;
	}

	char[] reverse(char[] a) {
		int i = 0;
		int j = a.length - 1;
		while (i < j) {
			char c = a[i];
			a[i] = a[j];
			a[j] = c;
			i++;
			j--;
		}
		return a;
	}

	public List<List<Integer>> fourSum(int[] a, int target) {
		ArrayList<List<Integer>> list = new ArrayList<>();
		if (a.length < 4) {
			return list;
		}
		Arrays.sort(a);
		HashMap<Integer, Set<Integer>> m = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			Set<Integer> s = m.get(a[i]);
			if (s == null) {
				s = new HashSet<Integer>();
				m.put(a[i], s);
			}
			s.add(i);
		}

		for (int i = 0; i < a.length; i++) {
			int j = i + 1;
			int k = a.length - 1;
			while (j < k) {
				int sum = (a[i] + a[j] + a[k]);
				int temp = Math.abs(target - sum);
				Set<Integer> v = m.get(temp);
				if (v != null) {
					Iterator<Integer> iter = v.iterator();

					Integer first = iter.next();
					int p = first.intValue();
					v.remove(p);
					if ((sum + a[p] == target)
							&& (p > i && p < j || p > j && p < k)) {
						ArrayList<Integer> l = new ArrayList<>();
						l.add(a[i]);
						l.add(a[j]);
						l.add(a[k]);
						l.add(a[p]);
						list.add(l);

						Collections.sort(l);
					}
					if (v.isEmpty())
						m.remove(temp);
				}
				if (sum > target) {
					k--;
				} else if (sum <= target) {
					j++;
				}
			}

		}
		return list;
	}

	public List<List<Integer>> threeSum(int[] a) {
		List<List<Integer>> l = new ArrayList<>();
		if (a.length < 3) {
			return l;
		}
		int target = 0;
		Arrays.sort(a);
		for (int i = 0; i < a.length - 2; i++) {
			if (i > 0 && a[i] == a[i - 1])
				continue;
			int j = i + 1;
			int k = a.length - 1;
			while (j < k) {
				int sum = a[i] + a[j] + a[k];
				if (sum == target) {
					List<Integer> t = new ArrayList<>();
					t.add(a[i]);
					t.add(a[j]);
					t.add(a[k]);
					l.add(t);
					j++;
					while (j < a.length && a[j - 1] == a[j])
						j++;
					while (k > 0 && a[k] == a[k - 1])
						k--;
				} else if (sum < target) {
					j++;
				} else {
					k--;
				}
			}
		}
		return l;
	}

	public List<List<Integer>> permute(int[] a) {
		List<List<Integer>> l = new ArrayList<>();
		permute(a, 0, l);
		return l;

	}

	public void permute(int[] a, int start, List<List<Integer>> l) {
		if (start >= a.length) {
			List<Integer> t = new ArrayList<>();
			for (int i : a) {
				t.add(i);
			}
			l.add(t);
			return;
		}
		for (int i = start; i < a.length; i++) {
			swap(a, start, i);
			permute(a, start + 1, l);
			swap(a, start, i);
		}
	}

	List<List<Integer>> o = new ArrayList<>();

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<Integer> l = new ArrayList<>();
		combinationSum3(k, n, 1, l);
		return o;
	}

	public void combinationSum3(int k, int n, int start, List<Integer> l) {
		if (l.size() == k && n == 0) {
			List<Integer> p = new ArrayList<>(l);
			o.add(p);
			return;
		}
		for (int i = start; i <= 9; i++) {
			l.add(i);
			combinationSum3(k, n - i, i + 1, l);
			l.remove(l.size() - 1);
		}
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {

		// o.add(new ArrayList());
		subsetsWithDup(nums, 0, new ArrayList<Integer>());
		return o;
	}

	public void subsetsWithDup(int[] nums, int start, List<Integer> l) {
		o.add(new ArrayList<>(l));
		for (int i = start; i < nums.length; i++) {
			if (i == start || nums[i] != nums[i - 1]) {
				l.add(nums[i]);
				subsetsWithDup(nums, i + 1, l);
				l.remove(l.size() - 1);
			}
		}
	}

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int j = 0;
		int count = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[j]) {
				if (count == 0) {
					count++;
					j++;
					nums[j] = nums[i];
				}
			} else {
				j++;
				nums[j] = nums[i];
				count = 0;
			}
		}

		return j + 1;
	}

	int[] xa = { 0, 0, 1, -1 };
	int[] ya = { 1, -1, 0, 0 };
	char[] pos = { 'r', 'l', 'd', 'u' };
	boolean[][] visited;
	List<String> res = new ArrayList<String>();
	LinkedList<Node> q = new LinkedList<Node>();

	class Node {
		int x;
		int y;
		String dist;

		Node(int x, int y, String d) {
			this.x = x;
			this.y = y;
			dist = d;
		}
	}

	public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
		visited = new boolean[maze.length][maze[0].length];
		q.add(new Node(ball[0], ball[1], ""));
		findShortestWay(maze, hole, ball[0], ball[1], "", ' ');
		Collections.sort(res);
		if (res.isEmpty()) {
			return "impossible";
		}
		return res.get(0);
	}

	public void findShortestWay(int[][] maze, int[] hole, int i, int j,
			String a, char direction) {

		while (q.isEmpty() == false) {
			Node currentNode = q.removeFirst();
			if (currentNode.x == hole[0] && currentNode.y == hole[1]) {
				res.add(currentNode.dist);
				continue;
			}
			for (int k = 0; k < 4; k++) {
				int nx = currentNode.x + xa[k];
				int ny = currentNode.y + ya[k];
				if (isValid(maze, nx, ny) && maze[nx][ny] == 0
						&& visited[nx][ny] == false) {
					visited[nx][ny] = true;
					String temp = currentNode.dist;
					if (temp.isEmpty()
							|| temp.charAt(temp.length() - 1) != pos[k]) {
						temp = temp + pos[k];
					}
					System.out.println(nx + " " + ny + " " + temp);
					q.addLast(new Node(nx, ny, temp));
				}
			}
		}
	}

	boolean isValid(int[][] maze, int i, int j) {
		if (i < 0 || j < 0 || i >= maze.length || j >= maze[0].length) {
			return false;
		}
		if (maze[i][j] == 1) {
			return false;
		}
		return true;
	}

	public List<Integer> spiralOrder(int[][] a) {
		ArrayList<Integer> l = new ArrayList<>();
		int row = 0;
		int col = 0;
		int m = a.length - 1;
		int n = a[0].length - 1;
		int i = row;
		int j = col;
		while (row <= m && col <= n) {
			for (j = col; j <= n; j++) {
				l.add(a[row][j]);
			}
			row++;
			for (i = row; i <= m; i++) {
				l.add(a[i][n]);
			}
			n--;
			for (j = n; j >= col && row <= m; j--) {
				l.add(a[m][j]);
			}
			m--;
			for (i = m; i >= row && col <= n; i--) {
				l.add(a[i][col]);
			}
			col++;
		}
		return l;
	}

	public int[][] generateMatrix(int len) {
		if (len < 0)
			return null;
		int a[][] = new int[len][len];
		int row = 0;
		int col = 0;
		int m = len - 1;
		int n = len - 1;
		int c = 1;
		while (row <= m && col <= n) {
			for (int j = col; j <= n; j++) {
				a[row][j] = c * c;
				c++;
			}
			row++;
			for (int i = row; i <= m; i++) {
				a[i][n] = c * c;
				c++;
			}
			n--;
			for (int j = n; j >= col && row <= m; j--) {
				a[m][j] = c * c;
				c++;
			}
			m--;
			for (int i = m; i >= row && col <= n; i--) {
				a[i][col] = c * c;
				c++;
			}
			col++;
		}
		return a;
	}

	List<List<Integer>> out = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] a, int target) {
		int[] b = new int[a.length];
		combinationSum(a, target, 0, b);

		return out;
	}

	public void combinationSum(int[] a, int target, int j, int b[]) {
		if (target == 0) {
			ArrayList<Integer> t = new ArrayList<Integer>();
			for (int i = 0; i < j; i++) {
				for (int k = 0; k < b[i]; k++) {
					t.add(a[i]);
				}
			}
			out.add(t);
			return;
		}
		if (j >= a.length || target < 0) {
			return;
		}
		for (int i = j; i < a.length; i++) {
			int temp = target;
			if (a[i] <= target && a[i] != 0) {
				int q = target / a[i];
				int r = target % a[i];
				for (int k = q; k >= 1; k--) {
					temp = target - a[i] * k;
					b[i] = k;
					combinationSum(a, temp, i + 1, b);
					b[i] = 0;
				}
			}

		}

	}

	public int candy(int[] ratings) {
		int candy[] = new int[ratings.length];
		Arrays.fill(candy, 1);
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candy[i] = candy[i - 1] + 1;
			}
		}
		int min = candy[candy.length - 1];
		for (int i = candy.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candy[i] = Math.max(candy[i], candy[i + 1] + 1);
			}
			min += candy[i];
		}
		return min;

	}

	// List<List<Integer>> out = new ArrayList<>();

	public List<List<Integer>> combinationSum3_(int k, int n) {
		combinationSum3_(k, n, 1, 0, new ArrayList<Integer>());
		return out;
	}

	public void combinationSum3_(int k, int n, int index, int s,
			ArrayList<Integer> l) {
		if (s == n && l.size() == k) {
			out.add(new ArrayList<>(l));
			return;
		}
		if (l.size() > k)
			return;
		if (index > 7 & l.size() == 0) {
			return;
		}
		if (index > 9) {
			return;
		}
		l.add(index);
		combinationSum3_(k, n, index + 1, s + index, l);
		l.remove(l.size() - 1);
		combinationSum3_(k, n, index + 1, s, l);
	}

	final class Nodee implements Comparator<Nodee> {

		private final int x;
		private final int y;

		Nodee(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public boolean equals(Nodee other) {
			Nodee otherNode = other;
			return x == otherNode.x;
		}

		public int hashCode() {
			return x * 31; // For example...
		}
//		@Override
//		public int compare(Node a, Node b) {
//			// As of Java 7, this can be replaced with
//			// return x != other.x ? Integer.compare(x, other.x)
//			// : Integer.compare(y, other.y);
//			return a.x - b.x;
//		}

		@Override
		public int compare(Nodee o1, Nodee o2) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	TreeSet<Nodee> tr = new TreeSet<Nodee>();

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		for (int i = 0; i < nums.length; i++) {
			Nodee n = new Nodee(nums[i], i);

			Nodee val = tr.floor(n);

			if (val != null && Math.abs(val.x - nums[i]) <= t
					&& Math.abs(val.y - i) <= k) {
				return true;
			} else {
				tr.add(n);
			}
		}
		return false;
	}
	
    public int[] productExceptSelf(int[] nums) {
        
        int ret[] = new int [nums.length];
        if (nums.length < 1) return ret;
        int prefix = 1;
        for (int i = 0;i< nums.length; i++) {
            ret[i] = prefix;
            prefix *= nums[i];
        }
        System.out.println(ret[nums.length-1]);
        int sufix = 1;
        for (int i = nums.length-1; i>=0; i--) {
            ret[i] *= sufix;
            sufix *= nums[i];  
            System.out.println(ret[i]);
        }
        return ret;
    }
    
    public Date testDate() throws ParseException  {
    	Date date = new Date();
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    	Date d = simpleDateFormat.parse("2016-05-04T00:00:00 +05:30");
    	return d;
    }
    
}
