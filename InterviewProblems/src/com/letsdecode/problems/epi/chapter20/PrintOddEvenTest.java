package com.letsdecode.problems.epi.chapter20;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrintOddEvenTest {

	@Test
	public void test() {
		new PrintOddEven().print();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
