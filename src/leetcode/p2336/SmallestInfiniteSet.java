package leetcode.p2336;
// https://leetcode.com/problems/smallest-number-in-infinite-set/

import java.util.Deque;
import java.util.LinkedList;

/**
 * Deque
 * | Time: O (1) for popSmallest, O (n) for addBack
 * | Space: O (n)
 */
public class SmallestInfiniteSet {
    private int nextNum;
    private Deque<Integer> deque;

    public SmallestInfiniteSet() {
        nextNum= 1;
        deque= new LinkedList<>();
    }

    public int popSmallest() {
        if (deque.isEmpty()) {
            deque.addLast(nextNum++);
        }
        return deque.removeFirst();
    }

    public void addBack(int num) {
        if (num >= nextNum || deque.contains(num)) return;
        Deque<Integer> newDeque= new LinkedList<>();
        while (!deque.isEmpty() && deque.peekFirst() < num) {
            newDeque.addLast(deque.removeFirst());
        }
        newDeque.addLast(num);
        newDeque.addAll(deque);
        deque= newDeque;
    }
}