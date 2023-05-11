package io.nuevedejun.leetcode.middlenode;

import io.nuevedejun.leetcode.utils.ListNode;

public class Solution {
  public ListNode middleNode(ListNode head) {
    ListNode middle = head;
    ListNode moving = head;
    boolean move = true;
    while (moving.next != null) {
      moving = moving.next;
      if (move) {
        middle = middle.next;
        move = false;
      } else {
        move = true;
      }
    }
    return middle;
  }
}
