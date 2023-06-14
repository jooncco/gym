package leetcode.p530;
// https://leetcode.com/problems/minimum-absolute-difference-in-bst/

/**
 * Inorder Traversal
 * | Time: O (n)
 * | Space: O (log n)
 */
public class Solution {
    private int prev= Integer.MIN_VALUE;
    private int minDiff= Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode node) {
        inorder(node);
        return minDiff;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prev != Integer.MIN_VALUE) {
            minDiff= Math.min(minDiff, node.val - prev);
        }
        prev= node.val;
        inorder(node.right);
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
