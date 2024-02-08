package leetcode.java.p23;
// https://leetcode.com/problems/merge-k-sorted-lists/description/

import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        PriorityQueue<Pair<ListNode, Integer>> pq = new PriorityQueue<>((a, b) -> a.getKey().val - b.getKey().val);
        for (int idx = 0; idx < lists.length; ++idx) {
            if (lists[idx] != null)
                pq.add(new Pair(lists[idx], idx));
        }
        if (pq.isEmpty())
            return null;
        Pair<ListNode, Integer> firstPair = pq.poll();
        ListNode head = firstPair.getKey();
        int index = firstPair.getValue();
        lists[index] = lists[index].next;
        if (lists[index] != null)
            pq.add(new Pair(lists[firstPair.getValue()], index));
        ListNode cur = head;
        while (!pq.isEmpty()) {
            Pair<ListNode, Integer> pair = pq.poll();
            ListNode node = pair.getKey();
            int idx = pair.getValue();
            cur.next = new ListNode(node.val);
            cur = cur.next;
            lists[idx] = lists[idx].next;
            if (lists[idx] != null)
                pq.add(new Pair(lists[idx], idx));
        }
        return head;
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

class Pair<K, V> {
    private K key;
    private V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}