package com.letsdecode.problems.leetcode;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.omg.Messaging.SyncScopeHelper;

public class HeapRelatedQuestionsTest {

	@Test
	public void testtopKFrequent() {
		int a[] = { 1, 1, 1, 2, 2, 3 };
		List<Integer> res = new HeapRelatedQuestions().topKFrequent(a, 2);
		print(res);

	}

	private void print(List<Integer> a) {
		System.out.println("");
		for (Integer i : a) {
			System.out.print(i + " ");
		}

	}
}
