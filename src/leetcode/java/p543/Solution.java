package leetcode.java.p543;
// https://leetcode.com/problems/diameter-of-binary-tree/

/**
 * Trees
 * Time: O(n)
 * Space: O(n)
 */
public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = lengthOfLongestPath(root.left);
        int right = lengthOfLongestPath(root.right);
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        return Math.max(left + right, Math.max(leftDiameter, rightDiameter));
    }

    private int lengthOfLongestPath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = lengthOfLongestPath(node.left);
        int right = lengthOfLongestPath(node.right);
        return Math.max(left, right) + 1;
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