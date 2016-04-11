package com.leetcode.algorithm;

public class Q34_SearchforaRange {
	public int[] searchRange(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;
		int mid = 0;

		if (target > nums[r] || target < nums[0]) {
			return new int[] { -1, -1 };
		}

		while (l < r) {
			mid = (l + r) / 2;
			if (nums[mid] > target) {
				r = mid - 1;
			} else if (nums[mid] < target) {
				l = l + 1;
			} else {
				l = mid;
				r = mid;
				break;
			}
		}

		if (nums[l] != target) {
			return new int[] { -1, -1 };
		} else {
			while (l >= 0 && nums[l] == target) {
				l--;
			}

			while (r <= nums.length - 1 && nums[r] == target) {
				r++;
			}
		}
		return new int[] { l + 1, r - 1 };
	}
}
