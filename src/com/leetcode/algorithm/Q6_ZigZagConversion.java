package com.leetcode.algorithm;

public class Q6_ZigZagConversion {
	public String convert(String s, int numRows) {
		int len = s.length();
		if (numRows < 2 || len == 0) {
			return s;
		}
		String result[] = new String[numRows];
		for (int i = 0; i < numRows; i++) {
			result[i] = "";
		}
		int count = 2 * numRows - 2;
		int step = len / count + 1;
		int index = 0;
		for (int i = 0; i < step; i++) {
			System.out.println("NEW");
			index = count * i;
			System.out.println(index);
			result[0] += s.charAt(index);
			for (int j = 1; j < numRows - 1; j++) {
				if ((index = j + count * i) < len) {
					System.out.print(index + ",");
					result[j] += s.charAt(index);
				}
				if ((index = 2 * (numRows - 1 + count * i) - j) < len) {
					System.out.print(index);
					result[j] += s.charAt(index);
				}
				System.out.println("");
			}
			if ((index = numRows - 1 + count * i) < len) {
				System.out.println(index);
				result[numRows - 1] += s.charAt(index);
			}
		}
		String results = "";
		for (int i = 0; i < numRows; i++) {
			System.out.println(result[i]);
			results += result[i];
		}
		return results;
	}
}