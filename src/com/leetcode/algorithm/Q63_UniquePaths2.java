package com.leetcode.algorithm;

public class Q63_UniquePaths2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int lenx = obstacleGrid.length;
		int leny = obstacleGrid[0].length;
		
		int[][] paths = new int[lenx][leny];
		paths[0][0] = 1 ^ obstacleGrid[0][0];

		for (int i = 1; i < lenx; i++) {
			paths[i][0] = paths[i - 1][0] & (~obstacleGrid[i][0]);
		}

		for (int i = 1; i < leny; i++) {
			paths[0][i] = paths[0][i - 1] & (~obstacleGrid[0][i]);
		}

		for (int i = 1; i < lenx; i++) {
			for (int j = 1; j < leny; j++) {
				paths[i][j] = (1 ^ obstacleGrid[i][j]) * (paths[i - 1][j] + paths[i][j - 1]);
			}
		}
		return paths[lenx - 1][leny - 1];
	}
}
