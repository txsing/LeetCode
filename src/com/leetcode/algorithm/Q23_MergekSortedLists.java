package com.leetcode.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q23_MergekSortedLists {
	// Definition for singly-linked list.
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/*
	 * Priority Queue (Heap structure) to solve this problem
	 * n*log(k)
	 * the tree depth is always log(k)
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val-o2.val;
			}
		});

		for (ListNode node : lists)
			if(node != null) //can not add null object into queue
				queue.add(node);

		//dummy node is useful to solve such cases (make code concise)
		ListNode dummy = new ListNode(0);
		ListNode temp = dummy;
		while (!queue.isEmpty()) {
			temp.next = queue.poll();
			temp = temp.next;
			if (temp.next != null) {
				queue.add(temp.next);
			}

		}
		return dummy.next;
	}
}
