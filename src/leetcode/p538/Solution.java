package leetcode.p538;
// https://leetcode.com/problems/convert-bst-to-greater-tree/

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

class Solution {
    private final int NO_VALUE = -Integer.MAX_VALUE;
    private int convertNode(TreeNode node, int parentSum) {
        if (node == null) return NO_VALUE;

        int rightSum = convertNode(node.right, parentSum);
        node.val += rightSum != NO_VALUE ? rightSum : parentSum;
        int leftSum= convertNode(node.left, node.val);
        return leftSum != NO_VALUE ? leftSum : node.val;
    }

    public TreeNode convertBST(TreeNode root) {
        convertNode(root, 0);
        return root;
    }
}