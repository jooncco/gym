package leetcode.java.p623;
// https://leetcode.com/problems/add-one-row-to-tree/

public class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return reconstruct(root, val, depth, 1);
    }

    private TreeNode reconstruct(TreeNode node, final int val, final int targetDepth, int curDepth) {
        if (node == null)
            return null;
        if (targetDepth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = node;
            return newRoot;
        }

        if (curDepth == targetDepth - 1) {
            TreeNode newLeft = new TreeNode(val);
            newLeft.left = node.left;
            node.left = newLeft;
            TreeNode newRight = new TreeNode(val);
            newRight.right = node.right;
            node.right = newRight;
        } else {
            node.left = reconstruct(node.left, val, targetDepth, curDepth + 1);
            node.right = reconstruct(node.right, val, targetDepth, curDepth + 1);
        }
        return node;
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
