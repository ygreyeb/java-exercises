package io.nuevedejun.leetcode.addtwonumbers;

import org.junit.jupiter.api.Test;

import static io.nuevedejun.leetcode.utils.TestUtils.ln;
import static io.nuevedejun.leetcode.utils.TestUtils.same;
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
}
