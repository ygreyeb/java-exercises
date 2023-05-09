package io.nuevedejun.leetcode.spiralorder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  final Solution solution = new Solution();

  @Test
  void spiralOrder0() {
    assertEquals(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5), new int[][]{
        new int[]{1, 2, 3},
        new int[]{4, 5, 6},
        new int[]{7, 8, 9}
    });
  }

  @Test
  void spiralOrder1() {
    assertEquals(List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), new int[][]{
        new int[]{1, 2, 3, 4},
        new int[]{5, 6, 7, 8},
        new int[]{9, 10, 11, 12}
    });
  }
}