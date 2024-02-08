package leetcode.java.p876;
// https://leetcode.com/problems/middle-of-the-linked-list/

public class Solution {
    public ListNode middleNode(ListNode head) {
        int size = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            ++size;
        }
        cur = head;
        int curIdx = 0, middle = size / 2;
        while (curIdx < middle) {
            cur = cur.next;
            ++curIdx;
        }
        return cur;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}