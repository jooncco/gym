package leetcode.p897;
// https://leetcode.com/problems/increasing-order-search-tree/

import leetcode.TreeNode;

public class Solution {
    private void inorder(TreeNode node, TreeNode result) {
        if (node == null) return;
        inorder(node.left, result);
        while (result.right != null) result= result.right;
        result.right= new TreeNode(node.val);
        inorder(node.right, result.right);
    }


    public TreeNode increasingBST(TreeNode root) {
        TreeNode ret= new TreeNode(-1);
        inorder(root, ret);
        return ret.right;
    }
}