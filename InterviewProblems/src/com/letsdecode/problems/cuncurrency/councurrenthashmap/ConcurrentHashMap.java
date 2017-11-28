package com.letsdecode.problems.cuncurrency.councurrenthashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SuppressWarnings("serial")
public class ConcurrentHashMap<K, V> extends HashMap<K, V> {
	public static int LOCKS = 16;
	Object[] locks = new Object[LOCKS];

	@Override
	public V put(K key, V value) {
		int hash = key.hashCode();
		Object lock = locks[hash % LOCKS];
		V ret = null;
		synchronized (lock) {
			ret = super.put(key, value);
		}
		return ret;
	}

	@Override
	public V get(Object key) {
		int hash = key.hashCode();
		Object lock = locks[hash % LOCKS];
		V ret = null;
		synchronized (lock) {
			ret = super.get(key);
		}
		return ret;
	}

	@Override
	public V remove(Object key) {
		int hash = key.hashCode();
		Object lock = locks[hash % LOCKS];
		V ret = null;
		synchronized (lock) {
			ret = super.remove(key);
		}
		return ret;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		Iterator it = m.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<K, V> pair = (Map.Entry<K, V>) it.next();
			put(pair.getKey(), pair.getValue());
		}
	}
}
