package com.leetcode.algorithm;

public class Q26_RemoveDuplicatesfromSortedArray {
	/**
	 * Two pointers, "index" and "i" "i" went through all elements in nums and
	 * "index" is used to record non-duplicated elements
	 * 
	 */
	public int removeDuplicates(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}
		int index = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1])
				nums[index++] = nums[i];
		}
		return index;
	}
}
