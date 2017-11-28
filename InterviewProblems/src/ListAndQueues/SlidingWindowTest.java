package ListAndQueues;

import static org.junit.Assert.*;

import org.junit.Test;

public class SlidingWindowTest {

	@Test
	public void testgenerateMaxElements() {
		int a[] = { 1, 3, 1, 2, 0, 5 };
		new SlidingWindow(a, 3).generateMaxElements();
	}

}
