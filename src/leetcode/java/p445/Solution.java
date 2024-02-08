package leetcode.java.p445;
// https://leetcode.com/problems/add-two-numbers-ii/

/**
 * Linked List
 * | Time: O (n)
 * | Space: O (1)
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reversed1 = getReversedList(l1);
        ListNode reversed2 = getReversedList(l2);
        ListNode root = new ListNode(), cur = root;
        int carry = 0;
        while (reversed1 != null || reversed2 != null || carry > 0) {
            ListNode next = new ListNode();
            cur.next = next;
            cur = next;
            int sum = carry;
            if (reversed1 != null) {
                sum += reversed1.val;
                reversed1 = reversed1.next;
            }
            if (reversed2 != null) {
                sum += reversed2.val;
                reversed2 = reversed2.next;
            }
            carry = sum / 10;
            sum %= 10;
            cur.val = sum;
        }
        return getReversedList(root.next);
    }

    private ListNode getReversedList(ListNode node) {
        ListNode prev, it = node, cur = null;
        while (it != null) {
            prev = cur;
            cur = new ListNode(it.val);
            cur.next = prev;
            it = it.next;
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