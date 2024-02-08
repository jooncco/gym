package leetcode.java.p114;
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

public class Solution {
    public void flatten(TreeNode root) {
        reconstruct(root);
    }

    private TreeNode reconstruct(TreeNode parent) {
        if (parent == null)
            return null;

        if (parent.left != null) {
            TreeNode originalRightChild = parent.right;
            parent.right = parent.left;
            parent.left = null;
            TreeNode lastNodeOfReconstructedLeftChild = reconstruct(parent.right);
            if (originalRightChild == null)
                return lastNodeOfReconstructedLeftChild;

            lastNodeOfReconstructedLeftChild.right = originalRightChild;
            return reconstruct(lastNodeOfReconstructedLeftChild.right);
        }
        if (parent.right != null) {
            return reconstruct(parent.right);
        }
        return parent;
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