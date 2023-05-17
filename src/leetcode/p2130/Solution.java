package leetcode.p2130;
// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

/**
 * Linked List
 * | Time: O (n)
 * | Space: O (1)
 */
public class Solution {
    public int pairSum(ListNode head) {
        int size= 0;
        ListNode it= head;
        while (it != null) {
            ++size;
            it= it.next;
        }
        it= head;
        for (int i=0; i < size-1; ++i) it= it.next;
        ListNode curHead= null, cur= it.next;
        it.next= null;
        ListNode temp= cur.next;
        while (temp != null) {
            cur.next= curHead;
            curHead= cur;
            cur= temp;
            temp= cur.next;
        }
        curHead= cur;

        int ans= 0;
        ListNode l= head, r= curHead;
        while (l != null && r != null) {
            ans= Math.max(ans, l.val + r.val);
            l= l.next;
            r= r.next;
        }
        return ans;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}