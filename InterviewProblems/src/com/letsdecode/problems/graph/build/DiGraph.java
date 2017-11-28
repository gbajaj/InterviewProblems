package com.letsdecode.problems.graph.build;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DiGraph {
	private int nV;
	private HashMap<Integer, Node> V = new HashMap();

	public int getnV() {
		return V.size();
	}

	public int getnE() {
		int count = 0;
		for (Entry<Integer, Node> e : V.entrySet()) {
			count += e.getValue().adj.size();
		}

		return count;
	}

	public Set<Integer> getKeySet() {
		return V.keySet();
	}

	public Node getV(Integer key) {
		return V.get(key);
	}

	public Node pickRandomNode() {
		Set<Map.Entry<Integer, Node>> set = V.entrySet();
		Iterator<Map.Entry<Integer, Node>> i = set.iterator();
		return i.next().getValue();
	}

	public Node put(Node n) {
		return V.put(n.label, n);
	}

	public boolean addEdge(Integer start, Integer end) {
		Node startNode = getV(start);
		if (startNode == null) {
			startNode = new Node(start);
			put(startNode);
		}
		Node endNode = getV(end);
		if (endNode == null) {
			endNode = new Node(end);
			put(endNode);
		}
		System.out.print(((char)('a'+start.intValue())) + "->" + ((char)('a'+end.intValue())) );
		System.out.println(" ");
		return startNode.addEdge(endNode);
	}

	public void printGraph() {
		Set<Integer> set= V.keySet();
		for (Integer i : set) {
			Node n = V.get(i);
			System.out.print(((char)('a'+i.intValue())) + " :");
			Set<Node> list = n.adj;
			for(Node a:list) {
				System.out.print(((char)('a'+a.label)) + " ");
			}
			System.out.println(" ");
		}
		
	}
}
