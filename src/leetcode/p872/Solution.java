package leetcode.p872;
// https://leetcode.com/problems/leaf-similar-trees/description/

import java.util.*;

/**
 * Trees
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1= new ArrayList<>();
        inOrder(leaves1, root1);
        List<Integer> leaves2= new ArrayList<>();
        inOrder(leaves2, root2);
        return leaves1.equals(leaves2);
    }

    private void inOrder(List<Integer> leaves, TreeNode node) {
        if (node == null) return;
        inOrder(leaves, node.left);
        if (node.left == null && node.right == null) leaves.add(node.val);
        inOrder(leaves, node.right);
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