package com.letsdecode.problems.cuncurrency.timer;

import static org.junit.Assert.*;

import java.util.TimerTask;

import org.junit.Test;

public class TimeManagerTest {

	@Test
	public void test() {
		long t = System.currentTimeMillis();
		TimeManager timeManager  = new TimeManager();
		timeManager.addTask(new TimedTask<Runnable>(r, t + 2000000));
		timeManager.addTask(new TimedTask<Runnable>(r, t + 1500000));
		timeManager.addTask(new TimedTask<Runnable>(r, t + 1000000));
		timeManager.addTask(new TimedTask<Runnable>(r, t + 500000));
		TimedTask<Runnable> ta = new TimedTask<Runnable>(r, t + 100000);
		timeManager.addTask(ta);
		timeManager.remove(ta);
		
		
	}
	
	private Runnable r =new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	};

}
