package leetcode.p606;
// https://leetcode.com/problems/construct-string-from-binary-tree/

/**
 * Tree
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    private StringBuilder sb= new StringBuilder();

    public String tree2str(TreeNode root) {
        preOrder(root);
        return sb.substring(1, sb.length()-1).toString();
    }

    private void preOrder(TreeNode node) {
        sb.append("(");
        sb.append(node.val);

        if (node.left != null) preOrder(node.left);
        else if (node.right != null) sb.append("()");
        if (node.right != null) preOrder(node.right);
        
        sb.append(")");
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