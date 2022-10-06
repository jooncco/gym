package leetcode.p981;
// https://leetcode.com/problems/time-based-key-value-store/

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map= new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> values= map.get(key);
        if (values == null) return "";

        Integer floorTimestamp= values.floorKey(timestamp);
        if (floorTimestamp == null) return "";
        return values.get(floorTimestamp);
    }
}