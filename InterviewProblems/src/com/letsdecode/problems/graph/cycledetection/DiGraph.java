package com.letsdecode.problems.graph.cycledetection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class DiGraph {
	private HashMap<String, DiGraphVertex> vertices = new HashMap<>();

	static class DiGraphVertex {
		public final String id;
		public final HashSet<DiGraphVertex> adj = new HashSet<>();

		public DiGraphVertex(String label) {
			this.id = label;
		}

		@Override
		public int hashCode() {
			return id.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			return id.equals(obj);
		}

		@Override
		public String toString() {
			String print = id + " - > [";
			for (DiGraphVertex v : adj) {
				print += v.id + ", ";
			}
			print += "]";
			return print;
		}
	}

	public void addEdge(DiGraphVertex addTo, DiGraphVertex added) {
		addTo.adj.add(added);
	}

	public void addEdge(String fromLabel, String toLabel) {
		DiGraphVertex from = getVertex(fromLabel);
		if (from == null) {
			from = new DiGraphVertex(fromLabel);
			addVertex(from);
		}
		DiGraphVertex to = getVertex(toLabel);
		if (to == null) {
			to = new DiGraphVertex(toLabel);
			addVertex(to);
		}
		addEdge(from, to);
	}

	public Collection<DiGraphVertex> getVertices() {
		return vertices.values();
	}

	public boolean addVertex(DiGraphVertex toAdd) {
		if (vertices.containsKey(toAdd.id) == false) {
			return vertices.put(toAdd.id, toAdd) != null;
		}
		return false;
	}

	public int V() {
		return vertices.size();
	}

	public DiGraphVertex getVertex(String lable) {
		return vertices.get(lable);
	}

	public int E() {
		Collection<DiGraphVertex> ver = getVertices();
		int res = 0;
		for (DiGraphVertex v : ver) {
			res += v.adj.size();
		}
		return res;
	}

	public DiGraphVertex addVertex(String lable) {

		DiGraphVertex vertex = vertices.get(lable);
		if (vertex == null) {
			vertex = new DiGraphVertex(lable);
			vertices.put(lable, vertex);
		}
		return vertex;
	}

	public HashSet<DiGraphVertex> getAdj(String label) {
		DiGraphVertex vertex = vertices.get(label);
		if (vertex != null) {
			return vertex.adj;
		}
		return null;
	}

	public String toString() {
		Collection<DiGraphVertex> ver = getVertices();
		String out = "";
		for (DiGraphVertex v : ver) {
			out += v + "\n";
		}
		return out;
	}

	HashSet<DiGraphVertex> callStack = new HashSet<>();
	HashSet<DiGraphVertex> visited = new HashSet<>();
	HashMap<DiGraphVertex, DiGraphVertex> pathFrom = new HashMap<>();

	public boolean hasCycle() {

		Collection<DiGraphVertex> ver = getVertices();
		for (DiGraphVertex v : ver) {
			callStack.clear();
			pathFrom.clear();
			if (hasCycle(v))
				return true;
		}
		return false;
	}

	public boolean hasCycle(DiGraphVertex v) {
		visited.add(v);
		callStack.add(v);
		for (DiGraphVertex ad : v.adj) {
			boolean visitedVer = visited.contains(ad);
			// if ()
			if (visitedVer == false) {
				// Since never visited; it can't be on stack
				pathFrom.put(v, ad);
				if (hasCycle(ad)) {
					return true;
				}
			} else {
				// Already Visited; But is on stack?
				if (callStack.contains(ad)) {
					DiGraphVertex cur = ad;
					while (cur != null) {
						System.out.print(cur.id + " -> ");
						cur = pathFrom.get(cur);
					}
					System.out.print(ad.id);
					return true;
				}
			}
		}

		callStack.remove(v);
		return false;
	}

	public Stack<DiGraphVertex> getReversePost() {
		Stack<DiGraphVertex> reversePost = new Stack<>();
		visited.clear();
		Collection<DiGraphVertex> ver = getVertices();
		for (DiGraphVertex v : ver) {
			if (visited.contains(v) == false) {
				getReversePost(v, reversePost);
			}
		}
		return reversePost;
	}

	private void getReversePost(DiGraphVertex d,
			Stack<DiGraphVertex> reversePost) {
		if (visited.contains(d))
			return;
		visited.add(d);
		for (DiGraphVertex v : d.adj) {
			getReversePost(v, reversePost);
		}
		reversePost.push(d);
	}

	public Stack<DiGraphVertex> topologicalSortDFS() {
		if (hasCycle())
			throw new IllegalStateException();
		return getReversePost();
	}

	public static DiGraph reverseGraph(final DiGraph g) {
		DiGraph out = new DiGraph();
		for (DiGraphVertex v : g.getVertices()) {
			for (DiGraphVertex ad : v.adj) {
				out.addEdge(ad.id, v.id);
			}
		}
		return out;
	}

	public ArrayList<HashSet<DiGraphVertex>> CCs() {
		ArrayList<HashSet<DiGraphVertex>> out = new ArrayList<>();
		DiGraph reverse = DiGraph.reverseGraph(this);
		Stack<DiGraphVertex> reversePost = new Stack<>();
		for (DiGraphVertex v : reverse.getVertices()) {
			if (reverse.visited.contains(v) == false) {
				reverse.getReversePost(v, reversePost);
			}
		}
		System.out.println(reverse);
		System.out.println(reversePost);

		visited.clear();
		while (reversePost.isEmpty() == false) {
			DiGraphVertex popped = reversePost.pop();
			DiGraphVertex dV = getVertex(popped.id);
			if (visited.contains(dV) == false) {
				HashSet<DiGraphVertex> cc = new HashSet<>();
				out.add(cc);
				ccDFS(dV, cc);
			}
		}
		return out;
	}

	private void ccDFS(DiGraphVertex v, HashSet<DiGraphVertex> cc) {
		if (visited.contains(v))
			return;
		visited.add(v);
		cc.add(v);

		for (DiGraphVertex ad : v.adj) {
			ccDFS(ad, cc);
		}
	}
}
