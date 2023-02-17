package leetcode.p783;
// https://leetcode.com/problems/minimum-distance-between-bst-nodes/

public class Solution {
    private int minDiff= Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        Integer maxVal= findMax(root.left);
        if (maxVal != null) minDiff= Math.min(minDiff, root.val-maxVal);
        Integer minVal= findMin(root.right);
        if (minVal != null) minDiff= Math.min(minDiff, minVal-root.val);
        minDiffInBST(root.left);
        minDiffInBST(root.right);
        return minDiff;
    }

    private Integer findMax(TreeNode node) {
        if (node == null) return null;
        Integer larger= findMax(node.right);
        return larger == null ? node.val : larger;
    }

    private Integer findMin(TreeNode node) {
        if (node == null) return null;
        Integer smaller= findMin(node.left);
        return smaller == null ? node.val : smaller;
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