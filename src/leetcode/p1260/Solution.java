package leetcode.p1260;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int k, size;
    private int getShiftedIndex(int idx) {
        return (idx-k+size)%size;
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m= grid.length, n= grid[0].length;
        this.size= m*n;
        this.k= k%size;
        List<List<Integer>> shiftedGrid = new ArrayList<>();
        for (int i=0; i < m; ++i) {
            shiftedGrid.add(new ArrayList<>());
            List<Integer> row = shiftedGrid.get(i);
            for (int j=0; j < n; ++j) {
                int shiftedIdx= getShiftedIndex(i*n+j);
                row.add(grid[shiftedIdx/n][shiftedIdx%n]);
            }
        }
        return shiftedGrid;
    }
}
