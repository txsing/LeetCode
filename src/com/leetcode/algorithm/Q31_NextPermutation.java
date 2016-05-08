package com.leetcode.algorithm;

public class Q31_NextPermutation {
	public static void nextPermutation(int[] nums) {
		int r = nums.length - 1;
		int l = r - 1;

		while (r != 0) {
			if (nums[l] < nums[r]) {
				r = nums.length;
				do r--;
				while (nums[l] >= nums[r]);
				swap(nums, l, r);
				
                for(r = l+1; r<(nums.length+l+1)/2; r++){
                    swap(nums, r, nums.length+l-r);
                }
                
				return;
			}
			r--;
			l--;
		}

		for (r = 0; r < nums.length / 2; r++) {
			swap(nums, r, nums.length - 1 - r);
		}
	}
	
	/**
	 * implementation of quick sort algorithm.
	 */
	public static void quicksort(int[] K, int s) {
		quick(K, s, K.length - 1);
	}

	public static void quick(int[] K, int s, int t) {
		int i, j;
		if (s < t) {
			i = s;
			j = t + 1;
			while (true) {
				do
					i++;
				while (!(K[s] <= K[i] || i == t));
				do
					j--;
				while (!(K[s] >= K[j] || j == s));
				if (i < j)
					swap(K, i, j);
				else
					break;
			}
			swap(K, s, j);
			quick(K, s, j - 1);
			quick(K, j + 1, t);
		}
	}

	public static void swap(int[] n, int i, int j) {
		int temp = n[i];
		n[i] = n[j];
		n[j] = temp;
	}
}
