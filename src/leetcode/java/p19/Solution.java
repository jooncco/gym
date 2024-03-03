package leetcode.java.p19;
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

/**
 * Data Structures
 * Time: O(n)
 * Space: O(1)
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Compute size
        int size = 0;
        ListNode curNode = head;
        while (curNode != null) {
            ++size;
            curNode = curNode.next;
        }

        // Remove target node
        ListNode fakeHead = new ListNode(0, head);
        int targetIdx = size - n;
        curNode = fakeHead;
        for (int i = 0; i < targetIdx; ++i) {
            curNode = curNode.next;
        }
        curNode.next = curNode.next.next;
        return fakeHead.next;
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