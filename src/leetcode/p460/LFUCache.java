package leetcode.p460;
// https://leetcode.com/problems/lfu-cache/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LFUCache {
    private Map<Integer, Integer> value= new HashMap<>(); // { key, value }
    private Map<Integer, Integer> freq= new HashMap<>(); // { key, frequency }
    private Map<Integer, Queue<Integer>> freqToKeys= new HashMap<>(); // { frequency, key[] }
    private int capacity, size;

    public LFUCache(int capacity) {
        this.capacity= capacity;
        this.size= 0;
    }

    public int get(int key) {
        if (!value.containsKey(key)) return -1;
        Integer frequency= freq.get(key)+1;
        freq.put(key, frequency);
        freqToKeys.computeIfAbsent(frequency, q -> new LinkedList<>()).add(key);
        return value.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (!freq.containsKey(key) && size == capacity) {
            boolean removed= false;
            for (int frequency : freqToKeys.keySet()) {
                if (removed) break;
                Queue<Integer> keys= freqToKeys.get(frequency);
                while (!keys.isEmpty() && !removed) {
                    int removeCandidate= keys.poll();
                    if (freq.get(removeCandidate) == frequency) {
                        this.value.remove(removeCandidate);
                        this.freq.remove(removeCandidate);
                        removed= true;
                    }
                }
            }
            --size;
        }
        if (!freq.containsKey(key)) ++size;
        this.value.put(key, value);
        this.freq.put(key, freq.getOrDefault(key, 0)+1);
        this.freqToKeys.computeIfAbsent(freq.get(key), q -> new LinkedList<>()).add(key);
    }
}