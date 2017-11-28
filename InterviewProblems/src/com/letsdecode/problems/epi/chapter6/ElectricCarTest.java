package com.letsdecode.problems.epi.chapter6;

import org.junit.Test;

public class ElectricCarTest {

	@Test
	public void test() {
		final ElectricCar electricCar = new ElectricCar();
		int []a ={8, 1, 15, 3, 25};
		System.out.println(electricCar.findCapacity(a));
	}

}
