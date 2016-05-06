package com.leetcode.algorithm;

public class Q30_SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        
        if(s == null || words == null)
            return ans;
            
        int L = s.length(), M = words.length;
        
        if(L == 0 || M == 0)
            return ans;
            
        int K = words[0].length();
        
        if(L < M*K)
            return ans;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, Integer> curMap = new HashMap<String, Integer>();
        
        for(String word : words){
            if(map.containsKey(word))
                map.put(word, map.get(word)+1);
            else
                map.put(word, 1);
        }
        
        //why i range from (0, K)
        for(int i = 0; i < K; i++){
            int count = 0; //match count, when count == M, we get a full match
            // l: left side of the sliding window; r: right side
            for(int l = i, r = i; r+K <= L; r += K){
                String temp;
                String str = s.substring(r, r+K);
                
                if(map.containsKey(str)){
                    if(curMap.containsKey(str))
                        curMap.put(str, curMap.get(str)+1);
                    else
                        curMap.put(str, 1);
                        
                    if(curMap.get(str) <= map.get(str))
                        count++;
                    
                    //if str is one more redundant, we remove the first occurred str for rebalance
                    while(curMap.get(str) > map.get(str)){
                        temp = s.substring(l, l+K);
                        curMap.put(temp, curMap.get(temp) - 1);
                        if(!temp.equals(str))
                            count--;
                        l += K;
                    }
                    if(count == M){
                        ans.add(l);
                        temp = s.substring(l, l+K);
                        curMap.put(temp, curMap.get(temp) - 1);
                        count--;
                        l += K;
                    }
                }else{
                    curMap.clear();
                    count = 0;
                    l = r + K;
                }
            }
            curMap.clear();
        }
        return ans;
    }
}
