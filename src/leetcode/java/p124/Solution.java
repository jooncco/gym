package leetcode.java.p124;
// https://leetcode.com/problems/binary-tree-maximum-path-sum/

public class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumDown(root);
        return maxSum;
    }

    private int maxPathSumDown(TreeNode node) {
        if (node == null)
            return 0;
        int leftMax = Math.max(0, maxPathSumDown(node.left));
        int rightMax = Math.max(0, maxPathSumDown(node.right));
        maxSum = Math.max(maxSum, leftMax + rightMax + node.val);
        return Math.max(leftMax, rightMax) + node.val;
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