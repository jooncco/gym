package leetcode.java.p997;
// https://leetcode.com/problems/find-the-town-judge/

/**
 * Brute force solution
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1];
        int[] beingtrustedCount = new int[n + 1];
        for (int[] t : trust) {
            trustCount[t[0]]++;
            beingtrustedCount[t[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == 0 && beingtrustedCount[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}