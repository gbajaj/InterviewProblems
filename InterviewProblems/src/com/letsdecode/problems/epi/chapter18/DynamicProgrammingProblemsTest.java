package com.letsdecode.problems.epi.chapter18;

import org.junit.Test;

public class DynamicProgrammingProblemsTest {

	@Test
	public void test() {
		DynamicProgrammingProblems dynamicProgrammingProblems = new DynamicProgrammingProblems();
		int a[] = { 2, 3, 7 };
		int comb[] = { 0, 0, 0 };
		int count = dynamicProgrammingProblems.combinations(12, a, comb);
		System.out.println("ways " + count);
		for (int i = 0; i < comb.length; i++) {
			int j = comb[i];
			switch (i) {
			case 0:
				System.out.println(j + " saftey");
				break;
			case 1:
				System.out.println(j + " field goals");
				break;
			case 2:
				System.out.println(j + " touch down");
				break;
			default:
				break;
			}
		}
	}

	@Test
	public void ampleCity() {
		int[] gas = { 65, 45, 10, 45, 25, 20, 15, 15, 15, 35, 25, 30, 15 };
		int[] miles = { 400, 1000, 200, 300, 300, 300, 400, 1000, 300, 300,
				600, 400, 1100 };
		DynamicProgrammingProblems dpp = new DynamicProgrammingProblems();
		dpp.ampleCity(gas, miles);
	}

}
