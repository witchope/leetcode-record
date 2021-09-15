package cn.hackzone.leetcode.editor.cn;

//Given a string s, reverse the order of characters in each word within a 
//sentence while still preserving whitespace and initial word order. 
//
// 
// Example 1: 
// Input: s = "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"
// Example 2: 
// Input: s = "God Ding"
//Output: "doG gniD"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// s contains printable ASCII characters. 
// s does not contain any leading or trailing spaces. 
// There is at least one word in s. 
// All the words in s are separated by a single space. 
// 
// Related Topics 双指针 字符串 👍 327 👎 0


public class ReverseWordsInAStringIii {

    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();
        solution.reverseWords("this is test");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            int n = s.length(), i = 0;
            char[] c = s.toCharArray();
            while (i < n) {
                int start = i;
                while (i < n && c[i] != ' ') i++;
                reverseString(c, start, i - 1);
                i++;
            }
            return new String(c);
        }

        private void reverseString(char[] c, int left, int right) {
            while (left < right) {
                swap(c, left, right);
                left++;
                right--;
            }
        }

        private void swap(char[] c, int i, int j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
