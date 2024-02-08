package leetcode.java.p841;
// https://leetcode.com/problems/keys-and-rooms/

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // simple BFS
        boolean[] visited = new boolean[rooms.size()];
        int visitedRooms = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int here = queue.poll();
            if (visited[here])
                continue;

            visited[here] = true;
            ++visitedRooms;
            List<Integer> adjRooms = rooms.get(here);
            for (int there : adjRooms) {
                if (visited[there])
                    continue;
                queue.add(there);
            }
        }
        return visitedRooms == rooms.size();
    }
}