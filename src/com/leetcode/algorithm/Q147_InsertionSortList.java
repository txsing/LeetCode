package com.leetcode.algorithm;

public class Q147_InsertionSortList {
	public static void main(String[] args) {
		Q147_InsertionSortList testcase = new Q147_InsertionSortList();

		ListNode head = new ListNode(3);
		ListNode b = new ListNode(5);
		ListNode c = new ListNode(4);
		ListNode d = new ListNode(2);
		head.next = b;
		b.next = c;
		c.next = d;

		head = testcase.insertionSortList(head);
		System.out.println(head.val + "," + head.next.val);
	}

	public ListNode insertionSortList(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		ListNode next = null;
		ListNode footer = null;
		while (cur != null && cur.next != null) {
			next = cur.next;
			if (cur.val <= next.val) {
				cur = next;
			} else {
				footer = cur;
				pre = null;
				cur = head;
				while (cur != footer && cur.val <= next.val) {
					pre = cur;
					cur = cur.next;
				}

				if (pre == null) {
					pre = next;
					footer.next = next.next;
					next.next = cur;
					head = pre;
				} else {
					pre.next = next;
					footer.next = next.next;
					next.next = cur;
				}
				cur = footer;
			}
		}
		return head;

	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}