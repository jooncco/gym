package leetcode.java.p1342;
// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

public class Solution {
    public int numberOfSteps(int num) {
        int cnt = 0;
        while (num > 0) {
            ++cnt;
            if (num % 2 == 1)
                num -= 1;
            else
                num /= 2;
        }
        return cnt;
    }
}