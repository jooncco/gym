package leetcode.java.p133;
// https://leetcode.com/problems/clone-graph/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Integer, Node> nodes = new HashMap<>();

    public Node cloneGraph(Node node) {
        visit(new boolean[101], node);
        updateNeighbors(new boolean[101], node);
        return nodes.get(node.val);
    }

    private void visit(boolean[] visited, Node node) {
        visited[node.val] = true;
        nodes.put(node.val, new Node(node.val));
        for (Node neighbor : node.neighbors) {
            if (visited[neighbor.val])
                continue;
            visit(visited, neighbor);
        }
    }

    private void updateNeighbors(boolean[] visited, Node node) {
        visited[node.val] = true;
        Node clonedNode = nodes.get(node.val);
        clonedNode.neighbors = new ArrayList<>();
        for (Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(nodes.get(neighbor.val));
            if (visited[neighbor.val])
                continue;
            updateNeighbors(visited, neighbor);
        }
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}