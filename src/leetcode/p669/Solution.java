package leetcode.p669;
// https://leetcode.com/problems/trim-a-binary-search-tree/

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

public class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        TreeNode trimmedNode= new TreeNode(root.val);
        trimmedNode.left= trimBST(root.left, low, high);
        trimmedNode.right= trimBST(root.right, low, high);
        return trimmedNode;
    }
}