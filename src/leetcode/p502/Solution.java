package leetcode.p502;
// https://leetcode.com/problems/ipo/

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        final int n= profits.length;
        List<int[]> projects= new LinkedList<>();
        for (int i=0; i < n; ++i) {
            projects.add(new int[]{capital[0], profits[0]});
        }
        projects.sort(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b) -> b-a);
        int curCapital= w;
        while (k-- > 0) {
            while (!projects.isEmpty() && projects.get(0)[0] <= curCapital) {
                int[] project= projects.get(0);
                projects.remove(0);
                pq.add(project[1]);
            }
            if (pq.isEmpty()) break;
            curCapital += pq.poll();
            System.out.println(curCapital);
        }
        return curCapital;
    }
}