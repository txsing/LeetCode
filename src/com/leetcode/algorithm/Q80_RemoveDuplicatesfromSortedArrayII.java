package com.leetcode.algorithm;

public class Q80_RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int index = 1;
        int count = 1;
        int last = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > last){
                count = 1;
                last = nums[i];
            }else{
                count++;
                if(count > 2){
                    continue;
                }
            }
            nums[index++] = nums[i];
        }
        return index;
    }
}
