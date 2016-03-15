package com.leetcode.algorithm;

public class Q14_LongestCommonPrefix {
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
}
