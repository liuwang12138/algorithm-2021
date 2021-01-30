package com.uzgf.top.interview;

/**
 * 正方形染色问题
 * 有一些排成一行的正方形，每个正方形已经被染成红色或者绿色。现在可以选择任意一个正方形 然后用这两种颜色的任意一种进行染色，这个正方形的颜色将会被覆盖。
 * 目标是在完成染色之后，每个红色R都比绿色G距离最左侧近，返回至少需要涂染几个正方形。
 * 如样例所示：s = RGRGR，我们涂染之后变成RRRGG满足了要求，涂染的个数为2，没有比这个更好的涂染方案。
 */
public class Q004_SquareDye {

    /**
     * 枚举分界线，看每个分界线左侧有几个绿色，右侧有几个红色
     */
    public static int minDyeNum(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] cs = s.toCharArray();
        int[] leftGreen = new int[cs.length+1];
        int[] rightRed = new int[cs.length+1];
        // arr[i]代表分割线放在cs[i]的左侧
        for (int i=1; i<cs.length+1; i++) {
            leftGreen[i] = cs[i-1] == 'G' ? leftGreen[i-1] + 1 : leftGreen[i-1];
        }
        for (int i=cs.length-1; i>=0; i--) {
            rightRed[i] = cs[i] == 'R' ? rightRed[i+1] +  1 : rightRed[i+1];
        }

        int res = Integer.MAX_VALUE;
        for (int i=0; i<cs.length+1; i++) {
            res = Math.min(res, leftGreen[i] + rightRed[i]);
        }

        return res;
    }

    public static int minDyeNum2(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] cs = s.toCharArray();
        int[] leftGreen = new int[cs.length+1];
        int[] rightRed = new int[cs.length+1];
        // arr[i]代表分割线放在cs[i]的左侧
        for (int i=1; i<cs.length+1; i++) {
            leftGreen[i] = cs[i-1] == 'G' ? leftGreen[i-1] + 1 : leftGreen[i-1];
        }
        for (int i=cs.length-1; i>=0; i--) {
            rightRed[i] = cs[i] == 'R' ? rightRed[i+1] +  1 : rightRed[i+1];
        }

        int res = Integer.MAX_VALUE;
        for (int i=0; i<cs.length+1; i++) {
            res = Math.min(res, leftGreen[i] + rightRed[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minDyeNum("RGRGR"));
    }

}
