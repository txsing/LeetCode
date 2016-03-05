package com.leetcode.algorithm;

public class Q5_LongestPalindromicSubstring {
	int maxLen = 0;
	int index = 0; //the starting index of the target substring.
	
	public String longestPalindrome(String s){
		int len = s.length();
		if(len<2)
			return s;
		
		for(int i = 0; i<len; i++){
			extendPalindrome(s, i, i);	// when the length of target palindromic string is odd
			extendPalindrome(s, i, i+1); //....even
		}
		
		return s.substring(index,index+maxLen);
	}
	
	/*
	 * This method is used to find a palindromic substring with s[i,j] as central char(s)
	 * j can only be equal to i or i+1 
	 */
	public void extendPalindrome(String s, int i, int k){
		
		//NOTICE: here we cannot put i-- & k++ inside while condition filed
		//WRONG: while(i>=0 && k<s.length() && s.charAt(i--) == s.charAt(k++))
		//because if s[i]!=s[i+1] before entering the loop, k-i-1 will be 2, which is should be 0
		//e,g,. s = "abb"
		while(i>=0 && k<s.length() && s.charAt(i) == s.charAt(k)){
			i--;
			k++;
		}
		if(k-i-1 >maxLen){
			maxLen = k-i-1;
			index = i+1;
		}
	}

}
