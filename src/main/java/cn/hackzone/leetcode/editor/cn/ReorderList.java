package cn.hackzone.leetcode.editor.cn;

import cn.hackzone.leetcode.editor.common.struct.ListNode;
import cn.hackzone.leetcode.editor.common.util.CommonUtils;
import cn.hackzone.leetcode.editor.common.util.LinkedListUtils;

import java.util.Arrays;

/**
 * [143] Reorder list
 *
 * @author maxwell
 * @date 2023/03/14
 */
public class ReorderList {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list = LinkedListUtils.createSinglyLinkedList(Arrays.asList(1, 2, 3, 4, 5, 6));
        solution.reorderList(list);
        CommonUtils.printList(list);
    }

    static
    class Solution {

        /**
         * 思路：
         * 1. 寻找链表的中点
         * 2. 根据中点拆分成 l1、l2 两个链表
         * 3. 反转 l2 链表
         * 4. 合并 l1, l2 两个链表
         *
         * @param head Head ListNode
         */
        public void reorderList(ListNode head) {

            ListNode mid = middleNode(head);

            ListNode l1 = head;
            ListNode l2 = mid.next;
            mid.next = null;

            l2 = reverseList(l2);

            mergeList(l1, l2);
        }

        private void mergeList(ListNode l1, ListNode l2) {
            ListNode next1 = l1;
            ListNode next2 = l2;
            while (next1 != null && next2 != null) {
                next1 = l1.next;
                next2 = l2.next;

                // 交叉
                l1.next = l2;
                // 偏移指针
                l1 = next1;

                // 交叉
                l2.next = l1;
                // 偏移指针
                l2 = next2;
            }
        }

        private ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode tail = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return tail;
        }

        private ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}
