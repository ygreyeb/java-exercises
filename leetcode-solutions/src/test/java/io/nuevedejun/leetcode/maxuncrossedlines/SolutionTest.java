package io.nuevedejun.leetcode.maxuncrossedlines;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  final Solution solution = new Solution();

  @Test
  void maxUncrossedLines0() {
    assertEquals(3, solution.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
  }

  @Test
  void maxUncrossedLines1() {
    assertEquals(2, solution.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));
  }

  @Test
  void maxUncrossedLines2() {
    assertEquals(1, solution.maxUncrossedLines(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}));
  }

  @Test
  void maxUncrossedLines3() {
    assertEquals(3, solution.maxUncrossedLines(new int[]{1, 2, 2, 2}, new int[]{2, 2, 2, 1}));
  }

  @Test
  void maxUncrossedLines4() {
    assertEquals(3, solution.maxUncrossedLines(new int[]{1, 2, 2, 2}, new int[]{2, 2, 2, 3}));
  }

  @Test
  void maxUncrossedLines5() {
    assertEquals(3, solution.maxUncrossedLines(new int[]{1, 2, 2, 3}, new int[]{3, 2, 2, 1, 1, 2, 3}));
  }

  @Test
  void maxUncrossedLines6() {
    assertEquals(2, solution.maxUncrossedLines(new int[]{1, 2, 2, 3}, new int[]{3, 2, 2, 1}));
  }

  @Test
  void maxUncrossedLines7() {
    assertEquals(9, solution.maxUncrossedLines(new int[]{3, 1, 4, 1, 1, 3, 5, 1, 2, 2},
        new int[]{4, 1, 5, 2, 1, 1, 1, 5, 3, 1, 1, 1, 2, 3, 1, 4, 3, 5, 5, 3, 1, 2, 3, 2, 4, 1, 1, 1, 5, 3}));
  }
}
