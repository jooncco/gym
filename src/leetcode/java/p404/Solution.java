package leetcode.java.p404;
// https://leetcode.com/problems/sum-of-left-leaves/

/**
 * Trees
 * Time: O(n)
 * Space: O(n)
 */
public class Solution {
    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        addLeftLeaves(root, false);
        return sum;
    }

    private void addLeftLeaves(TreeNode node, boolean isLeft) {
        if (node == null)
            return;
        if (isLeft && node.left == null && node.right == null) {
            sum += node.val;
        }
        addLeftLeaves(node.left, true);
        addLeftLeaves(node.right, false);
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