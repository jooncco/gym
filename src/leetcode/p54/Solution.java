package leetcode.p54;
// https://leetcode.com/problems/spiral-matrix/

import java.util.ArrayList;
import java.util.List;

/**
 * Iteration
 * | Time: O (mn)
 * | Space: O (mn)
 */
public class Solution {
    private enum Direction { RIGHT, DOWN, LEFT, UP }

    private int m, n;
    private final List<Integer> list= new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        m= matrix.length;
        n= matrix[0].length;
        addToList(matrix, 0, 0, Direction.RIGHT);
        return list;
    }

    private void addToList(int[][] matrix, int r, int c, Direction dir) {
        if (list.size() == m*n) return;
        final int VISITED = Integer.MIN_VALUE;
        if (c >= n || r >= m || c < 0 || matrix[r][c] == VISITED) {
            switch (dir) {
                case RIGHT:
                    addToList(matrix, r+1, c-1, Direction.DOWN);
                    break;
                case DOWN:
                    addToList(matrix, r-1, c-1, Direction.LEFT);
                    break;
                case LEFT:
                    addToList(matrix, r-1, c+1, Direction.UP);
                    break;
                case UP:
                    addToList(matrix, r+1, c+1, Direction.RIGHT);
                    break;
            }
            return;
        }
        list.add(matrix[r][c]);
        matrix[r][c]= VISITED;

        int nextR= r, nextC= c;
        if (dir == Direction.DOWN) ++nextR;
        if (dir == Direction.UP) --nextR;
        if (dir == Direction.RIGHT) ++nextC;
        if (dir == Direction.LEFT) --nextC;
        addToList(matrix, nextR, nextC, dir);
    }
}