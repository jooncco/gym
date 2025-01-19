package leetcode.java.lw-358. B;
// https://leetcode.com/contest/weekly-contest-358/problems/double-a-number-represented-as-a-linked-list/

/**
 * Implementation (Linked List, Multiplication)
 * | Time: O (n)
 * | Space: O (1)
 */
public class Solution {
    public ListNode doubleIt(ListNode head) {
        int[] a = new int[10010];
        int baseIdx = -1;
        ListNode cur = head;
        while (cur != null) {
            a[++baseIdx] = cur.val;
            cur = cur.next;
        }
        int idx = baseIdx, carry = 0;
        while (idx >= 0) {
            int d = a[idx] * 2 + carry;
            a[idx] = d % 10;
            carry = d / 10;
            --idx;
        }
        ListNode root = new ListNode(carry);
        cur = root;
        for (int i = 0; i <= baseIdx; ++i) {
            cur.next = new ListNode(a[i]);
            cur = cur.next;
        }
        return root.val == 0 ? root.next : root;
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