package com.leetcode.algorithm;

public class Q10_RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		int lens = s.length();
		int lenp = p.length();

		if (lens == 0) {
			// the remaining parttern string must be in the format of (X*)*
			if (lenp % 2 != 0) {
				return false;
			}
			while (lenp > 0) {
				if (p.charAt(lenp - 1) == '*') {
					lenp -= 2;
				} else {
					return false;
				}
			}
			return true;
		}
		
		if (lenp == 0) {
			return false;
		}

		char ch = s.charAt(lens - 1);
		char match, count = p.charAt(lenp - 1);

		if (count != '*') {
			match = count;
			count = '1';
		} else {
			match = p.charAt(lenp - 2);
		}

		if (ch == match || match == '.') {
			if (count == '1') {
				//must match once
				return isMatch(s.substring(0, lens - 1), p.substring(0, lenp - 1));
			} else {
				//three cases for x*:
				//1: match more once
				//2: match only once
				//3: don't match at all
				return isMatch(s.substring(0, lens - 1), p)
						|| isMatch(s.substring(0, lens - 1), p.substring(0, lenp - 2))
						|| isMatch(s, p.substring(0, lenp - 2));
			}
		} else if (count == '*') {
			return isMatch(s, p.substring(0, lenp - 2));
		} else {
			return false;
		}
	}
}
