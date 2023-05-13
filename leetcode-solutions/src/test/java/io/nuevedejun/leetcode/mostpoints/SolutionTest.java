package io.nuevedejun.leetcode.mostpoints;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static io.nuevedejun.leetcode.utils.TestUtils.fromFile;
import static io.nuevedejun.leetcode.utils.TestUtils.m;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  final Solution solution = new Solution();

  @Test
  void mostPoints0() {
    assertEquals(157, solution.mostPoints(m(2, 21, 5, 92, 3, 74, 2, 39, 4, 58, 2, 5, 5, 49, 4, 65, 3)));
  }

  @Test
  void mostPoints1() throws Exception {
    fromFile("most-points-test1.txt", line -> {
      int[] values = Arrays.stream(line.get().split(",")).mapToInt(Integer::parseInt).toArray();
      long expected = Long.parseLong(line.get());

      assertEquals(expected, solution.mostPoints(m(2, values)));
    });
  }
}
