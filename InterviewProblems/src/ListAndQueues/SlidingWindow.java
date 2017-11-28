package ListAndQueues;

import java.util.LinkedList;

public class SlidingWindow {
	LinkedList<Integer> list = new LinkedList<>();
	int w;

	int a[];
	int out[];

	public SlidingWindow(int []a, int w) {
		this.w = 3;
		this.a = a;
		out = new int[a.length - this.w + 1];
	}

	public int[] generateMaxElements() {
		for (int i = 0; i < w; i++) {
			while (list.isEmpty() == false && a[i] >= a[list.peekLast()]) {
				list.pollLast();
			}
			list.addLast(i);
		}
		int o = 0;
		for (int i = w; i < a.length; i++) {
			out[o++] = a[list.peek().intValue()];
			while (list.isEmpty() == false && a[i] >= a[list.peekLast()]) {
				list.pollLast();
			}
			while (list.isEmpty() == false && list.peek() <= i - w) {
				list.poll();
			}
			list.addLast(i);
		}
		if (w > 0) {
			out[o] = a[list.peek().intValue()];
		}
		return out;
	}
}
