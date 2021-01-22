package com.uzgf.top.interview;

import com.uzgf.utils.TestUtils;

/**
 * 给定一个有序数组arr，从左往右依次表示x轴上从左往右点的位置，给定一个正整数K，返回如果有一根长度为K的绳子，最多能盖住几个点？
 * 绳子的边缘点碰到x轴上的点，也算盖住
 */
public class Q001_MaxPointCountCoveredByRope {

    public static int getMaxPointCount(int[] arr, int k) {
        int L = 0;
        int R = 0;
        int max = 0;
        while (L <= R && R < arr.length) {
            if (R - L <= k) {
                max = Math.max(max, R-L);
                R++;
            } else {
                L++;
            }
        }

        return max;
    }

    // for test
    public static int test(int[] arr, int L) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int pre = i - 1;
            while (pre >= 0 && arr[i] - arr[pre] <= L) {
                pre--;
            }
            max = Math.max(max, i - pre);
        }
        return max;
    }

    public static void main(String[] args) {
        int len = 100;
        int max = 1000;
        int testTime = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int L = (int) (Math.random() * max);
            int[] arr = TestUtils.generateSortedArray(len, max);
            int ans1 = getMaxPointCount(arr, L);
            int ans3 = test(arr, L);
            if (ans1 != ans3) {
                System.out.println("oops!");
                break;
            }
        }
        System.out.println("OK!");

    }

}
