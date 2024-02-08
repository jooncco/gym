package leetcode.java.p284;
// https://leetcode.com/problems/peeking-iterator/

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PeekingIterator implements Iterator<Integer> {

    private List<Integer> arr;
    private int curIdx;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        arr = new ArrayList<>();
        while (iterator.hasNext()) {
            arr.add(iterator.next());
        }
        curIdx = 0;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return arr.get(curIdx);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return arr.get(curIdx++);
    }

    @Override
    public boolean hasNext() {
        return curIdx < arr.size();
    }
}