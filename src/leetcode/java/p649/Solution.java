package leetcode.java.p649;
// https://leetcode.com/problems/dota2-senate/

import java.util.Deque;
import java.util.LinkedList;

/**
 * Game Theory, Greedy
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Deque<Integer> radiants = new LinkedList<>(), dires = new LinkedList<>();
        for (int i = 0; i < senate.length(); ++i) {
            if (senate.charAt(i) == 'R')
                radiants.addLast(i);
            else
                dires.addLast(i);
        }
        while (!radiants.isEmpty() && !dires.isEmpty()) {
            int radiantIdx = radiants.pollFirst(), direIdx = dires.pollFirst();
            if (radiantIdx < direIdx)
                radiants.addLast(radiantIdx + n);
            else
                dires.addLast(direIdx + n);
        }
        return radiants.isEmpty() ? "Dire" : "Radiant";
    }
}
