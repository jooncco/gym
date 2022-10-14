package leetcode.p2095;
// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

public class Solution {
    public ListNode deleteMiddle(ListNode head) {
        int n= 0;
        ListNode cur= head;
        while (cur != null) {
            ++n;
            cur= cur.next;
        }
        if (n == 1) return null;

        int targetIdx= n/2, curIdx= 0;
        cur= head;
        while (curIdx < targetIdx-1) {
            ++curIdx;
            cur= cur.next;
        }
        cur.next= cur.next.next;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}