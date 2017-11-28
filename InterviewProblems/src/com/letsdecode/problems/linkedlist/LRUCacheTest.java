package com.letsdecode.problems.linkedlist;

import org.junit.Test;

public class LRUCacheTest {

	@Test
	public void test() {
		LRUCache lru = new LRUCache(10);
		lru.set(0,0);
		System.out.println(lru.get(0));
		lru.set(2,2);
		lru.set(1,1);
		lru.set(1,1);
		lru.set(2,2);
		System.out.println(lru.get(1));
	}

}
