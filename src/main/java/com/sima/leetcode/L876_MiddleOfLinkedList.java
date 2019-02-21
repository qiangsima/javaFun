package com.sima.leetcode;

import com.sima.leetcode.util.ListNode;

/**
 * Created by qisima on 2/21/2019 11:58 AM
 *
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 *
 * Example 1:
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 */
public class L876_MiddleOfLinkedList {
    public ListNode middleNode(ListNode head){
        if (head == null) return head;
        ListNode fast = head, slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast.next != null){
                fast = fast.next;
            }
        }
        return slow;
    }
}
