package leetcode.p938;
// https://leetcode.com/problems/range-sum-of-bst/description/

public class Solution {
    private int sum= 0;
    private int l, r;

    public int rangeSumBST(TreeNode root, int low, int high) {
        l= low; r= high;
        add(root);
        return sum;
    }

    private void add(TreeNode node) {
        if (node == null) return;
        if (node.val >= l && node.val <= r) sum += node.val;
        add(node.left);
        add(node.right);
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