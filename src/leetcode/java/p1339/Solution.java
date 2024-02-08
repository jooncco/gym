package leetcode.java.p1339;
// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/

public class Solution {
    private final int MOD = 1000000007;
    private long totalSum = 0;

    public int maxProduct(TreeNode root) {
        totalSum = treeSum(root);
        return (int) (computeMaxProduct(root) % MOD);
    }

    private long computeMaxProduct(TreeNode node) {
        if (node == null)
            return 0;
        long treeSum = node.val;
        long maxProduct = (totalSum - treeSum) * treeSum;
        maxProduct = Math.max(maxProduct, computeMaxProduct(node.left));
        maxProduct = Math.max(maxProduct, computeMaxProduct(node.right));
        return maxProduct;
    }

    private long treeSum(TreeNode node) {
        if (node == null)
            return 0;
        int sum = node.val;
        sum += treeSum(node.left);
        sum += treeSum(node.right);
        node.val = sum;
        return sum;
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