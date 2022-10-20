package leetcode.p12;
// https://leetcode.com/problems/integer-to-roman/

public class Solution {
    private final String[] ten= {"", "M", "C", "X"};
    private final String[] one= {"M", "C", "X", "I"};
    private final String[] five= {"", "D", "L", "V"};

    public String intToRoman(int num) {
        StringBuilder sb= new StringBuilder();
        int mul= 1000;
        for (int i=0; i < 4; ++i) {
            System.out.println(num/mul);
            appendRoman(sb, num/mul, ten[i], one[i], five[i]);
            num %= mul;
            mul /= 10;
        }
        return sb.toString();
    }

    private void appendRoman(StringBuilder sb, int digit, String ten, String one, String five) {
        if (digit < 4) {
            while (digit-- > 0) sb.append(one);
        } else if (digit == 4) {
            sb.append(one).append(five);
        } else if (digit < 9) {
            sb.append(five);
            int cnt= digit-5;
            while (cnt-- > 0) sb.append(one);
        } else {
            sb.append(one).append(ten);
        }
    }
}