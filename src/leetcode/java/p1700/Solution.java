package leetcode.java.p1700;
// https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/

import java.util.*;

/**
 * Data Structures
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        Queue<Integer> stu = new LinkedList<>();
        int circles = 0, squares = 0;
        for (int i = 0; i < n; ++i) {
            stu.add(students[i]);
            if (students[i] == 0)
                ++circles;
            else
                ++squares;
        }

        Stack<Integer> snd = new Stack<>();
        for (int i = n - 1; i >= 0; --i) {
            snd.push(sandwiches[i]);
        }

        while (!stu.isEmpty()) {
            int pref = stu.poll();
            if (snd.peek() != pref) {
                if (pref == 0 && squares == 0)
                    return circles;
                if (pref == 1 && circles == 0)
                    return squares;
                stu.add(pref);
            } else {
                int eat = snd.pop();
                if (eat == 0)
                    --circles;
                else
                    --squares;
            }
        }
        return 0;
    }
}