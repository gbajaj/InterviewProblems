package com.letsdecode.problems.graph.edgeweighted.directed;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

import com.letsdecode.problems.graph.edgeweighted.Vertex;

public class DijkastraSP {
	private EdgeWeightedDiGraph G;
	private String s;
	private PriorityQueue<VertexDistance> pq;
	HashMap<String, Integer> steps = new HashMap<>();
	/*
	 * Distance of last edge to w from v
	 */
	private HashMap<String, Double> distTo = new HashMap<>();
	/*
	 * Vertex v what leads to w
	 */
	private HashMap<String, DirectedEdge> edgeTo = new HashMap<>();

	class VertexDistance {
		String id;
		double distance;

		public VertexDistance(String id, double dist) {
			this.id = id;
			this.distance = dist;
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return id.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			return id.equals((VertexDistance) obj);
		}
	}

	public DijkastraSP(EdgeWeightedDiGraph G, String id) {
		this.G = G;
		this.s = id;

		for (DirectedEdge e : G.edges()) {
			distTo.put(e.from(), Double.MAX_VALUE);
		}
		pq = new PriorityQueue<>(G.edges().size(),
				new Comparator<VertexDistance>() {
					@Override
					public int compare(VertexDistance o1, VertexDistance o2) {
						if (o1.distance < o2.distance) {
							return -1;
						} else if (o1.distance > o2.distance) {
							return 1;
						}
						return 0;
					}
				});
		distTo.put(s, 0.0);// source vertex
		steps.put(s, 0);//Step counts to current vertex is 0;
		pq.add(new VertexDistance(s, 0.0));// Add first vertex
		while (!pq.isEmpty()) {
			relax(pq.poll().id);
		}
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

	private void relax(String id) {
		Set<DirectedEdge> adj = G.edges.get(id);
		if (adj != null) {
			for (DirectedEdge e : adj) {
				String w = e.to();
				int stepCount = steps.get(id);//Step counts to the current Vertex v
				
				Double distToW = distTo.get(w);//Current distance to the 
				//vertex w adjacent to v 

				Double distToV = distTo.get(id);//Current distance to vertext v
				int wStepCounts = steps.get(w);//
				if (distToW > distToV + e.getWeight()) {
					distTo.put(w, distToV + e.getWeight());
					edgeTo.put(w, e);
					pq.remove(new VertexDistance(id, 0.0));
					pq.add(new VertexDistance(w, distToV + e.getWeight()));
					steps.put(w, stepCount + 1);//Step counts to v +1
				} else if (distToW.equals(distToV + e.getWeight()) 
						&& wStepCounts > stepCount + 1) {
					distTo.put(w, distToV + e.getWeight());
					edgeTo.put(w, e);
					pq.remove(new VertexDistance(id, 0.0));
					pq.add(new VertexDistance(w, distToV + e.getWeight()));
					steps.put(w, stepCount + 1);
				}

			}
		}
	}
}
