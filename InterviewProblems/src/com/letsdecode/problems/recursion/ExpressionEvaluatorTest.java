package com.letsdecode.problems.recursion;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionEvaluatorTest {

	@Test
	public void test() {
//		char A[] = {'2', '3', '4'};
//		char tokens [] =  {',','*', '+'};
//		String expected [] =  {"23+4=27"};
//		runTest(A, tokens, expected, 27);
//		
//		char[] A2 = {'2'};
//		char tokens2 [] =  {',','*', '+'};
//		String expected2 [] =  {"2=2"};
//		runTest(A2, tokens2, expected2, 2);		

		char[] A3 = {'2', '2', '2'};
		char tokens3 [] =  {',','*', '+'};
		String expected3 [] =  {"2*2+2=6", "2+2*2=6", "2+2+2=6"};
		runTest(A3, tokens3, expected3, 6);	
	}
	
	private void runTest(char[] a, char [] tokens, String[] expected, int target) {
		ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(a, tokens, target);
		expressionEvaluator.call();
		expressionEvaluator.getResult();
		String [] actual = expressionEvaluator.getResult();
		Assert.assertArrayEquals(expected, actual);
	}
}
