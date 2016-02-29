package com.leetcode.algorithm;
class Q28_strstr{
	
	public static void main(String[] args) {
		String target = "babcbabcabcaabcabcabcacabc";
		String pattern = "abcabcacab";
		
		System.out.println(strstr(target, pattern));
	}
	static int strstr(String t, String p) {
		if (p.length() == 0)
			return 0;
		if (t.length() < p.length())
			return -1;
		int[] next = buildNext(p);
		int tstart = 0;
		int i = 0;
		int j = 0;
		while (tstart <= t.length()-p.length()) {
			for (i = tstart, j = 0; j < p.length(); j++, i++) {
				if (p.charAt(j) == t.charAt(i)) {
					continue;
				} else {
					tstart = tstart + (j + 1) - next[j + 1];
					break;
				}
			}
			if (j == p.length()) {
				return tstart;
			}
		}
		return -1;
	}

	static int[] buildNext(String p) {
		int n = p.length();
		int[] next = new int[n + 1];
		next[1] = 0;
		int t = 1;
		int i = 2;
		while (i <= n) {
			if (p.charAt(t - 1) == p.charAt(i - 1)) {
				next[i] = next[t];
				t++;
			} else {
				next[i] = t;
				t = 1;
			}
			i++;
		}
		return next;
	}
}
