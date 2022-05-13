package leetcode.p117;
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Node>> nodesWithLevel;

    public Node connect(Node root) {
        nodesWithLevel= new ArrayList<>();
        populateNodesWithLevel(root, 0);
        for (List<Node> nodes : nodesWithLevel) {
            setNexts(nodes);
        }
        return root;
    }

    private void populateNodesWithLevel(Node node, int level) {
        if (node == null) return;

        if (nodesWithLevel.size() == level) {
            nodesWithLevel.add(new ArrayList<>());
        }
        nodesWithLevel.get(level).add(node);
        populateNodesWithLevel(node.left, level+1);
        populateNodesWithLevel(node.right, level+1);
    }

    private void setNexts(List<Node> nodes) {
        int n= nodes.size();
        for (int i=1; i < n; ++i) {
            nodes.get(i-1).next= nodes.get(i);
        }
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};