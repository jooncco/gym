package leetcode.java.p938;
// https://leetcode.com/problems/range-sum-of-bst/description/

/**
 * Tree
 * | Time: O(n)
 * | Space: O(log(n))
 */
public class Solution {
    int ans = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        preOrder(root, low, high);
        return ans;
    }

    private void preOrder(TreeNode node, int low, int high) {
        if (node == null)
            return;
        if (node.val >= low && node.val <= high)
            ans += node.val;
        if (node.val <= high)
            preOrder(node.right, low, high);
        if (node.val >= low)
            preOrder(node.left, low, high);
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