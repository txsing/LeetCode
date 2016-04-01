package com.leetcode.algorithm;

public class Q299_BullsandCows {
	/**
	 * pick out all matched Bulls
	 * model Cows match between secret and guess as Supply (+1) & Demand (-1)
	 * use an array to record the supply & demand state;
	 * @param secret
	 * @param guess
	 * @return
	 */
	public String getHint(String secret, String guess) {
		int bulls = 0;
		int cows = 0;
		int[] numbers = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			//handle all Bull match
			if (secret.charAt(i) == guess.charAt(i))
				bulls++;
			//handle Cows match as Supply & Demand, numbers array is used as state recording
			else {
				if (numbers[secret.charAt(i) - '0']++ < 0)	//supply array[]++
					cows++;
				if (numbers[guess.charAt(i) - '0']-- > 0)	//demand array[]--
					cows++;
			}
		}
		return bulls + "A" + cows + "B";
	}
}
