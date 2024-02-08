package leetcode.java.p662;
// https://leetcode.com/problems/maximum-width-of-binary-tree/

import java.util.LinkedList;
import java.util.List;

/**
 * Recursion
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    private final List<int[]> boundary = new LinkedList<>();
    private int ans = 0;

    public int widthOfBinaryTree(TreeNode root) {
        maxWidth(root, 0, 0);
        return ans;
    }

    private void maxWidth(TreeNode node, int idx, int depth) {
        if (node == null)
            return;
        if (boundary.size() == depth)
            boundary.add(new int[] { idx, idx });
        int[] boundaryOfCurrentLevel = boundary.get(depth);
        boundaryOfCurrentLevel[0] = Math.min(boundaryOfCurrentLevel[0], idx);
        boundaryOfCurrentLevel[1] = Math.max(boundaryOfCurrentLevel[1], idx);
        boundary.set(depth, boundaryOfCurrentLevel);
        ans = Math.max(ans, boundaryOfCurrentLevel[1] - boundaryOfCurrentLevel[0]);
        System.out.println("depth: " + depth + " / idx: " + idx + " / bounary: [" + boundaryOfCurrentLevel[0] + ", "
                + boundaryOfCurrentLevel[1] + "]");
        maxWidth(node.left, idx, depth + 1);
        maxWidth(node.right, 2 * idx + 1, depth + 1);
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