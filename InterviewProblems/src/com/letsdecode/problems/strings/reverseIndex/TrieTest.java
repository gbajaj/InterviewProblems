package com.letsdecode.problems.strings.reverseIndex;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class TrieTest {

	@Test
	public void test() {
		Trie trie = new Trie();
		Assert.assertTrue(trie.serch("abc") == null);// Test empty trie

		trie.getNode("gaurav");
		Assert.assertTrue(trie.serch("abc") == null);// test Not found

		trie.getNode("gaurav");
		Assert.assertTrue(trie.serch("gaurav") != null);// test found

		trie.getNode("gaurav");
		Assert.assertTrue(trie.serch("gau") != null);// test prefix Found

	}

	@Test
	public void testPositions() {
		Trie trie = new Trie();
		String items [] = {"The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
		int pos = 0;
		for (String item : items){ 
			trie.getNode(item).positions.add(pos);
			pos++;
		}
		Assert.assertTrue(trie.serch("The").positions.get(0) == 0);
		Assert.assertTrue(trie.serch("quick").positions.get(0) == 1);
		Assert.assertTrue(trie.serch("fox").positions.get(0) == 3);
		Assert.assertTrue(trie.serch("dog").positions.get(0) == 8);
	}
	
	@Test
	public void printPositions() {
		Trie trie = new Trie();
		String items [] = {"us", "use", "uses", "used", "user", "users", "using", "useful", "username", "user", "utah"};
		int pos = 0;
		for (String item : items){ 
			trie.getNode(item).positions.add(pos);
			pos++;
		}
		
		trie.print(trie, "");
		
	}
	
	
	

}
