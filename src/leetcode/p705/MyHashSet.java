package leetcode.p705;
// https://leetcode.com/problems/design-hashset/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hashing
 * | Time: O (1) for add, remove, contains
 * | Space: O (key)
 */
public class MyHashSet {
    private final List<List<Integer>> buckets;
    private static final int INDEX_SIZE= 10000;

    public MyHashSet() {
        buckets= new ArrayList<>(INDEX_SIZE);
        for (int i=0; i < INDEX_SIZE; ++i) {
            buckets.add(new ArrayList<>());
        }
    }

    public void add(int key) {
        int idx= key%INDEX_SIZE;
        if (!buckets.get(idx).contains(key)) {
            buckets.get(idx).add(key);
        }
    }

    public void remove(int key) {
        int idx= key%INDEX_SIZE;
        if (buckets.get(idx).contains(key)) {
            List<Integer> bucket= buckets.get(idx)
                    .stream()
                    .filter(k -> k != key)
                    .collect(Collectors.toList());
            buckets.set(idx, bucket);
        }
    }

    public boolean contains(int key) {
        return buckets.get(key%INDEX_SIZE).contains(key);
    }
}