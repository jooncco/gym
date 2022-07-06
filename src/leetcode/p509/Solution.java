package leetcode.p509;

public class Solution {
    private boolean isReady;
    private int[] cache;

    public int fib(int n) {
        if (!isReady) initCache();
        return cache[n];
    }

    private void initCache() {
        cache= new int[31];
        cache[0]= 0; cache[1]= 1;
        for (int i=2; i <= 30; ++i) cache[i]= cache[i-1]+cache[i-2];
        isReady= true;
    }
}