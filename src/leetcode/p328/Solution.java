package leetcode.p328;
// https://leetcode.com/problems/odd-even-linked-list/

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        int n= 0;
        ListNode cur= head;
        while (cur != null) {
            ++n;
            cur= cur.next;
        }

        ListNode evenHead= new ListNode(), even= evenHead;
        cur= head.next;
        for (int i=1; i < n; ++i) {
            if (i%2 == 1) {
                even.val= cur.val;
                even.next= new ListNode();
                even= even.next;
            }
            cur= cur.next;
        }

        ListNode odd= head;
        cur= head;
        for (int i=0; i < n; ++i) {
            if (odd == null) {
                cur.val= evenHead.val;
                evenHead= evenHead.next;
            }
            else {
                cur.val= odd.val;
                for (int j=0; j < 2 && odd != null; ++j) odd= odd.next;
            }
            cur= cur.next;
        }
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