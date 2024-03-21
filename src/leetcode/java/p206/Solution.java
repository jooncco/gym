package leetcode.java.p206;
// https://leetcode.com/problems/reverse-linked-list/

/**
 * Data Structures
 * Time: O(n)
 * Space: O(1)
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = null;
        cur = head;
        while (cur.next != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        cur.next = prev;
        return cur;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}