package cn.hackzone.leetcode.editor.cn.sort;

import java.util.Arrays;

/**
 * Insertion sort array solution
 *
 * @author maxwell
 * @date 2023/03/14
 */
public class InsertionSortArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = solution.sortArray(new int[]{3, 2, 1, 5, 4});
        System.out.println(Arrays.toString(nums));
    }

    static
    class Solution {

        public int[] sortArray(int[] nums) {
            int n = nums.length;
            // 最外层为未排序数组
            for (int i = 1; i < n; i++) {
                int cur = nums[i];
                int j = i - 1;
                // 内层维护一个排好序的数组
                while (j >= 0 && cur < nums[j]) {
                    nums[j + 1] = nums[j];
                    j--;
                }
                nums[j + 1] = cur;
            }
            return nums;
        }
    }
}
