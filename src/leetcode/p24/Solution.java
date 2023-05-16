package leetcode.p24;
// https://leetcode.com/problems/swap-nodes-in-pairs/

/**
 * Linked List
 * | Time: O (n)
 * | Space: O (1)
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode retHead= head.next;
        ListNode nextLeft= head.next.next;
        retHead.next= head;
        ListNode curRight= retHead.next;
        while (nextLeft != null) {
            if (nextLeft.next == null) {
                curRight.next= nextLeft;
                curRight= curRight.next;
                nextLeft= null;
            } else {
                ListNode tmp= nextLeft.next.next;
                curRight.next= nextLeft.next;
                curRight.next.next= nextLeft;
                curRight= nextLeft;
                nextLeft= tmp;
            }
        }
        curRight.next= null;
        return retHead;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}