package com.letsdecode.problems.cuncurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CommonPool<T extends PoolObject> {
	private PoolFactory<T> factory;
	private Queue<T> poolQueue = new LinkedList<T>();
	private int min;
	private int max;
	private int validationInterval;
	private ScheduledExecutorService executerService;
	private Object MUTEX = new Object();

	public CommonPool(PoolFactory<T> factory, int min, int max,
			int validateIterval) {
		this.factory = factory;
		this.min = min;
		this.max = max;
		this.validationInterval = validateIterval;
		// precondition.checkExpression(min > 0)
		// precondition.checkExpression(max>=min)
		// precondition.checkExpression(validateIterval> 5000) ms
	}

	private void initialize() {
		for (int i = 0; i < min; i++) {
			poolQueue.add(factory.createObject());
		}
		executerService = Executors.newSingleThreadScheduledExecutor();
		executerService.scheduleWithFixedDelay(new Runnable() {

			@Override
			public void run() {
				while (true) {
					synchronized (MUTEX) {
						if (poolQueue.size() < min) {
							poolQueue.add(factory.createObject());
						} else {
							break;
						}
					}
				}
				while (true) {
					synchronized (MUTEX) {
						if (poolQueue.size() > max) {
							final T object = poolQueue.poll();
							if (object != null) {
								// We can do the clean using threads form the
								// thread pools as well
								new Thread(new Runnable() {
									@Override
									public void run() {
										object.clean();
									}
								});
							}
						} else {
							break;
						}
					}
				}
			}
		}, validationInterval, validationInterval, TimeUnit.MILLISECONDS);
	}

	private void evictObjectOnShutdown() {
		while (true) {
			synchronized (MUTEX) {
				if (poolQueue.size() > 0) {
					final T object = poolQueue.poll();
					if (object != null) {
						// We can do the clean using threads form the
						// thread pools as well
						new Thread(new Runnable() {
							@Override
							public void run() {
								object.clean();
							}
						});
					}
				} else {
					break;
				}
			}
		}
	}

	public void shutdown() {
		if (executerService != null) {
			executerService.shutdown();
		}
		evictObjectOnShutdown();
	}

	public T borrowObject() {
		T ret = null;
		synchronized (MUTEX) {
			if ((ret = poolQueue.poll()) == null) {
				ret = factory.createObject();
				// No need to add to the pool yet
				// Object would/should be added back
				// when caller is done with the
				// connection
			}
		}
		return ret;
	}

	public void returnObject(T object) {
		if (object == null) {
			return;
		}

		synchronized (MUTEX) {
			poolQueue.add(object);
		}
	}
}
