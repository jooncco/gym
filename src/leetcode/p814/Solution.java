package leetcode.p814;

public class Solution {
    private final int TARGET_VALUE = 1;

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;

        root.left= pruneTree(root.left);
        root.right= pruneTree(root.right);
        if (root.left == null && root.right == null && root.val != TARGET_VALUE) return null;
        return root;
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