package com.letsdecode.problems.graph.misc;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComputeEnclosedRegionsTest {
	String W = ComputeEnclosedRegions.W;
	String B = ComputeEnclosedRegions.B;

	@Test
	public void test() {
		
		String matrix[][] = {
								{B,B,B,B},
								{W,B,W,B},
								{B,W,W,B},
								{B,B,B,B}
							};
		ComputeEnclosedRegions computeEnclosedRegions = new ComputeEnclosedRegions(matrix);
		computeEnclosedRegions.print();
		computeEnclosedRegions.computeRecursiveDFS();
		computeEnclosedRegions.print();
	}
	
	@Test
	public void computeEnclosedRegions_RecursiveBFS() {
		
		String matrix[][] = {
								{B,B,B,B},
								{W,B,W,B},
								{B,B,W,B},
								{B,B,B,B}
							};
		ComputeEnclosedRegions computeEnclosedRegions = new ComputeEnclosedRegions(matrix);
		computeEnclosedRegions.print();
		computeEnclosedRegions.computeRecursiveBFS();
		computeEnclosedRegions.print();
	}
}
