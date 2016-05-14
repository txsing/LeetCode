package com.leetcode.algorithm;

public class Q35_SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		int len = nums.length;
		int L = 0, R = len - 1;
		int mid = 0;

		while (L <= R) {
			mid = (L + R) / 2;
			if (target == nums[mid])
				return mid;
			if (nums[mid] > target) {
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}

		if (L > mid)
			return L;
		return R + 1;
	}
}
