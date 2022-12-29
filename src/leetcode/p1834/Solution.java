package leetcode.p1834;
// https://leetcode.com/problems/single-threaded-cpu/

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int[] getOrder(int[][] tasks) {
        final int n= tasks.length;
        // Make it int[3], appending index
        List<int[]> taskList = new ArrayList<>(n);
        for (int i=0; i < n; ++i) {
            taskList.add(new int[]{tasks[i][0], tasks[i][1], i});
        }
        // Sort them in (enqueue time, process time) ascending order
        taskList.sort((a,b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);
        // Priority Queue is used when there are multiple executable tasks
        // Sort them in (process time, index) ascending order
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b) -> a[1] != b[1] ? a[1]-b[1] : a[0]-b[0]);
        int[] ans= new int[n];
        int listIdx= 0, curTime= 0;
        for (int i=0; i < n; ++i) {
            while (listIdx < n && taskList.get(listIdx)[0] <= curTime) {
                pq.add(taskList.get(listIdx++));
            }
            int[] nextTask;
            if (pq.isEmpty()) {
                nextTask= taskList.get(listIdx++);
                curTime= nextTask[0] + nextTask[1];
            } else {
                nextTask= pq.poll();
                curTime= curTime + nextTask[1];
            }
            ans[i]= nextTask[2];
        }
        return ans;
    }
}
