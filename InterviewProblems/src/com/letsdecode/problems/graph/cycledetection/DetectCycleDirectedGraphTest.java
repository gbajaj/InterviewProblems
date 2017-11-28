package com.letsdecode.problems.graph.cycledetection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.letsdecode.problems.graph.cycledetection.DetectCycleDirectedGraph.Vertex;

public class DetectCycleDirectedGraphTest {

	@Test
	public void testHasCycle() {
		Boolean USE_V2_NOT = Boolean.FALSE;
		int[][] graph = { { 1, 2 }, { 2, 3 }, { 3, 4 } };

		DetectCycleDirectedGraph diGraph = new DetectCycleDirectedGraph();

		Map<Integer, DetectCycleDirectedGraph.Vertex> vertices = new HashMap<>();

		for (int[] a : graph) {
			Vertex start = vertices.get(a[0]);
			Vertex end = vertices.get(a[1]);
			if (start == null) {
				start = new Vertex();
				start.id = a[0];
				vertices.put(start.id, start);
			}

			if (end == null) {
				end = new Vertex();
				end.id = a[1];
				vertices.put(end.id, end);
			}
			start.addAdjacent(end);
		}
		Collection<Vertex> values = vertices.values();
		ArrayList<Vertex> list = new ArrayList<>();
		list.addAll(values);
		if (diGraph.hasCycle(list, USE_V2_NOT)) {
			System.out.println("Has Cycle");
		} else {
			System.out.println("Doesn't have a Cycle");
		}

	}

	@Test
	public void testHasCycleV2() {
		Boolean USE_V2 = Boolean.TRUE;
		int[][] graph = { { 1, 2 }, { 2, 3 }, { 3, 4 } };

		DetectCycleDirectedGraph diGraph = new DetectCycleDirectedGraph();

		Map<Integer, DetectCycleDirectedGraph.Vertex> vertices = new HashMap<>();

		for (int[] a : graph) {
			Vertex start = vertices.get(a[0]);
			Vertex end = vertices.get(a[1]);
			if (start == null) {
				start = new Vertex();
				start.id = a[0];
				vertices.put(start.id, start);
			}

			if (end == null) {
				end = new Vertex();
				end.id = a[1];
				vertices.put(end.id, end);
			}
			start.addAdjacent(end);
		}
		Collection<Vertex> values = vertices.values();
		ArrayList<Vertex> list = new ArrayList<>();
		list.addAll(values);
		if (diGraph.hasCycle(list, USE_V2)) {
			System.out.println("Has Cycle");
		} else {
			System.out.println("Doesn't have a Cycle");
		}

	}
}
