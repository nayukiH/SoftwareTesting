package scs.st;

import java.util.Arrays;

public class TakeOutCash {
	
	public static int takeOut(Pocket[] coins, int target) {
		Arrays.sort(coins);
		int count = 0;
		for(int i = coins.length-1; i >= 0; i--) {
			int currentCount = Math.min(coins[i].getCount(), target/coins[i].getValue());
			target -= currentCount * coins[i].getValue();
			count += currentCount;
		}
		if(target > 0) {
			count = -1;
		}
		return count;
	}
	
	public static void main(String args[] ){
		Pocket[] coins = {
				new Pocket(1, 3),
				new Pocket(5, 2),
				new Pocket(10, 1),
				new Pocket(20, 1),
				new Pocket(50, 1),	
		};
		int x = 17;
		int result = takeOut(coins, x);
		if(result > 0) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}
}

