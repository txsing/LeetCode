package com.leetcode.algorithm;

public class Q20_ValidParentheses {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        stack[0] = s.charAt(0);
        int head = 0;
        
        for(int i = 1; i < s.length(); i++){
            char ch = s.charAt(i);
            if(head >=0 && match(stack[head], ch)){
                head --;
                continue;
            }
            if(ch == ')' || ch == '}' || ch == ']'){
                return false;
            }
            stack[++head] = ch;
        }
        
        if(head == -1){
            return true;
        }
        return false;
    }
    
    boolean match(char left, char right){
        if( (left == '(' && right == ')')
        ||(left == '{' && right == '}')
        ||(left == '[' && right == ']')){
            return true;
        }
        return false;
    }
}
