package com.leetcode.algorithm;

import java.util.*;

/**
 * Two ends BFS
 * runtime 29ms
 * @author txsing
 *
 */
public class Q127_WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        
        Set<String> visited = new HashSet<String>();
        int len = 1;
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            //two-end BFS, reduce the num of visited nodes that needed.
        	//The intuition behind is that we are replacing a big search tree in the one-end solution 
        	//with two smaller trees in the two-end solution. 
        	//Both solutions have the same TOTAL depth, yet tree width grows exponentially w.r.t. depths, 
        	//and the two-end solutions results in less nodes being visited.
            if(beginSet.size() > endSet.size()){
                Set<String> swap = beginSet;
                beginSet = endSet;
                endSet = swap;
            }
            
            Set<String> tempSet = new HashSet<String>();
            
            for(String beginWd : beginSet){
                char[] bwdArray = beginWd.toCharArray();
                for(int i = 0; i < bwdArray.length; i++){
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        char tempChar = bwdArray[i];
                        bwdArray[i] = ch;
                        
                        //noted that bwdArray.toString() will only return the id of bwdArray
                        String tempString = String.valueOf(bwdArray);
                        
                        if(endSet.contains(tempString)){
                            return len + 1;
                        }
                        
                        if(!visited.contains(tempString) && wordList.contains(tempString)){
                            tempSet.add(tempString);
                            visited.add(tempString);
                        }
                        
                        //restore begin word array
                        bwdArray[i] = tempChar;
                    }
                }
            }
            beginSet = tempSet;
            //one search step finish 
            len++;
        }
        return 0;
    }
}