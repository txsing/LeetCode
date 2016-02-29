package com.leetcode.algorithm;

public class Q88_MergeStoredArray {

	// 这个问题肯定是从后往前赋值更节省空间，因为从头开始赋值的话，就需要移动数组！
	// o(n)
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// 这里的条件换成 m>0 的话，while之后还需要再处理 n>m 的情况
		while (n > 0)
			nums1[m + n - 1] = ((m == 0) || (nums2[n - 1] > nums1[m - 1])) ? nums2[--n] : nums1[--m]; // 如果m提前到0，那么就直接跳过大小判断，直接取nums2里的值
	}

	// 这个就是很单纯的解决方案
	public void merge1(int[] nums1, int m, int[] nums2, int n) {
		int[] result = new int[m + n];
		int k = 0;
		int i = 0;
		int j = 0;
		while (i < m && j < n) {
			if (nums1[i] < nums2[j]) {
				result[k++] = nums1[i++];
			} else {
				result[k++] = nums2[j++];
			}
		}

		if (i >= m) {
			while (j < n) {
				result[k++] = nums2[j++];
			}
		} else {
			while (i < m) {
				result[k++] = nums1[i++];
			}
		}
		System.arraycopy(result, 0, nums1, 0, m + n);
	}

}