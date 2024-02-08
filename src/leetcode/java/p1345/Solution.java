package leetcode.java.p1345;
// https://leetcode.com/problems/jump-game-iv/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> indicesOfValue = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            indicesOfValue.computeIfAbsent(arr[i], set -> new ArrayList<>()).add(i);
        }
        int[] minDis = new int[n];
        for (int i = 1; i < n; ++i)
            minDis[i] = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                if (cur == n - 1)
                    return step;

                List<Integer> nextIndices = indicesOfValue.get(arr[cur]);
                nextIndices.add(cur - 1);
                nextIndices.add(cur + 1);
                for (int next : nextIndices) {
                    if (next >= 0 && next < n && minDis[next] == -1) {
                        minDis[next] = step + 1;
                        queue.offer(next);
                    }
                }
                nextIndices.clear();
            }
            ++step;
        }
        return minDis[n - 1];
    }
}