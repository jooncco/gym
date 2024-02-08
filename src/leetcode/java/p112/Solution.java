package leetcode.java.p112;
// https://leetcode.com/problems/path-sum/

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return targetSumPathExist(root, targetSum);
    }

    private boolean targetSumPathExist(TreeNode node, final int targetSum) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null) {
            return node.val == targetSum;
        }

        return targetSumPathExist(node.left, targetSum - node.val) ||
                targetSumPathExist(node.right, targetSum - node.val);
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