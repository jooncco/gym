package leetcode.p94;
// https://leetcode.com/problems/binary-tree-inorder-traversal/

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result= new LinkedList<>();

        TreeNode curNode = root;
        while (true) {
            if (curNode == null) {
                if (stack.isEmpty()) break;
                result.add(stack.peek().val);
                curNode= stack.pop().right;
            } else {
                if (curNode.left != null) {
                    stack.push(curNode);
                    curNode= curNode.left;
                } else {
                    result.add(curNode.val);
                    curNode= curNode.right;
                }
            }
        }
        return result;
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