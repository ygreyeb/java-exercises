package io.nuevedejun.leetcode.middlenode;

import org.junit.jupiter.api.Test;

import static io.nuevedejun.leetcode.utils.TestUtils.ln;
import static io.nuevedejun.leetcode.utils.TestUtils.same;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  final Solution solution = new Solution();

  @Test
  void middleNode0() {
    assertTrue(same(ln(3, 4, 5), solution.middleNode(ln(1, 2, 3, 4, 5))));
  }

  @Test
  void middleNode1() {
    assertTrue(same(ln(4, 5, 6), solution.middleNode(ln(1, 2, 3, 4, 5, 6))));
  }
}