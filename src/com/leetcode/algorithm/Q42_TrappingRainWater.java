package com.leetcode.algorithm;

public class Q42_TrappingRainWater {
	public int trap(int[] A) {
		int len = A.length;
		int left = 0, right = len - 1;
		int maxleft = 0, maxright = 0;
		int res = 0;

		while (left <= right) {
			if (A[left] <= A[right]) {
				if (A[left] >= maxleft)
					maxleft = A[left];
				else
					res += maxleft - A[left];
				left++;
			} else {
				if (A[right] >= maxright)
					maxright = A[right];
				else
					res += maxright - A[right];
				right--;
			}
		}

		return res;
	}
}
