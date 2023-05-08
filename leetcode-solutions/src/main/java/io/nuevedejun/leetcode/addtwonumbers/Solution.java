package io.nuevedejun.leetcode.addtwonumbers;

public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int[] result = new int[101];
    int len = 0;

    ListNode c1 = l1;
    ListNode c2 = l2;
    boolean carry = false;
    boolean any;
    do {
      int d1 = 0;
      if (c1 != null) {
        d1 = c1.val;
        c1 = c1.next;
      }
      int d2 = 0;
      if (c2 != null) {
        d2 = c2.val;
        c2 = c2.next;
      }

      int t = d1 + d2 + (carry ? 1 : 0);
      carry = t >= 10;
      result[len++] = t % 10;

      any = c1 != null || c2 != null;
    } while (any);

    if (carry) result[len++] = 1;

    ListNode next = null;
    for (int i = len - 1; i >= 0; i--) {
      next = new ListNode(result[i], next);
    }
    return next;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
