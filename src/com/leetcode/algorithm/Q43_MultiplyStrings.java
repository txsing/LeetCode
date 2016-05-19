package com.leetcode.algorithm;

public class Q43_MultiplyStrings {
	public String multiply(String num1, String num2) {
		int n = num1.length(), m = num2.length();
		// 999 * 999 < 1000 * 999 = 999000 (6 digits), so max No. of digits of
		// (num1 * num2) is n+m
		int res[] = new int[n + m];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				mul += res[i + j + 1];
				res[i + j + 1] = mul % 10;
				res[i + j] += mul / 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int p : res)
			if (!(sb.length() == 0 && p == 0))
				sb.append(p);
		return sb.length() == 0 ? "0" : sb.toString();
	}
}