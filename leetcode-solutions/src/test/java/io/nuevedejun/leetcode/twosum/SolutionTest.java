package io.nuevedejun.leetcode.twosum;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

  final Solution solution = new Solution();

  @Test
  void twoSum0() {
    int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
    Arrays.sort(result);
    assertArrayEquals(new int[]{0, 1}, result);
  }
}
