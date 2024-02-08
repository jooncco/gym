package leetcode.java.p113;
// https://leetcode.com/problems/path-sum-ii/

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> ans;
    private int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        ans = new LinkedList<>();
        findPaths(root, new LinkedList<>(), 0);
        return ans;
    }

    private void findPaths(final TreeNode node, List<Integer> curPath, final int curSum) {
        if (node == null)
            return;

        curPath.add(node.val);
        if (node.left == null && node.right == null && (curSum + node.val) == target) {
            List<Integer> path = new LinkedList<>();
            path.addAll(curPath);
            ans.add(path);
        }
        findPaths(node.left, curPath, curSum + node.val);
        findPaths(node.right, curPath, curSum + node.val);
        curPath.remove(curPath.size() - 1);
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