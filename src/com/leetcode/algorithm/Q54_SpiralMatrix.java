package com.leetcode.algorithm;

import java.util.*;

public class Q54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        
        int n = matrix.length;
        for(int i = 0; i < (n+1)/2; i++){
            spiralSquare(matrix, res, i, n - i*2);
        }
        
        return res;
    }
    
    public void spiralSquare(int[][] M, List<Integer> lst, int index ,int n){
        if(n == 1){
            lst.add(M[index][index]);
            return;
        }
        for(int i = 0; i < n - 1; i++)
            lst.add(M[index][index+i]);
        
        for(int i = 0; i < n - 1; i++)
            lst.add(M[index+i][index+n-1]);
        
        for(int i = 0; i < n - 1; i++)
            lst.add(M[index+n-1][index+n-1-i]);
        
        for(int i = 0; i < n - 1; i++)
            lst.add(M[index+n-1-i][index]);
    }
}
