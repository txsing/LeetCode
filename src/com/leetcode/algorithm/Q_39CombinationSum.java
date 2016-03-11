package com.leetcode.algorithm;

import java.util.*;

public class Q_39CombinationSum {
	List<List<Integer>> result = new ArrayList<>();
	List<Integer> temp = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		find(candidates, target);
		return result;
	}

	public void find(int[] candidates, int target) {
		for (int i = 0; i < candidates.length; i++) {
			if (target > candidates[i]) {
				temp.add(candidates[i]);
				find(candidates, target - candidates[i]);
			} else if (target == candidates[i]) {
				temp.add(candidates[i]);
				result.add(temp);
			}
		}
		return;
	}
}
