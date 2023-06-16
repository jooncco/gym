package programmers.p181186;
// https://school.programmers.co.kr/learn/courses/30/lessons/181186

/**
 * Dynamic Programming
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    private static final int M = 1000_000_007;

    public int solution(int n) {
        long[] cache = new long[Math.max(6, n+1)];
        cache[0]= 1; cache[1]= 1; cache[2]= 3; cache[3]= 10; cache[4]= 23; cache[5]= 62;
        for (int i=6; i <= n; ++i) {
            cache[i]= (cache[i-1] + 2*cache[i-2] + 6*cache[i-3] + cache[i-4] - cache[i-6] + M) % M;
        }
        return (int)cache[n];
    }
}