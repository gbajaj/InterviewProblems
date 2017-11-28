package com.letsdecode.problems.stack;

import java.util.Stack;

@SuppressWarnings("serial")
public class MinStack extends Stack<Integer> {
	Stack<Integer> minStack = new Stack();

	public void push(int val) {
		if (minStack.isEmpty()) {
			minStack.push(val);
		} else {
			if (val <= minStack.peek()) {
				minStack.push(val);
			}
		}
		
		super.push(val);
	}
	
	@Override
	public Integer pop() {
		Integer val = super.pop();
		if (val.equals(minStack.peek())) {
			minStack.pop();
		}
		return val;
	}

	public Integer getMin() {
		return minStack.peek();
	}
}
