package leetcode.java.p1361;
// https://leetcode.com/problems/validate-binary-tree-nodes/

/**
 * Graph, DFS
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    boolean isValid;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = -1;
        }
        for (int i = 0; i < n; ++i) {
            if (leftChild[i] != -1) {
                if (parent[leftChild[i]] != -1)
                    return false;
                parent[leftChild[i]] = i;
            }
            if (rightChild[i] != -1) {
                if (parent[rightChild[i]] != -1)
                    return false;
                parent[rightChild[i]] = i;
            }
        }
        // find root
        int root = -1;
        for (int i = 0; i < n; ++i) {
            if (parent[i] == -1) {
                if (root != -1)
                    return false;
                root = i;
            }
        }
        if (root == -1)
            return false;
        // visit nodes
        isValid = true;
        boolean[] visited = new boolean[n];
        visited[root] = true;
        visit(n, visited, leftChild, rightChild, root);
        // all visited?
        for (int i = 0; i < n; ++i) {
            if (!visited[i])
                isValid = false;
        }
        return isValid;
    }

    private void visit(int n, boolean[] visited, int[] leftChild, int[] rightChild, int cur) {
        if (leftChild[cur] != -1) {
            visited[leftChild[cur]] = true;
            visit(n, visited, leftChild, rightChild, leftChild[cur]);
        }
        if (rightChild[cur] != -1) {
            visited[rightChild[cur]] = true;
            visit(n, visited, leftChild, rightChild, rightChild[cur]);
        }
    }
}