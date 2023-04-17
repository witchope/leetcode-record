package cn.hackzone.leetcode.editor.cn;

import cn.hackzone.leetcode.editor.common.struct.TreeNode;
import cn.hackzone.leetcode.editor.common.util.TreeUtils;

import java.util.Arrays;

/**
 * [124]Binary Tree Maximum Path Sum
 *
 * @author maxwell
 * @date 2023/03/14
 */
public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.constructBinaryTree(Arrays.asList(-10, 9, 20, null, null, 15, 7));
        Solution solution = new Solution();
        int ans = solution.maxPathSum(root);
        System.out.println(ans);
    }


    static
    class Solution {

        int ans = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxGain(root);
            return ans;
        }

        private int maxGain(TreeNode root) {
            // base case
            if (root == null) {
                return 0;
            }

            // 递归计算左右子节点的最大贡献值
            // 只有在最大贡献值大于 0 时，才会选取对应子节点
            int leftGain = Math.max(maxGain(root.left), 0);
            int rightGain = Math.max(maxGain(root.right), 0);

            // 后续遍历
            // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
            int nodeGain = root.val + leftGain + rightGain;

            ans = Math.max(ans, nodeGain);

            // 返回节点的最大贡献值
            return root.val + Math.max(leftGain, rightGain);
        }
    }
}
