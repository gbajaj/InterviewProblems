package com.letsdecode.problems.maths;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerProblensTest {

	@Test
	public void test() {
		new IntegerProblens().reverse(-2147483648);
	}

	@Test
	public void myAtoi() {
//		new IntegerProblens().myAtoi("");
//		new IntegerProblens().myAtoi("0");
//		new IntegerProblens().myAtoi("123");
		System.out.println(new IntegerProblens().myAtoi("2147483648"));
		
	}

	@Test
	public void divide() {
		System.out.println(new IntegerProblens().divide(-2147483648,-1));
		
	}

	@Test
	public void largestNumber() {
		int a [] = {3, 30, 34, 5, 9};
		System.out.println(new IntegerProblens().largestNumber(a));
		
	}

	@Test
	public void reverseBits() {
		
		System.out.println(new IntegerProblens().reverseBits(1));
		
	}
	@Test
	public void hammingWeight() {
		
		System.out.println(new IntegerProblens().hammingWeight(15));
		
	}

	@Test
	public void isHappy() {
		System.out.println(new IntegerProblens().isHappy(19));
	}
	
}
