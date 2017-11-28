package com.letsdecode.problems.recursion;

import static org.junit.Assert.*;

import org.junit.Test;

import sun.org.mozilla.javascript.internal.json.JsonParser.ParseException;

public class BuildTreeForDiameterTest {

	@Test
	public void test() {
		try {
			new BuildTreeForDiameter("{{0,0}\",0}").call();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// fail("Not yet implemented");
	}

}
