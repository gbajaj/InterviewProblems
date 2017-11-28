package com.letsdecode.problems.epi.chapter6;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import com.letsdecode.problems.graph.edgeweighted.Vertex;

public class Chapter6ProblemsTest {

	@Test
	public void test() {
		Chapter6Problems chapter6Problems = new Chapter6Problems();
		Vector<Integer> a = new Vector<>();
		a.add(7);
		a.add(9);
		a.add(9);
		chapter6Problems.incrementBigIntergre(a);
		for (Integer i : a) {
			System.out.print(i);
		}
	}

}
