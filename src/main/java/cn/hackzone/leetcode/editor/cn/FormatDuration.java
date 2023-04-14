package cn.hackzone.leetcode.editor.cn;

/**
 * 将数字转换成 ?h?m?s 时分秒格式
 *
 * @author maxwell
 */
public class FormatDuration {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.formatDuration(3600);
        System.out.println(s);
        String s1 = solution.formatDuration(3678);
        System.out.println(s1);
    }

    static
    class Solution {

        public String formatDuration(long duration) {
            long hour = duration / 3600;
            long min = (duration % 3600) / 60;
            long second = duration % 60;
            StringBuilder sb = new StringBuilder();
            if (hour > 0) {
                sb.append(hour);
                sb.append("h");
            }
            if (min > 0) {
                sb.append(hour);
                sb.append("m");
            }
            if (second > 0) {
                sb.append(second);
                sb.append("s");
            }
            return sb.toString();
        }
    }

}
