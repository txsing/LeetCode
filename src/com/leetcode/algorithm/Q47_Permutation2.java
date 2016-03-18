package com.leetcode.algorithm;

import java.util.*;

/**
 * eg, for [1,1,2] compute the permutations without duplication
 * @author txsing
 *
 */
public class Q47_Permutation2 {
	List<Integer> path = new ArrayList<Integer>();
	List<List<Integer>> results = new ArrayList<List<Integer>>();
	
	//runtime: 65ms
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		if (nums.length == 0)
			return ans;
		List<Integer> l0 = new ArrayList<>();
		l0.add(nums[0]);
		ans.add(l0);
		for (int i = 1; i < nums.length; i++) {
			List<List<Integer>> new_ans = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				for (List<Integer> l : ans) {
					List<Integer> new_l = new ArrayList<>(l);
					new_l.add(j, nums[i]);
					// this is quite a naive way to solve duplication problem
					if (!new_ans.contains(l)) {
						new_ans.add(new_l);
					}
				}
			}
			ans = new_ans;
		}
		return ans;
	}
	
	/**
	 * The basic concept behind this method is that, we build a tree with unique branches
	 * e,g,. [1,1,2]: the tree need build is as follow
	 * 	    1- 2
	 *   1- 
	 * 0-   2- 1
	 *   2- 1- 1
	 *
	 *runtime: 8ms
	 */
	public List<List<Integer>> permuteUnique2(int[] nums){
		boolean[] used = new boolean[nums.length]; 
		Arrays.sort(nums);
		find(nums, used);
		return null;
	}
	
	void find(int[] nums, boolean[] used){
		//flag == false means, the next unused Integer should be added to the path
		boolean flag = false;
		for(int i = 0; i < nums.length; i++){
			if(i > 0 && nums[i-1] != nums[i]){
				flag = false;
			}
			if(used[i] == false && flag == false){
				//the next unused Integer (if it equals to the last one)
				//will result in duplication if added, so set flag to true
				flag = true;
				path.add(nums[i]);
				used[i] = true;
				if(path.size() < nums.length){
					find(nums, used);
				}else{
					//reach the end of the tree
					List<Integer> result = new ArrayList<>();
					for(Integer integer : path){
						result.add(integer);
					}
					results.add(result);
				}
				path.remove(path.size()-1);
				used[i] = false;
			}

		}
	}
}