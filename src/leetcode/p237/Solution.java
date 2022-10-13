package leetcode.p237;
// https://leetcode.com/problems/delete-node-in-a-linked-list/

public class Solution {
    public void deleteNode(ListNode node) {
        ListNode cur= node;
        while (cur.next != null) {
            cur.val= cur.next.val;
            if (cur.next.next == null) {
                cur.next= null;
            } else {
                cur= cur.next;
            }
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}