package com.leetcode.algorithm;

class Q28_strstr {

	public static void main(String[] args) {
		String target = "babcbabcabcaabcabcabcacabc";
		String pattern = "abcabcacab";

		System.out.println(strstr1(target, pattern));
	}

	/*
	 * KMP
	 */
	static int strstr(String t, String p) {
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
	 * Rabin-Karp
	 * expected matching complexity = O(M+N) when q >> M; preprocess complexity =o(M) 
	 */
	static int strstr1(String txt, String pat) {
		int q = 101; //a prime number
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

}
