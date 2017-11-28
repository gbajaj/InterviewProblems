package com.letsdecode.problems.graph.edgeweighted.directed;

import com.letsdecode.problems.graph.edgeweighted.Vertex;

public class Arbitrage {
	public boolean isThereAnArbitrage() {
		String input[][] = {
				{ "USD", "1", "0.741", "0.657", "1.061", "1.005" },
				{ "EUR", "1.349", "1", "0.888", "1.433", "1.366" },
				{ "GBP", "1.521", "1.126", "1", "1.614", "1.538" },
				{ "CHF", "0.942", "0.698", "0.619", "1", "0.953" },
				{ "CAD", "0.995", "0.732", "0.650", "1.049", "1" } };
		
		EdgeWeightedDiGraph edgeWeightedDiGraph = new EdgeWeightedDiGraph();
		Vertex usd = new Vertex("USD");
		Vertex eur = new Vertex("EUR");
		Vertex gbp = new Vertex("GBP");
		Vertex chf = new Vertex("CHF");
		Vertex cad = new Vertex("CAD");

		edgeWeightedDiGraph.addVertex(usd);
		edgeWeightedDiGraph.addVertex(eur);
		edgeWeightedDiGraph.addVertex(gbp);
		edgeWeightedDiGraph.addVertex(chf);
		edgeWeightedDiGraph.addVertex(cad);

		for (int v = 0; v < input.length; v++) {
			String  from = input[v][0];
			for (int w = 1; w < input[0].length; w++) {
				String to = input[v][0];
				double rate = Double.parseDouble(input[v][w]); 
				DirectedEdge e = new DirectedEdge(from, to, -Math.log(rate));
				edgeWeightedDiGraph.addEdge(e);
			}
		}
		BellmanFord bellmanFord = new BellmanFord(edgeWeightedDiGraph, input[0][0]);
		try {
			bellmanFord.findShortestPath();
			return false;
		} catch (Exception e) {
			return true;
		}

	}
}
