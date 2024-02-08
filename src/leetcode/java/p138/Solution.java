package leetcode.java.p138;
// https://leetcode.com/problems/copy-list-with-random-pointer/

/**
 * Implementation
 * | Time: O(2n)
 * | Space: O(n)
 */
public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node[] arr = new Node[1010];
        int idx = -1;
        Node it = head;
        while (it != null) {
            arr[++idx] = new Node(it.val);
            it.val = idx;
            if (idx > 0)
                arr[idx - 1].next = arr[idx];
            it = it.next;
        }
        idx = 0;
        it = head;
        while (it != null) {
            Node curRandom = it.random;
            if (curRandom != null) {
                arr[idx].random = arr[curRandom.val];
            }
            it = it.next;
            ++idx;
        }
        return arr[0];
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}