package com.leetcode.algorithm;

import java.util.*;

public class Q22_GenerateParentheses {
    List<String> results = new ArrayList<String>();
    List<Character> path = new ArrayList<>(); 
    int index = 0; //head pointer of path stack
    
    public List<String> generateParenthesis(int n) {
        int rp = n; //num of available right parenthesis
        int lp = n; //letf parenthesis
        int[] par = {1, -1}; //1 represents '(' and -1 represents')'
        
        
        return results;
    }
    
    public void find(int state, int rp, int lp){
    }
}
