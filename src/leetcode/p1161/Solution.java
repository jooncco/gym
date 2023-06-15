package leetcode.p1161;
// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

import java.util.ArrayList;
import java.util.List;

/**
 * Depth First Search
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    private final List<Integer> levelSum= new ArrayList<>();

    public int maxLevelSum(TreeNode root) {
        computeSum(root, 1);
        int maxSum= levelSum.stream()
                .mapToInt(v -> v)
                .max().orElse(Integer.MIN_VALUE);
        for (int i=0; i < levelSum.size(); ++i) {
            if (maxSum == levelSum.get(i)) return i+1;
        }
        return 1;
    }

    private void computeSum(TreeNode node, int level) {
        if (node == null) return;
        if (levelSum.size() < level) levelSum.add(0);
        levelSum.set(level-1, levelSum.get(level-1) + node.val);
        computeSum(node.left, level+1);
        computeSum(node.right, level+1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}