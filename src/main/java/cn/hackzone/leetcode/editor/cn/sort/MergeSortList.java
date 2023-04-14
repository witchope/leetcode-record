package cn.hackzone.leetcode.editor.cn.sort;

import cn.hackzone.leetcode.editor.common.struct.ListNode;
import cn.hackzone.leetcode.editor.common.util.LinkedListUtils;

/**
 * @author maxwell
 */
public class MergeSortList {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = LinkedListUtils.constructLinkedList(new int[]{5, 4, 2, 3, 1});
        LinkedListUtils.printList(listNode);
        ListNode sortedList = solution.sortList(listNode);
        LinkedListUtils.printList(sortedList);
    }

    static
    class Solution {

        public ListNode sortList(ListNode head) {
            return sortList(head, null);
        }

        private ListNode sortList(ListNode head, ListNode tail) {
            if (head == null) {
                return head;
            }
            if (head.next == tail) {
                head.next = null;
                return head;
            }
            ListNode mid = getMid(head, tail);
            ListNode list1 = sortList(head, mid);
            ListNode list2 = sortList(mid, tail);
            return merge(list1, list2);
        }

        private ListNode getMid(ListNode head, ListNode tail) {
            ListNode slow = head, fast = head;
            while (fast != tail) {
                slow = slow.next;
                fast = fast.next;
                if (fast != tail) {
                    fast = fast.next;
                }
            }
            return slow;
        }

        public ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummyHead = new ListNode(0);
            ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
            while (temp1 != null && temp2 != null) {
                if (temp1.val <= temp2.val) {
                    temp.next = temp1;
                    temp1 = temp1.next;
                } else {
                    temp.next = temp2;
                    temp2 = temp2.next;
                }
                temp = temp.next;
            }
            if (temp1 != null) {
                temp.next = temp1;
            } else if (temp2 != null) {
                temp.next = temp2;
            }
            return dummyHead.next;
        }
    }
}
