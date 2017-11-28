package com.letsdecode.problems.cuncurrency.racecondtion;



public class TestRaceCondition {
	volatile long val = 0;

	public synchronized void inc() {
		val += 1;
	}

	public synchronized  void dec() {
		val -= 1;
	}

	public long get() {
		return val;
	}
}
