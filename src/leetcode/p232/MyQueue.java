package leetcode.p232;
// https://leetcode.com/problems/implement-queue-using-stacks/

public class MyQueue {

    private final int CAPACITY= 1000;
    private int[] queue;
    private int head, tail;
    private boolean isFull;

    public MyQueue() {
        queue= new int[CAPACITY];
        head= tail= 0;
        isFull= false;
    }

    public void push(int x) {
        queue[tail++]= x;
        tail= tail%CAPACITY;
        if (tail == head) isFull= true;
    }

    public int pop() {
        int ret= queue[head++];
        head= head%CAPACITY;
        if (isFull) isFull= false;
        return ret;
    }

    public int peek() {
        return queue[head];
    }

    public boolean empty() {
        return !isFull && head == tail;
    }
}