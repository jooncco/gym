package leetcode.java.p141;
// https://leetcode.com/problems/linked-list-cycle/

/**
 * Implementation
 * | Time: O (1)
 * | Space: O (1)
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // trivial case
        if (head == null)
            return false;

        // detect
        ListNode l = head, r = head.next;
        for (int i = 0; i < 15_000; ++i) {
            if (l == null || r == null)
                break;
            if (l == r)
                return true;
            l = l.next;
            r = r.next;
            if (r != null)
                r = r.next;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}