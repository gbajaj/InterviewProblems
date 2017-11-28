package com.letsdecode.problems.graph.misc;

import org.junit.Test;

import com.letsdecode.problems.graph.misc.BiPartiteGraph.Vertex;

public class BiPartiteGraphTest {

	@Test
	public void test() {
		BiPartiteGraph biPartiteGraph = new BiPartiteGraph();
		Vertex v1 = biPartiteGraph.new Vertex();
		v1.label = "1";
		
		Vertex v2 = biPartiteGraph.new Vertex();
		v2.label = "2";

		Vertex v3 = biPartiteGraph.new Vertex();
		v3.label = "3";

		Vertex v4 = biPartiteGraph.new Vertex();
		v4.label = "4";
		connect(v4, v2);
		connect(v4, v3);

		connect(v1, v2);
		connect(v1, v3);
		biPartiteGraph.vertices.add(v1);
		biPartiteGraph.vertices.add(v2);
		biPartiteGraph.vertices.add(v3);
		biPartiteGraph.vertices.add(v4);
		System.out.println(biPartiteGraph.BFS(v1));
		
	}
	
	private void connect(Vertex a, Vertex b) {
		a.edges.add(b);
		b.edges.add(a);
	}
	
}
