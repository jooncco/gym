package leetcode.p901;
// https://leetcode.com/problems/online-stock-span/
public class StockSpanner {
    private final int[] arr, cache;
    private int idx;

    public StockSpanner() {
        arr= new int[10000];
        cache= new int[10000];
        idx= 0;
    }

    public int next(int price) {
        cache[idx]= 1;
        int curIdx= idx-1;
        while (curIdx >= 0 && arr[curIdx] <= price) {
            cache[idx] += cache[curIdx];
            curIdx -= cache[curIdx];
        }
        arr[idx]= price;
        return cache[idx++];
    }
}