package com.letsdecode.problems.maths;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class DoublePower {
	public double pow1(double d, int p) {
		boolean neg = false;
		if (p < 0) {
			p *= -1;
			neg = true;
		}
		if (p == 0) {
			return 1;
		}
		double res = d;
		res = d * powHelper1(d, p - 1);

		if (neg) {
			res = 1 / res;
		}
		return res;
	}

	private double powHelper1(double d, int p) {
		if (p == 0) {
			return 1;
		}
		return d * powHelper1(d, p - 1);
	}

	public double pow2(double d, int p) {
		double res = powHelper2(d, Math.abs(p));
		if (p < 0) {
			return 1 / res;
		}
		return res;
	}

	private double powHelper2(double d, int p) {
		if (p == 0) {
			return 1;
		}
		double res = d;
		if (p == 1) {
			return res;
		} else if (p % 2 == 0) {
			res = powHelper2(d, p / 2);
			res *= res;
		} else {
			res = powHelper2(d, (p - 1) / 2);
			res *= res * d;
		}
		return res;
	}

	public double powIterative(double d, int p) {
		if (p == 0) {
			return 1;
		}

		int abs = Math.abs(p);
		double res = d;
		while (abs > 1) {
			res *= d;
			abs--;
		}

		if (p < 0) {
			return 1 / res;
		}
		return res;
	}

	public double powEPI(double x, int y) {
		double result = 1.0;
		long power = y;
		if (y < 0) {
			power = -power;
			x = 1.0 / x;
		}
		while (power != 0) {
			if (power % 2 == 1) {
				// for odd number just multiple with base
				result *= x;
			}
			//
			x *= x;
			power >>= 1;
		}
		return result;
	}
}
