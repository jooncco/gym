package leetcode.p59;
// https://leetcode.com/problems/spiral-matrix-ii/


/**
 * Iteration
 * | Time: O (n^2)
 * | Space: O (n^2)
 */
public class Solution {
    private int grid[][];
    private int num, size, r, c;
    private enum DIRECTION { DOWN, LEFT, UP, RIGHT }
    private DIRECTION direction= DIRECTION.RIGHT;

    public int[][] generateMatrix(int n) {
        grid= new int[n][n];
        size= n*n; num= 1; r= 0; c= 0;
        while (num <= size) {
            grid[r][c]= num++;
            switch (direction) {
                case DOWN:
                    if (r < n-1 && grid[r+1][c] == 0) ++r;
                    else {
                        --c;
                        direction= DIRECTION.LEFT;
                    }
                    break;
                case LEFT:
                    if (c > 0 && grid[r][c-1] == 0) --c;
                    else {
                        --r;
                        direction= DIRECTION.UP;
                    }
                    break;
                case UP:
                    if (r > 0 && grid[r-1][c] == 0) --r;
                    else {
                        ++c;
                        direction= DIRECTION.RIGHT;
                    }
                    break;
                case RIGHT:
                    if (c < n-1 && grid[r][c+1] == 0) ++c;
                    else {
                        ++r;
                        direction= DIRECTION.DOWN;
                    }
                    break;
            }
        }
        return grid;
    }
}