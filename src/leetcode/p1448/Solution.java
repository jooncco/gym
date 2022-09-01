package leetcode.p1448;

public class Solution {
    public int goodNodes(TreeNode root) {
        return preOrder(root, Integer.MIN_VALUE);
    }

    private int preOrder(TreeNode node, int maxVal) {
        if (node == null) return 0;
        int cnt= 0;
        if (node.val >= maxVal) ++cnt;
        int newMaxVal= Math.max(maxVal, node.val);
        cnt += preOrder(node.left, newMaxVal);
        cnt += preOrder(node.right, newMaxVal);
        return cnt;
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