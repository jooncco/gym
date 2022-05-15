package leetcode.p1302;
// https://leetcode.com/problems/deepest-leaves-sum/

public class Solution {
    private int ans, deepestLevel;

    public int deepestLeavesSum(TreeNode root) {
        ans= 0;
        deepestLevel= 0;
        compute(root,0);
        return ans;
    }

    private void compute(TreeNode node, int level) {
        if (node == null) return;

        if (deepestLevel == level) {
            ans += node.val;
        }
        else if (deepestLevel < level) {
            ans= node.val;
            deepestLevel= level;
        }
        compute(node.left, level+1);
        compute(node.right, level+1);
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