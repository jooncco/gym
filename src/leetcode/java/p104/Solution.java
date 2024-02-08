package leetcode.java.p104;
// https://leetcode.com/problems/maximum-depth-of-binary-tree/

public class Solution {
    private int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        traverse(root, 1);
        return maxDepth;
    }

    private void traverse(TreeNode node, int curDepth) {
        if (node == null)
            return;
        // pre-order traverse
        maxDepth = Math.max(maxDepth, curDepth);
        traverse(node.left, curDepth + 1);
        traverse(node.right, curDepth + 1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}