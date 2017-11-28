package com.letsdecode.problems.epi.chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.xml.stream.events.Characters;

public class StringProblems {
	public int stringtoInteger(String s) {
		int res = 0;
		if (s == null)
			return res;
		s = s.trim();
		if (s.isEmpty())
			return res;
		int i = 0;
		char ch = s.charAt(i);
		boolean neg = false;
		if (ch == '-') {
			neg = true;
			i++;
		} else if (ch == '+') {
			i++;
		}
		if (i >= s.length())
			return res;
		long val = 0;
		long temp = 0;
		for (; i < s.length(); i++) {
			ch = s.charAt(i);
			if (Character.isDigit(ch) == false)
				break;

			val = temp * 10 + (ch - '0');
			if (neg && val > (long) Integer.MAX_VALUE + 1) {
				return Integer.MIN_VALUE;
			}
			if (neg == false && val > (long) Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			temp = val;
		}
		if (neg) {
			temp *= -1;
		}

		return (int) (temp);
	}

	String removeAndReplace(String a) {
		return _removeAndReplace(a.toCharArray());
	}

	String _removeAndReplace(char[] a) {
		int aCount = 0;
		int w = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 'b' && a[i] != ' ') {
				a[w++] = a[i];
			}
			if (a[i] == 'a') {
				aCount++;
			}
		}
		// Resize a with a.size + aCount
		int lastLetter = w - 1;
		w = a.length - 1;
		while (lastLetter >= 0) {
			if (a[lastLetter] == 'a') {
				a[w--] = 'd';
				a[w--] = 'd';
			} else {
				a[w--] = a[lastLetter];
			}
			lastLetter--;
		}
		return new String(a);
	}

	public String addBinary(String a, String b) {
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while (i >= 0 || j >= 0 || carry == 1) {
			int ii = i >= 0 ? a.charAt(i) - '0' : 0;
			int ij = j >= 0 ? b.charAt(j) - '0' : 0;
			int val = ii + ij + carry;
			carry = 0;
			switch (val) {
			case 0:
				sb.append('0');
				break;
			case 1:
				sb.append('1');
				break;
			case 2:
				sb.append('0');
				carry = 1;
				break;
			case 3:
				sb.append('1');
				carry = 1;
				break;

			}
			j--;
			i--;
		}
		return sb.reverse().toString();
	}

	List<String> res = new ArrayList();

	public List<String> fullJustify(String[] w, int L) {
		int index = 0;
		while (index < w.length) {
			int count = w[index].length();
			int last = index + 1;
			while (last < w.length) {
				if ((count + w[last].length() + 1) > L)
					break;
				count += w[last].length() + 1;
				last++;
			}
			StringBuffer b = new StringBuffer();
			int wordsCount = last - index;
			if (last == w.length || wordsCount == 1) {
				for (int i = index; i < last; i++) {
					b.append(w[i]).append(" ");
				}
				b.deleteCharAt(b.length() - 1);
				for (int i = b.length(); i < L; i++) {
					b.append(" ");
				}
			} else {
				int spaces = (L - count) / (wordsCount - 1);
				int r = (L - count) % (wordsCount - 1);
				for (int i = index; i < last; i++) {
					b.append(w[i]);
					if (i < last - 1) {
						b.append(" ");
						for (int j = 0; j < spaces; j++) {
							b.append(" ");
						}
						if (r > 0) {
							b.append(" ");
							r--;
						}
					}
				}
			}
			res.add(b.toString());
			index = last;
		}

		return res;
	}

	List<Integer> ret = new ArrayList<>();

	public List<Integer> findSubstring(String s, String[] words) {
		int len = words[0].length();

		for (int i = 0; i < s.length() - (len - 1); i++) {
			HashSet<String> set = prepare(words);
			String sub = s.substring(i, i + len);
			if (set.remove(sub)) {
				int j = i + len;
				for (; j < s.length() - (len - 1) && set.isEmpty() == false; j += len) {
					sub = s.substring(j, j + len);
					if (set.remove(sub) == false) {
						break;
					}
				}
				if (set.isEmpty()) {
					ret.add(i);
				}
				i = j - 1;
			}
		}
		return ret;
	}

	HashSet<String> prepare(String[] words) {
		HashSet<String> set = new HashSet<String>();
		for (String s : words) {
			set.add(s);
		}
		return set;
	}

	public int numDecodings(String s) {
		if (s == null || s.isEmpty())
			return 0;
		return numDecodings(s, 0);
	}

	public int numDecodings(String s, int start) {
		if (start >= s.length()) {
			return 1;
		}
		int res = 0;
		for (int i = start; i < start + 2 && i < s.length(); i++) {
			String part = s.substring(start, i + 1);
			int val = Integer.parseInt(part);
			if (part.charAt(0) == '0' || val > 26) {
				break;
			}
			res += numDecodings(s, i + 1);
		}
		return res;
	}

	// public String fractionToDecimal(int numerator, int denominator) {
	// if (numerator == 0) {
	// return "0";
	// }
	// StringBuilder res = new StringBuilder();
	// // "+" or "-"
	// sb.append((num>0) ^ (den >0))? "-":"");
	// long num = Math.abs((long)numerator);
	// long den = Math.abs((long)denominator);
	//
	// // integral part
	// res.append(num / den);
	// num %= den;
	// if (num == 0) {
	// return res.toString();
	// }
	//
	// // fractional part
	// res.append(".");
	// HashMap<Long, Integer> map = new HashMap<Long, Integer>();
	// map.put(num, res.length());
	// while (num != 0) {
	// num *= 10;
	// res.append(num / den);
	// num %= den;
	// if (map.containsKey(num)) {
	// int index = map.get(num);
	// res.insert(index, "(");
	// res.append(")");
	// break;
	// }
	// else {
	// map.put(num, res.length());
	// }
	// }
	// return res.toString();
	// }
	//
	
    public int compareVersion(String version1, String version2) {
        String a[] = version1.split("\\.");
        String b[] = version2.split("\\.");
        int aval = 0;
        int bval = 0;
        for (int i = 0, j = 0; i < a.length || j < b.length; i++, j++) {
            aval = i < a.length? Integer.parseInt(a[i]):0;
            bval = j < b.length? Integer.parseInt(b[j]):0;
            if (aval < bval) {
                return -1;
            } else if (aval > bval) {
                return 1;
            }
        }
        return 0;
    }
	public String multiply(String num1, String num2) {
		char[] a = num1.toCharArray();
		char[] b = num2.toCharArray();
		reverse(a);
		reverse(b);
		char res[] = new char[a.length + b.length];
		Arrays.fill(res, '0');
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				int val = (res[i+j] - '0') + (a[i] - '0') * (b[j] - '0');
				int q = val/10;
				int r = val%10;
				res[i+j] =  (char)('0' + r);
				res[i+j+1] = (char)(('0' + q) + (res[i+j+1] - '0'));
			}
		}
		reverse(res);
		StringBuilder  sb = new StringBuilder();
		int i = 0;
		while (i < res.length) {
			if (res[i] != '0')  {
				break;
			}
			i++;
		}
		for (;i< res.length; i++) {
			sb.append(res[i]);
		}
		if (sb.length() == 0) {
			sb.append('0');
		}
		return sb.toString();
	}

	private void reverse(char[] a) {
		int i = 0;
		int j = a.length - 1;
		while (i < j) {
			char t = a[i];
			a[i] = a[j];
			a[j] = t;
			i++;
			j--;
		}
	}
}
