package com.letsdecode.problems.cuncurrency.timer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Timer;
import java.util.TimerTask;

public class TimeManager {
	public class MyComparator implements Comparator<TimedTask<Runnable>> {
		public int compare(TimedTask<Runnable> x, TimedTask<Runnable> y) {
			return (int) (x.when - y.when);
		}
	}

	// Create a min heap
	PriorityQueue<TimedTask<Runnable>> queue = new PriorityQueue<TimedTask<Runnable>>(
			1000, new MyComparator());
	Timer timer = new Timer();
	boolean killTimer = false;
	private Object MUTEX = new Object();

	public TimeManager() {
	}

	public synchronized void addTask(TimedTask<Runnable> task) {
		if (task == null) {
			throw new IllegalArgumentException("Provide a valid Timer Task");
		}
		if (task.when - System.currentTimeMillis() < 200) {
			runTask(task);
			return;
		}
		if (queue.isEmpty() == false) {
			TimedTask<Runnable> storedTask = queue.peek();
			long diff = storedTask.time() - task.time();
			if (diff > 0) {
				queue.add(task);
				resetAlarm(task.time() - System.currentTimeMillis());
			} else {
				queue.add(task);
				System.out.println(queue.peek().when);
			}
		} else {
			queue.add(task);
			System.out.println(queue.peek().when);
			resetAlarm(task.time() - System.currentTimeMillis());
		}

	}

	public synchronized boolean remove(TimedTask<Runnable> toRemove) {
		boolean res = false;
		res = queue.remove(toRemove);
		if (res) {
			resetAlarmWithPeek();
		}
		return res;
	}

	public void runTask(TimedTask<Runnable> toRun) {
		if (toRun != null) {
			new Thread(toRun.timed).start();
		}
	}

	public synchronized void alarmFired() {
		TimedTask<Runnable> toRun = queue.remove();
		if (toRun != null) {
			runTask(toRun);
		}
		resetAlarmWithPeek();
	}

	private synchronized void resetAlarmWithPeek() {
		if (queue.isEmpty() == false) {
			TimedTask<Runnable> storedTask = queue.peek();
			if (storedTask != null) {
				long timeToFire = storedTask.time()
						- System.currentTimeMillis();
				resetAlarm(timeToFire);
			}
		}
	}


	private synchronized void resetAlarm(long time) {
		System.out.println("fire after " + time + " ");
	}
}
