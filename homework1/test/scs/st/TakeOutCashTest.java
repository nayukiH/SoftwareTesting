package scs.st;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TakeOutCashTest {
	TakeOutCash takes;
	Pocket[] coins = {
			new Pocket(1, 3),
			new Pocket(5, 2),
			new Pocket(10, 1),
			new Pocket(20, 1),
			new Pocket(50, 1),	
	};
	
	@Before
	public void before() {
		takes = new TakeOutCash();
	}

	@Test
	public void testTakeOut() {
		int result1 = takes.takeOut(coins, 0);
		int result2 = takes.takeOut(coins, -1);
		int result3 = takes.takeOut(coins, 94);
		int result4 = takes.takeOut(coins, 93);
		int result5 = takes.takeOut(coins, 24);
		assertEquals(0, result1);
		assertEquals(-1, result2);
		assertEquals(-1, result3);
		assertEquals(8, result4);
		assertEquals(-1, result5);
	}

}
