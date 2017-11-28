package com.letsdecode.problems.epi.chapter20;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintOddEven {
	AtomicInteger i = new AtomicInteger(1);
	Runnable oddRunnable = new Runnable() {

		@Override
		public void run() {
			while (i.intValue() <= 99) {
				synchronized (i) {
					if (i.get() % 2 == 1) {
						System.out.println(i.get());
						i.incrementAndGet();
						i.notify();
					} else {
						try {
							i.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

		}
	};
	Runnable evenRunnable = new Runnable() {

		@Override
		public void run() {
			while (i.intValue() <= 100) {
				synchronized (i) {
					if (i.get() % 2 == 0) {
						System.out.println(i.get());
						i.incrementAndGet();
						i.notify();
					} else {
						try {
							i.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

		}
	};

	public void print() {
		new Thread(oddRunnable).start();
		new Thread(evenRunnable).start();
	}
}
