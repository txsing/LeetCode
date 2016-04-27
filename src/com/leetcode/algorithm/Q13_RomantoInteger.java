package com.leetcode.algorithm;

public class Q13_RomantoInteger {
    public int romanToInt(String s) {
        int[] a = new int[26];
        a['I' - 'A'] = 1;
        a['V' - 'A'] = 5;
        a['X' - 'A'] = 10;
        a['L' - 'A'] = 50;
        a['C' - 'A'] = 100;
        a['D' - 'A'] = 500;
        a['M' - 'A'] = 1000;
        char pre = 'A';
        int sum = 0;
        for(char cur : s.toCharArray()){
            if(a[cur - 'A'] > a[pre - 'A']){
            	//here we subtract 2 times of prev cos we added it before comparison.
                sum -= 2*a[pre- 'A'];
            }
            sum += a[cur - 'A'];
            pre = cur;
        }
        return sum;
    }
}
