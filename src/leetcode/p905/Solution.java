package leetcode.p905;
// https://leetcode.com/problems/sort-array-by-parity/

import java.util.*;

/**
 * Math
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    public int[] sortArrayByParity(int[] nums) {
        List<Integer> odd= new ArrayList<>();
        int idx= 0;
        int[] ret= new int[nums.length];
        for (int num : nums) {
            if ((num&1) == 1) odd.add(num);
            else ret[idx++]= num;
        }
        for (int oddNum : odd) {
            ret[idx++]= oddNum;
        }
        return ret;
    }
}