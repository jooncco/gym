package programmers.p214289;
// https://school.programmers.co.kr/learn/courses/30/lessons/214289

/**
 * Dynamic Programming
 * | Time: O (n)
 * | Space: O (51n)
 */
public class Solution {
    private final int TEMP_OFFSET= 10;
    private final int INF= (int)1e8;
    private int[][] cache;

    public int solution(int t, int l, int r, int a, int b, int[] onboard) {
        int n= onboard.length;
        cache= new int[n][51];
        for (int i=0; i < n; ++i) {
            for (int j=0; j < 51; ++j) {
                cache[i][j]= -1;
            }
        }
        return findMin(t, l, r, a, b, onboard, 0, t);
    }

    private int findMin(int t, int l, int r, int a, int b, int[] onboard, int idx, int temp) {
        if (idx == onboard.length) return 0;
        if (onboard[idx] == 1 && (temp > r || temp < l)) return INF;
        if (cache[idx][TEMP_OFFSET+temp] > -1) return cache[idx][TEMP_OFFSET+temp];

        cache[idx][TEMP_OFFSET+temp]= INF;
        cache[idx][TEMP_OFFSET+temp]= Math.min(cache[idx][TEMP_OFFSET+temp], b + findMin(t, l, r, a, b, onboard, idx+1, temp));
        if (l < temp && r < t) {
            cache[idx][TEMP_OFFSET+temp]= Math.min(cache[idx][TEMP_OFFSET+temp], a + findMin(t, l, r, a, b, onboard, idx+1, temp-1));
        }
        if (r > temp && l > t) {
            cache[idx][TEMP_OFFSET+temp]= Math.min(cache[idx][TEMP_OFFSET+temp], a + findMin(t, l, r, a, b, onboard, idx+1, temp+1));
        }
        int nextTemp= temp == t
                ? temp
                : temp > t
                ? temp-1
                : temp+1;
        cache[idx][TEMP_OFFSET+temp]= Math.min(cache[idx][TEMP_OFFSET+temp], findMin(t, l, r, a, b, onboard, idx+1, nextTemp));
        return cache[idx][TEMP_OFFSET+temp];
    }
}