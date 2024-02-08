package leetcode.java.p1396;
// https://leetcode.com/problems/design-underground-system/

import java.util.HashMap;
import java.util.Map;

/**
 * Ad hoc
 * | Time: O (1) for checkIn, checkOut, getAverageTime
 * | Space: O (# of travels)
 */
public class UndergroundSystem {
    private final Map<Integer, CheckIn> checkIns;
    private final Map<String, Map<String, Travels>> sums;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        sums = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkIns.get(id);
        sums.computeIfAbsent(checkIn.stationName, x -> new HashMap<>())
                .computeIfAbsent(stationName, x -> new Travels())
                .add(t - checkIn.t);
    }

    public double getAverageTime(String startStation, String endStation) {
        return sums.get(startStation).get(endStation).getAverage();
    }

    private static class CheckIn {
        String stationName;
        int t;

        CheckIn(String stationName, int t) {
            this.stationName = stationName;
            this.t = t;
        }
    }

    private static class Travels {
        long sum;
        int count;

        void add(int time) {
            sum += time;
            ++count;
        }

        double getAverage() {
            return sum * 1.0 / count;
        }
    }
}