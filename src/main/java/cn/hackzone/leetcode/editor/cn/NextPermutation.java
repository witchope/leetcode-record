package cn.hackzone.leetcode.editor.cn;

import cn.hackzone.leetcode.editor.common.util.CommonUtils;

/**
 * 下一个排列
 * <p>
 * 整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * <p>
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 */
public class NextPermutation {

    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        int[] nums = {4, 5, 3, 1, 6, 2};
        CommonUtils.printArray(nums);
        solution.nextPermutation(nums);
        CommonUtils.printArray(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            /* 1. 如果是升序序列直接交换位置即可
             * 2. 如果是降序序列，意味着已经枚举完毕, 目的就是为了遭到降序序列的边界， 也就是较小的高位数
             */
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                // 找到降序序列里面尽可能低位的较大数, 这样保证变大幅度最小
                while (j >= 0 && nums[i] >= nums[j]) {
                    j--;
                }
                swap(nums, i, j);
            }
            //针对降序序列逆序，降低变大幅度
            reverse(nums, i + 1);
        }

        /**
         * 交换数据
         */
        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        /**
         * 逆序一个已排序的数组
         */
        private void reverse(int[] nums, int start) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
