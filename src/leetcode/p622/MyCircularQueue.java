package leetcode.p622;
// https://leetcode.com/problems/design-circular-queue/

public class MyCircularQueue {
    private int[] arr;
    private int l, r, size, capacity;

    public MyCircularQueue(int k) {
        arr= new int[k];
        l= -1; r= -1; size= 0; capacity= k;
    }

    public boolean enQueue(int value) {
        if (size == capacity) return false;
        if (l == -1) l= 0;
        ++r;
        if (r == capacity) r= 0;
        arr[r]= value;
        ++size;
        return true;
    }

    public boolean deQueue() {
        if (size == 0) return false;
        ++l;
        if (l == capacity) l= 0;
        --size;
        if (size == 0) {
            l= -1; r= -1;
        }
        return true;
    }

    public int Front() {
        if (size == 0) return -1;
        return arr[l];
    }

    public int Rear() {
        if (size == 0) return -1;
        return arr[r];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}