package com.letsdecode.problems.maths;

import static org.junit.Assert.*;

import org.junit.Test;

public class HexadecimalTest {

	@Test
	public void test() {
		Hexadecimal h = new Hexadecimal();
		System.out.println(h.toHex(-1));
	}

	@Test
	public void isHappy() {
		Hexadecimal h = new Hexadecimal();
		System.out.println(h.isHappy(23));
	}

}
