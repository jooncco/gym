package leetcode.java.p103;
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<QueueEntry> queue = new LinkedList<>();
        queue.add(new QueueEntry(root, 0));
        while (!queue.isEmpty()) {
            QueueEntry cur = queue.poll();
            // first entry?
            if (ret.size() == cur.level) {
                ret.add(new LinkedList<>());
            }
            if (cur.level % 2 == 0) {
                // left to right
                ret.get(ret.size() - 1).add(cur.node.val);
            } else {
                // right to left
                ret.get(ret.size() - 1).add(0, cur.node.val);
            }
            // add children
            if (cur.node.left != null)
                queue.add(new QueueEntry(cur.node.left, cur.level + 1));
            if (cur.node.right != null)
                queue.add(new QueueEntry(cur.node.right, cur.level + 1));
        }
        return ret;
    }
}

class QueueEntry {
    TreeNode node;
    int level;

    QueueEntry(TreeNode node, int level) {
        this.node = node;
        this.level = level;
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