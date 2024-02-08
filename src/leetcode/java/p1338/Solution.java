package leetcode.java.p1338;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> count;

    public int minSetSize(int[] arr) {
        // count
        count = new HashMap<>();
        for (int num : arr) {
            count.computeIfPresent(num, (k, v) -> v + 1);
            count.computeIfAbsent(num, key -> 1);
        }
        List<int[]> countList = new ArrayList<>();
        for (Integer num : count.keySet()) {
            countList.add(new int[] { num, count.get(num) });
        }

        // sort in count descending order
        Collections.sort(countList, (a, b) -> b[1] - a[1]);

        // compute
        int ans = 0, numOfElements = arr.length;
        while (numOfElements > arr.length / 2) {
            ++ans;
            numOfElements -= countList.get(0)[1];
            countList.remove(0);
        }
        return ans;
    }
}
