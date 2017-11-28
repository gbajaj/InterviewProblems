package com.letsdecode.problems.graph.edgeweighted.directed;

import static org.junit.Assert.*;

import org.junit.Test;

import com.letsdecode.problems.graph.edgeweighted.Vertex;

public class BellmanFordTest {

	@Test
	public void test() throws Exception {
		EdgeWeightedDiGraph edgeWeightedDiGraph = new EdgeWeightedDiGraph();
		Vertex vertex4 = new Vertex("4");
		Vertex vertex5 = new Vertex("5");
		edgeWeightedDiGraph.addVertex(vertex4);
		edgeWeightedDiGraph.addVertex(vertex5);
		
		DirectedEdge directedEdge = new DirectedEdge("4", "5", 0.35);
		
		edgeWeightedDiGraph.addEdge(directedEdge);
		directedEdge = new DirectedEdge("5", "4", -0.66);
		edgeWeightedDiGraph.addEdge(directedEdge);
		BellmanFord bellmanFord = new BellmanFord(edgeWeightedDiGraph, "4");
		bellmanFord.findShortestPath();
	}
}
