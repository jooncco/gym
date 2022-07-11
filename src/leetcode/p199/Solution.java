package leetcode.p199;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Integer> view;

    public List<Integer> rightSideView(TreeNode root) {
        view= new ArrayList<>();
        preOrder(root, 0);
        return view;
    }

    private void preOrder(TreeNode node, int depth) {
        if (node == null) return;

        if (view.size() <= depth) view.add(node.val);
        else view.set(depth, node.val);
        preOrder(node.left, depth+1);
        preOrder(node.right, depth+1);
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