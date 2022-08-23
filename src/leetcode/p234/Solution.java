package leetcode.p234;
// https://leetcode.com/problems/palindrome-linked-list/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        int size = 1;
        ListNode cur = head;
        while (cur.next != null) {
            ++size;
            cur = cur.next;
        }

        List<ListNode> list= new ArrayList<>();
        cur = head;
        for (int i=0; i < size/2; ++i) {
            list.add(cur);
            cur = cur.next;
        }
        if (size%2 == 1) cur = cur.next;
        for (int i=0; i < size/2; ++i) {
            if (list.get(size/2-1-i).val != cur.val) return false;
            cur = cur.next;
        }
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}