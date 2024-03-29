package cn.hackzone.leetcode.editor.cn.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSortArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = solution.sortArray(new int[]{3, 4, 1, 5, 2});
        System.out.println(Arrays.toString(nums));
    }

    static class Solution {

        public int[] sortArray(int[] nums) {
            shuffle(nums);
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        void quickSort(int[] nums, int left, int right) {
            if (left >= right) return;

            int p = partition(nums, left, right);

            quickSort(nums, left, p - 1);
            quickSort(nums, p + 1, right);
        }

        private int partition(int[] nums, int left, int right) {
            int pivot = nums[right];
            // 双指针, 进行分组，pivot 左边小，右边大
            int i = left - 1;
            for (int j = left; j < right; j++) {
                if (nums[j] <= pivot) {
                    ++i;
                    swap(nums, i, j);
                }
            }
            // 交换 pivot 索引
            int p = i + 1;
            swap(nums, p, right);
            return p;
        }

        void shuffle(int[] nums) {
            Random r = new Random();
            for (int i = 0; i < nums.length; i++) {
                int j = i + r.nextInt(nums.length - i);
                swap(nums, i, j);
            }
        }

        void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
