package io.nuevedejun.leetcode.generatematrix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static io.nuevedejun.leetcode.utils.TestUtils.m;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  final Solution solution = new Solution();

  @Test
  void generateMatrix0() {
    assertTrue(Arrays.deepEquals(m(3,
            1, 2, 3,
            8, 9, 4,
            7, 6, 5),
        solution.generateMatrix(3)));
  }
}
