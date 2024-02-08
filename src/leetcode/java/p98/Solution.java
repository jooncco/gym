package leetcode.java.p98;
// https://leetcode.com/problems/validate-binary-search-tree/

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, long l, long r) {
        if (node == null)
            return true;

        if (node.val <= l || node.val >= r)
            return false;
        if (node.left != null && node.val <= node.left.val)
            return false;
        if (node.right != null && node.val >= node.right.val)
            return false;
        if (!isValid(node.left, l, node.val))
            return false;
        if (!isValid(node.right, node.val, r))
            return false;
        return true;
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