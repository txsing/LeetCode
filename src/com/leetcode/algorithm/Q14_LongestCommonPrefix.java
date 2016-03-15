package com.leetcode.algorithm;

public class Q14_LongestCommonPrefix {
	
	/*
	 * Make use of Java try-catch mechanism to handle out-of-bound problem 
	 * Runtime: 3ms 
	 */
    public String longestCommonPrefix(String[] strs) {
        String result ="";
        if(strs.length == 0){
            return result;
        }
        for(int i = 0; i<strs[0].length(); i++){
            try{
                char ch = strs[0].charAt(i);
                for(int j = 1; j<strs.length; j++){
                    if(strs[j].charAt(i) != ch){
                        return result;
                    }
                }
                result += ch;
            }catch(StringIndexOutOfBoundsException e){
                return result;
            }
        }
        return result;
    }
    
    /*
     * Keep reducing strs[0] into target common prefix
     * Runtime: 1ms
     */
    public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0){
        	return "";
        }
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0){
                pre = pre.substring(0,pre.length()-1);
            }
            i++;
        }
        return pre;
    }
}
