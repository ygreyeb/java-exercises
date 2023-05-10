package io.nuevedejun.leetcode.mergetwolists;

import io.nuevedejun.leetcode.utils.ListNode;

public class Solution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) return list2;
    if (list2 == null) return list1;

    final ListNode head;
    ListNode sliding1;
    ListNode sliding2;
    if (list1.val < list2.val) {
      head = sliding1 = list1;
      sliding2 = list2;
    } else {
      head = sliding1 = list2;
      sliding2 = list1;
    }

    while (true) {
      if (sliding1.next == null) {
        sliding1.next = sliding2;
        break;
      } else if (sliding2.val < sliding1.next.val) {
        ListNode aux = sliding1.next;
        sliding1.next = sliding2;
        sliding2 = aux;
      }
      sliding1 = sliding1.next;
    }
    return head;
  }
}
