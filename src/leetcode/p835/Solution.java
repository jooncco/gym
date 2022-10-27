package leetcode.p835;

import java.util.Arrays;

public class Solution {
    private int n;

    public int largestOverlap(int[][] img1, int[][] img2) {
        n= img1.length;
        int[] A= getMaskedImage(img1), B= getMaskedImage(img2);
        int ans= 0;
        for (int row= -n+1; row < n; ++row) {
            for (int col= -n+1; col < n; ++col) {
                ans= Math.max(ans, computeOverlap(A, translate(B, row, col)));
                System.out.println("r: " + row + " c: " + col + " ans: " + ans);
                int[] tmp= translate(B, row, col);
                for (int i=0; i < n; ++i) {
                    for (int j=0; j < n; ++j) {
                        System.out.print((tmp[i] & (1<<j)) > 0 ? 1 : 0);
                    }
                    System.out.println();
                }
            }
        }
        return ans;
    }

    private int[] getMaskedImage(final int[][] img) {
        int[] maskedImage= new int[n];
        for (int row=0; row < n; ++row) {
            int mask= 0;
            for (int col= 0; col < n; ++col) {
                if (img[row][col] == 1) mask |= (1<<col);
            }
            maskedImage[row]= mask;
        }
        return maskedImage;
    }

    private int[] translate(final int[] img, int r, int c) {
        int[] translatedImage= Arrays.copyOf(img, n);
        if (c > 0) {
            for (int row= 0; row < n; ++row) translatedImage[row] >>= c;
        }
        if (c < 0) {
            for (int row= 0; row < n; ++row) translatedImage[row] <<= -c;
        }
        if (r > 0) {
            int row= n-1;
            while (row-r >= 0) {
                translatedImage[row]= translatedImage[row-r];
                --row;
            }
            for (int i=row; i >= 0; --i) translatedImage[i]= 0;
        }
        if (r < 0) {
            int row= 0;
            while (row-r < n) {
                translatedImage[row]= translatedImage[row-r];
                ++row;
            }
            for (int i=row; i < n; ++i) translatedImage[i]= 0;
        }
        return translatedImage;
    }

    private int computeOverlap(final int[] A, final int[] B) {
        int overlap= 0;
        for (int row=0; row < n; ++row) {
            int mask= A[row] & B[row];
            for (int i=0; i < n; ++i) {
                if ((mask & (1<<i)) > 0) ++overlap;
            }
        }
        return overlap;
    }
}