package leetcode.p341;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    int n;
    Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        n= nestedList.size();
        stack= new Stack<>();
        prepareStack(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext()) return null;
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) return false;
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            prepareStack(stack.pop().getList());
        }
        return !stack.isEmpty();
    }

    private void prepareStack(List<NestedInteger> nestedIntegerList) {
        for (int i = nestedIntegerList.size()-1; i >= 0; --i) {
            stack.push(nestedIntegerList.get(i));
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
