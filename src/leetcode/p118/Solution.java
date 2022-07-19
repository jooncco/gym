package leetcode.p118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalsTriangle= new ArrayList<>();
        pascalsTriangle.add(List.of(1));
        while (pascalsTriangle.size() < numRows) {
            List<Integer> prevRow= pascalsTriangle.get(pascalsTriangle.size()-1);
            List<Integer> newRow= new ArrayList<>();
            newRow.add(1);
            for (int idx=1; idx < prevRow.size(); ++idx) {
                newRow.add(prevRow.get(idx-1) + prevRow.get(idx));
            }
            newRow.add(1);
            pascalsTriangle.add(newRow);
        }
        return pascalsTriangle;
    }
}