package programmers.pccp1.D;

import java.util.*;

public class Solution {
    public long[] solution(int[][] program) {
        int n= program.length;
        PriorityQueue<int[]> programs= new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for (int i=0; i < n; ++i) programs.add(program[i]);
        
        PriorityQueue<int[]> waitQueue= new PriorityQueue<>(
            (a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        long finishTime= programs.peek()[1];
        long[] ans= new long[11];
        while (!programs.isEmpty() || !waitQueue.isEmpty()) {
            while (!programs.isEmpty() && programs.peek()[1] <= finishTime) {
                waitQueue.add(programs.poll());
            }
            if (!programs.isEmpty() && waitQueue.isEmpty()) waitQueue.add(programs.poll());
            int[] next= waitQueue.poll();
            int priority= next[0];
            ans[priority] += Math.max(finishTime-next[1], 0);
            finishTime= Math.max(finishTime+next[2], next[1]+next[2]);
        }
        ans[0]= finishTime;
        return ans;
    }
}