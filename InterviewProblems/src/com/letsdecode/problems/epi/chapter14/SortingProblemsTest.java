package com.letsdecode.problems.epi.chapter14;

import static org.junit.Assert.*;

import javax.xml.soap.SOAPException;

import org.junit.Test;

public class SortingProblemsTest {

	@Test
	public void testIntersection() {
		SortingProblems s = new SortingProblems();
		String a[] = { "abc", "abr", "qrs", "xyz" };
		String b[] = { "abc", "qrs" };
		System.out.println(s.intersectionOfArrays(a, b));

	}

}
