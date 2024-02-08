package leetcode.java.p92;
// https://leetcode.com/problems/reverse-linked-list-ii/

/**
 * Implementation
 * | Time: O(n)
 * | Space: O(1)
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;

        int idx = 0;
        ListNode virHead = new ListNode();
        virHead.next = head;
        ListNode cutPrev = virHead, tmp = null, tmp2;
        ListNode cur = virHead;
        while (cur != null) {
            if (idx <= left - 1) {
                if (idx == left - 1)
                    cutPrev = cur;
                cur = cur.next;
            }
            if (idx == left) {
                tmp = cur;
                cur = cur.next;
                tmp.next = null;
            }
            if (idx > left && idx <= right) {
                tmp2 = cur;
                cur = cur.next;
                tmp2.next = tmp;
                tmp = tmp2;
            }
            if (idx > right)
                break;
            ++idx;
        }
        cutPrev.next = tmp;
        while (tmp.next != null)
            tmp = tmp.next;
        tmp.next = cur;
        return virHead.next;
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