package com.leetcode.algorithm;

import java.util.Comparator;
import java.util.List;
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
	 * Priority Queue to solve this problem
	 * 
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val < o2.val)
					return -1;
				else if (o1.val == o2.val)
					return 0;
				else
					return 1;
			}
		});

		for (ListNode node : lists)
			if(node != null) //can not add null object into queue
				queue.add(node);

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
