package leetcode.p1146;
// https://leetcode.com/problems/snapshot-array/

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Binary Search
 * | Time: O (length) for constructor, O (1) for set and snap, O (n) for get
 * | Space: O (n)
 */
public class SnapshotArray {
    private int snapId;
    private final List<TreeMap<Integer, Integer>> list;

    public SnapshotArray(int length) {
        snapId= 0;
        list= new ArrayList<>();
        for (int i=0; i < length; ++i) {
            list.add(new TreeMap<>());
        }
    }

    public void set(int index, int val) {
        list.get(index).put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
        Integer floorKey= list.get(index).floorKey(snapId);
        return floorKey == null
            ? 0
            : list.get(index).get(floorKey);
    }
}