package com.leetcode.algorithm;

public class Q20_ValidParentheses {
    public boolean isValid(String s) {
        int[] stack = new int[s.length()];
        int head = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(match(ch, stack[head])){
                head --;
                continue;
            }
            stack[head++] = ch;
        }
        
        if(head == 0){
            return true;
        }
        return false;
    }
    
    bool
}
