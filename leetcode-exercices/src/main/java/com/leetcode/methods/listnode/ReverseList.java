package com.leetcode.methods.listnode;

import com.leetcode.methods.tools.ListNode;

/**
 * Reverse a singly linked list
 * <p>
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * @author KoenigSEA
 */
public class ReverseList {
    /**
     * [ReverseList] with Recursive function
     */
    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }

    /**
     * Normal function of [ReverseList]
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
