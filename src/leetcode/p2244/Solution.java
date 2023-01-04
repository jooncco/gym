package leetcode.p2244;
// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> count= new HashMap<>();
        for (int task : tasks) {
            count.put(task, count.getOrDefault(task, 0) + 1);
        }
        int ans= 0;
        for (int cnt : count.values()) {
            int minRound= minimumRounds(cnt);
            if (minRound < 0) return -1;
            ans += minRound;
        }
        return ans;
    }

    private int minimumRounds(int task) {
        for (int three= task/3; three >= 0; --three) {
            int rest= task - three*3;
            if (rest%2 == 0) return three + rest/2;
        }
        return -1;
    }
}