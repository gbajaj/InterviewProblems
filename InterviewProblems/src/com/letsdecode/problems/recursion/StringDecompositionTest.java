package com.letsdecode.problems.recursion;

import org.junit.Test;

public class StringDecompositionTest {

	@Test
	public void test() {
		StringDecomposition stringDecomposition = new StringDecomposition("abracadabra");
		stringDecomposition.call();
		System.out.println(stringDecomposition.getResult());
	}

}
