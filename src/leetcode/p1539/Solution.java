package leetcode.p1539;
// https://leetcode.com/problems/kth-missing-positive-number/

public class Solution {
    public int findKthPositive(int[] arr, int k) {
        int cnt= 0, idx= 0, curNum= 0;
        while (cnt < k) {
            ++curNum;
            if (idx < arr.length && arr[idx] == curNum) {
                ++idx;
            } else {
                ++cnt;
            }
        }
        return curNum;
    }
}