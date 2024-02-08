package leetcode.java.p897;
// https://leetcode.com/problems/increasing-order-search-tree/

public class Solution {
    private void inorder(TreeNode node, TreeNode result) {
        if (node == null)
            return;
        inorder(node.left, result);
        while (result.right != null)
            result = result.right;
        result.right = new TreeNode(node.val);
        inorder(node.right, result.right);
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode ret = new TreeNode(-1);
        inorder(root, ret);
        return ret.right;
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}