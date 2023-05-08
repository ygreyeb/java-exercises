package io.nuevedejun.leetcode.addtwonumbers;

import io.nuevedejun.leetcode.addtwonumbers.Solution.ListNode;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  final Solution solution = new Solution();

  @Test
  void addTwoNumbers0() {
    assertTrue(same(ln(7, 0, 8), solution.addTwoNumbers(ln(2, 4, 3), ln(5, 6, 4))));
  }

  @Test
  void addTwoNumbers1() {
    assertTrue(same(ln(0), solution.addTwoNumbers(ln(0), ln(0))));
  }

  @Test
  void addTwoNumbers2() {
    assertTrue(same(ln(8, 9, 9, 9, 0, 0, 0, 1), solution.addTwoNumbers(ln(9, 9, 9, 9, 9, 9, 9), ln(9, 9, 9, 9))));
  }

  private boolean same(ListNode... listNodes) {
    ListNode pivot = listNodes[0];
    boolean valMatch = Stream.of(listNodes).skip(1).allMatch(node -> {
      if (pivot == null) return node == null;
      else return pivot.val == node.val;
    });
    return valMatch && (pivot == null ||
        same(Stream.of(listNodes).map(node -> node.next).toArray(ListNode[]::new)));
  }

  private ListNode ln(int... elements) {
    ListNode next = null;
    for (int i = elements.length - 1; i >= 0; i--) {
      next = new ListNode(elements[i], next);
    }
    return next;
  }
}
