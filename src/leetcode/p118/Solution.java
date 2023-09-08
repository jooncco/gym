package leetcode.p118;
// https://leetcode.com/problems/pascals-triangle/

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation
 * | Time: O(n^2)
 * | Space: O(n^2)
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list= new ArrayList<>();
        list.add(List.of(1));
        for (int i=1; i < numRows; ++i) {
            List<Integer> row= new ArrayList<>();
            row.add(1);
            for (int j=1; j < i; ++j) {
                row.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
            }
            row.add(1);
            list.add(row);
        }
        return list;
    }
}