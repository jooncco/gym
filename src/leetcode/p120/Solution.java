package leetcode.p120;
// https://leetcode.com/problems/triangle/

import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<Integer> cache;

    public int minimumTotal(List<List<Integer>> triangle) {
        int h= triangle.size(), w= triangle.get(h-1).size();
        cache= Arrays.asList(new Integer[1]);
        cache.set(0, triangle.get(0).get(0));
        for (int row=1; row < h; ++row) {
            int rowSize= row+1;
            List<Integer> newRow = Arrays.asList(new Integer[rowSize]);
            for (int col=0; col < rowSize; ++col) {
                int minValue;
                if (col == 0) minValue = cache.get(col);
                else if (col == rowSize-1) minValue = cache.get(col-1);
                else minValue = Math.min(cache.get(col-1), cache.get(col));

                newRow.set(col, minValue + triangle.get(row).get(col));
            }
            cache= newRow;
        }
        return cache.stream().mapToInt(x->x).min().orElse(0);
    }
}