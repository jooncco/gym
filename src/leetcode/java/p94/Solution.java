package leetcode.java.p94;
// https://leetcode.com/problems/binary-tree-inorder-traversal/

import java.util.*;

/**
 * Tree
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    private List<Integer> list = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return list;
    }

    public void inorder(TreeNode cur) {
        if (cur == null)
            return;
        inorder(cur.left);
        list.add(cur.val);
        inorder(cur.right);
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