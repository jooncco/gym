package leetcode.p46;
// https://leetcode.com/problems/permutations/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DFS / Implementation (Next Permutation)
 * Time: O (n! n)
 * Space: O (n! n)
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        int total = 1;
        for (int i = 1; i <= n; ++i)
            total *= i;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < total; ++i) {
            List<Integer> list = new ArrayList<>(n);
            for (int num : nums)
                list.add(num);
            ans.add(list);
            nums = nextPermutation(nums);
        }
        return ans;
    }

    private int[] nextPermutation(int[] arr) {
        int n = arr.length;
        int[] ret = new int[n];
        for (int i = 0; i < n; ++i)
            ret[i] = arr[i];
        int pivot = n - 1;
        while (pivot > 0 && ret[pivot - 1] >= ret[pivot])
            --pivot;
        if (pivot > 0) {
            --pivot;
            int idx = n - 1;
            while (ret[idx] <= ret[pivot])
                --idx;
            swap(ret, pivot, idx);
            reverse(ret, pivot + 1, n - 1);
        } else {
            Arrays.sort(ret);
        }
        return ret;
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private void reverse(int[] arr, int l, int r) {
        int[] buf = new int[r - l + 1];
        for (int i = l; i <= r; ++i)
            buf[i - l] = arr[r - (i - l)];
        for (int i = 0; i < r - l + 1; ++i)
            arr[l + i] = buf[i];
    }
}