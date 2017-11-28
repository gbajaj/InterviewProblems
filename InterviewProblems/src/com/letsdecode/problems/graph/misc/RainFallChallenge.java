package com.letsdecode.problems.graph.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class RainFallChallenge {
	public RainFallChallenge(int size, int input[][]) {
		graph = new Node[size][size];
	}

	Node graph[][];

	class Node {
		String index;
		String label;
		int value;
		int size = 1;

		public int hashCode() {
			return index.hashCode();
		};

		HashSet<Node> in = new HashSet<>();
		Node parent;
		boolean visited;

		public void setLabel(String lab) {
			this.label = lab;
		}

		public void union(Node pr, Node qr) {
			Node p = pr.findRoot();
			Node q = qr.findRoot();
			if (p.size < q.size) {
				p.parent = q;
				q.in.add(p);
				q.size += p.size;
			} else {
				q.parent = p;
				p.in.add(q);
				p.size += q.size;
			}
		}

		private Node findRoot() {
			if (this.parent == null)
				return this;
			return this.parent.findRoot();
		}

	}

	int xa[] = { 1, -1, 0, 0 };
	int ya[] = { 0, 0, 1, -1 };

	public void buildGraph(int input[][]) {
		for (int row = 0; row < input.length; row++) {
			for (int col = 0; col < input[row].length; col++) {
				Node n = new Node();
				n.value = input[row][col];
				n.index = "" + row + "" + col;
				graph[row][col] = n;
			}
		}
	}

	public void buildBasins() {
		for (int row = 0; row < graph.length; row++) {
			for (int col = 0; col < graph[row].length; col++) {
				buildBasins(row, col);
			}
		}

	}

	public void buildBasins(int row, int col) {
		if (isValidCell(row, col) == false) {
			return;
		}

		Node cur = graph[row][col];
		Node nei = null;
		nei = findSmallestNeibhour(row, col);
		if (nei != null) {
			nei.union(nei, cur);
		}
	}

	Node findSmallestNeibhour(int row, int col) {
		Node cur = graph[row][col];
		int max = -10000;
		Node node = null;

		for (int i = 0; i < xa.length; i++) {
			int nrow = row + xa[i];
			int ncol = col + ya[i];
			Node nei = null;
			if (isValidCell(nrow, ncol)) {
				nei = graph[nrow][ncol];
				if (nei.value < cur.value) {
					int diff = cur.value - nei.value;
					if (diff > max) {
						node = nei;
						max = diff;
					}
				}
			}
		}
		return node;
	}

	public ArrayList<Node> arrangeByParent() {
		HashSet<Node> set = new HashSet<>();
		for (int row = 0; row < graph.length; row++) {
			for (int col = 0; col < graph[row].length; col++) {
				set.add(graph[row][col].findRoot());
			}
		}
		ArrayList<Node> list = new ArrayList<>();
		list.addAll(set);
		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if (o1.size < o2.size) {
					return 1;
				} else if (o1.size >= o2.size) {
					return -1;
				}
				return 0;
			}
		});

		return list;

	}

	private boolean isConnected(Node p, Node q) {
		return p.findRoot() == q.findRoot();
	}

	public boolean isValidCell(int row, int col) {
		if (row < 0 || row == graph.length || col < 0
				|| col >= graph[row].length) {
			return false;
		}
		return true;
	}

	public void printGraphByVal() {
		for (int row = 0; row < graph.length; row++) {
			for (int col = 0; col < graph[row].length; col++) {
				System.out.print("" + graph[row][col].value + " ");
			}
			System.out.println("");
		}
	}

	public void inAndOut() {
		for (int row = 0; row < graph.length; row++) {
			for (int col = 0; col < graph[row].length; col++) {
				String in = "";
				String out = "";
				for (Node inD : graph[row][col].in) {
					in += inD.value + ", ";
				}
				if (graph[row][col].parent != null) {
					out = "" + graph[row][col].parent.value;
				}
				System.out.print("" + graph[row][col].value + " { {" + in
						+ "} {" + out + "} }, ");
			}
			System.out.println("");
		}
	}

	public void printGraphByVal(ArrayList<Node> list) {
		for (Node l : list) {
			System.out.print("" + l.value + " ");
		}
	}

	public void addLabel(ArrayList<Node> list) {
		char a = 65;
		for (Node l : list) {
			addLabel(l, "" + a);
			a++;
		}
	}

	public void addLabel(Node n, String label) {
		HashSet<Node> set = n.in;
		n.label = label;
		for (Node l : set) {
			addLabel(l, label);
		}
	}

	public void printByLabel() {
		for (int row = 0; row < graph.length; row++) {
			for (int col = 0; col < graph[row].length; col++) {
				System.out.print("" + graph[row][col].label + " ");
			}
			System.out.println("");
		}
	}

}
