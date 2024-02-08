package leetcode.java.p706;
// https://leetcode.com/problems/design-hashmap/

/**
 * Hasing
 * | Time: O(1) for all operations
 * | Space: O(|key|)
 */
public class MyHashMap {
    private static final int CAPACITY = 1000_000 + 10;
    private int[] bucket;

    public MyHashMap() {
        bucket = new int[CAPACITY];
        for (int i = 0; i < CAPACITY; ++i)
            bucket[i] = -1;
    }

    public void put(int key, int value) {
        bucket[key] = value;
    }

    public int get(int key) {
        return bucket[key];
    }

    public void remove(int key) {
        bucket[key] = -1;
    }
}