package leetcode.p352;
// https://leetcode.com/problems/data-stream-as-disjoint-intervals/

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class SummaryRanges {
    private SortedSet<Integer> numbers;

    public SummaryRanges() {
        numbers= new TreeSet<>();
    }

    public void addNum(int value) {
        numbers.add(value);
    }

    public int[][] getIntervals() {
        List<int[]> intervals= new ArrayList<>();
        int l= -1, r= -1;
        for (int num : numbers) {
            if (l < 0) l= r= num;
            else if (r+1 == num) r= num;
            else {
                intervals.add(new int[]{l, r});
                l= r= num;
            }
        }
        intervals.add(new int[]{l, r});
        return intervals.toArray(new int[intervals.size()][2]);
    }
}