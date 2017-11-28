package com.letsdecode.problems.cuncurrency.timer;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeManagerWithWaitNotifyTest {

	@Test
	public void test() {

		TimeManagerWithWaitNotify timeManager = new TimeManagerWithWaitNotify();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long t = System.currentTimeMillis();
		timeManager.addTask(new TimedTask<Runnable>(r, t + 5000, "5000"));
		timeManager.addTask(new TimedTask<Runnable>(r, t + 4000, "4000"));
		TimedTask<Runnable> r2 = new TimedTask<Runnable>(r, t + 1000, "1000");
		timeManager.addTask( r2 );
		timeManager.addTask(new TimedTask<Runnable>(r, t + 500, "500"));
		TimedTask<Runnable> ta = new TimedTask<Runnable>(r, t + 100, "100");
		timeManager.addTask(ta);
		timeManager.remove(r2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		timeManager.shutDown();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Runnable r = new Runnable() {
		public String id;

		@Override
		public void run() {
			System.out.println("Task Fired " + System.currentTimeMillis());
		}
	};
}
