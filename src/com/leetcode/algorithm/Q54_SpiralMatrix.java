package com.leetcode.algorithm;

import java.util.*;

public class Q54_SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		int m = matrix.length;

		if (m == 0)
			return res;

		int n = matrix[0].length;

		for (int i = 0; i < (Math.min(m, n) + 1) / 2; i++) {
			spiral(matrix, res, i, n - i * 2, m - i * 2);
		}

		return res;
	}

	public void spiral(int[][] M, List<Integer> lst, int index, int n, int m) {
		if (m == 1) {
			for (int i = 0; i < n; i++)
				lst.add(M[index][index + i]);
			return;
		}

		if (n == 1) {
			for (int i = 0; i < m; i++)
				lst.add(M[index + i][index]);
			return;
		}

		for (int i = 0; i < n - 1; i++)
			lst.add(M[index][index + i]);

		for (int i = 0; i < m - 1; i++)
			lst.add(M[index + i][index + n - 1]);

		for (int i = 0; i < n - 1; i++)
			lst.add(M[index + m - 1][index + n - 1 - i]);

		for (int i = 0; i < m - 1; i++)
			lst.add(M[index + m - 1 - i][index]);
	}
}
