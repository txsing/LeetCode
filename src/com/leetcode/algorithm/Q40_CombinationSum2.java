package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40_CombinationSum2 {

	List<Integer> trace = new ArrayList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> results = new ArrayList<>();
		Arrays.sort(candidates);
		find(candidates, target, 0, results);
		return results;
	}

	void find(int[] candidates, int target, int start, List<List<Integer>> results) {
		for (int i = start; i < candidates.length; i++) {
			//Avoid duplication
			if (i > start && candidates[i - 1] == candidates[i]) {
				continue;
			}
			trace.add(candidates[i]);
			if (target - candidates[i] > 0) {
				find(candidates, target - candidates[i], i + 1, results);
			}

			if (target - candidates[i] == 0) {
				List<Integer> result = new ArrayList<>();
				for (Integer num : trace) {
					result.add(num);
				}
				results.add(result);
			}

			trace.remove(trace.size() - 1);
		}
		return;
	}
}
