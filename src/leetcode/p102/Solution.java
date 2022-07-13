package leetcode.p102;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> ans;

    public List<List<Integer>> levelOrder(TreeNode root) {
        ans= new ArrayList<>();
        preOrder(root, 0);
        return ans;
    }

    private void preOrder(TreeNode node, int level) {
        if (node == null) return;

        if (ans.size() <= level) ans.add(new ArrayList<>());
        ans.get(level).add(node.val);
        preOrder(node.left, level+1);
        preOrder(node.right, level+1);
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