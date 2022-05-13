package leetcode.p173;
// https://leetcode.com/problems/binary-search-tree-iterator/submissions/

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

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}