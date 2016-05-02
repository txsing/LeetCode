package com.leetcode.algorithm;

import java.util.*;

public class Q17LetterCombinationsofaPhoneNumber {
	public static List<String> letterCombinations(String digits) {
		String map[] = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		LinkedList<String> result = new LinkedList<String>();
		if (digits.length() == 0)
			return result;
		result.add("");
		for (int i = 0; i < digits.length(); i++) {
			String letters = map[digits.charAt(i) - '0'];
			while (result.peek().length() == i) { // nice!!!
				String t = result.remove();
				// 在字符串的长度不是很大的情况下，使用toCharArray方法是高效的，但若字符串长度很大的时候，使用toCharArray的性能就会降低，因为花了高额的代价来获取字符数组
				for (char ch : letters.toCharArray()) {
					result.add(t + ch);
				}
				// for (int j = 0; j < letters.length(); j++) {
				// 	   result.add(t + letters.charAt(j));
				// }
			}
			//compared with "while (result.peek().length() == i)"
//			int size = result.size();
//          for(int j = 0;j < size;j++)
		}
		return result;
	}
}
