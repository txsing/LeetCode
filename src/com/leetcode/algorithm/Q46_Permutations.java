package com.leetcode.algorithm;

import java.util.*;

public class Q46_Permutations {
	List<Integer> trace = new ArrayList<>();
	List<List<Integer>> results = new ArrayList<>();

	/**
	 * <Q40>CODE REUSE - Compute the sum of nums, then this permutation problem
	 * can be turned into a sum combination problem where the target sum is
	 * Sum(nums) so we can reuse the code of Q40 Combination Sum 2 Runtime: 5ms
	 */
	public List<List<Integer>> permute1(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		find(nums, sum, results);
		return results;
	}

	// modified code of Q40
	void find(int[] candidates, int target, List<List<Integer>> results) {
		for (int i = 0; i < candidates.length; i++) {
			if (trace.contains(candidates[i])) {
				continue;
			}
			trace.add(candidates[i]);
			if (trace.size() < candidates.length) {
				find(candidates, target - candidates[i], results);
			}

			if (trace.size() == candidates.length) {
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

	/**
	 * typical recursive solution
	 * X 1 X -> X 2 X 1 X & X 1 X 2 X-> 3 2 1, 2 3 1, 2 1 3
	 * 	 l         new_l1 & new_l2		 
	 * 					ans		
	 */
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if (num.length == 0)
			return ans;
		List<Integer> l0 = new ArrayList<Integer>();
		l0.add(num[0]);
		ans.add(l0);
		for (int i = 1; i < num.length; ++i) {
			List<List<Integer>> new_ans = new ArrayList<List<Integer>>();
			for (int j = 0; j <= i; ++j) {
				for (List<Integer> l : ans) {
					List<Integer> new_l = new ArrayList<Integer>(l);
					new_l.add(j, num[i]);
					new_ans.add(new_l);
				}
			}
			ans = new_ans;
		}
		return ans;
	}

}