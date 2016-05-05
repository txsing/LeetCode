package com.leetcode.algorithm;

public class Q25_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1 || head == null || head.next ==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        tail.next = head;
        
        while(tail.next!=null){
            int i = k;
            ListNode endK = tail.next;
            while(endK != null && --i > 0)
                endK = endK.next;
            if(i == 0){
                ListNode beginK = tail.next;
                reverse(beginK, endK);
                tail.next = endK;
                tail = beginK; 
            }else{
                return dummy.next;
            }
        }
        return dummy.next;
    }
    
    /**
     * reverse sublist [begin->,,,->end]
     */
    public void reverse(ListNode begin, ListNode end){
        ListNode p,q,r;
        p = begin;
        q = end.next;
        ListNode stop = end.next;
        while(p != stop){
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
    }
}
