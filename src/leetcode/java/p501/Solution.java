package leetcode.java.p501;
// https://leetcode.com/problems/find-mode-in-binary-search-tree/

import java.util.*;

/**
 * Tree
 * | Time: O(n)
 * | Space: O(1) (extra. other than the space for the return value)
 */
public class Solution {
    private Set<Integer> ans = new HashSet<>();
    private int cur = 987654321, cnt = 0, mxCnt = 0;

    public int[] findMode(TreeNode root) {
        inOrder(root); // O(n)
        int[] ret = new int[ans.size()];
        int idx = 0;
        for (int mode : ans) {
            ret[idx++] = mode;
        }
        return ret;
    }

    private void inOrder(TreeNode node) {
        if (node == null)
            return;

        inOrder(node.left);
        if (node.val == cur)
            ++cnt;
        else {
            cur = node.val;
            cnt = 1;
        }
        if (cnt > mxCnt)
            ans.clear();
        if (cnt >= mxCnt) {
            ans.add(node.val);
            mxCnt = cnt;
        }
        inOrder(node.right);
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