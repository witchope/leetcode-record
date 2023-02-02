package cn.hackzone.leetcode.editor.cn;

import cn.hackzone.leetcode.editor.common.struct.Node;
import cn.hackzone.leetcode.editor.common.util.TreeUtils;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * [116] 填充每个节点的下一个右侧节点指针
 * <pre>{@code
 * // Definition for a Node.
 * class Node {
 *     public int val;
 *     public Node left;
 *     public Node right;
 *     public Node next;
 *
 *     public Node() {}
 *
 *     public Node(int _val) {
 *         val = _val;
 *     }
 *
 *     public Node(int _val, Node _left, Node _right, Node _next) {
 *         val = _val;
 *         left = _left;
 *         right = _right;
 *         next = _next;
 *     }
 * };
 * }</pre>
 */
public class PopulatingNextRightPointersInEachNode {

    public static void main(String[] args) {
        Node node = TreeUtils.constructLinkedBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
        solution.connect(node);
        System.out.println(node);
    }

    class Solution {

        //BFS
        public Node connect(Node root) {
            if (root == null) return null;

            Deque<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();

                    // not the last one, then link
                    if (i < size - 1) node.next = queue.peek();

                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }

            }
            return root;
        }

    }

}


