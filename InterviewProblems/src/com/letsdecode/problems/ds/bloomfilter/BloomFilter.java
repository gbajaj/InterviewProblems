package com.letsdecode.problems.ds.bloomfilter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;

//http://www.maxburstein.com/blog/creating-a-simple-bloom-filter/

public class BloomFilter {
	private static final int MAX_SIZE = 100;
	private final byte[] a = new byte[MAX_SIZE];
	BitSet bitset = new BitSet(2063);
	private static final long HMULT = 7664345821815920749L;
	private MessageDigest hasher;
	int HASH_COUNT = 3;
	int primes[] = { 2, 3, 5 };

	public BloomFilter() {

		try {
			hasher = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void add(String word) {
		for (int i = 0; i < HASH_COUNT; i++) {
			int hash = hash(word + primes[i]);
			hash = Math.abs(hash);
			bitset.set(hash % 2063);
		}
	}
	

	public boolean contains(String word) {
		for (int i = 0; i < HASH_COUNT; i++) {
			int hash = hash(word + primes[i]);
			hash = Math.abs(hash);
			if (bitset.get(hash % 2063) == false) {
				return false;
			}
		}
		return true;
	}

	int hash(String word) {
		hasher.update(word.getBytes(), 0, word.length());
		byte[] hashBytes = hasher.digest();
		int h = 0;
		for (int i = 0; i < hashBytes.length; i++) {
			h ^= (int) ((0xff & hashBytes[i]) * HMULT);
		}
		hasher.reset();
		return h;
	}
}
