package leetcode.p997;
// https://leetcode.com/problems/find-the-town-judge/

public class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] beingTrustedCount= new int[n];
        boolean[] voted= new boolean[n];
        for (int[] vote : trust) {
            voted[vote[0]-1]= true;
            ++beingTrustedCount[vote[1]-1];
        }
        for (int i=0; i < n; ++i) {
            if (beingTrustedCount[i] == n-1 && !voted[i]) return i+1;
        }
        return -1;
    }
}