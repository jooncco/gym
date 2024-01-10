package leetcode.p2385;
// https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/

import java.util.*;

/**
 * Trees(Lowest Common Ancestor): calculating distance between two nodes.
 * | Time: O(n + n(log(n))^2)
 * | Space: O(n)
 */
public class Solution {
    private int[] p= new int[100010], d= new int[100010];
    private List<Integer> leaves= new ArrayList<>();

    public int amountOfTime(TreeNode root, int start) {
        preorder(root, 0); // O(n)
        int ans= d[start];
        for (int leaf : leaves) { // O(n (log(n))^2)
            int ca= lca(leaf, start); // O((log(n))^2)
            ans= Math.max(ans, d[leaf] + d[start] - 2*d[ca]);
        }
        return ans;
    }

    private void preorder(TreeNode node, int dist) {
        d[node.val]= dist;
        if (node.left != null) {
            p[node.left.val]= node.val;
            preorder(node.left, dist+1);
        }
        if (node.right != null) {
            p[node.right.val]= node.val;
            preorder(node.right, dist+1);
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        }
    }

    private int lca(int l, int r) {
        while (r > 0) {
            int it= l;
            while (it != r && it != 0) it= p[it];
            if (it == r) return it;
            r= p[r];
        }
        return 0;
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