package leetcode.p222;
// https://leetcode.com/problems/count-complete-tree-nodes/

public class Solution {
    public int countNodes(TreeNode root) {
        int h= height(root);
        if (h == -1) return 0;

        return height(root.right) == h-1
                ? (1 << h) + countNodes(root.right)
                : (1 << h-1) + countNodes(root.left);
    }

    private int height(TreeNode node) {
        if (node == null) return -1;
        return 1 + height(node.left);
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