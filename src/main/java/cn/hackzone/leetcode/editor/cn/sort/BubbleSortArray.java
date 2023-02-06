package cn.hackzone.leetcode.editor.cn.sort;

import java.util.Arrays;
import java.util.Collections;

public class BubbleSortArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = solution.sortArray(new int[]{3, 2, 1, 5, 4});
        System.out.println(Arrays.toString(nums));
    }

    static
    class Solution {

        public int[] sortArray(int[] nums) {
            if (nums == null) return null;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (nums[j] > nums[j + 1]) {
                        swap(nums, j, j + 1);
                    }
                }
            }
            return nums;
        }

        void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
