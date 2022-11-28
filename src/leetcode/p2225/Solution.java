package leetcode.p2225;
// https://leetcode.com/problems/find-players-with-zero-or-one-losses/

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> zero= new HashSet<>(), one= new HashSet<>(), out= new HashSet<>();
        for (int[] result : matches) zero.add(result[0]);
        for (int[] result : matches) {
            if (one.contains(result[1])) one.remove(result[1]);
            else if (zero.contains(result[1])) {
                zero.remove(result[1]);
                one.add(result[1]);
            }
            else if (!out.contains(result[1])) one.add(result[1]);
        }
        List<Integer> neverLost= zero.stream().sorted((a,b) -> a-b).collect(Collectors.toList());
        List<Integer> lostOnce= one.stream().sorted((a,b) -> a-b).collect(Collectors.toList());
        return List.of(neverLost, lostOnce);
    }
}