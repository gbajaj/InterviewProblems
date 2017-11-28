package com.letsdecode.problems.recursion;

import java.util.ArrayList;
import java.util.List;
//
//public class FindAllSubsets {
//	private char[] in;
//	private ArrayList<String> list = new ArrayList<>();
//
//	public FindAllSubsets(char[] in) {
//		this.in = in;
//	}
//
//	public void call() {
//		generate(in, 0, new char[in.length + 2], 0);
//	}
//
//	public ArrayList<String> getResult() {
//		return list;
//	}
//
//	private void generate(char[] in, int i, char[] out, int o) {
//		if (i == 0) {
//			out[o++] = '{';
//		}
//		if (i >= in.length) {
//			out[o++] = '}';
//			StringBuilder builder = new StringBuilder();
//			builder.append(out, 0, o);
//			list.add(builder.toString());
//			return;
//		}
//		out[o] = in[i];
//		generate(in, i + 1, out, o + 1);
//		generate(in, i + 1, out, o);
//	}
//
//}

public class FindAllSubsets {
	private int[] in;
	private List<List<Integer>> list = new ArrayList<>();

	public FindAllSubsets(int[] in) {
		this.in = in;
	}

	public void call() {
		generate(in, 0, new int[in.length], 0);
	}

	public List<List<Integer>> getResult() {
		return list;
	}

	private void generate(int[] in, int i, int[] out, int o) {
		// if (i == 0) {
		// out[o++] = '{';
		// }
		if (i >= in.length) {
			// out[o++] = '}';
			ArrayList<Integer> temp = new ArrayList<>();
			for (int k = 0; k < o; k++) {
				temp.add(out[k]);
			}
			list.add(temp);
			return;
		}
		out[o] = in[i];
		
		generate(in, i + 1, out, o + 1);
		generate(in, i + 1, out, o);
	}

}
