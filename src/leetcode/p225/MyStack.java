package leetcode.p225;
// https://leetcode.com/problems/implement-stack-using-queues/

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementation
 * | Time: O(n) for push, O(1) for the rest
 * | Space: O(n)
 */
public class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue= new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        for (int i=0; i < queue.size()-1; ++i) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}