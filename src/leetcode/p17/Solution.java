package leetcode.p17;
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private String[] letters = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        int n= digits.length();
        if (n == 0) return List.of();

        List<String> combinations= new LinkedList<>();
        int digit= Integer.parseInt(digits.charAt(0)+"");
        for (int i=0; i < letters[digit].length(); ++i) {
            combinations.add(""+letters[digit].charAt(i));
        }
        for (int i=1; i < n; ++i) {
            digit= Integer.parseInt(digits.charAt(i)+"");
            String possibleLetters= letters[digit];
            List<String> newCombinations = new LinkedList<>();
            for (int j=0; j < combinations.size(); ++j) {
                for (int k=0; k < possibleLetters.length(); ++k) {
                    newCombinations.add(combinations.get(j)+possibleLetters.charAt(k));
                }
            }
            combinations= newCombinations;
        }
        return combinations;
    }
}