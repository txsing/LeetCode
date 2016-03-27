package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

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
	 * recursive implementation of preorder traversal
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
}
