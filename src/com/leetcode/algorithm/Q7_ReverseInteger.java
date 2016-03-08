package com.leetcode.algorithm;

public class Q7_ReverseInteger {
	/**
	 * Two questions need to consider before coding 
	 * If the integer's last digit is 0, what should the output be? 
	 * Did you notice that the reversed integer might overflow?
	 */
	public int reverse(int x) {
		int result = 0;
		int tail = 0;

		while (x != 0) {
			int intrmResult; // intermediate result
			tail = x % 10;
			x = x / 10;
			intrmResult = result * 10 + tail;

			// if overflow happens, then the intermediate result will not equal to result
			if (intrmResult / 10 != result) {
				return 0;
			} else {
				result = intrmResult;
			}
		}

		return result;
	}
}
