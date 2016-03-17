package com.leetcode.algorithm;

import java.util.*;

public class Q47_Permutation2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0)
            return ans;
        List<Integer> l0 = new ArrayList<>();
        l0.add(nums[0]);
        ans.add(l0);
        for(int i = 1; i < nums.length; i++){
            List<List<Integer>> new_ans = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                for(List<Integer> l : ans){
                    if(j != i && nums[i] == l.get(j)){
                        continue;
                    }else{
                        List<Integer> new_l = new ArrayList<>(l);
                        new_l.add(j, nums[i]);
                        new_ans.add(new_l);
                        //System.out.println(j+","+nums[i]);
                    }
                }
            }
            ans = new_ans;
        }
        return ans;
    }
}