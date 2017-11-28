package com.letsdecode.problems.epi.chapter13;

import static org.junit.Assert.*;

import java.net.Socket;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PartiionIntoAnagramsTest {

	@Test
	public void test() {
		String [] s={ "debitcard", "elvis", "silent", "lives", "freedom", "listen"};
		String [] []expected ={ {"debitcard"}, {"freedom"}, {"listen","silent"}, {"elvis","lives"}};
//		String [] s={ "elvis", "lives"};
//		String [] s={ "", ""};
		List<List<String>>res = new PartiionIntoAnagrams().groupAnagrams(s);
		String [][]resA = new String [res.size()][];
		int i = 0;
		for (List<String> t: res) {
			resA[i] = new String[t.size()];
			int j  = 0;
			for (String tt: t) {
				resA[i][j] = tt;
				j++;
			}
			i++;
		}
		Assert.assertArrayEquals(expected, resA);
		
	}

}
