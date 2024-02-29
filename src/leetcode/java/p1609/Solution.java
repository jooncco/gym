package leetcode.java.p1609;
// https://leetcode.com/problems/even-odd-tree/

/**
 * Trees: Inorder traversal
 * Time: O(n)
 * Space: O(n)
 */
public class Solution {
    private int[] levelsPrevNum = new int[100_000];
    private boolean result = true;

    public boolean isEvenOddTree(TreeNode root) {
        inOrder(root, 0);
        return result;
    }

    private void inOrder(TreeNode node, int level) {
        if (node == null || result == false) {
            return;
        }

        inOrder(node.left, level + 1);

        // Check current node.
        if (!isValidNode(node, level)) {
            result = false;
            return;
        }
        int prevNum = levelsPrevNum[level];
        if (prevNum > 0) {
            if (level % 2 == 0 && prevNum >= node.val) {
                result = false;
                return;
            }
            if (level % 2 == 1 && prevNum <= node.val) {
                result = false;
                return;
            }
        }
        levelsPrevNum[level] = node.val;

        inOrder(node.right, level + 1);
    }

    private boolean isValidNode(TreeNode node, int level) {
        if (level % 2 == 0 && node.val % 2 == 0)
            return false;
        if (level % 2 == 1 && node.val % 2 == 1)
            return false;
        return true;
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