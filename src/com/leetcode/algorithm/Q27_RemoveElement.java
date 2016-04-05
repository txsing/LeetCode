package com.leetcode.algorithm;

public class Q27_RemoveElement {
	/**
	 * The naive way to solve this problem is just scan the whole array from
	 * n[0] to n[length-1] step by step, when meet val, then remove and move the
	 * rest array to left by one step. while when the element that need to be
	 * remove is rare and they appear in the staring part of the array, then
	 * move the whole rest array is too costly and we didn't use the given
	 * condition: "the order of the elements in the array can be changed"
	 * 
	 * So here we use two points, we swap the pointer when the left pointer meet
	 * val. runtime: 0ms
	 */
	public int removeElement(int[] nums, int val) {
		int l = 0;
		int r = nums.length - 1;
		int count = 0;

		while (l <= r) {
			// nums[r] should be the last non-Val elements of nums[0,r]
			if (nums[r] == val) {
				count++;
				r--;
				continue;
			}
			// prevent case: l==r and nums[l]!=val
			if (l == r) {
				break;
			}
			// cover nums[l]
			if (nums[l] == val) {
				count++;
				nums[l] = nums[r];
				nums[r] = val;
				r--;
			}
			l++;
		}
		return nums.length - count;
	}

	/**
	 * This implementation uses least moves which is more compact.
	 */
	public static int removeElement2(int[] nums, int val) {
		int valSize = 0;
		int rear = nums.length - 1;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				// get the last rear value!=val,cover the current val;
				// last move
				for (; rear != i && rear >= 0; rear--) {
					if (nums[rear] != val) {
						nums[i] = nums[rear];
						rear--;
						break;
					}
				}
				valSize++;
			}
		}
		return nums.length - valSize;
	}
}
