package leetcode.p216;
// https://leetcode.com/problems/combination-sum-iii/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private int k, n;
    private List<List<Integer>> resultLists;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k= k; this.n= n;
        resultLists= new LinkedList<>();
        List<Integer> list= new LinkedList<>();
        findCombination(list, 1);
        return resultLists;
    }

    private void findCombination(List<Integer> curList, int curNum) {
        int sum= curList.stream().mapToInt(Integer::intValue).sum();
        if (curList.size() == k) {
            if (sum == n) {
                resultLists.add(new ArrayList<>(curList));
            }
            return;
        }
        if (curNum >= 10) return;

        for (int i= curNum; i < 10; ++i) {
            if (sum + i > n) break;
            curList.add(i);
            findCombination(curList, i+1);
            curList.remove(curList.size()-1);
        }
    }
}