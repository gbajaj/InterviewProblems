package com.letsdecode.problems.epi.chapter7;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.letsdecode.problems.strings.StringQuestions;

public class StringProblemsTest {

	@Test
	public void test() {
		StringProblems stringProblems = new StringProblems();
		Assert.assertEquals(0, stringProblems.stringtoInteger(null));
		Assert.assertEquals(0, stringProblems.stringtoInteger(""));
		Assert.assertEquals(0, stringProblems.stringtoInteger(" "));
		Assert.assertEquals(0, stringProblems.stringtoInteger("-"));
		Assert.assertEquals(0, stringProblems.stringtoInteger("+"));
		Assert.assertEquals(1, stringProblems.stringtoInteger("1"));
		Assert.assertEquals(-1, stringProblems.stringtoInteger("-1"));
		Assert.assertEquals(-12, stringProblems.stringtoInteger("  -0012a42"));
		Assert.assertEquals(2147483647,
				stringProblems.stringtoInteger("2147483648"));
		Assert.assertEquals(-2147483648,
				stringProblems.stringtoInteger("-2147483648"));

		// System.out.println(stringProblems.stringtoInteger("2147483648"));
	}

	@Test
	public void removeAndReplace() {
		StringProblems sp = new StringProblems();
		Assert.assertEquals("dd", sp.removeAndReplace("a "));
		Assert.assertEquals("c", sp.removeAndReplace("c"));
		Assert.assertEquals("ddc", sp.removeAndReplace("ddc"));
	}
	
	@Test
	public void addBinary() {
		StringProblems sq = new StringProblems();		
		System.out.println(sq.addBinary("1", "1"));
	}

	@Test
	public void justify() {
		String a[] = {"a", "b", "c", "d", "e"};
//		String a[] = {""};
		StringProblems sq = new StringProblems();		
		System.out.println(sq.fullJustify(a, 3));
	}

	@Test
	public void findSubstring() {
		String a = "barfoothefoobar";
		String dic[] = {"foo", "bar"};
		StringProblems sq = new StringProblems();		
		System.out.println(sq.findSubstring(a, dic));
	}

	@Test
	public void numDecodings() {
		StringProblems sq = new StringProblems();		
		System.out.println(sq.numDecodings("1201"));
	}

//	@Test
//	public void fractionToDecimal() {
//		new StringProblems().fractionToDecimal(1, 6);
//	}

	@Test
    public void compareVersion() {
		new StringProblems().compareVersion("1", "0");
    }
	
	@Test
	public void multiply() {
//		Assert.assertEquals("0", new StringProblems().multiply("", ""),"0");
//		Assert.assertEquals("9", new StringProblems().multiply("3", "3"));
//		Assert.assertEquals("9801", new StringProblems().multiply("99", "99"));
		Assert.assertEquals("56088", new StringProblems().multiply("123", "456"));
	}
}
