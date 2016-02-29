package com.leetcode.algorithm;

class Q186_ReverseWordsSentence {

	public static void main(String[] args) {
		String rawStr = "the sky is blue";
		System.out.println(reverseWords(rawStr));
	}

	static String reverseWords(String s) {
		int mark = s.length();
		String result = "";
		char chr;

		int i = s.length() - 1;
		while (i >= 0) {
			chr = s.charAt(i);
			if ((chr >= 'a' && chr < 'z') || (chr >= 'A' && chr <= 'Z')) {
				i--;
			} else {
				result = result + s.substring(i + 1, mark) + " ";
				mark = i;
				i--;
			}
		}
		result = result + s.substring(0, mark);
		return result;
	}
}
