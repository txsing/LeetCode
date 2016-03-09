package com.leetcode.algorithm;

class Q28_strstr {

	public static void main(String[] args) {
		String target = "babcbabcabcaabcabcabcacabc";
		String pattern = "abcabcacab";

		System.out.println(sunday(target, pattern));
	}

	/*
	 * KMP
	 */
	static int KMP(String t, String p) {
		if (p.length() == 0)
			return 0;
		if (t.length() < p.length())
			return -1;
		int[] next = buildNext(p);
		int tstart = 0;
		int i = 0;
		int j = 0;
		while (tstart <= t.length() - p.length()) {
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

	/*
	 * Rabin-Karp expected matching complexity = O(M+N) when q >> M; preprocess
	 * complexity =o(M)
	 */
	static int rabinkarp(String txt, String pat) {
		int q = 101; // a prime number
		int d = 95; //
		int M = pat.length();
		int N = txt.length();
		int i, j;
		int p = 0; // hash value for pattern
		int t = 0; // hash value for txt
		int h = 1;

		// The value of h would be "pow(d, M-1)%q"
		for (i = 0; i < M - 1; i++)
			h = (h * d) % q;

		// Calculate the hash value of pattern and first window of text
		for (i = 0; i < M; i++) {
			p = (d * p + pat.charAt(i)) % q;
			t = (d * t + txt.charAt(i)) % q;
		}

		// Slide the pattern over text one by one
		for (i = 0; i <= N - M; i++) {

			// Check the hash values of current window of text and pattern
			// If the hash values match then only check for characters on by one
			if (p == t) {
				/* Check for characters one by one */
				for (j = 0; j < M; j++) {
					if (txt.charAt(i + j) != pat.charAt(j))
						break;
				}
				if (j == M) // if p == t and pat[0...M-1] = txt[i, i+1,
							// ...i+M-1]
				{
					return i;
				}
			}

			// Calulate hash value for next window of text: Remove leading
			// digit,
			// add trailing digit
			if (i < N - M) {
				t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
				// We might get negative value of t, converting it to positive
				if (t < 0)
					t = (t + q);
			}
		}
		return -1;
	}

	/**
	 * Sunday Algorithm
	 * @param target
	 * @param pattern
	 * @return
	 */
	static int sunday(String target, String pattern) {
		int n = target.length();
		int m = pattern.length();
		int begin = 0; // compare T[begin, begin+m-1] and P[0,m-1]
		while (begin <= n - m) {
			int i = begin;
			int j = 0;
			//check char one by one
			while (j < m && target.charAt(i++) == pattern.charAt(j++)) {
				;
			}
			
			if (j == m) {
				return begin;
			}
			
			//if begin+m already reach the end of target string and still no match found
			//then return -1
			if(begin == n-m){
				return -1;
			}
			
			//check whether the following char of T[begin, begin+m] -->T[begin+m]
			//is in pattern string or not.
			//if pattern string doesn't contain T[begin+m], then target string 
			//move m+1 chars left. 
			
			//the time complexity lastIndexOf() can be O(1) by using HashMap 
			int index = pattern.lastIndexOf(target.charAt(begin + m));
			begin = begin + m - index;
		}
		return -1;
	}

}
