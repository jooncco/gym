package leetcode.java.p1026;
// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/

/**
 * Trees
 * | Time: O(n)
 * | Space: O(log(n))
 */
public class Solution {
    private int ans = 0;

    public int maxAncestorDiff(TreeNode root) {
        preorder(root, 987654321, -1);
        return ans;
    }

    private void preorder(TreeNode node, int mn, int mx) {
        if (node == null)
            return;
        mn = Math.min(mn, node.val);
        mx = Math.max(mx, node.val);
        ans = Math.max(ans, Math.abs(mn - mx));

        preorder(node.left, mn, mx);
        preorder(node.right, mn, mx);
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