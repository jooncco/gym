package p1396;
// https://leetcode.com/problems/design-underground-system/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndergroundSystem {

    class Destination {
        String name;
        int cnt;
        int total;

        public Destination(String name, int cnt, int total) {
            this.name= name;
            this.cnt= cnt;
            this.total= total;
        }
    }

    class Station {
        String name;
        List<Destination> destinations;

        public Station(String name) {
            this.name= name;
            this.destinations= new ArrayList<>();
        }
    }

    private List<Station> stations;
    private Map<Integer,String> checkIns;
    private Map<Integer,Integer> times;

    public UndergroundSystem() {
        stations= new ArrayList<>();
        checkIns= new HashMap<>();
        times= new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id,stationName);
        times.put(id,t);
    }

    public void checkOut(int id, String stationName, int t) {
        String startStation= checkIns.get(id);
        Integer startTime= times.get(id);
        Station station= stations.stream().filter(s -> s.name.equals(startStation)).findAny().orElse(null);
        if (station == null) {
            station= new Station(startStation);
            station.destinations.add(new Destination(stationName, 1, t-startTime));
            stations.add(station);
        }
        else {
            Destination destination= station.destinations.stream().filter(d -> d.name.equals(stationName)).findAny().orElse(null);
            if (destination == null) {
                destination= new Destination(stationName, 1, t-startTime);
                station.destinations.add(destination);
            }
            else {
                destination.cnt++;
                destination.total += t-startTime;
            }
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        Station station= stations.stream().filter(s -> s.name.equals(startStation)).findAny().orElse(null);
        for (Destination destination : station.destinations) {
            if (destination.name.equals(endStation)) {
                return destination.total / (double)destination.cnt;
            }
        }
        return 1d;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
