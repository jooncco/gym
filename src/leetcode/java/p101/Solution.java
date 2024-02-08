package leetcode.java.p101;
// https://leetcode.com/problems/symmetric-tree/

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        TreeNode reflectedLeft = reflect(root.left);
        return isSameTree(reflectedLeft, root.right);
    }

    private TreeNode reflect(TreeNode subTree) {
        if (subTree == null)
            return null;
        TreeNode newLeft = reflect(subTree.right);
        TreeNode newRight = reflect(subTree.left);
        TreeNode root = new TreeNode(subTree.val);
        root.left = newLeft;
        root.right = newRight;
        return root;
    }

    private boolean isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null)
            return true;
        if (A == null || B == null)
            return false;
        if (A.val != B.val)
            return false;
        return isSameTree(A.left, B.left) && isSameTree(A.right, B.right);
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