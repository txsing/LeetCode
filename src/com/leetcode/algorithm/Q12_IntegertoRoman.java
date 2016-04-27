package com.leetcode.algorithm;

public class Q12_IntegertoRoman {
	public String intToRoman(int num) {
		int list[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		// the cases where small value symbols are put right beside larger value
		// symbols are limited to those starting with I, X, C
		String chars[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int i = 0;
		String out = "";
		while (num > 0) {
			for (; i < list.length; i++)
				if (num >= list[i])
					break;
			out += chars[i];
			num -= list[i];
		}
		return out;
	}
}
