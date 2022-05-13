package leetcode.p99;
// https://leetcode.com/problems/recover-binary-search-tree/

public class Solution {
    private final int NEG_INF= Integer.MIN_VALUE;
    private int prev= NEG_INF, first= NEG_INF, second= NEG_INF;

    private void findSwappedNodes(TreeNode node) {
        if (node == null) return;

        findSwappedNodes(node.left);
        if (prev > node.val) {
            if (first == NEG_INF) {
                first= prev;
                second= node.val;
            }
            else {
                second= node.val;
            }
        }
        prev= node.val;
        findSwappedNodes(node.right);
    }

    private void recover(TreeNode node) {
        if (node == null) return;
        if (node.val == first) node.val= second;
        else if (node.val == second) node.val= first;
        recover(node.left);
        recover(node.right);
    }

    public void recoverTree(TreeNode root) {
        findSwappedNodes(root);
        recover(root);
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