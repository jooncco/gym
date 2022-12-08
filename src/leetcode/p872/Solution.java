package leetcode.p872;
// https://leetcode.com/problems/leaf-similar-trees/description/

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafSeq1= new LinkedList<>(), leafSeq2= new LinkedList<>();
        appendLeafValues(leafSeq1, root1);
        appendLeafValues(leafSeq2, root2);
        return leafSeq1.equals(leafSeq2);
    }

    private void appendLeafValues(List<Integer> list, TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) list.add(node.val);
        appendLeafValues(list, node.left);
        appendLeafValues(list, node.right);
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