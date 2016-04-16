package com.leetcode.algorithm;

public class Q260_SingleNumberIII {
	/**
	 * The main concept is, find the bit feature that can be used to distinguish
	 * the two single numbers. Here this feature is, the last different bit of
	 * these two single numbers, that is, the last bit with value '1' of (x XOR y).
	 * The last step, divide the whole array into two subsets by this feature.
	 */
	public int[] singleNumber(int[] nums) {
		// Pass 1 :
		// Get the XOR of the two numbers we need to find
		int diff = 0;
		for (int num : nums) {
			diff ^= num;
		}
		
		// Get its last bit with the value '1'
		diff &= -diff;

		// Pass 2 :
		int[] rets = { 0, 0 };
		for (int num : nums) {
			if ((num & diff) == 0) // the bit is '0'
			{
				rets[0] ^= num;
			} else // the bit is '1'
			{
				rets[1] ^= num;
			}
		}
		return rets;
	}
}
