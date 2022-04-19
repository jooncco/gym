package leetcode.p230;
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

import leetcode.TreeNode;

class Solution {
    private int cnt= 0, ans;
    private void inorder(TreeNode node, int target) {
        if (node.left != null) inorder(node.left, target);
        ++cnt;
        if (target == cnt) ans= node.val;
        if (node.right != null) inorder(node.right, target);
    }

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }
}
