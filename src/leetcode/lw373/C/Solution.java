package leetcode.lw373.C;

import java.util.*;

public class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n= nums.length;
        List<int[]> arr= new ArrayList<>();
        for (int i= 0; i < n; ++i) {
            arr.add(new int[]{nums[i], i});
        }
        arr.sort((a,b) -> Integer.compare(a[0], b[0]));
        int[] ans= new int[n];
        int l= 0;
        PriorityQueue<Integer> indices= new PriorityQueue<>((a,b) -> a-b);
        indices.add(arr.get(0)[1]);
        for (int r=1; r < n; ++r) {
            int num= arr.get(r)[0], origIdx= arr.get(r)[1];
            if (num - arr.get(r-1)[0] > limit) {
                while (!indices.isEmpty()) {
                    int idx= indices.poll();
                    ans[idx]= arr.get(l++)[0];
                }
            }
            indices.add(origIdx);
        }
        while (!indices.isEmpty()) {
            int idx= indices.poll();
            ans[idx]= arr.get(l++)[0];
        }
        return ans;
    }
}