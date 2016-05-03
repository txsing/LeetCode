package com.leetcode.algorithm;

public class Q29_DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}

		if (dividend == Integer.MIN_VALUE) {
			if (divisor == 1)
				return Integer.MIN_VALUE;
			if (divisor == -1)
				return Integer.MAX_VALUE;
			//divisor&1==1 is used to determine whether divisor is odd or even
			return (divisor & 1) == 1 ? divide(dividend + 1, divisor) : divide(dividend >> 1, divisor >> 1);
		}

		if (dividend == 0 || divisor == Integer.MIN_VALUE) {
			return 0;
		}

		// now divisor and dividend are both within range [-2^32-1, 2^32-1]
		int sign = (dividend ^ divisor) >= 0 ? 1 : -1;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		if (divisor > dividend) {
			return 0;
		}
		int ans = 0;
		while (dividend >= divisor) {
			int temp = divisor, count = 1;
			//(temp<<1)>=divisor is typical way to determine overflow
			while (dividend >= (temp << 1) && (temp << 1) >= divisor) {
				count <<= 1;
				temp <<= 1;
			}
			dividend -= temp;
			ans += count;
		}

		ans = (sign == 1) ? ans : -ans;
		return (int) ans;
	}
}
