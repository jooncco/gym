package leetcode.p1457;
// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/

/**
 * Brute Force (DFS)
 * | Time: O(n)
 * | Space: O(log(n))
 */
public class Solution {
    private int ans= 0;

    public int pseudoPalindromicPaths (TreeNode root) {
        visit(root, new int[10]);
        return ans;
    }

    private void visit(TreeNode node, int[] cnt) {
        if (node == null) return;
        ++cnt[node.val];
        if (node.left == null && node.right == null) {
            if (isPalindromic(cnt)) {
                ++ans;
            }
        }
        visit(node.left, cnt);
        visit(node.right, cnt);
        --cnt[node.val];
    }

    private boolean isPalindromic(int[] cnt) {
        int oddCnt= 0;
        for (int c : cnt) {
            if (c % 2 == 1) {
                ++oddCnt;
            }
            if (oddCnt > 1) {
                return false;
            }
        }
        return true;
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