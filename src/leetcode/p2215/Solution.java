package leetcode.p2215;
// https://leetcode.com/problems/find-the-difference-of-two-arrays/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Set
 * | Time: O (n + m)
 * | Space: O (n + m)
 */
public class Solution {
    public List<List<Integer>> findDifference(int[] A, int[] B) {
        Set<Integer> lookUpA= new HashSet<>();
        for (int num : A) lookUpA.add(num);
        Set<Integer> lookUpB= new HashSet<>();
        for (int num : B) lookUpB.add(num);

        Set<Integer> setA= new HashSet<>();
        for (int num : A) {
            if (!lookUpB.contains(num)) setA.add(num);
        }
        Set<Integer> setB= new HashSet<>();
        for (int num : B) {
            if (!lookUpA.contains(num)) setB.add(num);
        }
        return List.of(
                new ArrayList<>(setA),
                new ArrayList<>(setB));
    }
}