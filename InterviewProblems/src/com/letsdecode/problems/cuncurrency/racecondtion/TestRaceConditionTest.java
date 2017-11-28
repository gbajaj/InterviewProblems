package com.letsdecode.problems.cuncurrency.racecondtion;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRaceConditionTest {
	TestRaceCondition r;

	@Test
	public void test() throws InterruptedException {
		r = new TestRaceCondition();

		Thread t1 = new Thread(writeRun);
		Thread t2 = new Thread(readRun);
		Thread t3 = new Thread(writeRun);
		Thread t4 = new Thread(readRun);
		Thread t5 = new Thread(writeRun);
		Thread t6 = new Thread(readRun);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
		t1.join();
		t2.join();

		t3.join();
		t4.join();
		t5.join();
		 t6.join();
		System.out.println(r.get());
		Thread.sleep(30000);
		System.out.println(r.get());
	}

	Runnable writeRun = new Runnable() {

		@Override
		public void run() {
			try {
				Thread.sleep(200);
				for (int i = 0; i < 10000; i++) {
					r.inc();
					Thread.sleep(1);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	};

	Runnable readRun = new Runnable() {

		@Override
		public void run() {
			try {
				Thread.sleep(200);
				for (int i = 0; i < 10000; i++) {
					r.dec();
					Thread.sleep(1);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	};

}
