package programmers.pccp1.C;
// https://school.programmers.co.kr/learn/courses/15008/lessons/121685

import java.util.*;

public class Solution {
    public String[] solution(int[][] queries) {
        int N= queries.length;
        String[] ans= new String[queries.length];
        for (int i= 0; i < N; ++i) {
            int n= queries[i][0], p= queries[i][1];
            ans[i]= getGene(n, p);
        }
        return ans;
    }

    private String getGene(int n, int p) {
        if (n == 1) return "Rr";
        if (n == 2) {
            if (p == 1) return "RR";
            if (p == 4) return "rr";
            return "Rr";
        }

        int parentP= (p+3)/4;
        String parentGene= getGene(n-1, parentP);
        if (List.of("RR", "rr").contains(parentGene)) return parentGene;
        // Rr
        p= p%4;
        if (p == 1) return "RR";
        if (p == 0) return "rr";
        return "Rr";
    }
}