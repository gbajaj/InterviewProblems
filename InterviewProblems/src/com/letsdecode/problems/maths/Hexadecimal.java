package com.letsdecode.problems.maths;

import java.util.HashSet;

public class Hexadecimal {
	char []a = {'f', 'e', 'd', 'c', 'b', 'a', '9', '8', '7', '6', '5', '4', '3', '2', '1', '0'};
    public String toHex(int A) {
        long n = A;
        StringBuilder sb= new StringBuilder ();
        if (A < 0) {
            n = -n;
        }
        while (n > 0) {
            long r = n % 16;
            long q = n/16;
            char c = a[(int)(15-r)];
            if (A < 0) {
                c = a[(int)(r - 1)];
            }
            sb.append(c);
            n = q;
        }
        return sb.reverse().toString();
    }
    
    public boolean isHappy(int n) {
        String a = ""+n;
        HashSet<String> m = new HashSet<>();
        while (m.contains(a) == false) {
            int t = 0;
            m.add(a);
            for (char c: a.toCharArray()) {
                t += Math.pow(c  - '0', 2);
            }
            if (t == 1) return true;
            a = "" + t;
        }
        return false;
    }
}
