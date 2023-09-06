package leetcode.p725;
// https://leetcode.com/problems/split-linked-list-in-parts/

/**
 * Implementation, Number Theory
 * | Time: O(n)
 * | Space: O(k)
 */
public class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int cnt= 0;
        ListNode cur= head;
        while (cur != null) {
            ++cnt;
            cur= cur.next;
        }

        int groupSize= cnt/k;
        int rem= cnt%k;
        if (rem > 0) ++groupSize;
        ListNode[] ret= new ListNode[k];
        int curCnt= 0, idx= 0;
        cur= head;
        ListNode it= null;
        while (cur != null) {
            if (curCnt == 0) {
                it= ret[idx]= cur;
            } else {
                it= it.next= cur;
            }
            ++curCnt;
            if (curCnt == groupSize) {
                ListNode lastNode= cur;
                cur= cur.next;
                lastNode.next= null;
                curCnt= 0;
                ++idx;
                if (--rem == 0) --groupSize;
            } else {
                cur= cur.next;
            }
        }
        return ret;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}