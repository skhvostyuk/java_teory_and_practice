package leetcode.linked_list;

public class Task2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = l1;
        while (l1.next != null) {
            if (l2 != null) {
                l1.next.val += (l1.val + l2.val) / 10;
                l1.val = (l1.val + l2.val) % 10;
                l2 = l2.next;
            } else {
                l1.next.val += l1.val / 10;
                l1.val %= 10;
            }
            l1 = l1.next;
        }


        if (l2 != null) {
            l1.val = (l1.val + l2.val);
        }

        if (l2 != null && l2.next != null) {
            l1.next = l2.next;
            l1.next.val += l1.val / 10;
            l1.val %= 10;

            while (l1.next != null) {
                l1.next.val += l1.val / 10;
                l1.val %= 10;
                l1 = l1.next;
            }
        }

        if (l1.val >= 10) {
            l1.val %= 10;
            l1.next = new ListNode(1);
        }

        return ret;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
