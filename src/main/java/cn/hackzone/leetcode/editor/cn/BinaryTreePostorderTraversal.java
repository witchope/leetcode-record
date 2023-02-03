package cn.hackzone.leetcode.editor.cn;

import cn.hackzone.leetcode.editor.common.struct.TreeNode;
import cn.hackzone.leetcode.editor.common.util.TreeUtils;

import java.util.*;

public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = TreeUtils.constructBinaryTree(Arrays.asList(1, null, 2, 3));
        solution.postorderTraversal(treeNode);
    }

    static
    class Solution {

        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode visited = new TreeNode(-1);

        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) return ans;

            pushLeft(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.peek();
                // 遍历右子树
                pushRight(node);
                // 右子树遍历完成，出栈
                popup(node);
            }
            return ans;
        }

        void pushLeft(TreeNode node) {
            // 遍历左子树
            while (node != null) {
                //前序
                stack.push(node);
                node = node.left;
            }
        }

        private void pushRight(TreeNode node) {
            if ((node.left == null || node.left == visited)
                    && node.right != visited) {
                // 中序
                pushLeft(node.right);
            }
        }

        private void popup(TreeNode node) {
            if (node.right == null || node.right == visited) {
                // 后续
                ans.add(node.val);
                visited = stack.pop();
            }
        }

    }

}
