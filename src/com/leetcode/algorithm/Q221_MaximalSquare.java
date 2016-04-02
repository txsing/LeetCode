package com.leetcode.algorithm;

public class Q221_MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		int len = matrix.length;
		int result = 0;
		int temp = 0;
		for (int xy = 0; xy < len; xy++) {
			temp = maxSqrLen(matrix, xy, xy, temp - 1);
			if (temp == 0) {
				continue;
			}
			int vt = temp;
			int ht = temp;
			for (int i = xy + 1; i < len; i++) {
				vt = maxSqrLen(matrix, xy, i, vt - 1);
				if (vt > result) {
					result = vt;
				}

				ht = maxSqrLen(matrix, i, xy, ht - 1);
				if (ht > result) {
					result = ht;
				}
			}
		}
		return result * result;
	}

	public int maxSqrLen(char[][] matrix, int x, int y, int skips) {
		if (matrix[x][y] == '0') {
			return 0;
		}
		if (skips < 1) {
			skips = 1;
		}
		while (skips < matrix.length - x && skips < matrix.length - y) {
			int i = skips;
			for (int j = 0; j <= i; j++) {
				if (matrix[x + i][x + j] != '1' || matrix[x + i][y + j] != matrix[x + j][x + i]) {
					return skips;
				}
			}
			skips++;
		}
		return skips;
	}

}
