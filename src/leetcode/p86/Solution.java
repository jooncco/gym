package leetcode.p86;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        List<Integer> lt = new ArrayList<>();
        List<Integer> ge = new ArrayList<>();
        ListNode it = head;
        while (it != null) {
            if (it.val < x) lt.add(it.val);
            else ge.add(it.val);
            it= it.next;
        }
        ListNode virtualHead= new ListNode();
        ListNode cur= virtualHead;
        for (int val : lt) {
            cur.next= new ListNode(val);
            cur= cur.next;
        }
        for (int val : ge) {
            cur.next= new ListNode(val);
            cur= cur.next;
        }
        return virtualHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}