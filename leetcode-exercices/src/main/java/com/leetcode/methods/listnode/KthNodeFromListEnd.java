package com.leetcode.methods.listnode;

import com.leetcode.methods.tools.ListNode;

/**
 * @author KoenigSEA
 */
public class KthNodeFromListEnd {

    /**
     * [KthNodeFromListEnd] with function double pointers
     */
    public static int kthToLast(ListNode head, int k) {
        if(head == null) {
            return 0;
        }

        ListNode fast = head;
        ListNode slow = head;
        int step = 0;

        while(step != k){
            fast = fast.next;
            step++;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow.val;
    }
}
