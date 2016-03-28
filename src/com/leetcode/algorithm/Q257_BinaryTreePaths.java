package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Q257_BinaryTreePaths {
	
	/**
	 * Definition for a binary tree node.
	 * @author txsing
	 *
	 */
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	/**
	 * recursive implementation of pre-order traversal
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePaths1(TreeNode root) {
		List<String> results = new ArrayList<String>();
		if (root == null) {
			return results;
		}
		find(root, "", results);
		return results;
	}

	void find(TreeNode root, String path, List<String> results) {
		path = path + root.val + "->";
		if (root.left != null) {
			find(root.left, path, results);
		}
		if (root.right != null) {
			find(root.right, path, results);
		}
		if (root.left == null && root.right == null) {
			results.add(path.substring(0, path.length() - 2));
			path = path.substring(0, path.lastIndexOf(root.val + ""));
			return;
		}

	}
	
	/**
	 * non-recursive implementation of pre-order traversal
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePaths2(TreeNode root) {
		List<String> results = new ArrayList<String>();
		if (root == null) {
			return results;
		}
		TreeNode T = root;
		TreeNode temp = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		String path = "";
		while(T!=null || !stack.isEmpty()){
			while(T!=null){
				stack.push(T);
				path = path + T.val + "->";
				T = T.left;
			}
			T = stack.pop();
			temp = T;
			//path = path.substring(0,path.lastIndexOf(T.val+""));
			T = T.right;
			if(T == null && temp.left == null){
				results.add(path.substring(0, path.length() - 2));
			}
			
			if(temp != null){
				String str = temp.val+"";
				path = path.substring(0, path.lastIndexOf(str)+str.length()+2);
			}
		}
		return results;
	}
	
	
}
