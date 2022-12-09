package leetcode.p1026;
// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/

public class Solution {
    private final int MAX_VAL= -1, MIN_VAL= 100001;
    private int maxDiff= 0;


    public int maxAncestorDiff(TreeNode root) {
        int mn= root.val, mx= root.val;
        findMaxDiff(root, mn, mx);
        return maxDiff;
    }

    private void findMaxDiff(TreeNode node, int mn, int mx) {
        if (node == null) return;
        mn= Math.min(mn, node.val);
        mx= Math.max(mx, node.val);
        maxDiff= Math.max(maxDiff, mx-mn);
        findMaxDiff(node.left, mn, mx);
        findMaxDiff(node.right, mn, mx);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}