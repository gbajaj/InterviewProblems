package com.letsdecode.problems.strings;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.letsdecode.problems.epi.chapter7.StringProblems;

public class StringQuestionsTest {

	@Test
	public void test() {
		new StringQuestions().snakePrinting("Google Worked");
	}

	@Test
	public void testInterleaving() {
		new StringQuestions().interleavings("", "ABC");
	}

	@Test
	public void isInterleaving() {
		System.out.println(new StringQuestions().isInterleaving("abc", "xyz",
				"abcxyz"));
	}

	@Test
	public void isInterleavingDP() {
		System.out.println(new StringQuestions().isInterleavingDP("aa", "ab",
				"aaba"));
	}

	@Test
	public void isInterleav() {
		Long l = new Long(23445555);
		Long d = new Long(232343453);
		System.out.println((int) (l - d));
	}

	@Test
	public void convertRomanToInteger() {
		StringQuestions sq = new StringQuestions();
		Assert.assertEquals(4, sq.convertRomanToInteger("IIII"));
		Assert.assertEquals(5, sq.convertRomanToInteger("V"));
		Assert.assertEquals(4, sq.convertRomanToInteger("IV"));
		Assert.assertEquals(10, sq.convertRomanToInteger("X"));
		Assert.assertEquals(90, sq.convertRomanToInteger("LXXXX"));
		Assert.assertEquals(140, sq.convertRomanToInteger("CXXXX"));
		Assert.assertEquals(59, sq.convertRomanToInteger("LIX"));

	}

	@Test
	public void repeatedSubstringPattern() {
		StringQuestions sq = new StringQuestions();
		System.out.println(sq.repeatedSubstringPattern("abab"));
	}

	@Test
	public void countAndSay() {
		StringQuestions sq = new StringQuestions();
		System.out.println(sq.countAndSay(3));
	}

	@Test
	public void isValid() {
		StringQuestions sq = new StringQuestions();
		System.out.println(sq.isValid("[]"));
	}

	@Test
	public void lengthOfLongestSubstring() {
		StringQuestions sq = new StringQuestions();
		System.out.println(sq.lengthOfLongestSubstring("tmmzuxt"));
	}

	@Test
	public void longestPalindrome() {
		StringQuestions sq = new StringQuestions();
		System.out.println(sq.longestPalindrome("dabad"));
		System.out.println(sq.longestPalindrome("cbbd"));
		System.out.println(sq.longestPalindrome("babad"));

	}

	@Test
	public void minWindow() {
		StringQuestions sq = new StringQuestions();
		System.out.println(sq.minWindow("ADOBECODEBANC", "ABC"));

	}

	@Test
	public void strStr() {
		StringQuestions sq = new StringQuestions();
		System.out.println(sq.strStr("abc", "bc"));

	}

	@Test
	public void compareVersion() {
		StringQuestions sq = new StringQuestions();
		System.out.println(sq.compareVersion("1", "0"));

	}

	@Test
	public void countSegments() {
		StringQuestions sq = new StringQuestions();
		System.out.println(sq.countSegments("        Foo     bar"));
		// System.out.println(sq.countSegments(", , , ,        a, eaefa"));
	}

	@Test
	public void findAnagrams() {
		StringQuestions sq = new StringQuestions();
		System.out.println(sq.findAnagrams("baa", "aa"));
	}

	@Test
	public void wordPattern() {
		StringQuestions sq = new StringQuestions();
		System.out.println(sq.wordPattern("abb", "b c d"));
	}

	@Test
	public void getHint() {
		StringQuestions sq = new StringQuestions();
		System.out.println(sq.getHint("11", "10"));
	}

	@Test
	public void isMatch() {
		StringQuestions sq = new StringQuestions();
		// System.out.println(sq.isMatch("aa", "a*"));
		// System.out.println(sq.isMatch("aa", ".*"));
		// System.out.println(sq.isMatch("ab", ".*"));
		System.out.println(sq.isMatch("ab", ".*c"));

	}

	@Test
	public void fullJustify() {
		// String []s = {"aaaaaaaaaaaaaaaa", "This", "is", "an", "example",
		// "of", "text", "justification."};//16
		// String []s = {""}; //2
		// String []s = {"a","b","c","d","e"};//3
		// String[] s = { "What", "must", "be", "shall", "be." }; // 12
//		String[] s = { "Listen", "to", "many,", "speak", "to", "a", "few." };// 66
		String[] s = {"Here","is","an","example","of","text","justification."};//16

		StringQuestions sq = new StringQuestions();
		System.out.println(sq.fullJustify(s, 16));

	}

	@Test
	public void decodeString() {
		StringQuestions sq = new StringQuestions();		
//		System.out.println(sq.decodeString("abc"));
//		System.out.println(sq.decodeString("3[abc]"));
//		System.out.println(sq.decodeString("3[abc3[a]]"));
//		System.out.println(sq.decodeString("3[a]2[bc]"));
//		System.out.println(sq.decodeString("3[a2[c]]"));
		System.out.println(sq.decodeString("2[abc]3[cd]ef"));
		
		
		

	}
	@Test
	public void restoreIpAddresses() {
		StringQuestions sq = new StringQuestions();		
//		System.out.println(sq.decodeString("abc"));
//		System.out.println(sq.decodeString("3[abc]"));
//		System.out.println(sq.decodeString("3[abc3[a]]"));
//		System.out.println(sq.decodeString("3[a]2[bc]"));
//		System.out.println(sq.decodeString("3[a2[c]]"));
		System.out.println(sq.restoreIpAddresses("172162541"));
	}

	@Test
	public void simplifyPath() {
		StringQuestions sq = new StringQuestions();		
//		System.out.println(sq.simplifyPath("../../"));
//		System.out.println(sq.simplifyPath("../././"));
//		System.out.println(sq.simplifyPath("./"));
		System.out.println(sq.simplifyPath("/abc./..."));
		
	}
	@Test
	public void partition() {
		StringQuestions sq = new StringQuestions();		
//		System.out.println(sq.simplifyPath("../../"));
//		System.out.println(sq.simplifyPath("../././"));
//		System.out.println(sq.simplifyPath("./"));
		System.out.println(sq.partition("cdd"));
		
		
	}

	
	
	
	
}
