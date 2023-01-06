package cn.hackzone.leetcode.editor.cn;

/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数 myAtoi(string s) 的算法如下：
 * <p>
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * <p>
 * <a href="https://leetcode.cn/problems/string-to-integer-atoi">链接</a>
 */
public class MyAtoi {

    public static void main(String[] args) {
        String s = " ";
        Solution solution = new MyAtoi().new Solution();
        int i = solution.myAtoi(s);
        System.out.println(i);
    }

    class Solution {
        public int myAtoi(String s) {
            if (s.isEmpty()) return 0;
            int ans = 0, i = 0, flag = 1;

            while (i < s.length() - 1 && s.charAt(i) == ' ') i++; // 跳过空格
            if (s.charAt(i) == '-') flag = -1; //正负标志
            if (s.charAt(i) == '+' || s.charAt(i) == '-') i++;

            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                // 处理溢出情况
                if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && num > 7)) {
                    return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                ans = ans * 10 + num;
                i++;
            }
            return flag > 0 ? ans : -ans;
        }
    }
}
