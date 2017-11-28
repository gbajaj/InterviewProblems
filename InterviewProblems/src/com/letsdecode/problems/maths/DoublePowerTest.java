package com.letsdecode.problems.maths;

import org.junit.Assert;
import org.junit.Test;

public class DoublePowerTest {

	@Test
	public void testPow1() {
		DoublePower dp = new DoublePower();

		double res = dp.pow1(2.0, 3);
		double expected = 8.0;
		Assert.assertEquals(expected, res, 0.001);

		res = dp.pow1(2.0, 0);
		expected = 1;
		Assert.assertEquals(expected, res, 0.001);

		res = dp.pow1(2.0, 1);
		expected = 2.0;
		Assert.assertEquals(expected, res, 0.001);

		res = dp.pow1(2.0, 20);
		expected = 1048576.0;
		Assert.assertEquals(expected, res, 0.001);

		res = dp.pow1(2.0, -3);
		expected = 0.125;
		Assert.assertEquals(expected, res, 0.001);

		res = dp.pow1(2.0, -1);
		expected = 0.5;
		Assert.assertEquals(expected, res, 0.001);
	}

	@Test
	public void testPow2() {
		DoublePower dp = new DoublePower();

		double res = dp.pow2(2.0, 3);
		double expected = 8.0;
		Assert.assertEquals(expected, res, 0.001);

		res = dp.pow2(2.0, 0);
		expected = 1;
		Assert.assertEquals(expected, res, 0.001);

		res = dp.pow2(2.0, 1);
		expected = 2.0;
		Assert.assertEquals(expected, res, 0.001);

		res = dp.pow2(2.0, 20);
		expected = 1048576.0;
		Assert.assertEquals(expected, res, 0.001);

		res = dp.pow2(2.0, -3);
		expected = 0.125;
		Assert.assertEquals(expected, res, 0.001);

		res = dp.pow2(2.0, -1);
		expected = 0.5;
		Assert.assertEquals(expected, res, 0.001);
	}

	@Test
	public void testPowIterative() {
		DoublePower dp = new DoublePower();

		double res = dp.powIterative(2.0, 3);
		double expected = 8.0;
		Assert.assertEquals(expected, res, 0.001);

		res = dp.powIterative(2.0, 0);
		expected = 1;
		Assert.assertEquals(expected, res, 0.001);

		res = dp.powIterative(2.0, 1);
		expected = 2.0;
		Assert.assertEquals(expected, res, 0.001);

		res = dp.powIterative(2.0, 20);
		expected = 1048576.0;
		Assert.assertEquals(expected, res, 0.001);

		res = dp.powIterative(2.0, -3);
		expected = 0.125;
		Assert.assertEquals(expected, res, 0.001);

		res = dp.powIterative(2.0, -1);
		expected = 0.5;
		Assert.assertEquals(expected, res, 0.001);
	}
	
	@Test
	public void testpowEPI() {
		DoublePower dp = new DoublePower();

		double res = dp.powEPI(2.0, 3);
		double expected = 8.0;
		Assert.assertEquals(expected, res, 0.001);

		res = dp.powEPI(2.0, 0);
		expected = 1;
		Assert.assertEquals(expected, res, 0.001);

		res = dp.powEPI(2.0, 1);
		expected = 2.0;
		Assert.assertEquals(expected, res, 0.001);

		res = dp.powEPI(2.0, 20);
		expected = 1048576.0;
		Assert.assertEquals(expected, res, 0.001);

		res = dp.powEPI(2.0, -3);
		expected = 0.125;
		Assert.assertEquals(expected, res, 0.001);

		res = dp.powEPI(2.0, -1);
		expected = 0.5;
		Assert.assertEquals(expected, res, 0.001);
	}


	public static void printSuccessFailure(double expected, double res) {
		if (expected == res) {
			success();
		} else {
			fail();
		}
	}

	public static void fail() {
		System.out.println("failed");
	}

	public static void success() {
		System.out.println("success");
	}

}
