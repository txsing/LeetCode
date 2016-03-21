package com.leetcode.algorithm;

public class Q21_MergeTwoSortedLists {

	// Definition for singly-linked list.
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode mergeHead;
		if (l1.val < l2.val) {
			mergeHead = l1;
			mergeHead.next = mergeTwoLists(l1.next, l2);
		} else {
			mergeHead = l2;
			mergeHead.next = mergeTwoLists(l1, l2.next);
		}
		return mergeHead;
	}
	
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
	    ListNode fakeHead = new ListNode(0);
	    ListNode current = fakeHead;

	    while (l1 != null || l2 != null) {
	        if (l1 == null || (l2 != null && l1.val >= l2.val)) {
	            current.next = l2;
	            current = l2;
	            l2 = l2.next;
	        } else {
	            current.next = l1;
	            current = l1;
	            l1 = l1.next;
	        }
	    }
	    return fakeHead.next;
	}
}