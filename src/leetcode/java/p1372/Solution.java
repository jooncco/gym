package leetcode.java.p1372;
// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/

/**
 * Recursion
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    int ans = 0;

    public int longestZigZag(TreeNode root) {
        findLongest(root);
        return ans;
    }

    private int[] findLongest(TreeNode curNode) {
        if (curNode == null)
            return new int[] { -1, -1 };
        int left = 1 + findLongest(curNode.left)[1];
        int right = 1 + findLongest(curNode.right)[0];
        ans = Math.max(ans, Math.max(left, right));
        return new int[] { left, right };
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