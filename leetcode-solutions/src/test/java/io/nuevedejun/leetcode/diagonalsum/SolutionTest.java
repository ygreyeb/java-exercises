package io.nuevedejun.leetcode.diagonalsum;

import org.junit.jupiter.api.Test;

import static io.nuevedejun.leetcode.utils.TestUtils.m;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  final Solution solution = new Solution();

  @Test
  void diagonalSum0() {
    assertEquals(25, solution.diagonalSum(m(3,
        1, 2, 3,
        4, 5, 6,
        7, 8, 9)));
  }

  @Test
  void diagonalSum1() {
    assertEquals(8, solution.diagonalSum(m(4,
        1, 1, 1, 1,
        1, 1, 1, 1,
        1, 1, 1, 1,
        1, 1, 1, 1)));
  }

  @Test
  void diagonalSum2() {
    assertEquals(5, solution.diagonalSum(m(1, 5)));
  }
}
