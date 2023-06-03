package leetcode.p1376;

import java.util.*;

public class Solution {
    public int numOfMinutes(int n, int headID, int[] managerOf, int[] informTime) {
		Map<Integer, List<Integer>> subordinates= new HashMap<>();
		for (int i=0; i < managerOf.length; ++i) {
			subordinates.computeIfAbsent(managerOf[i], x -> new ArrayList<>()).add(i);
		}

		int ans= 0;
		Queue<int[]> queue= new LinkedList<>();
		queue.add(new int[]{headID, 0});
		while (!queue.isEmpty()) {
			int[] cur= queue.poll();
			int who= cur[0], time= cur[1];
			ans= Math.max(ans, time);
			if (subordinates.get(who) != null)
				for (int subordinate : subordinates.get(who)) {
					queue.add(new int[]{subordinate, time + informTime[who]});
				}
		}
		return ans;
    }
}