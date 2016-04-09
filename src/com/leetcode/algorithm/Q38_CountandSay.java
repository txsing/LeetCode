package com.leetcode.algorithm;

public class Q38_CountandSay {
    public String countAndSay(int n) {
        String result = "1";
        for(int i = 1; i < n; i++){
            result = say(result);
        }
        return result;
    }
    
    String say(String str){
        char last = str.charAt(0); 
        int count = 1;
        String result = "";
        
        for(int i = 1; i<str.length(); i++){
            char cur = str.charAt(i);
            if(cur != last){
                result = result + count + last;
                last = cur;
                count = 1;
            }else{
                count++;
            }
        }
        
        //Attention: this step is easy to forget
        result = result + count + last;
        return result;
    }
}
