package com.letsdecode.problems.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class StringQuestions {
	/*
	 * Print a string Sinusoidally Also called "SnakeString". For example, the
	 * phrase "Google Worked" should be printed as follows (where ~ is the word
	 * separator):
	 * 
	 * o ~ k o g e W r e G l o d
	 */
	public void snakePrinting(String str) {
		int MAXSIZE = 3;

		ArrayList<ArrayList<String>> list = new ArrayList<>();
		for (int i = 0; i < MAXSIZE; i++) {
			list.add(new ArrayList<String>());
		}
		int level = 0;
		boolean inc = true;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				list.get(level).add("~");
			} else {
				list.get(level).add("" + str.charAt(i));
			}
			if (inc) {
				level++;
				if (level == MAXSIZE) {
					level -= 2;
					inc = false;
				}
			} else {
				level--;
				if (level == -1) {
					level += 2;
					inc = true;
				}
			}
		}
		System.out.println(list.get(0));
		for (int i = list.size() - 1; i >= 0; i--) {
			ArrayList<String> levelList = list.get(i);
			for (int k = MAXSIZE - i; k >= 0; k--) {
				System.out.print(" ");
			}
			for (int j = 0; j < levelList.size(); j++) {
				for (int k = 0; k < i; k++) {
					System.out.print(" ");
				}

				System.out.print(levelList.get(j));
				for (int k = MAXSIZE - i; k > 0; k--) {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}

	}

	public void interleavings(String a, String b) {
		char[] out = new char[a.length() + b.length()];
		interleavings(out, a, b, 0, 0, 0);
	}

	public boolean isInterleaving(String a, String b, String c) {
		return isInterleaving(a, 0, b, 0, c, 0);
	}

	public boolean isInterleavingDP(String a, String b, String c) {
		if (c.length() != a.length() + b.length())
			return false;
		boolean dp[][] = new boolean[a.length() + 1][b.length() + 1];
		dp[0][0] = true;
		for (int j = 1; j <= b.length(); j++) {
			// A might be empty; then all the characters in B should match we
			// C's
			dp[0][j] = dp[0][j - 1] && c.charAt(j - 1) == b.charAt(j - 1);
		}
		// B might be empty; then all the characters in A should match we C's
		for (int i = 1; i <= a.length(); i++) {
			dp[i][0] = dp[i - 1][0] && c.charAt(i - 1) == a.charAt(i - 1);
		}

		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				// Set current cell to true
				dp[i][j] = dp[i][j - 1]
						&& c.charAt(i + j - 1) == b.charAt(j - 1)
						|| dp[i - 1][j]
						&& c.charAt(i + j - 1) == a.charAt(i - 1);
			}
		}

		return dp[a.length()][b.length()];
	}

	public boolean isInterleaving(String a, int i, String b, int j, String I,
			int l) {
		if (l == I.length() && i == a.length() && j == b.length()) {
			return true;
		}
		boolean res = false;
		if (l >= I.length()) {
			return res;
		}

		char ch = I.charAt(l);
		if (i >= a.length()) {
			return matchString(b, I, j, l);
		}
		if (i < a.length() && a.charAt(i) == ch) {
			res = isInterleaving(a, i + 1, b, j, I, l + 1);
		}

		if (j >= b.length()) {
			return matchString(a, I, i, l);
		}
		if (!res && j < b.length() && b.charAt(j) == ch) {
			res = isInterleaving(a, i, b, j + 1, I, l + 1);
		}

		return res;
	}

	boolean matchString(String a, String b, int i, int j) {
		while (i < a.length() && j < b.length()) {
			if (a.charAt(i) != b.charAt(j)) {
				return false;
			}
			i++;
			j++;
		}
		if (i == a.length() && j == b.length()) {
			return true;
		}
		return false;
	}

	private void interleavings(char[] out, String stri, String strj, int i,
			int j, int pos) {
		if (i == stri.length() && j == strj.length()) {
			System.out.println(new String(out));
		}
		if (i < stri.length()) {
			out[pos] = stri.charAt(i);
			interleavings(out, stri, strj, i + 1, j, pos + 1);
		} else if (j < strj.length()) {
			// Extra optimization
			while (j < strj.length()) {
				out[pos++] = strj.charAt(j);
				j++;
			}
			System.out.println(new String(out));
			return;
		}
		if (j < strj.length()) {
			out[pos] = strj.charAt(j);
			interleavings(out, stri, strj, i, j + 1, pos + 1);
		} else if (i < stri.length()) {
			// Extra optimization
			while (i < stri.length()) {
				out[pos++] = strj.charAt(i);
				i++;
			}
			System.out.println(new String(out));
			return;
		}
	}

	// An array to be used for faster comparisons and reading the values
	private int[] letters26 = new int[26];

	private void init() {
		letters26['I' - 'A'] = 1;
		letters26['V' - 'A'] = 5;
		letters26['X' - 'A'] = 10;
		letters26['L' - 'A'] = 50;
		letters26['C' - 'A'] = 100;
		letters26['D' - 'A'] = 500;
		letters26['M' - 'A'] = 1000;
	}

	public int convertRomanToInteger(String s) {
		// Initialize the array
		init();
		return _convertRomanToInteger(s.toCharArray(), 0);
	}

	// Recursively calls itself as long as 2 consecutive chars are different
	private int _convertRomanToInteger(char[] s, int index) {
		int ret = 0;
		char pre = s[index];// Char from the given index
		ret = _getValue(pre);

		// Iterate through the rest of the string
		for (int i = index + 1; i < s.length; i++) {
			if (compare(s[i], s[i - 1]) == 0) {
				// If 2 consecutive chars are similar, just add them
				ret += _getValue(s[i]);
			} else if (compare(s[i], s[i - 1]) > 0) {
				// If current char is greater than the previous e.g IX ('I' s[i
				// - 1] and 'X' s[i - 1])
				// We need to calculate starting from 'i' and subtract the
				// calculation ('ret')
				// done so far in current call
				return _convertRomanToInteger(s, i) - ret;
			} else {
				// If current char is smaller than the previous e.g XI ('X' s[i
				// - 1] and 'I' s[i - 1])
				// We need to calculate starting from 'i' and subtract the
				// result
				// from the calculation done so far in current call
				return ret + _convertRomanToInteger(s, i);
			}
		}
		return ret;
	}

	// Helper function for comparison
	private int compare(char a, char b) {
		return letters26[Character.toUpperCase(a) - 'A']
				- letters26[Character.toUpperCase(b) - 'A'];
	}

	private int _getValue(char c) {
		return letters26[Character.toUpperCase(c) - 'A'];
	}

	public boolean repeatedSubstringPattern(String str) {
		if (str == null || str.isEmpty())
			return true;
		int len = str.length();
		for (int i = 1; i <= len / 2; i++) {
			if (len % (i - 0) == 0) {
				String temp = str.substring(0, i);
				int pre = i;
				int j = i + (i - 0);
				while (j <= len) {
					if (temp.equals(str.substring(pre, j)) == false)
						break;
					pre = j;
					j = pre + (i - 0);
				}
				if (j > len) {
					return true;
				}
			}
		}
		return false;
	}

	public String countAndSay(int n) {
		String res = "1";
		// solve it again

		return res;
	}

	public boolean isValid(String s) {
		Stack<String> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ']' || c == ')' || c == '}') {
				if (st.isEmpty()) {
					return false;
				}
				String l = st.peek();
				if (l.equals("(") && c == ')') {
					st.pop();
				} else if (l.equals("[") && c == ']') {
					st.pop();
				} else if (l.equals("{") && c == '}') {
					st.pop();
				} else {
					return false;
				}

			} else {
				st.push("" + c);
			}
		}
		return st.isEmpty();
	}

	public int lengthOfLongestSubstring(String s) {
		HashMap<String, Integer> map = new HashMap<>();
		int len = 0;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			Integer in = map.get("" + s.charAt(i));
			if (in != null) {
				start = Math.max(start, in + 1);
			}
			map.put("" + s.charAt(i), i);
			len = Math.max(len, i - start + 1);
		}

		return len;
	}

	public String longestPalindrome(String s) {
		if (s == null || s.isEmpty())
			return "";
		String ret = "" + s.charAt(0);
		int preMax = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			int even = getEvenLength(s, i);
			int odd = getOddLength(s, i);
			int max = Math.max(even, odd);
			if (preMax < max) {
				preMax = max;
				if (even > odd) {
					int index = (i + 1) - even / 2;
					ret = s.substring(index, index + even);
				} else {
					int index = i - odd / 2;
					ret = s.substring(index, index + odd);
				}
			}
		}
		return ret;
	}

	private int getEvenLength(String s, int i) {
		int l = i;
		int r = i + 1;
		int len = 0;
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			len += 2;
			l--;
			r++;
		}
		return len;
	}

	private int getOddLength(String s, int i) {
		int l = i - 1;
		int r = i + 1;
		int len = 1;
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			len += 2;
			l--;
			r++;
		}
		return len;
	}

	private HashMap<String, Integer> m = new HashMap<>();

	public String minWindow(String s, String t) {
		if (s == t || (s != null && s.equals(t))) {
			return s;
		}
		if (t == null || s.length() < t.length()) {
			return "";
		}

		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < t.length(); i++) {
			set.add("" + t.charAt(i));
		}
		HashSet<String> original = new HashSet<>();
		original.addAll(set);
		int count = set.size();
		int start = 0;
		int end = 0;
		int max = Integer.MAX_VALUE;
		int os = 0;
		int oe = 0;
		while (start <= end && start < s.length()) {
			if (set.isEmpty() == false) {
				// increment t
				if (end < s.length()) {
					char ch = s.charAt(end);
					end++;
					set.remove("" + ch);
				}
			} else if (set.isEmpty()) {
				if (end - start < max) {
					max = end - start;
					os = start;
					oe = end;
				}
				char ch = s.charAt(start);
				set.add("" + ch);
				start++;
				while (start <= end && start < s.length()
						&& original.contains("" + ch) == false) {
					start++;
					ch = s.charAt(start);
				}
			}
		}

		if (max != Integer.MAX_VALUE) {
			return s.substring(os, oe);
		}
		return "";
	}

	public int strStr(String a, String b) {
		if (a == null || b == null)
			return -1;
		if (a.length() == b.length() && a.equals(b))
			return 0;
		if (a.length() < b.length())
			return -1;
		for (int i = 0; i <= a.length() - b.length(); i++) {
			if (b.charAt(0) == a.charAt(i)) {
				int j = 1;
				int k = i + 1;

				while (k < a.length() && b.charAt(j) == a.charAt(k)) {
					System.out
							.println(" j" + b.charAt(j) + " k " + a.charAt(k));
					j++;
					k++;
				}
				if (j == b.length()) {
					return i;
				}
			}
		}
		return -1;

	}

	public int compareVersion(String version1, String version2) {
		String one[] = version1.split("\\.");
		String two[] = version2.split("\\.");
		int v1 = (one.length == 0 ? Integer.parseInt(version1) : 0);
		int v2 = (two.length == 0 ? Integer.parseInt(version2) : 0);
		int i = 0;
		int j = 0;

		for (; i < one.length || j < two.length; i++, j++) {
			v1 = (i < one.length ? Integer.parseInt(one[i]) : 0);
			v2 = (j < two.length ? Integer.parseInt(two[j]) : 0);
			System.out.println("" + v1 + " " + v2);
			if (v1 < v2) {
				return -1;
			} else if (v1 > v2) {
				return 1;
			}
		}
		return v1 - v2;
	}

	public int countSegments(String s) {
		if (s == null) {
			return 0;
		}
		s = s.trim();
		if (s.isEmpty())
			return 0;
		String[] a = s.split(" +");
		return a.length;

	}

	public List<Integer> findAnagrams(String s, String p) {

		List<Integer> res = new ArrayList<>();
		if (s == null || s.isEmpty() || p == null || p.isEmpty()) {
			return res;
		}
		int hash[] = new int[256];

		for (int i = 0; i < p.length(); i++) {
			hash[p.charAt(i)]++;
		}
		int left = 0;
		int right = 0;
		int count = p.length();
		while (right < s.length()) {
			// move right everytime, if the character exists in p's hash,
			// decrease the count
			// current hash value >= 1 means the character is existing in p
			// if (hash[s.charAt(right++)]-- >= 1) count--;

			char ch = s.charAt(right);
			int val = hash[ch];
			hash[ch]--;
			if (val >= 1) {
				count--;
			}
			right++;

			// when the count is down to 0, means we found the right anagram
			// then add window's left to result list
			if (count == 0)
				res.add(left);

			// if we find the window's size equals to p, then we have to move
			// left (narrow the window) to find the new match window
			// ++ to reset the hash because we kicked out the left
			// only increase the count if the character is in p
			// the count >= 0 indicate it was original in the hash, cuz it won't
			// go below 0
			// if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0)
			// count++;

			// char ch = s.charAt(right);
			// System.out.println("right :" + ch);
			// if (hash[ch] >= 1) {
			// hash[ch]--;
			// count --;

			// }
			// right++;
			// System.out.println(count);

			// if (count == 0) {
			// res.add(left);
			// }

			ch = s.charAt(left);
			val = hash[ch];
			if (right - left == p.length()) {
				if (val >= 0) {
					count++;
				}
				hash[ch]++;
				left++;
			}

		}

		return res;
	}

	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		if (words.length != pattern.length())
			return false;
		Map index = new HashMap<>();
		for (Integer i = 0; i < words.length; ++i) {
			Integer val1 = (Integer) index.put(pattern.charAt(i), i);
			Integer val2 = (Integer) index.put(words[i], i);
			if (val1 != val2)
				return false;
		}
		return true;
	}

	// Cows and Bulls cows bulls
	public String getHint(String secret, String guess) {
		char[] sec = secret.toCharArray();
		char[] gue = guess.toCharArray();
		HashMap<Character, Integer> m = new HashMap<>();
		int count = sec.length;
		int cows = 0;
		int bulls = 0;
		for (int i = 0; i < sec.length; i++) {
			Integer c = m.get(sec[i]);
			if (c == null) {
				m.put(sec[i], 1);
			} else {
				m.put(sec[i], c + 1);
			}
		}

		for (int i = 0; i < sec.length; i++) {
			if (sec[i] == gue[i]) {
				cows++;
				Integer a = m.get(sec[i]);
				if (a == 1) {
					m.remove(sec[i]);
				} else {
					m.put(sec[i], a - 1);
				}
				gue[i] = '.';
			}
		}
		for (int i = 0; i < sec.length; i++) {
			if (m.containsKey(gue[i])) {
				Integer a = m.get(gue[i]);
				if (a == 1) {
					m.remove(gue[i]);
				} else {
					m.put(gue[i], a - 1);
				}
				bulls++;
			}
		}
		return "" + cows + "A" + bulls + "B";
	}

	public boolean isMatch(String s, String p) {
		boolean res = false;
		if (s == null && p == null || s.isEmpty() || p.isEmpty()) {
			return false;
		}
		return isMatch(s, p, 0, 0);

	}

	public boolean isMatch(String s, String p, int i, int j) {
		if (j >= p.length()) {
			return i >= s.length();
		}

		if (j == p.length() - 1 || j < p.length() - 1 && p.charAt(j + 1) != '*') {
			if (s.isEmpty()
					|| (p.charAt(j) != '.' || p.charAt(j) != s.charAt(i))) {
				return false;
			} else {
				return isMatch(s, p, i + 1, j + 1);
			}
		}

		while (i < s.length() && s.charAt(i) == p.charAt(j)
				|| s.charAt(i) == '.') {
			if (isMatch(s, p, i, j + 2)) {
				return true;

			}
			i++;
		}

		return isMatch(s, p, i, j + 2);
	}

	List<String> out = new ArrayList<String>();

	public List<String> fullJustify(String[] words, int maxWidth) {
		int cur = 0;
		while (cur < words.length) {
			int end = cur;
			int count = words[cur].length();
			int index = cur + 1;
			int left = (maxWidth - count);
			while (index < words.length && (1 + words[index].length()) <= left) {
				end = index;
				count += (1 + words[index].length());
				left = (maxWidth - count);
				index++;
			}
			String o = "";
			if (end == words.length - 1 || left == 0) {
				int start = cur;
				int total = 0;
				while (start <= end) {
					o += words[start];
					total += words[start].length();
					if (start < end || total < maxWidth) {
						o += " ";
						total += 1;
					}
					start++;
				}
				while (total < maxWidth) {
					o += " ";
					total++;
				}
				out.add(o);
			} else {
				int spaces = 0;
				int r = 0;
				if (end > cur) {
					spaces = left / (end - cur);
					r = left % (end - cur);
				}
				int start = cur;
				while (start <= end) {

					o += words[start];
					if (start < end) {
						o += " ";
						for (int i = 0; i < spaces; i++) {
							o += " ";
						}
						if (r > 0) {
							o += " ";
							r--;
						}
					}
					start++;
				}
				out.add(o);
			}

			cur = end + 1;
		}
		return out;
	}
	// public List<String> fullJustify(String[] words, int maxWidth) {
	// int cur = 0;
	//
	// List<String> l = new ArrayList<>();
	// while (cur < words.length) {
	// int index = cur;
	// int tlen = 0;
	// int end = index;
	// while (index < words.length && tlen <= maxWidth) {
	// int total = tlen + words[index].length();
	// if (total > maxWidth) {
	// if (index > cur) {
	// tlen--;
	// } else {
	// tlen = total;
	// }
	// break;
	// } else if (total < maxWidth) {
	// tlen = total;
	// if (index < words[index].length() -1) {
	// tlen++;
	// }
	// } else {
	// tlen = total;
	// end = index;
	// break;
	// }
	// end = index;
	// index++;
	// }
	// add(words, cur, end, maxWidth - tlen, maxWidth);
	// cur = end + 1;
	// }
	// return out;
	// }
	//
	// public void add(String[] words, int start, int end, int spaces, int
	// maxWidth) {
	// String o = "";
	// if (start == end) {
	// int len = o.length();
	// o = words[start];
	// for (int i = 0; i < (maxWidth - len); i++) {
	// o += " ";
	// }
	// out.add(o);
	// } else {
	// int r = spaces % (end - start);
	// spaces = spaces / (end - start);
	// while (start <= end) {
	// o += words[start];
	// if (start < end) {
	// o += " ";
	// for (int i = 0; i < spaces; i++) {
	// o += " ";
	// }
	// while (r > 0) {
	// o += " ";
	// r--;
	// }
	// }
	// start++;
	// }
	// out.add(o);
	// }
	//
	// }
    public String decodeString(String s) {
        int []a ={0};
        return decodeString(s, 0, a);
        
    }
    
    public String decodeString(String s, int start, int a[]) {
        if (s== null || s.isEmpty()) return s;
        System.out.println(s + " start " + start + " a[0]" + a[0]);
        int i = start;
        char c = s.charAt(0);
        int count = 0;
        String res = "";
        while (i < s.length()) {
            c = s.charAt(i);
            if (c == '[') {
            	String temp = decodeString(s, i+1, a);
                
                for (int j = 0 ; j < count ; j++) {
                    res += temp; 
                }
                i = a[0]-1;
            } else if (c == ']') {
            	a[0] = i+1;
            	break;
            } else if (Character.isDigit(c)) {
                 String num = "";
                 int j = i;
                 while (j < s.length() && Character.isDigit(s.charAt(j))) {
                     num += s.charAt(j);
                     j++;
                 }
                 count = Integer.parseInt(num);
                 //Assuming that j never reaches end
                 i = j-1;
             } else {
            	 res +=c;
             }
            i++;
            
        }
        return res;
    }	
    
    List<String> l = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.isEmpty() || s.length() < 4) return l;
        for (int i = 0 ; i < 3 && i < s.length(); i++) {
            String first = s.substring(0, i+1);
            if (isValidSegment(first) == false) continue;
            for (int j = i+1; j < i + 4  && j < s.length(); j++) {
                String sec = s.substring(i + 1, j+1);
                if (isValidSegment(sec) == false) continue;    
                for (int k = j+1; k < j + 4 && k < s.length(); k++) {
                    String third = s.substring(j + 1, k+1);
                    if (isValidSegment(third) == false) continue;    
                    String forth = s.substring(k + 1);
                    if (isValidSegment(forth)) {
                        l.add(first + "." + sec + "." + third + "."+forth);
                    }
                }
            }
        }
        return l;
    }
    
    boolean isValidSegment(String s) {
        if (s.isEmpty()) return false;
        if (s.charAt(0) == '0' && s.length() > 1) return false;
        try {
            Integer res = Integer.parseInt(s);
            if (res < 0 || res > 255) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }    

    public String simplifyPath(String path) {
        LinkedList<String> s = new LinkedList();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir:path.split("/")) {
            if (dir.equals("..") && !s.isEmpty()) s.removeLast();
            else if (skip.contains(dir) == false) s.addLast(dir);
        }
        String res = "";
        for (String dir: s) {
            res += "/" + dir;
        }
        return res.isEmpty()? "/":res;
        
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> ret= new LinkedList<>();
        for (int i = 1; i<=s.length();i++ ) {
            String part = s.substring(0, i);
            LinkedList<String> l = new LinkedList<>();
            if (isPalindrome(part)) {
                _partition(s.substring(i, s.length()), l);
                if (l.isEmpty() == false) {
                    l.addFirst(part);
                    ret.add(l);
                }
            }            
            
        }
        return ret;
    }
    
    void  _partition(String s, LinkedList<String> l) {
        if (s == null || s.isEmpty()) return;
        for (int i = 1; i<=s.length();i++ ) {
            String part = s.substring(0, i);
            if (isPalindrome(part)) {
            	String sec = s.substring(i, s.length());
            	if (sec.isEmpty()) {
            		l.add(part);
            		return;
            	}
                _partition(sec, l);
                if (l.isEmpty() == false) {
                    l.addFirst(part);
                }
            }            
        }
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;
        int i = 0;
        int j = s.length() -1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
