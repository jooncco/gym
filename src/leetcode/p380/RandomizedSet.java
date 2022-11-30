package leetcode.p380;
// https://leetcode.com/problems/insert-delete-getrandom-o1/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomizedSet {

    private Random rand;
    private Set<Integer> set;
    private List<Integer> nums;

    public RandomizedSet() {
        rand= new Random();
        set= new HashSet<>();
        nums= new LinkedList<>();
    }

    public boolean insert(int val) {
        if (set.contains(val)) return false;
        set.add(val);
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!set.contains(val)) return false;
        set.remove(val);
        nums.remove(nums.indexOf(val));
        return true;
    }

    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}