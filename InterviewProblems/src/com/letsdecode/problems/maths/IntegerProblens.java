package com.letsdecode.problems.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class IntegerProblens {
	public int reverse(int x) {
		boolean neg = false;
		long l = x;
		if (x < 0) {
			neg = true;
			l *= -1;
		}
		long ret = 0;
		long max = Integer.MAX_VALUE;
		long min = max += 1;
		while (l != 0) {
			long pre = ret;
			ret = (ret * 10) + l % 10;
			if (neg && ret > min || ret > max) {
				ret = pre;
				break;
			}
			l /= 10;
		}
		if (neg) {
			ret *= -1;
		}
		return (int) ret;
	}

	public int myAtoi(String str) {
		if (str == null)
			return 0;
		str = str.trim();
		if (str.isEmpty())
			return 0;
		boolean neg = false;
		if (str.charAt(0) == '-') {
			str = str.substring(1);
			neg = true;
		} else if (str.charAt(0) == '+') {
			str = str.substring(1);
		}
		char[] a = str.toCharArray();
		long ret = 0;
		for (int i = 0; i < a.length; i++) {
			char ch = a[i];
			if (Character.isDigit(ch) == false)
				break;
			long temp = ret * 10 + ch - '0';
			if (neg && temp > ((long) Integer.MAX_VALUE + 1)) {
				ret = ((long) Integer.MAX_VALUE + 1);
				break;
			} else if (neg == false && temp > ((long) Integer.MAX_VALUE)) {
				ret = Integer.MAX_VALUE;
				break;
			}
			ret = temp;
		}
		if (neg) {
			ret *= -1;
		}
		return (int) ret;
	}

	public int divide(int dividend_, int divisor_) {
		long ans = 0;
		long dividend = Math.abs((long)dividend_);
		long divisor = Math.abs((long)divisor_);
		while (dividend >= divisor) {
			long a = divisor;
			long m = 1;
			while ((a << 1) <= dividend) {
				a <<= 1;
				m <<= 1;
			}
			ans +=m;
			dividend-=a;
		}

		if ((dividend_ < 0 && divisor_ >= 0)
				|| (dividend_ >= 0 && divisor_ <= 0)) {
            if (ans > ((long)(Integer.MAX_VALUE) + 1)) {
                return Integer.MIN_VALUE;
            }
			return (int) -ans;
		}
		if (ans > ((long)(Integer.MAX_VALUE))) {
            return Integer.MAX_VALUE;
        }
		return (int) ans;
	}
	
	public String largestNumber(int[] nums) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i : nums) {
            a.add(i);
        }
        Collections.sort(a, new Comparator<Integer>() {
          public int compare(Integer ob1, Integer ob2) {
              String v1 = ob1.toString() + ob2.toString();
              String v2 = ob2.toString() + ob1.toString();
              long a1 = Long.parseLong(v1);
              long a2 = Long.parseLong(v2);
              if (a1 > a2) {
                  return -1;
              } else if (a2 > a1){
                  return 1;
              }
              return 0;
          }  
        });
        
        StringBuilder sb = new StringBuilder();
        for (int i: a) {
            sb.append(i);
        }
        return sb.toString();
    }
	
	 int rev[] =  {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
	    // you need treat n as an unsigned value
	    public int reverseBits(int n) {
	        int res = revese16((n>>>16) & 0xFFFF)|(revese16(n&0xFFFF) <<16); 
	        return res;
	    }
	    
	    public int revese16(int n) {
	        return reverse8((n>>>8) & 0XFF)|(reverse8(n & 0xff) <<8);
	    }
	    
	    public int reverse8(int n) {
	        return rev[((n>>>4) & 0xF)]| (rev[n & 0xF] <<4); 
	    }
	    int c [] = {0, 1, 1, 2, 1, 2, 2,3,1,2,2,3,2, 3,3,4};
	    // you need to treat n as an unsigned value
	    public int hammingWeight(int n) {
	        return hammingWeight16((n>>>16) & 0xffff)+ hammingWeight16(n & 0xffff);
	    }

	    public int hammingWeight16(int n) {
	        return hammingWeight8((n>>>8) & 0xff) + 
	        hammingWeight8(n & 0xff);
	    }

	    public int hammingWeight8(int n) {
	        return c[(n >>> 4) & 0xf] + c[n & 0xf];
	    }
	    
	    private HashSet<Integer> s = new HashSet<>();

	    public boolean isHappy(int n) {
	        if (n == 0) return false;
	        while (s.contains(n) == false) {
	        	if (n == 1) return true;
	        	s.add(n);
	            n = getSq(n);
	        }
	        return n == 1;
	    }
	    
	    private int getSq(int n) {
	        int sum = 0;
	        while (n > 0) {
	            int r = n %10;
	            n = n / 10;
	            sum += r*r;
	        }
	        return sum;
	    }
	    
	    
}

