package others;

import java.util.ArrayList;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

public class AddTwoNumbers {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> sumOfNumbers = new ArrayList<>();
        int sumInt = 0;
        boolean transfer = false;
        while (l1 != null || l2 != null) {
            if (transfer) {
                sumInt++;
                transfer = false;
            }
            if (l1 == null) sumInt += l2.val;
            else if (l2 == null) sumInt += l1.val;
            else sumInt += l1.val + l2.val;
            if (sumInt > 9) {
                transfer = true;
                sumInt -= 10;
            }
            sumOfNumbers.add(sumInt);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            if (l1 == null && l2 == null && transfer) sumOfNumbers.add(1);
            sumInt = 0;
        }
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        for (int item : sumOfNumbers) {
            dummy.next = new ListNode(item);
            dummy = dummy.next;
        }
        return result.next;
    }

    public static void main(String[] args) {

    }

}
