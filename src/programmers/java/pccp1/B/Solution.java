package programmers.pccp1.B;
// https://school.programmers.co.kr/learn/courses/15008/lessons/121684

public class Solution {
    private int s, g;
    private int[][] cc;

    public int solution(int[][] ability) {
        s= ability.length; g= ability[0].length;
        cc= new int[g][1<<s];
        for (int i=0; i < g; ++i) {
            for (int j=0; j < (1<<s); ++j) {
                cc[i][j]= -1;
            }
        }
        return findMax(ability, 0, 0);
    }
    
    private int findMax(int[][] ability, int idx, int sMask) {
        if (idx == g) return 0;
        if (cc[idx][sMask] > -1) return cc[idx][sMask];

        cc[idx][sMask]= 0;
        for (int i=0; i < s; ++i) {
            if ((sMask & (1<<i)) > 0) continue;
            cc[idx][sMask]= Math.max(
                cc[idx][sMask], ability[i][idx] + findMax(ability, idx+1, sMask | (1<<i)));
        }
        return cc[idx][sMask];
    }
}
