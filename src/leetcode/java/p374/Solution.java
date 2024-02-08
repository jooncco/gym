package leetcode.java.p374;
// https://leetcode.com/problems/guess-number-higher-or-lower/

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, r = n, myGuess = (l + r) / 2;
        int queryResult;
        do {
            queryResult = guess(myGuess);
            if (queryResult < 0)
                r = myGuess - 1;
            if (queryResult > 0)
                l = myGuess + 1;
            myGuess = (l + r) / 2;
        } while (queryResult != 0);
        return myGuess;
    }
}

class GuessGame {
    // mocked method
    protected int guess(int num) {
        return 1;
    }
}