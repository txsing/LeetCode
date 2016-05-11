package com.leetcode.algorithm;

import java.util.*;

public class Q36_ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			if (!isParticallyValid(board, i, 0, i, 8))
				return false;
			if (!isParticallyValid(board, 0, i, 8, i))
				return false;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!isParticallyValid(board, i * 3, j * 3, i * 3 + 2, j * 3 + 2))
					return false;
			}
		}
		return true;
	}

	private boolean isParticallyValid(char[][] board, int x1, int y1, int x2, int y2) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				if (board[i][j] != '.') {
					// hashset:add, return false when the item to be added is
					// already in the set
					if (!set.add(board[i][j]))
						return false;
				}
			}
		}
		return true;
	}
}
