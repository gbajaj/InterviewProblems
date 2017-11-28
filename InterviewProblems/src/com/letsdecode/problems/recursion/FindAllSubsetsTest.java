package com.letsdecode.problems.recursion;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FindAllSubsetsTest {

	@Test
	public void test() {
		// char[] a = { '1', '2', '3' };
		// FindAllSubsets findAllSubsets = new FindAllSubsets(a);
		// findAllSubsets.call();
		// ArrayList<String> out = findAllSubsets.getResult();
		// String[] s = out.toArray(new String[out.size()]);
		// String[] expected = { "{123}", "{12}", "{13}", "{1}", "{23}", "{2}",
		// "{3}", "{}" };
		// Assert.assertArrayEquals(expected, s);

		int[] a = { 4, 1, 0 };
		FindAllSubsets findAllSubsets = new FindAllSubsets(a);
		findAllSubsets.call();
		List<List<Integer>> out = findAllSubsets.getResult();
//		int [][] s = out.toArray(new int[out.size()]);
		int[][] expected = { { 1, 2, 3 }, { 1, 2 }, { 1, 3 }, { 1 }, { 2, 3 },
				{ 2 }, { 3 }, {} };
//		Assert.assertArrayEquals(expected, s);

	}

}
