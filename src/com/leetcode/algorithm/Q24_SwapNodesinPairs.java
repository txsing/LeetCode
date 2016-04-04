package com.leetcode.algorithm;

public class Q24_SwapNodesinPairs {
	/**
	 * Definition for singly-linked list.
	 */
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	/**
	 * swap nodes, operate on the linked-list directly.
	 * @param head
	 * @return
	 */
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(-1);
		ListNode pre = dummy;
		pre.next = head;
		ListNode cur = head;

		ListNode next;
		while (cur != null && cur.next != null) {
			// swap cur and next
			next = cur.next;
			cur.next = next.next;
			next.next = cur;
			pre.next = next;

			// re-assign pre & cur
			pre = cur;
			cur = cur.next;
		}
		return dummy.next;
	}
	
	/**
	 * just swap the value of the nodes without changing the linked-list
	 * @param head
	 * @return
	 */
	public ListNode swapPairs1(ListNode head) {
		ListNode i = head;
		while (i != null && i.next != null) {
			int temp = i.next.val;
			i.next.val = i.val;
			i.val = temp;
			i = i.next.next;
		}
		return head;
	}
}
