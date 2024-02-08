package leetcode.java.p958;
// https://leetcode.com/problems/check-completeness-of-a-binary-tree/

public class Solution {
    private boolean nullAppearedBefore, ans;

    public boolean isCompleteTree(TreeNode root) {
        int depth = computeDepth(root);
        nullAppearedBefore = false;
        ans = true;
        traverse(root, depth, 0);
        return ans;
    }

    private void traverse(TreeNode node, final int maxDepth, int currDepth) {
        if (currDepth == maxDepth) {
            if (nullAppearedBefore && node != null)
                ans = false;
            if (node == null)
                nullAppearedBefore = true;
            return;
        }
        if (node == null) {
            ans = false;
            return;
        }
        traverse(node.left, maxDepth, currDepth + 1);
        traverse(node.right, maxDepth, currDepth + 1);
    }

    private int computeDepth(TreeNode node) {
        if (node == null)
            return -1;
        return Math.max(computeDepth(node.left), computeDepth(node.right)) + 1;
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