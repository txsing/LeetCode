package com.leetcode.algorithm;

import java.util.*;

public class Q39_CombinationSum {
	static List<List<Integer>> result = new ArrayList<>();
	static List<Integer> temp = new ArrayList<>();

	public static void main(String args[]) {
		int[] candidates = new int[] { 8, 7, 4, 3 };
		int target = 11;
		System.out.println(toString(combinationSum(candidates, target)));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		find(candidates, target, 0);
		return result;
	}
	
	public static void find(int[] candidates, int target, int j) {
		//i start from j, because if 2->2->3 works, then there is no need to go through 2->3->2 
		//take [2,3], 7 for example
		for (int i = j; i < candidates.length; i++) {
			temp.add(candidates[i]);
			if (target > candidates[i]) {
				find(candidates, target - candidates[i], i);
				temp.remove(temp.size() - 1);
			} else if (target == candidates[i]) {
				//noted that we can not result.add(temp) here
				List<Integer> comb = new ArrayList<>();
				for (Integer num : temp) {
					comb.add(num);
				}
				result.add(comb);
				temp.remove(temp.size() - 1);
			} else {
				temp.remove(temp.size() - 1);
			}

		}
		return;
	}

	public static String toString(List<List<Integer>> lst) {
		String result = "";
		for (List<Integer> list : lst) {
			result = result + list.toString() + "\n";
		}
		return result;
	}
}
