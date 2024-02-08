package leetcode.java.p2136;
// https://leetcode.com/problems/earliest-possible-day-of-full-bloom/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        List<int[]> flowers = new ArrayList<>(n);
        for (int i = 0; i < n; ++i)
            flowers.add(new int[] { plantTime[i], growTime[i] });
        flowers.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);

        int plant = 0, bloom = 0;
        for (final int[] flower : flowers) {
            plant += flower[0];
            bloom = Math.max(bloom, plant + flower[1]);
        }
        return bloom;
    }
}
