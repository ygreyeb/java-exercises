package io.nuevedejun.leetcode.utils;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    return "[" + val + "," + next + ']';
  }
}
