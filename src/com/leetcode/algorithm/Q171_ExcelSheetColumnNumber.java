package com.leetcode.algorithm;

public class Q171_ExcelSheetColumnNumber {
	/**
	 * A=1, B=2, ... , AA->27
	 * recall Rabin-Karp algorithm
	 * we can interpret a string as an integer
	 */
    public int titleToNumber(String s) {
        int result = 0;
        int len = s.length();
        int i = 0;
        for(i = 0; i < len - 1; i++){
            result = (result + (s.charAt(i) - 'A' + 1))*26;
        }
        result = result + (s.charAt(i) - 'A' + 1);
        return result;
    }
}
