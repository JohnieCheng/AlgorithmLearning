package hot_100;

import common.ListNode;

/**
 * 两数相加
 *
 * @author Johnie Cheng
 * @version 1.0
 */
public class Question2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry, null);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3, null);
        listNode1.next = new ListNode(4, null);
        listNode1.next.next = new ListNode(9, null);

        ListNode listNode2 = new ListNode(9, null);
        listNode2.next = new ListNode(4, null);
        listNode2.next.next = new ListNode(3, null);
        ListNode listNode = new Question2().addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
        System.out.println(listNode.next.next.next.val);
    }
}
