package com.leetcode.algorithm;

public class Q6_ZigZagConversion {
	/**
	 * 0    6     null
	 *  1  5 7   null
	 *  2 4  8 10
	 *  3    9
	 * the structure of a interval is |/, so in the above example, there are 2 intervals, the first one is 0-5, the second one is 6-10
	 * the length of a full interval is 6 = 2 * (Rows - 1)
	 */
    public String convert(String s, int numRows) {
        int len = s.length();
        if(numRows < 2 || len <= numRows){
            return s;
        }
        String result[] = new String[numRows];
        for(int i = 0; i < numRows; i++){
            result[i] = "";
        }
        
        //length of each full interval
        int intervallen = 2 * numRows - 2;
        
        //no.of intervals
        int intervals = (int)Math.ceil((double)len / (double)intervallen);
        
        int index = 0;
        for(int i = 0; i < intervals; i++){
            index = intervallen*i;
            //the first elements in | (of a interval)
            result[0] += s.charAt(index);
            
            //handle the elements in /
            for(int j = 1; j < numRows-1; j++){
                if((index = j+intervallen*i) < len){
                    result[j] += s.charAt(index);
                }
                if((index = 2*(numRows-1+intervallen*i) - index)<len){
                    result[j] += s.charAt(index);
                }
            }
            
            //the last elements of |
            if((index = numRows-1+intervallen*i) < len){
                result[numRows-1] += s.charAt(index);
            }
        }
        String results = "";
        for(int i = 0; i < numRows; i++){
            System.out.println(result[i]);
            results += result[i];
        }
        return results;
    }
}