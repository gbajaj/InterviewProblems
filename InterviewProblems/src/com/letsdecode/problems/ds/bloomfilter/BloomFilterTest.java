package com.letsdecode.problems.ds.bloomfilter;

import java.util.HashSet;

import org.junit.Test;

public class BloomFilterTest {

	@Test
	public void testBloom() {
		BloomFilter bloomFilter = new BloomFilter();
		long start = System.currentTimeMillis();
		String abc = "abc";
		for (int i = 0; i < 1000; i++) {
			for (int j = 'a'; j <= 'z'; j++) {
				bloomFilter.add(abc + (char) (j));
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("Bloom: " + (end - start));
	}

	@Test
	public void testMap() {
		HashSet<String> container = new HashSet<>();
		long start = System.currentTimeMillis();
		String abc = "abc";
		for (int i = 0; i < 1000; i++) {
			for (int j = 'a'; j <= 'z'; j++) {
				container.add(abc + (char) (j));
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("Set : " + (end - start));
	}

}
