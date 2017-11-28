package com.letsdecode.problems.cuncurrency.syncResponse;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class RequestDispatcherAsyncResponse extends
		RequestDispatcherSyncResponse {
	private LinkedBlockingQueue<Task> out = new LinkedBlockingQueue<Task>();
	private ExecutorService theadOutPool = Executors.newCachedThreadPool();

	@Override
	protected void sendResponse(Task task) {
		out.add(task);
	}

	@Override
	public void startDispatcher() {
		for (final Task t : out) {
			theadOutPool.submit(new Runnable() {
				@Override
				public void run() {
					t.res.write(t.result);
				}
			});
			if (stop.get()) {
				break;
			}
		}
		super.startDispatcher();

	}
}
