package leetcode.java.p427;
// https://leetcode.com/problems/construct-quad-tree/

public class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    private Node construct(int[][] grid, int r, int c, int size) {
        if (isLeaf(grid, r, c, size)) {
            return new Node(grid[r][c] == 1, true);
        }
        Node topLeft = construct(grid, r, c, size / 2);
        Node topRight = construct(grid, r, c + size / 2, size / 2);
        Node bottomLeft = construct(grid, r + size / 2, c, size / 2);
        Node bottomRight = construct(grid, r + size / 2, c + size / 2, size / 2);
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private boolean isLeaf(int[][] grid, int r, int c, int size) {
        int val = grid[r][c];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (grid[r + i][c + j] != val)
                    return false;
            }
        }
        return true;
    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};