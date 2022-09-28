package leetcode.p19;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len= 0;
        ListNode curNode= head;
        while (curNode != null) {
            ++len;
            curNode= curNode.next;
        }
        if (len <= 1) return null;
        if (len == n) return head.next;

        int idxFromHead= len - n, curIdx= 0;
        curNode= head;
        while (curIdx < idxFromHead-1) {
            curNode= curNode.next;
            ++curIdx;
        }
        curNode.next= curNode.next.next;
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