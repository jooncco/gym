package leetcode.lw360.C;

import java.util.*;

public class Solution {
    public int minOperations(List<Integer> nums, int target) {
        long sum= 0;
        for (int num : nums) sum += num;
        if (sum < target) return -1;

        List<Integer> targetDigits= new ArrayList<>();
        int p= 0;
        while (target > 0) {
            if (target%2 == 1) {
                targetDigits.add(p);
            }
            ++p;
            target /= 2;
        }
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for (int num : nums) {
            int pw= 0, d= 1;
            while (d < num) {
                d *= 2;
                ++pw;
            }
            pq.add(pw);
        }
        int ans= 0;
        for (int d : targetDigits) {
            while (!pq.isEmpty() && pq.peek() < d) {
                int tmp= pq.poll();
                if (pq.isEmpty() || pq.peek() != tmp) continue;
                pq.add(pq.poll()+1);
            }
            if (pq.peek() == d) {
                pq.poll(); // use it
                continue;
            }
            while (!pq.isEmpty() && pq.peek() > d) {
                int tmp= pq.poll();
                pq.add(tmp-1);
                pq.add(tmp-1);
                ++ans;
            }
            pq.poll(); // use it
        }
        return ans;
    }
}