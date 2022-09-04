package leetcode.p987;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private final int OFFSET= 1000;
    private List<Integer>[][] lists;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        lists= new LinkedList[1000][2000];
        preOrder(root, 0, OFFSET);

        List<List<Integer>> ans= new LinkedList<>();
        for (int c=0; c < 2000; ++c) {
            List<Integer> tmp= new LinkedList<>();
            for (int r=0; r < 1000; ++r) {
                if (lists[r][c] == null) continue;
                if (lists[r][c].size() > 1) Collections.sort(lists[r][c]);
                tmp.addAll(lists[r][c]);
            }
            if (tmp.size() > 0) ans.add(tmp);
        }
        return ans;
    }

    private void preOrder(TreeNode node, int r, int c) {
        if (node == null) return;

        if (lists[r][c] == null) lists[r][c]= new LinkedList<>();
        lists[r][c].add(node.val);
        preOrder(node.left, r+1, c-1);
        preOrder(node.right, r+1, c+1);
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