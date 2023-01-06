package cn.hackzone.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最长公共子序列
 * <p>
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-common-subsequence
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence().new Solution();
        int i = solution.longestCommonSubsequence("abcde", "ace");
        System.out.println(i);
    }

    class Solution {

        int[][] memo;
        String s1;
        String s2;

        public int longestCommonSubsequence(String text1, String text2) {
            memo = new int[text1.length()][text2.length()];
            s1 = text1;
            s2 = text2;
            //填充默认数据
            for (int[] row : memo) Arrays.fill(row, -1);

            return dp(0, 0);
        }

        int dp(int i, int j) {
            // base case
            if (i == s1.length() || j == s2.length()) return 0;

            // 返回备忘录数据，避免重复计算
            if (memo[i][j] != -1) return memo[i][j];

            if (s1.charAt(i) == s2.charAt(j)) {
                memo[i][j] = 1 + dp(i + 1, j + 1);
            } else {
                memo[i][j] = Math.max(dp(i + 1, j), dp(i, j + 1));
            }
            return memo[i][j];
        }
    }

}
