package leetcode.p682;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int calPoints(String[] ops) {
        List<Integer> scores= new ArrayList<Integer>();
        int n;
        for (String op : ops) {
            switch (op) {
                case "+":
                    n= scores.size();
                    scores.add(scores.get(n-1)+scores.get(n-2));
                    break;
                case "D":
                    n= scores.size();
                    scores.add(scores.get(n-1)*2);
                    break;
                case "C":
                    n= scores.size();
                    scores.remove(n-1);
                    break;
                default:
                    scores.add(Integer.valueOf(op));
                    break;
            }
        }
        return scores.stream().reduce(0, Integer::sum);
    }
}
