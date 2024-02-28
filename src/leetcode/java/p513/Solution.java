package leetcode.java.p513;
// https://leetcode.com/problems/find-bottom-left-tree-value/

/**
 * Trees
 * Time: O(n)
 * Space: O(n)
 */
public class Solution {
    private int curDepth = -1;
    private int leftValue = 0;

    public int findBottomLeftValue(TreeNode root) {
        inOrder(root, 0);
        return leftValue;
    }

    private void inOrder(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        inOrder(node.left, depth + 1);
        if (depth > curDepth) {
            curDepth = depth;
            leftValue = node.val;
        }
        inOrder(node.right, depth + 1);
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