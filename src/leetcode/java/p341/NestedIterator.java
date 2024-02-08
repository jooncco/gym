package leetcode.java.p341;
// https://leetcode.com/problems/flatten-nested-list-iterator/

import java.util.*;

/**
 * Stack
 * | Time: O(n) for both next(), hasNext()
 * | Space: O(n)
 */
public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        prepareStack(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext())
            return null;
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty())
            return false;
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            prepareStack(stack.pop().getList());
        }
        return !stack.isEmpty();
    }

    private void prepareStack(List<NestedInteger> nestedIntegerList) {
        for (int i = nestedIntegerList.size() - 1; i >= 0; --i) {
            stack.push(nestedIntegerList.get(i));
        }
    }
}

/**
 * List
 * | Time: O(n) for next(), O(n^2) for hasNext()
 * | Space: O(n)
 */
// public class NestedIterator implements Iterator<Integer> {
// private List<NestedInteger> list;
// private int idx;
// private NestedIterator child;

// public NestedIterator(List<NestedInteger> nestedList) {
// list= nestedList;
// idx= 0;
// if (!nestedList.isEmpty() && !nestedList.get(idx).isInteger()) {
// child= new NestedIterator(nestedList.get(idx).getList());
// }
// }

// @Override
// public Integer next() {
// if (idx == list.size()) return null;

// NestedInteger cur= list.get(idx);
// if (cur.isInteger()) {
// return list.get(idx++).getInteger();
// } else {
// if (child == null) {
// child= new NestedIterator(cur.getList());
// }
// if (!child.hasNext()) {
// child= null;
// ++idx;
// return next();
// }
// return child.next();
// }
// }

// @Override
// public boolean hasNext() {
// if (idx == list.size()) return false;

// if (list.get(idx).isInteger()) return true;
// if (child != null && child.hasNext()) return true;
// if (child == null && new NestedIterator(list.get(idx).getList()).hasNext())
// return true;
// for (int i= idx+1; i < list.size(); ++i) {
// if (list.get(i).isInteger()) return true;
// NestedIterator entry= new NestedIterator(list.get(i).getList());
// if (entry.hasNext()) return true;
// }
// return false;
// }
// }

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a
    // nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a
    // single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested
    // list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}