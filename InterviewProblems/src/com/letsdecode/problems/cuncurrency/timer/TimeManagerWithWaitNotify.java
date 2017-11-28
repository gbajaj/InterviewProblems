package com.letsdecode.problems.cuncurrency.timer;

import java.util.Comparator;
import java.util.PriorityQueue;


public class TimeManagerWithWaitNotify {
	// Create a min heap
	private PriorityQueue<TimedTask<Runnable>> queue = new PriorityQueue<TimedTask<Runnable>>(
			1000, new MyComparator());
	private boolean killTimer = false;
	private Object MUTEX = new Object();
	public class MyComparator implements Comparator<TimedTask<Runnable>> {
		public int compare(TimedTask<Runnable> x, TimedTask<Runnable> y) {
			return (int) (x.when - y.when);
		}
	}


	public TimeManagerWithWaitNotify() {
		init();
	}

	public synchronized void addTask(TimedTask<Runnable> task) {
		if (task == null) {
			throw new IllegalArgumentException("Provide a valid Timer Task");
		}
		if (task.when - System.currentTimeMillis() < 0) {
			runTask(task);
			return;
		}
		synchronized (MUTEX) {
			queue.add(task);
			MUTEX.notify();
		}
		System.out.println(queue.peek().when);
	}

	public boolean remove(TimedTask<Runnable> toRemove) {
		boolean res = false;
		synchronized (MUTEX) {
			res = queue.remove(toRemove);
			if (res) {
				MUTEX.notify();
			}
		}
		return res;
	}

	public void runTask(final TimedTask<Runnable> toRun) {
		if (toRun != null) {
			final long actual = System.currentTimeMillis();
			final long diff = Math.abs(toRun.when - actual);
			new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println(" id " + toRun.id + " diff" + diff
							+ " target " + toRun.when + " actual " + actual);
				}
			}).start();
		}
	}

	public void shutDown() {
		killTimer = true;
		
		synchronized (MUTEX) {
			System.out.println("Shutting down "+ queue.size() + " task left");
			MUTEX.notify();
		}
	}

	private void init() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (!killTimer) {
					synchronized (MUTEX) {
						while (queue.isEmpty()) {
							try {
								System.out.println("nothing to work on: GO to sleep");
								MUTEX.wait();
							} catch (InterruptedException e) {
								System.out.println("got Interuppted ");
							}
						}
						TimedTask<Runnable> t = queue.peek();
						if (t != null) {
							long diff = t.when - System.currentTimeMillis();
							if (diff <= 0) {
								t = queue.poll();
								runTask(t);
							} else {
								try {
									System.out.println("Goint in wait for some time " + diff);
									MUTEX.wait(diff);
									System.out.println("Just woke up after last wait " + diff);
								} catch (InterruptedException e) {
								}
							}
						}
					}
				}
				System.out.println("Exiting");
			}
		}).start();

	}

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
