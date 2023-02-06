package cn.hackzone.leetcode.editor.cn.sort;

public class MergeSortArray {

    static
    class Solution {

        int[] temp;

        public int[] sortArray(int[] nums) {
            temp = new int[nums.length];
            sort(nums, 0, nums.length - 1);
            return nums;
        }

        void sort(int[] nums, int low, int high) {
            if (low >= high) return;
            int mid = low + (high - low) / 2;
            sort(nums, low, mid);
            sort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }

        private void merge(int[] nums, int low, int mid, int high) {
            for (int i = low; i <= high; i++) {
                temp[i] = nums[i];
            }
            // 双指针
            int i = low, j = mid + 1;
            for (int p = low; p <= high; p++) {
                if (i == mid + 1) {
                    nums[p] = temp[j];
                    j++;
                } else if (j == high) {
                    nums[p] = temp[i];
                    i++;
                } else if (temp[i] < temp[j]) {
                    nums[p] = temp[i];
                    i++;
                } else {
                    nums[p] = temp[j];
                    j++;
                }
            }
        }

    }
}
