package ListAndQueues;

import org.junit.Assert;
import org.junit.Test;

public class SkipListTest {

	@Test
	public void testInsert() {
		int a [] = {4, 6, 19, 56, 67, 96, 123, 456, 789, 987};
		SkipList skipList = new SkipList();
		for(int  i = 0; i <  a.length; i++) {
			skipList.insert(a[i]);
		}
		skipList.printValues();
	}
	
	@Test
	public void testContains() {
		int a [] = {4, 6, 19, 56, 67, 96, 123, 456, 789, 987};
		SkipList skipList = new SkipList();
		for(int  i = 0; i <  a.length; i++) {
			skipList.insert(a[i]);
		}
		Assert.assertTrue(skipList.contains(96));
		Assert.assertFalse(skipList.contains(33));
	}

	
	@Test
	public void testRemove() {
		int a [] = {4, 6, 19, 56, 67, 96, 123, 456, 789, 987};
		SkipList skipList = new SkipList();
		for(int  i = 0; i <  a.length; i++) {
			skipList.insert(a[i]);
		}
		Assert.assertTrue(skipList.contains(96));
		Assert.assertFalse(skipList.remove(96));
		Assert.assertFalse(skipList.contains(96));
	}

}
