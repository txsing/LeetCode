package com.leetcode.algorithm;
public class Q2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int carry = 0;
    	int sum = 0;
    	ListNode t1 = l1;
    	ListNode t2 = l2;
    	ListNode t1p = t1;
    	ListNode t2p = t2;

        while((t1 != null)&&(t2 != null))
        {
        	sum = t1.val+t2.val+carry;
            t1.val = t2.val = sum%10;
            carry = sum/10;
            t1p = t1;
            t1=t1.next;
            t2p = t2;
            t2=t2.next;
        }

        if(t1 == null){
        	while(t2!=null && carry!=0){
        		sum = t2.val+carry;
        		t2.val = sum%10;
        		t2p = t2;
        		t2 = t2.next;
        		carry = sum/10;
        	}
        	if (carry!=0){
        	    t2p.next = new ListNode(1);
        	}
        	return l2;
        }
        
        while(t1!=null&&carry!=0){
        	sum=t1.val+carry;
        	t1.val=sum%10;
        	t1p = t1;
        	t1 = t1.next;
        	carry=sum/10;
        }
        if (carry!=0){
        	t1p.next = new ListNode(1);
        }
        return l1;
    }
}