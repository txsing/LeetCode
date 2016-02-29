package com.leetcode.algorithm;
import java.util.Arrays;

public class Q4_MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		Q4_MedianOfTwoSortedArrays test = new Q4_MedianOfTwoSortedArrays();
		int[] nums1 = { 2 };
		int[] nums2 = {};
		System.out.println(test.findMedianSortedArrays1(nums1, nums2));
	}

	public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;

		int i = (m + n + 1) >> 1; // X>>n 在不溢出的情况下等同于 X/2^n
		int j = (m + n + 2) >> 1; // 另外计算size为n的数组的中位数时,(n+1)/2和(n+2)/2
									// 取整得到下标，是标准做法。
		double result = (findKth(nums1, m, nums2, n, i) + findKth(nums1, m, nums2, n, j)) / 2.0;
		return result;
	}

	//两个排序好了的数组A、B合并为AB，找第k大的数，如果数组A的第k/2大的数小于数组B的第k/2大的数，那么说明A[0...K/2-1]一定都在AB[k]的左边。
	//利用这一逻辑，可以不断地递归剔除A[0...K/2-1]直到结束，复杂度 o(log(m+n))
	int findKth(int[] s1, int m, int[] s2, int n, int k) {
		if (m > n) {
			return findKth(s2, n, s1, m, k);
		}
		if (m == 0) {
			return s2[k - 1];
		}

		if (k == 1) {
			return Math.min(s1[0], s2[0]);
		}
		int i = Math.min(m, k / 2);
		int j = Math.min(n, k / 2);


		if (s1[i - 1] < s2[j - 1]) {
			int[] temp = Arrays.copyOfRange(s1, i, s1.length);
			return findKth(temp, m - i, s2, n, k - i);
		} else {
			int[] temp = Arrays.copyOfRange(s2, j, s2.length);
			return findKth(s1, m, temp, n - j, k - j);
		}
	}

	//log(min(m,n))
	//将A、B数组各自都分成两部分A[0~i-1] A[i~m] 以及 B[0~j-1] B[j~n]
	//找到一个i从而满足 1) len(left_part) == len(right_part) 2) max(left_part) <= min(right_part) 即可
	//利用二分查找法找 i
	public double findMedianSortedArrays2(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		if (m > n) {
			return findMedianSortedArrays2(B, A);
		}
		int L = 0;
		int R = m;
		int i = 0;
		int j = 0;
		int left_max;
		int right_min;
		while (L <= R) {
			i = (L + R) >> 1;
			j = (m + n + 1) / 2 - i;
			if (j > 0 && i < m && B[j - 1] > A[i]) {
				L = i + 1;
			} else if (i > 0 && j < n && A[i - 1] > B[j]) {
				R = i - 1;
			} else {
				// i is perfect
				if (i == 0) {
					left_max = B[j - 1];
				} else if (j == 0) {
					left_max = A[i - 1];
				} else {
					left_max = Math.max(A[i - 1], B[j - 1]);
				}
				if ((m + n) % 2 == 1) {
					return left_max;
				} else {
					if (i == m) {
						right_min = B[j];
					} else if (j == n) {
						right_min = A[i];
					} else {
						right_min = Math.min(A[i], B[j]);
					}
				return (left_max + right_min) / 2.0;	
				}
			}
		}
		return -1;
	}
}
