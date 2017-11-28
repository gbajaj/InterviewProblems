package com.letsdecode.problems.cuncurrency.dispatchsystem;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class DispatchSystem {
	public static final int FLAGS_NO_LOCK = 0x0;
	public static final int FLAGS_FILESYSTEM_LOCK = 0x1;
	public static final int FLAGS_DATABASE_LOCK = 0x2;
	public static final int FLAGS_MODEL_LOCK = 0x4;
	LinkedBlockingQueue<Task> queue = new LinkedBlockingQueue();
	private Object FILE_SYSTEM_LOCK = new Object();
	private Object DATBASE_LOCK = new Object();
	private Object MODEL_LOCK = new Object();

	interface Task {
		int GetFlags();

		void Run();
	}

	abstract class MyTask implements Task {
		final DispatchSystem ds;
		final int flags;

		MyTask(DispatchSystem ds, int flags) {
			this.ds = ds;
			this.flags = flags;
		}

		@Override
		public void Run() {
			
		}

		@Override
		public int GetFlags() {
			return 0;
		}
	}

	public void aquireLocks() {

	}
	boolean shutdown = false;
	public void init() {
		Task t = null;
		while ((t = queue.poll()) !=null && !shutdown ) {
			int flags = t.GetFlags();
			if ((flags &FLAGS_FILESYSTEM_LOCK ) != false) { {
				synchronized (FILE_SYSTEM_LOCK) {
					
				}
			}
			if ((flags &FLAGS_DATABASE_LOCK ) != false) { {
				synchronized (DATBASE_LOCK) {
					
				}
			}
			if ((flags &FLAGS_MODEL_LOCK ) != false) { {
				synchronized (MODEL_LOCK) {
					
				}
			}
		}

	}
}
