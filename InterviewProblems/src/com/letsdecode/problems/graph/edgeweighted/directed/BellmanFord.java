package com.letsdecode.problems.graph.edgeweighted.directed;

import java.util.HashMap;
import java.util.Set;

public class BellmanFord {
	private EdgeWeightedDiGraph G;
	private String s;
	/*
	 * Distance of last edge to w from v
	 */
	private HashMap<String, Double> distTo = new HashMap<>();
	/*
	 * Vertex v what leads to w
	 */
	private HashMap<String, DirectedEdge> edgeTo = new HashMap<>();

	public BellmanFord(EdgeWeightedDiGraph G, String id) {
		this.G = G;
		this.s = id;

		for (String vId : G.vertices()) {
			distTo.put(vId, Double.POSITIVE_INFINITY);
		}

		distTo.put(s, 0.0);// source vertex
	}

	public void findShortestPath() throws Exception {
		Set<String> vertices = distTo.keySet();
		for (String v : vertices) {
			Set<DirectedEdge> adjacent = G.adj(v);
			for (DirectedEdge e : adjacent) {
				double distanceToW = distTo.get(e.to());
				if (distanceToW > e.getWeight() + distTo.get(v)) {
					distTo.put(e.to(), e.getWeight() + distTo.get(v));
					edgeTo.put(e.to(), e);
				}
			}
		}
		for (DirectedEdge e : G.edges()) {
			String v = e.from();
			String w = e.to();
			double distanceToW = distTo.get(w);
			if (distanceToW > e.getWeight() + distTo.get(v)) {
				throw new Exception("Negative Cycle Detected");
			}
		}
	}
}
