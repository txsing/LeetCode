package com.leetcode.algorithm;

import java.util.*;

public class Q46_Permutations {
    List<Integer> trace = new ArrayList<>();
    List<List<Integer>> results = new ArrayList<>();
    
    /**
     * <Q40>CODE REUSE - Compute the sum of nums, then this permutation problem can 
     * be turned into a sum combination problem where the target sum is Sum(nums)
     * Runtime: 5ms
     */
    public List<List<Integer>> permute1(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        
        find(nums, sum, results);
        return results;
    }
    
    void find(int[] candidates, int target, List<List<Integer>> results) {
		for (int i = 0; i < candidates.length; i++) {
		    if(trace.contains(candidates[i])){
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
}