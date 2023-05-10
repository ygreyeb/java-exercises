package io.nuevedejun.leetcode.longestpalindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  final Solution solution = new Solution();

  @Test
  void longestPalindrome0() {
    assertEquals("bab", solution.longestPalindrome("babad"));
  }

  @Test
  void longestPalindrome1() {
    assertEquals("bb", solution.longestPalindrome("cbbd"));
  }

  @Test
  void longestPalindrome2() {
    assertEquals("gghjhgg", solution.longestPalindrome("hgghjhgg"));
  }

  @Test
  void longestPalindrome3() {
    assertEquals("shs", solution.longestPalindrome("dgnhucfshsbcgd"));
  }

  @Test
  void longestPalindrome4() {
    assertEquals("d", solution.longestPalindrome("dgnhucfshbscgd"));
  }

  @Test
  void longestPalindrome5() {
    assertEquals("bacab", solution.longestPalindrome("bacabab"));
  }


  @Test
  void longestPalindrome6() {
    assertEquals("arenanera", solution.longestPalindrome("arenaneraa"));
  }
}
