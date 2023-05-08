package io.nuevedejun.leetcode.diagonalsum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  final Solution solution = new Solution();

  private static int[][] m(int l, int... values) {
    int[][] matrix = new int[l][l];
    for (int i = 0; i < l; i++)
      System.arraycopy(values, i * l, matrix[i], 0, l);
    return matrix;
  }

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
