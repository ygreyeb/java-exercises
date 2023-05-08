package io.nuevedejun.leetcode.isisomorphic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  final Solution solution = new Solution();

  @Test
  void isIsomorphic0() {
    assertTrue(solution.isIsomorphic("egg", "add"));
  }

  @Test
  void isIsomorphic1() {
    assertFalse(solution.isIsomorphic("foo", "bar"));
  }

  @Test
  void isIsomorphic2() {
    assertTrue(solution.isIsomorphic("paper", "title"));
  }

  @Test
  void isIsomorphic3() {
    assertFalse(solution.isIsomorphic("badc", "baba"));
  }
}
