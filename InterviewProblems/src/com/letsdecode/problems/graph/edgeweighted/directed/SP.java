package com.letsdecode.problems.graph.edgeweighted.directed;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

import com.letsdecode.problems.graph.edgeweighted.Vertex;

public class SP {
	private EdgeWeightedDiGraph G;
	private String s;
	/*
	 * Distance of last edge to w from v
	 */
	private HashMap<String, Double> distTo;
	/*
	 * Vertex v what leads to w
	 */
	private HashMap<String, DirectedEdge> edgeTo;

	public SP(EdgeWeightedDiGraph G, String id) {
		this.G = G;
		this.s = id;
		for (DirectedEdge e : G.edges()) {
			distTo.put(e.from(), Double.MAX_VALUE);
		}
		distTo.put(s, 0.0);//source vertex
	}

	/**
	 * Path from s to v
	 * 
	 * @param id
	 * @return
	 */
	boolean hasPathTo(String v) {
		Double cost = distTo.get(v);
		if (cost.equals(Double.MAX_VALUE)) {
			return false;
		}
		return true;
	}

	public Collection<DirectedEdge> pathTo(String v) {
		if (hasPathTo(v) == false)
			return null;
		LinkedList<DirectedEdge> list = new LinkedList<>();
		for (DirectedEdge e = edgeTo.get(v); e != null; e = edgeTo
				.get(e.from())) {
			list.addFirst(e);
		}

		return list;
	}

	private void relax(DirectedEdge e) {
		String w = e.to();
		String v = e.from();
		Double distToW = distTo.get(w);
		Double distToV = distTo.get(v);
		if (distToW > distToV + e.getWeight()) {
			distTo.put(w, distToV + e.getWeight());

			edgeTo.put(w, e);
		}

	}
}
