package com.letsdecode.problems.recursion;

import org.junit.Test;

public class WildCharTest {


	@Test
	public void emptyInput() {
		new WildChar("", '?').call();
	}


	@Test
	public void onlyWildChar() {
		new WildChar("?", '?').call();
	}

	@Test
	public void noWildChar() {
		new WildChar("001", '?').call();
	}
	
	@Test
	public void test1() {
		new WildChar("10?", '?').call();
	}

	@Test
	public void test2() {
		new WildChar("1?0?", '?').call();
	}

}
