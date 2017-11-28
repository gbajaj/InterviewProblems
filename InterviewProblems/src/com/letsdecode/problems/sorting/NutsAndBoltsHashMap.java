package com.letsdecode.problems.sorting;

import java.util.HashMap;

public class NutsAndBoltsHashMap {
	char[] nuts;
	char[] bolts;
	public char[] resNuts;
	public char[] resBolts;
	private HashMap<String, Integer> map = new HashMap<>();

	public NutsAndBoltsHashMap(char[] nuts, char[] bolts) {

		this.nuts = nuts;
		this.bolts = bolts;
	}

	public void call() {
		char[] outNuts = new char[nuts.length];
		for (int i = 0; i < bolts.length; i++) {
			map.put("" + bolts[i], i);
		}

		for (int i = 0; i < nuts.length; i++) {
			Integer a = map.get("" + nuts[i]);
			if (a != null) {
				outNuts[a] = nuts[i];
			}
		}
		resNuts = outNuts;
		resBolts = bolts;
	}

}
