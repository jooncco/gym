package leetcode.p1626;
// https://leetcode.com/problems/best-team-with-no-conflicts/

import java.util.Arrays;

public class Solution {
    private int n;
    private int[][] cache, players;

    public int bestTeamScore(int[] scores, int[] ages) {
        n= scores.length;
        cache= new int[n+1][n+1];
        for (int i=0; i <= n; ++i) {
            for (int j=0; j <= n; ++j) {
                cache[i][j]= -1;
            }
        }
        players= new int[n+1][2];
        for (int i=1; i <= n; ++i) {
            players[i]= new int[]{ages[i-1], scores[i-1]};
        }
        Arrays.sort(players, (a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        return findMaxScore(1, 0);
    }

    private int findMaxScore(int curIdx, int maxPlayerIdx) {
        if (curIdx > n) return 0;
        if (cache[curIdx][maxPlayerIdx] > -1) return cache[curIdx][maxPlayerIdx];

        cache[curIdx][maxPlayerIdx]= findMaxScore(curIdx+1, maxPlayerIdx);
        if (players[maxPlayerIdx][1] <= players[curIdx][1]) {
            cache[curIdx][maxPlayerIdx]= Math.max(
                    cache[curIdx][maxPlayerIdx],
                    players[curIdx][1] + findMaxScore(curIdx+1, curIdx));
        }
        return cache[curIdx][maxPlayerIdx];
    }
}