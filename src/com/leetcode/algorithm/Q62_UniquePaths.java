package com.leetcode.algorithm;

public class Q62_UniquePaths {
	
	/***
	 * Use math formula of permutation	and	combination to solve this problems
	 * result = C(N, down)
	 */
    public int uniquePaths(int m, int n) {
        int N = m+n-2; //total num of steps
        int down = m-1;
        double result = 1;
        for(int i = 1; i <= down; i++){
            result = result * (N- down + i) / i;
        }
        return (int)result;
    }
}
