package leetcode.java.p653;
// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return isExistTarget(root, root, k);
    }

    private boolean isExistTarget(TreeNode root, TreeNode curNode, int k) {
        if (curNode == null)
            return false;
        int here = curNode.val, there = k - curNode.val;
        curNode.val = -here;
        boolean isExist = findNum(root, there);
        curNode.val = here;
        if (isExistTarget(root, curNode.left, k) || isExistTarget(root, curNode.right, k))
            isExist = true;
        return isExist;
    }

    private boolean findNum(TreeNode node, final int num) {
        if (node == null)
            return false;
        if (node.val == num)
            return true;
        return findNum(node.left, num) || findNum(node.right, num);
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