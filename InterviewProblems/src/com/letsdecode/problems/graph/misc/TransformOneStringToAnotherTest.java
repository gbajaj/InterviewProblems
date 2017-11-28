package com.letsdecode.problems.graph.misc;

import java.util.HashSet;

import org.junit.Test;

public class TransformOneStringToAnotherTest {

	@Test
	public void test() {
		HashSet<String> set = buildDic();
		TransformOneStringToAnother toAnother = new TransformOneStringToAnother(
				"cat", "hen", set);
		System.out.println(toAnother.productionSequence());
	}

	HashSet<String> buildDic() {
		HashSet<String> set = new HashSet<String>();
		set.add("cat");
		set.add("cal");
		set.add("bal");
		set.add("hal");
		set.add("hel");
		set.add("hat");
		set.add("pen");
		set.add("hen");
		return set;
	}
}
