package programmers.pccp1.D;
// https://school.programmers.co.kr/learn/courses/15008/lessons/121686

import java.util.*;

/**
 * Sortings
 * | Time: O (n log(n))
 * | Space: O (n)
 */
public class Solution {
    public long[] solution(int[][] program) {
        int n= program.length;
        PriorityQueue<int[]> programs= new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for (int i=0; i < n; ++i) programs.add(program[i]);
        
        PriorityQueue<int[]> waitQueue= new PriorityQueue<>(
            (a,b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);
        long curTime= programs.peek()[1];
        long[] ans= new long[11];
        while (!programs.isEmpty() || !waitQueue.isEmpty()) {
            while (!programs.isEmpty() && programs.peek()[1] <= curTime) {
                waitQueue.add(programs.poll());
            }
            if (waitQueue.isEmpty()) curTime= programs.peek()[1];
            while (!programs.isEmpty() && programs.peek()[1] <= curTime) {
                waitQueue.add(programs.poll());
            }
            int[] next= waitQueue.poll();
            int priority= next[0];
            ans[priority] += curTime-next[1];
            curTime += next[2];
        }
        ans[0]= curTime;
        return ans;
    }
}