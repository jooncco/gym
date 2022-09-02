package leetcode.p637;
// https://leetcode.com/problems/average-of-levels-in-binary-tree/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Double> averageValues;
    private List<Integer> counts;

    public List<Double> averageOfLevels(TreeNode root) {
        averageValues= new ArrayList<>();
        counts= new ArrayList<>();
        calculateSum(root, 0);
        calculateAverage();
        return averageValues;
    }

    private void calculateSum(TreeNode node, final int level) {
        if (node == null) return;
        if (averageValues.size() <= level) {
            averageValues.add(0.0);
            counts.add(0);
        }

        averageValues.set(level, averageValues.get(level) + node.val);
        counts.set(level, counts.get(level) + 1);
        calculateSum(node.left, level+1);
        calculateSum(node.right, level+1);
    }

    private void calculateAverage() {
        for (int i=0; i < averageValues.size(); ++i) {
            averageValues.set(i, averageValues.get(i)/counts.get(i));
        }
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