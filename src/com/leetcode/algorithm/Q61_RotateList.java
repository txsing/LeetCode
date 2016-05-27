package com.leetcode.algorithm;

public class Q61_RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return null;
		if (k == 0)
			return head;

		int count = 1;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode right = head;
		ListNode left = dummy;
		
		while (right.next != null) {
			right = right.next;
			if (++count > k)
				left = left.next;
		}
		
		if (count <= k) {
			k = k % count;
			if (k == 0)
				return head;
			k = count - k;
			while (k-- > 0)
				left = left.next;
		}

		right.next = head;
		head = left.next;
		left.next = null;

		return head;
	}
}
