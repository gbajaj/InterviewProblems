package com.letsdecode.problems.leetcode;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class WordLadderTest {

	@Test
	public void ladderLength() {
		WordLadder wl = new WordLadder();
		String []r ={"hot","dot","dog","lot","log"};
		Set<String> st = new HashSet<>();
		for (String s: r) {
			st.add(s);
		}
		int res = wl.ladderLength("hit", "cog", st);
		System.out.println(res);
	}
}
