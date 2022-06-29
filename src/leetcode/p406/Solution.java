package leetcode.p406;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1]-b[1] : b[0]-a[0]);

        List<int[]> ans= new LinkedList<>();
        for (final int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}