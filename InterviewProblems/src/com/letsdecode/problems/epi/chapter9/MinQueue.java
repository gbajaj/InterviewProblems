package com.letsdecode.problems.epi.chapter9;

import java.util.Stack;

class MinStack extends Stack<Integer> {
	private Stack<Integer> minStack = new Stack<>();

	public void push(int val) {
		if (minStack.isEmpty()) {
			minStack.push(val);
		} else {
			
			if (minStack.peek() >= val) {
				minStack.push(val);
			}
		}
		super.push(val);
	}

	public Integer pop() {
		//Current stack's top is the smallest element
		if (top() <= getMin()) {
			minStack.pop();
		}
		return super.pop();
	}

	public Integer top() {
		return peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
