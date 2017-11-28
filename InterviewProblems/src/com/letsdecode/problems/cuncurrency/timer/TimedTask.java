package com.letsdecode.problems.cuncurrency.timer;

public class TimedTask<T extends Runnable> {

	T timed;
	long when;
	String id;

	public long time() {
		return when;
	}

	public TimedTask(T timed, long when, String id) {
		this.timed = timed;
		this.when = when;
		this.id = id;
	}

	public void onTime() {
		timed.run();
	}
}
