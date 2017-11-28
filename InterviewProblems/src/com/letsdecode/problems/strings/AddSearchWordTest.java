package com.letsdecode.problems.strings;

import org.junit.Assert;
import org.junit.Test;

public class AddSearchWordTest {

	@Test
	public void test1() {
		AddSearchWord asw = new AddSearchWord();
		asw.addWord("a");
		asw.addWord("ab");
		Assert.assertTrue(asw.search("a"));
		Assert.assertTrue(asw.search("."));
	}

	@Test
	public void test2() {
		AddSearchWord asw = new AddSearchWord();
		asw.addWord("ab");
		asw.addWord("a");
		Assert.assertTrue(asw.search("a"));
	}
	
	@Test
	public void test3() {
		AddSearchWord asw = new AddSearchWord();
		asw.addWord("");
		Assert.assertTrue(asw.search(""));
	}

	@Test
	public void test4() {
		AddSearchWord asw = new AddSearchWord();
		asw.addWord("ab");
		Assert.assertTrue(asw.search(".."));
	}
	@Test
	public void test5() {
		AddSearchWord asw = new AddSearchWord();
		asw.addWord("ab");
		Assert.assertFalse(asw.search(".a"));
		Assert.assertTrue(asw.search("a."));
	}
}
