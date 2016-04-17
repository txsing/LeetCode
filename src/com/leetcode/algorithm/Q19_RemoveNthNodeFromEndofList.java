package com.leetcode.algorithm;

//Definition for singly-linked list.

public class Q19_RemoveNthNodeFromEndofList {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode l = head, r = head;
		for (int i = 0; i < n; i++) {
			r = r.next;
		}
		// when the removed node is the head
		if (r == null) {
			return head.next;
		}
		while (r.next != null) {
			l = l.next;
			r = r.next;
		}
		l.next = l.next.next;
		return head;
	}
}
