package io.nuevedejun.leetcode.pivotindex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  final Solution solution = new Solution();

  @Test
  void pivotIndex0() {
    assertEquals(3, solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
  }

  @Test
  void pivotIndex1() {
    assertEquals(-1, solution.pivotIndex(new int[]{1, 2, 3}));
  }

  @Test
  void pivotIndex2() {
    assertEquals(0, solution.pivotIndex(new int[]{2, 1, -1}));
  }

  @Test
  void pivotIndex3() {
    assertEquals(2, solution.pivotIndex(new int[]{-1, 1, 2}));
  }

  @Test
  void pivotIndex4() {
    assertEquals(1, solution.pivotIndex(new int[]{-2, 1, -2}));
  }

  @Test
  void pivotIndex5() {
    assertEquals(2, solution.pivotIndex(new int[]{-1, -1, 0, 0, -1, -1}));
  }
}
