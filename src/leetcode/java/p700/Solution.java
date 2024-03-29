package leetcode.java.p700;
// https://leetcode.com/problems/search-in-a-binary-search-tree/

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;

        TreeNode leftSearch = searchBST(root.left, val);
        if (leftSearch != null)
            return leftSearch;
        TreeNode rightSearch = searchBST(root.right, val);
        if (rightSearch != null)
            return rightSearch;
        return null;
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