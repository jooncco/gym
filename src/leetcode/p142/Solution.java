package leetcode.p142;
// https://leetcode.com/problems/linked-list-cycle-ii/

public class Solution {
    private static final int INF= 1000*1000;

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        // mark visited nodes while duplicating
        ListNode given= head;
        ListNode root= new ListNode(given.val);
        ListNode node= root;
        while (true) {
            given.val= INF;
            given= given.next;
            if (given == null) return null; // no cycle
            if (given.val == INF) break; // do not link back
            node.next= new ListNode(given.val);
            node= node.next;
        }
        // given node is 'pos' now.
        ListNode ans= given;
        // recover values
        node= root;
        while (node != null) {
            given.val= node.val;
            given= given.next;
            node= node.next;
        }
        return ans;
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