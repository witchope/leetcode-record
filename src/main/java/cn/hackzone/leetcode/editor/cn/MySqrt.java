package cn.hackzone.leetcode.editor.cn;

/**
 * x 的平方根
 * <p>
 * 给你一个非负整数 x ，计算并返回的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * <a href="https://leetcode.cn/problems/sqrtx">链接</a>
 */
public class MySqrt {

    public static void main(String[] args) {
        Solution solution = new MySqrt().new Solution();
        int i = solution.mySqrt(2147395599);
        System.out.println(i);
    }

    class Solution {
        public int mySqrt(int x) {
            int l = 1, r = x, ans = 0;
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                // upper bound 最接近的最大数
                if (mid <= x / mid) { // 防止溢出
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return ans;
        }
    }

}
