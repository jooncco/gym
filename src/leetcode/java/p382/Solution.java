package leetcode.java.p382;
// https://leetcode.com/problems/linked-list-random-node/

import java.security.SecureRandom;

public class Solution {
    private ListNode head;
    private SecureRandom sr;
    private final int OFF_LIMIT = 10000;

    public Solution(ListNode head) {
        sr = new SecureRandom();
        this.head = head;
    }

    public int getRandom() {
        int idx = sr.nextInt(OFF_LIMIT);
        ListNode cur = head;
        for (int i = 0; i < idx; ++i) {
            cur = cur.next == null ? head : cur.next;
        }
        return cur.val;
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