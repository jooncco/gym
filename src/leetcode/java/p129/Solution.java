package leetcode.java.p129;
// https://leetcode.com/problems/sum-root-to-leaf-numbers/

public class Solution {
    private int ans;

    public int sumNumbers(TreeNode root) {
        ans = 0;
        addNumber(root, 0);
        return ans;
    }

    private void addNumber(TreeNode node, int num) {
        if (node == null)
            return;
        int currNum = num * 10 + node.val;
        if (node.left == null && node.right == null) {
            ans += currNum;
            return;
        }
        addNumber(node.left, currNum);
        addNumber(node.right, currNum);
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