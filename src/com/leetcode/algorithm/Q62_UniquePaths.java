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
    
    /***
     * Dynamic programming
     * unique(m,n) = unique(m-1, n) + unique(m, n-1)
     * when m == 0 || n == 0, unique() = 1;
     */
    public int uniquePaths2(int m, int n){
    	int[][] paths = new int[m][n];
    	for(int i = 0; i<m; i++){
    		for(int j =0; j<n; j++){
    			if(i == 0 || j==0){
    				paths[i][j] = 1;
    			}else{
    				paths[i][j] = paths[i-1][j] + paths[i][j-1];
    			}
    		}
    	}
    	return paths[m-1][n-1];
    }
}
