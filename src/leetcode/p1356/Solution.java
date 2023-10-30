package leetcode.p1356;
// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/

import java.util.*;

/**
 * Sortings
 * | Time: O(n log(n)^2)
 * | Space: O(n)
 */
public class Solution {
    public int[] sortByBits(int[] arr) {
        List<Integer> list= new ArrayList<>();
        for (int num : arr) list.add(num);
        Collections.sort(list, (a,b) -> countBits(a) == countBits(b) ? a-b : countBits(a)-countBits(b));
        for (int i= 0; i < arr.length; ++i) {
            arr[i]= list.get(i);
        }
        return arr;
    }

    private int countBits(int num) {
        int cnt= 0;
        while (num != 0) {
            if ((num&1) == 1) ++cnt;
            num >>= 1;
        }
        return cnt;
    }
}