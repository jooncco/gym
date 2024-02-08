package leetcode.java.p1436;
// https://leetcode.com/problems/destination-city/

import java.util.*;

/**
 * Graph
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> cities = new HashSet<>();
        Set<String> from = new HashSet<>();
        for (List<String> path : paths) {
            cities.add(path.get(0));
            cities.add(path.get(1));
            from.add(path.get(0));
        }
        for (String city : cities) {
            if (!from.contains(city))
                return city;
        }
        return "";
    }
}