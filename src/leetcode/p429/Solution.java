package leetcode.p429;
// https://leetcode.com/problems/n-ary-tree-level-order-traversal/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> levelOrderLists;

    public List<List<Integer>> levelOrder(Node root) {
        levelOrderLists= new ArrayList<>();
        preOrder(root, 0);
        return levelOrderLists;
    }

    private void preOrder(Node node, final int currentLevel) {
        if (node == null) return;

        if (currentLevel >= levelOrderLists.size()) levelOrderLists.add(new LinkedList<>());
        levelOrderLists.get(currentLevel).add(node.val);
        if (node.children != null) {
            for (Node child : node.children) {
                preOrder(child, currentLevel+1);
            }
        }
    }
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};