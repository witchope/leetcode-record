package cn.hackzone.leetcode.editor.cn;

//Given the root of a binary tree, return the postorder traversal of its nodes' 
//values. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,3]
//Output: [3,2,1]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// Example 4: 
//
// 
//Input: root = [1,2]
//Output: [2,1]
// 
//
// Example 5: 
//
// 
//Input: root = [1,null,2]
//Output: [2,1]
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Recursive solution is trivial, could you do it iteratively? 
//Related Topics 栈 树 深度优先搜索 二叉树 👍 668 👎 0


import cn.hackzone.leetcode.editor.common.struct.TreeNode;
import cn.hackzone.leetcode.editor.common.util.TreeUtils;

import java.util.*;

public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
        TreeNode treeNode = TreeUtils.constructBinaryTree(Arrays.asList(1, null, 2, 3));
        solution.postorderTraversal(treeNode);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) return Collections.emptyList();
            List<Integer> ans = new ArrayList<>();

            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode prev = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                // 右子树未访问且不为空
                if (root.right != null && root.right != prev) {
                    stack.push(root);
                    root = root.right;
                } else {
                    ans.add(root.val);
                    prev = root; // 表示已经访问过
                    root = null; // 出栈条件
                }
            }
            return ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}
