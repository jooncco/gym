package leetcode.p173;
// https://leetcode.com/problems/binary-search-tree-iterator/submissions/

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BSTIterator {

    private List<Integer> nums;
    private int curIdx;

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);
        nums.add(node.val);
        inorder(node.right);
    }

    public BSTIterator(TreeNode root) {
        nums= new LinkedList<>();
        curIdx= 0;
        inorder(root);
    }

    public int next() {
        return nums.get(curIdx++);
    }

    public boolean hasNext() {
        return curIdx < nums.size();
    }
}