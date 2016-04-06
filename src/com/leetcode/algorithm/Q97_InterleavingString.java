package com.leetcode.algorithm;

public class Q97_InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length())
            return false;
        return helper(s1,s2,s3,s1.length(),s2.length(),s3.length());
    }
    
    boolean helper(String s1, String s2, String s3,int x, int y, int n){
        if(x == 0){
            return s3.substring(0,n-1).contains(s2.substring(0,y-1));
        }
        if(y == 0){
            return s3.substring(0,n-1).contains(s1.substring(0,x-1));
        }
        char ch1 = s1.charAt(x-1);
        char ch2 = s2.charAt(y-1);
        char ch3 = s3.charAt(n-1);
        
        boolean b1 = false;
        boolean b2 = false;
        
        //System.out.println(s1.length()+""+s2.length());
        if(ch1 == ch3 ){
            b1 = helper(s1, s2, s3, x-1, y, n-1);
        }
        if(ch2 == ch3){
            b2 = helper(s1, s2, s3, x, y-1, n-1);
        }
        return  b1||b2;
    }
}