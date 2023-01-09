package leetcode.p144;
// https://leetcode.com/problems/binary-tree-preorder-traversal/

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret= new LinkedList<>();
        preOrder(ret, root);
        return ret;
    }

    private void preOrder(List<Integer> ret, TreeNode node) {
        if (node == null) return;
        ret.add(node.val);
        preOrder(ret, node.left);
        preOrder(ret, node.right);
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
