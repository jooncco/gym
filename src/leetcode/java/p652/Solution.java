package leetcode.java.p652;
// https://leetcode.com/problems/find-duplicate-subtrees/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    List<TreeNode> ans = new ArrayList<>();
    Map<String, Integer> fingerPrintCounts = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        findDuplicates(root);
        return ans;
    }

    private String findDuplicates(TreeNode node) {
        if (node == null)
            return "";
        String left = findDuplicates(node.left);
        String right = findDuplicates(node.right);

        String fingerPrint = node.val + "/" + left + "=" + right;
        fingerPrintCounts.put(fingerPrint, fingerPrintCounts.getOrDefault(fingerPrint, 0) + 1);
        if (fingerPrintCounts.get(fingerPrint) == 2) {
            ans.add(node);
        }
        return fingerPrint;
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