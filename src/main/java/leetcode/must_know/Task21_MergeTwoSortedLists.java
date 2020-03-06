package leetcode.must_know;

import leetcode.array.ListNode;
import leetcode.linked_list.Task2_AddTwoNumbers;

public class Task21_MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode answer = new ListNode(0);;
        ListNode pointer = answer;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                pointer.next = new ListNode(l2.val);
                pointer = pointer.next;
                l2 = l2.next;
            } else if (l2 == null) {
                pointer.next = new ListNode(l1.val);
                pointer = pointer.next;
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    pointer.next = new ListNode(l1.val);
                    l1 = l1.next;
                    pointer = pointer.next;
                } else {
                    pointer.next = new ListNode(l2.val);
                    l2 = l2.next;
                    pointer = pointer.next;
                }
            }
        }
        return answer.next;
    }


    }
