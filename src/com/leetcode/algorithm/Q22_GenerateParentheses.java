package com.leetcode.algorithm;

import java.util.*;

public class Q22_GenerateParentheses {
    List<String> results = new ArrayList<String>();
    String path = ""; 
    
    public List<String> generateParenthesis(int n) {
        find(0,n,n);
        return results;
    }
    
    /**
     * 
     * @param state: INIT, state = 0; path.add('(') then state += 1;  path.add(')') then state -=1
     * @param rp: the No. of available right parenthesis
     * @param lp: the No. of available right parenthesis
     * runtime: 2ms
     */
    public void find(int state,int rp, int lp){
        //add '('
        if(rp > 0){
            rp -= 1;
            path += '(';
            state += 1;
            find(state, rp, lp);
            state -= 1;
            path = path.substring(0,path.length()-1);
            rp += 1;
        }
        //add ')'
        if(state > 0){
            lp -= 1;
            path += ')';
            state -= 1;
            
            //reach the end of the tree
            if(lp == 0){
                String result = path;
                results.add(result);
            }
            
            find(state, rp, lp);
            state += 1;
            path = path.substring(0,path.length()-1);
            rp -= 1;
        }
    }
}
