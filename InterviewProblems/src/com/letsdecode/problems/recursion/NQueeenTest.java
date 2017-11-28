package com.letsdecode.problems.recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class NQueeenTest {

	@Test
	public void test() {
		long cu = System.currentTimeMillis();
		System.out.println(cu);
		NQueeen nQueeen = new NQueeen(5);
		nQueeen.call();
//		System.out.println(System.currentTimeMillis() - cu);
		System.out.println(nQueeen.count);
	}

}
