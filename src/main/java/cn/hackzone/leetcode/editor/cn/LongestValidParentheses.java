package cn.hackzone.leetcode.editor.cn;

public class LongestValidParentheses {

    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        int i = solution.longestValidParentheses("()(())");
        System.out.println(i);
    }

    class Solution {
        public int longestValidParentheses(String s) {
            int ans = 0, n = s.length();
            int[] dp = new int[n];
            // 括号两步为一个跨度
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == ')') {
                    // 判断临近匹配
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = 2;
                        if (i >= 2) dp[i] += dp[i - 2];
                    } else {
                        int pairIndex = i - dp[i - 1] - 1;
                        // 保证配对的 '(' 下标有效
                        if (pairIndex >= 0 && s.charAt(pairIndex) == '(') {
                            dp[i] = dp[i - 1] + 2;
                            // 如果超过 2，加上之前的子序列
                            if (pairIndex >= 2) dp[i] += dp[pairIndex - 1];
                        }
                    }
                    ans = Math.max(ans, dp[i]);
                }
                // 如果是 '(' 保持 dp[i] = 0
            }
            return ans;
        }
    }

}
