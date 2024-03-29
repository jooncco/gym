package leetcode.java.p167;
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, r = n - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target)
                break;
            if (numbers[l] + numbers[r] > target)
                --r;
            else
                ++l;
        }
        int[] ans = { l + 1, r + 1 };
        return ans;
    }
}