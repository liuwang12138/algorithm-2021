package com.uzgf.top.interview;

/**
 * 返回一个括号字符串中, 最长的括号有效字串的长度
 */
public class Q003_LongestValidParenthesis {

    /**
     * dp[i]: 以arr[i]为结尾的最长的括号有效字串的长度
     * dp[i] = 0        arr[i] == '('
     *
     */
    public static int longestValidParenthesis(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        int[] dp = new int[str.length()];
        char[] cs = str.toCharArray();
        int res = 0;
        for (int i=1; i<dp.length; i++) {
            if (cs[i] == '(') {
                dp[i] = 0;
                continue;
            }
            // i-dp[i-1]...i-1
            if (i-dp[i-1]-1 < 0 || cs[i-dp[i-1]-1] == '(') {
                dp[i] = 0;
            }
            dp[i] = dp[i-1] + 2 + (i - dp[i-1] - 2 >= 0 ? dp[i-dp[i-1]-2] : 0);
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static int forTest(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] str = s.toCharArray();
        int[] dp = new int[str.length];
        int pre = 0;
        int ans = 0;
        // dp[0] = 0;
        for (int i = 1; i < str.length; i++) {
            if (str[i] == ')') {
                pre = i - dp[i - 1] - 1; // 与str[i]配对的左括号的位置 pre
                if (pre >= 0 && str[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "(())()(())";
        System.out.println(longestValidParenthesis(str));
        System.out.println(forTest(str));
    }

}
