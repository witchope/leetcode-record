package cn.hackzone.leetcode.editor.cn;

/**
 * x 的平方根
 * <p>
 * 给你一个非负整数 x ，计算并返回的 算术平方根 。
 * <p>
 * 结果只保留两位小数
 */
public class MySqrt1 {

    public static void main(String[] args) {
        Solution solution = new MySqrt1().new Solution();
        double i = solution.mySqrt(0);
        System.out.println(i);
    }

    class Solution {
        public double mySqrt(double x) {
            double n = 1e-2; //通过 n 控制步伐
            double l = 1, r = x, ans = 0;
            while (l <= r) {
                double mid = (r - l) / 2 + l;
                // upper bound 最接近的最大数
                if (mid <= x / mid) {
                    ans = mid;
                    l = mid + n;
                } else {
                    r = mid - n;
                }
            }
            return ans;
        }
    }

}
