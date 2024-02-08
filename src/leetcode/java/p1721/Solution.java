package leetcode.java.p1721;
// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

/**
 * Linked List
 * | Time: O (n)
 * | Space: O (1)
 */
public class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            ++size;
            cur = cur.next;
        }
        ListNode newHead = new ListNode();
        ListNode newCur = newHead;
        cur = head;
        ListNode l = null, r = null;
        for (int i = 0; i < size; ++i) {
            if (i == k - 1)
                l = newCur;
            if (i == size - k)
                r = newCur;
            newCur.val = cur.val;
            cur = cur.next;
            if (i < size - 1) {
                newCur.next = new ListNode();
                newCur = newCur.next;
            }
        }
        // swap
        if (l != null && r != null) {
            int tmp = l.val;
            l.val = r.val;
            r.val = tmp;
        }
        return newHead;
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