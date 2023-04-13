package leetcode.p946;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque= new LinkedList<>();
        int pushIdx= 0;
        for (int num : popped) {
            if (!deque.isEmpty() && num == deque.peekLast()) deque.removeLast();
            else {
                if (pushIdx >= pushed.length) return false;
                while (pushIdx < pushed.length && pushed[pushIdx] != num) {
                    deque.addLast(pushed[pushIdx++]);
                }
                pushIdx++;
            }
        }
        return true;
    }
}