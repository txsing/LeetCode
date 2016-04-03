package com.leetcode.algorithm;

public class Q283_MoveZeroes {
	public void moveZeroes(int[] nums){
		int index = 0;
		// Shift non-zero values as far forward as possible
		// Fill remaining space with zeros
		for(int i = 0; i<nums.length; i++){
			if(nums[i]!=0){
				nums[index++] = nums[i];
			}
		}
		while(index<nums.length){
			nums[index++] = 0;
		}
	}
}
