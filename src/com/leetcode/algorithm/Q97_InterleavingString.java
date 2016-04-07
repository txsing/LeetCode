package com.leetcode.algorithm;

public class Q97_InterleavingString {
	/**
	 * DP Algorithm (Assuming that the index starts from 1 instead of 0)
	 * F(x, y) = True or False = whether s3[1, x+y] is interleaved by s1[1,x] and s2[1,y]
	 * Iterative formula: F(x, y) = (F(x-1, y) && s1[x])||(F(x,y-1) && s2[y])
	 * 
	 * when x = 0 or y = 0, which means s3[1,x+y] is the substring of s1, s2 respectively.
	 */
	public boolean isInterleave(String s1, String s2, String s3) {
		//wrong input case
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		boolean[][] table = new boolean[s1.length() + 1][s2.length() + 1];
		
		//special case when s1=s2=s3=""
		table[0][0] = true;
		
		//Init
		for (int i = 1; i <= s2.length(); i++) {
			table[0][i] = (s2.charAt(i - 1) == s3.charAt(i - 1)) && table[0][i - 1];
		}

		for (int i = 1; i <= s1.length(); i++) {
			table[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1)) && table[i - 1][0];
		}
		
		//Iteration
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				table[i][j] = (table[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
						|| (table[i][j - 1]) && s2.charAt(j - 1) == s3.charAt(i + j - 1);
			}
		}

		return table[s1.length()][s2.length()];
	}
}