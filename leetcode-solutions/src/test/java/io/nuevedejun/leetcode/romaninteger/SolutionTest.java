package io.nuevedejun.leetcode.romaninteger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  final Solution solution = new Solution();

  @Test
  void romanToInt() {
    assertEquals(3, solution.romanToInt("III"));
    assertEquals(58, solution.romanToInt("LVIII"));
    assertEquals(1994, solution.romanToInt("MCMXCIV"));
  }
}
