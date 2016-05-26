package com.leetcode.algorithm;

import java.util.*;

public class Q49_GroupAnagrams {
	
	//all anagrams will become the same after inner char sort, which can be used as a key
	//28ms beats 60%
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList<List<String>>();
		}
		
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		
		for (String s : strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String keyStr = String.valueOf(ca);
			if (!map.containsKey(keyStr))
				map.put(keyStr, new ArrayList<String>());
			map.get(keyStr).add(s);
		}

		for (String key : map.keySet()) {
			Collections.sort(map.get(key));
		}
		return new ArrayList<List<String>>(map.values());
	}
	
	//if each char represents a prime number, then the string can be represents as the product
	//which is unique cos of the feature of prime number.
	//20ms beats 99.8%
	public List<List<String>> groupAnagrams2(String[] strs){
		//the first 26 prime numbers corresponding to 26 letters.
		int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
		Map<Integer,Integer> map = new HashMap<>();
		List<List<String>> res = new ArrayList<>();
		
		for(String str : strs){
			int key = 1;
			for(char ch: str.toCharArray()){
				key *= prime[ch - 'a'];				
			}
			List<String> tmp = null;
			if(map.containsKey(key)){
				tmp = res.get(map.get(key));
			}else{
				tmp = new ArrayList<String>();
				res.add(tmp);
				map.put(key, res.size()-1);
			}
			tmp.add(str);
		}
		
		for(List<String> lst : res){
			Collections.sort(lst);
		}
		
		return res;
	}
}
