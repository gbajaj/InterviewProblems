package com.letsdecode.problems.recursion;

import org.junit.Assert;
import org.junit.Test;

public class PossibleNumberOfTreesTest {

	@Test
	public void test() {
		PossibleNumberOfTrees possibleNumberOfTrees = new PossibleNumberOfTrees(
				1);
		possibleNumberOfTrees.call();
		Assert.assertEquals(1, possibleNumberOfTrees.res);
		
		possibleNumberOfTrees = new PossibleNumberOfTrees(
				2);
		possibleNumberOfTrees.call();
		Assert.assertEquals(2, possibleNumberOfTrees.res);
		
		possibleNumberOfTrees = new PossibleNumberOfTrees(
				3);
		possibleNumberOfTrees.call();
		Assert.assertEquals(5, possibleNumberOfTrees.res);

		possibleNumberOfTrees = new PossibleNumberOfTrees(
				4);
		possibleNumberOfTrees.call();
		Assert.assertEquals(14, possibleNumberOfTrees.res);

	}

}
