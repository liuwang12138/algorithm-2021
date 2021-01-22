package com.uzgf.utils;

import java.util.Arrays;

public class TestUtils {

    // for test
    public static int[] generateSortedArray(int len, int max) {
        int[] ans = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * max);
        }
        Arrays.sort(ans);
        return ans;
    }

}
