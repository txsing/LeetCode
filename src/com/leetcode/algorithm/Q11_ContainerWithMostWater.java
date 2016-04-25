package com.leetcode.algorithm;

public class Q11_ContainerWithMostWater {
	/**
	 * The basic concept behind is that assume the max area is obtained from
	 * [Am, An] we set two pointer(l,r) at the two ends of the array, and the
	 * pointer with smaller value move to the inner array. there must be a
	 * pointer which firstly reaches the Am/An, we assume it is l which firstly
	 * reach Am, at the same time r > n we now prove, l will stay at m, and r
	 * will keep moving to inner array until it reaches n.
	 * 
	 * maxArea = min[Am, An] * (m - n) the current area = min[Am, Ar] * (r - n)
	 * because (r-n) > (m-n), min[Am, An] must greater than min[Am, Ar] if Ar >
	 * Am, min[Am, Ar] = Am <= min[Am, An], which violates our assumption. so Ar
	 * will always less then An, so r will keep moving to inner array util it
	 * reaches n.
	 */
	public int maxArea(int[] h) {
		int max = 0;
		int l = 0;
		int r = h.length - 1;
		while (l < r) {
			/* 8ms */
			// max = Math.max(max, Math.min(h[l], h[r]) * (r - l));

			/* 8ms */
			// if(h[l] < h[r]){
			// l++;
			// }else{
			// r--;
			// }

			/* 6ms */
			int height = (h[l] < h[r]) ? h[l] : h[r];
			int area = height * (r - l);
			max = (max > area) ? max : area; // 6ms

			/* 3ms */
			int valL = h[l];
			int valR = h[r];
			if (valL <= valR) {
				// if the next value is even less then previous one, and the
				// width is shorter now, the current area we get is surely not
				// we want.
				while (l < r && h[l] <= valL) {
					l++;
				}
			} else {
				while (l < r && h[r] <= valR) {
					r--;
				}
			}
		}
		return max;
	}
}
