package leetcode.p134;
// https://leetcode.com/problems/gas-station/

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n= gas.length;
        int[] diff= new int[n];
        int totalSum= 0;
        for (int i=0; i < n; ++i) {
            diff[i]= gas[i]-cost[i];
            totalSum += diff[i];
        }
        if (totalSum < 0) return -1;

        int[] cumSum= new int[n];
        cumSum[0]= diff[0];
        for (int i=1; i < n; ++i) {
            cumSum[i]= cumSum[i-1]+diff[i];
        }
        int minIdx= 0, minCumSum= cumSum[0];
        for (int i=1; i < n; ++i) {
            if (cumSum[i] < minCumSum) {
                minIdx= i;
                minCumSum= cumSum[i];
            }
        }
        return (minIdx+1)%n;
    }
}