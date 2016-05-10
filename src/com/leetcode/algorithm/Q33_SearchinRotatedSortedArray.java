package com.leetcode.algorithm;

public class Q33_SearchinRotatedSortedArray {
	public int search(int[] nums, int target) {
		int len = nums.length;
		int l = 0, r = len - 1;
		int mid = 0;
		if (nums.length == 0)
			return -1;
		if (nums.length == 1) {
			return nums[0] == target ? 0 : -1;
		}
		// find the minimal value
		while (l < r) {
			mid = (l + r) / 2;
			if (nums[mid] == target) {
				return mid;
			}

			if (nums[mid] > nums[r])
				l = mid + 1;
			else
				r = mid;
		}

		int rot = l;
		l = 0;
		r = len - 1;

		while (l <= r) {
			mid = (l + r) / 2;
			int realmid = (mid + rot) % len;
			if (nums[realmid] == target)
				return realmid;
			if (nums[realmid] < target)
				l = mid + 1;
			else
				r = mid - 1;
		}
		return -1;
		// mid = r;
		// int index = bs(nums, 0, mid - 1, target);
		// return index != -1 ? index : bs(nums, mid, len - 1, target);
	}

	public static int bs(int[] nums, int s, int e, int target) {
		int mid;

		if (s < 0 || e < 0 || e > nums.length)
			return -1;

		if (s == e) {
			if (target == nums[s])
				return s;
			else
				return -1;
		}

		while (s <= e) {
			// noted that it is "s + (e - s)/2"
			mid = s + (e - s) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] > target)
				e = mid - 1;
			else
				s = mid + 1;
		}

		return -1;
	}
}
