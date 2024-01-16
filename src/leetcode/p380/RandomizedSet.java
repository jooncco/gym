package leetcode.p380;
// https://leetcode.com/problems/insert-delete-getrandom-o1/

import java.util.*;

/**
 * Hashing
 * | Time: O(1) for all operations
 * | Space: O(1e5)
 */
public class RandomizedSet {
    private final int HASH_TABLE_SIZE= 1000_00;
    
    private List<List<Integer>> table= new ArrayList<List<Integer>>(HASH_TABLE_SIZE);
    private List<Integer> hashCodes= new ArrayList<>();
    private Random random= new Random(10L);
    
    public RandomizedSet() {
        for (int i=0; i < HASH_TABLE_SIZE; ++i) table.add(new ArrayList<Integer>());
    }
    
    public boolean insert(int val) {
        if (table.get(hashCode(val)).size() == 0) {
            table.get(hashCode(val)).add(val);
            hashCodes.add(hashCode(val));
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (table.get(hashCode(val)).size() == 0) {
            return false;
        }
        table.get(hashCode(val)).clear();
        int idx= 0;
        for (int i=0; i < hashCodes.size(); ++i) {
            if (hashCodes.get(i) == hashCode(val)) {
                idx= i;
                break;
            }
        }
        hashCodes.remove(idx);
        return true;
    }
    
    public int getRandom() {
        int hash= hashCodes.get(random.nextInt(hashCodes.size()));
        return table.get(hash).get(0);
    }

    private int hashCode(int val) {
        long hash= val;
        hash= hash*31 + 7;
        while (hash < 0) hash += HASH_TABLE_SIZE;
        return (int)hash%HASH_TABLE_SIZE;
    }
}