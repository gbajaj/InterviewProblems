package com.letsdecode.problems.stack;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class MinStackTest {

	@Test
	public void test() {
		MinStack ms = new MinStack();
//		ms.push(15);
//		Assert.assertEquals(ms.getMin().intValue(), 15);
//		ms.push(10);
//		Assert.assertEquals(ms.getMin().intValue(), 10);
//		ms.push(12);
//		Assert.assertEquals(ms.getMin().intValue(), 10);
//		ms.push(8);
//		Assert.assertEquals(ms.getMin().intValue(), 8);
//		ms.push(3);
//		Assert.assertEquals(ms.getMin().intValue(), 3);
//		ms.pop();
//		Assert.assertEquals(ms.getMin().intValue(), 8);

		ms.push(512);
		ms.push(-1024);
		ms.push(-1024);
		ms.push(512);
		
		System.out.println(ms.pop()); //512
		System.out.println(ms.getMin());//-1024
		System.out.println(ms.pop());////-1024
		System.out.println(ms.getMin());//-1024
		System.out.println(ms.pop());//-1024
		System.out.println(ms.getMin());//512
	}

}
