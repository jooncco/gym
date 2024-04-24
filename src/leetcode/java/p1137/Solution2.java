package leetcode.java.p1137;

public class Solution2 {
    public int tribonacci(int n) {
        int[] fb = new int[38];
        fb[0] = 0;
        fb[1] = 1;
        fb[2] = 1;

        for(int i = 3; i <= 37; i++) {
            fb[i] = fb[i-3] + fb[i-2] + fb[i-1];
        }

        return fb[n];
    }
}
