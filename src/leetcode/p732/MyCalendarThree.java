package leetcode.p732;
// https://leetcode.com/problems/my-calendar-iii/

import java.util.TreeMap;

public class MyCalendarThree {

    TreeMap<Integer, Integer> sortedMap;

    public MyCalendarThree() {
        sortedMap= new TreeMap<>();
    }

    public int book(int start, int end) {
        sortedMap.put(start, sortedMap.getOrDefault(start, 0) + 1);
        sortedMap.put(end, sortedMap.getOrDefault(end, 0) - 1);
        int ans= 0, ongoing= 0;
        for (int value : sortedMap.values()) {
            ans= Math.max(ans, ongoing += value);
        }
        return ans;
    }
}
