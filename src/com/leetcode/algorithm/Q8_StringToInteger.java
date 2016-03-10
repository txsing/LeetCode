package com.leetcode.algorithm;

public class Q8_StringToInteger {
	final int INT_MAX = 2147483647;
	final int INT_MIN = -2147483648;

	public int myAtoi(String str) {
		// if str is null, return 0
		if (str == null) {
			return 0;
		}

		int result = 0;
		char cur = ' ';
		int posneg = 0;
		boolean conStart = false;

		for (int i = 0; i < str.length(); i++) {
			cur = str.charAt(i);

			// when meet '+' or '-', the conversion starts, valuence set
			// any following non-numeric char will stop the conversion
			if (((cur == '-' || cur == '+') && posneg == 0)) {
				conStart = true;
				// '+' -> 43 and '-' -> 45
				posneg = 44 - cur;
				continue;
			}

			// before the conversion starts, ignore white spaces
			if (conStart == false && (cur == ' ' || (cur >= 0 && cur <= 31)))
				continue;

			// If the first sequence of non-whitespace char is non-numeric, then
			// return 0
			if (cur > 57 || cur < 48)
				return result;

			// parse the numeric char
			if (cur >= 48 && cur <= 57) {
				conStart = true;
				if (posneg == 0)
					posneg = 1;
				int newResult = posneg * (cur - '0') + result * 10;

				// if overflow happens, newResult/10 != result
				if (newResult / 10 == result) {
					result = newResult;
				} else {
					if (result < 0)
						return INT_MIN;
					return INT_MAX;
				}
			}
		}

		// Input string only contains whitespace chars
		if (!conStart) {
			return 0;
		}

		return result;
	}
}
