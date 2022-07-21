package leetcode.p92;
// https://leetcode.com/problems/reverse-linked-list-ii/

import java.util.Stack;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        Stack<ListNode> stack = new Stack<>();
        ListNode iteratorNode = new ListNode();
        ListNode virtualHead = iteratorNode;
        ListNode curNode = head;
        int curIdx = 1;
        while (curIdx < left) {
            iteratorNode.next = curNode;
            iteratorNode = iteratorNode.next;
            curNode= curNode.next;
            ++curIdx;
        }
        while (curIdx <= right) {
            stack.push(curNode);
            curNode= curNode.next;
            ++curIdx;
        }
        while (!stack.isEmpty()) {
            iteratorNode.next = stack.pop();
            iteratorNode = iteratorNode.next;
        }
        while (curNode != null) {
            iteratorNode.next = curNode;
            iteratorNode = iteratorNode.next;
            curNode= curNode.next;
        }
        iteratorNode.next= null;
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