package com.letsdecode.problems.graph.build;

import java.util.HashSet;
import java.util.Iterator;

public class Node {
	Integer label;

	HashSet<Node> adj = new HashSet<>();

	@Override
	public int hashCode() {
		return label.hashCode();
	}
	public Integer getLabel() {
		return label;
	}

	public Node(Integer lable) {
		this.label = lable;
	}

	public Iterator<Node> getIterator() {
		return adj.iterator();
	}

	public boolean addEdge(Node e) {
		return adj.add(e);
	}

	public int getOutDegree() {
		return adj.size();
	}
}
