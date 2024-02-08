package leetcode.java.p106;
// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return buildTree(inorder, postorder, 0, n - 1, postorder[n - 1]);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int l, int r, int rootVal) {
        if (l == r)
            return new TreeNode(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int lCnt = 0;
        while (inorder[l + lCnt] != rootVal)
            ++lCnt;
        root.left = buildTree(inorder, postorder, l, l + lCnt - 1, postorder[l + lCnt - 1]);
        root.right = buildTree(inorder, postorder, l + lCnt + 1, r, postorder[r]);
        return root;
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