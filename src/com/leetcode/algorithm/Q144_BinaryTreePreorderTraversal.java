package com.leetcode.algorithm;

import java.util.*;

public class Q144_BinaryTreePreorderTraversal {
	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		stack.push(root);
		result.add(root.val);
		TreeNode cur = root.left;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				result.add(cur.val);
				cur = cur.left;
			}
			cur = stack.pop();
			cur = cur.right;
		}
		return result;
	}
}
