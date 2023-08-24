package programmers.pccp1.A;
// https://school.programmers.co.kr/learn/courses/15008/lessons/121683

public class Solution {
    public String solution(String inputStr) {
        String ans = "";
        for (int i=0; i < 26; ++i) {
            char alphabet= (char)('a'+i);
            boolean appeared= false, conscutive= false;
            for (char c : inputStr.toCharArray()) {
                if (alphabet != c) {
                    conscutive= false;
                    continue;
                }
                if (!appeared) {
                    appeared= true;
                    conscutive= true;
                    continue;
                }
                if (!conscutive) {
                    ans += alphabet;
                    break;
                }
            }
        }
        return ans;
    }
}
