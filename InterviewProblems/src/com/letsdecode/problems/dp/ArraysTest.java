package com.letsdecode.problems.dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArraysTest {

	@Test
	public void houseRobber() {
//		, 50, 90, 40, 7, 10
		int a [] = {10, 15, 9, 50, 90, 40, 7, 10};
		int res = new Arrays().houseRobber(a, 0);
		System.out.println(res);
	}

	@Test
	public void houseRobberDP() {
//		, 50, 90, 40, 7, 10
		int a [] = {10, 15, 9, 50, 90, 40, 7, 10};
		int res = new Arrays().houseRobberDP(a);
		System.out.println(res);
	}

	@Test
	public void houseRobberVariables() {
		int a [] = {10, 15, 9, 50, 90, 40, 7, 10};
		int res = new Arrays().houseRobberVariables(a);
		System.out.println(res);
	}

	@Test
	public void houseRobberABMax() {
		int a [] = {10, 15, 9, 50, 90, 40, 7, 10};
		int res = new Arrays().houseRobberABMax(a);
		System.out.println(res);
	}

	@Test
	public void houseRobberTwo_ABMax() {
		int a [] = {10, 15, 9, 50, 90, 40, 7, 10};
		int res = new Arrays().houseRobberTwo_ABMax(a);
		System.out.println(res);
	}

	@Test
	public void houseRobberTwoRec() {
		int a [] = {10, 15, 9, 50, 90, 40, 7, 10};
		int res = new Arrays().houseRobberTwoRec(a);
		System.out.println(res);
	}

	@Test
	public void houseRobberTwo_ABSmarter() {
		int a [] = {10};
		int res = new Arrays().houseRobberTwo_ABSmarter(a);
		System.out.println(res);
	}

}
