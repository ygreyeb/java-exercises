package io.nuevedejun.leetcode.issubsequence;

import org.junit.jupiter.api.Test;

import static io.nuevedejun.leetcode.utils.TestUtils.fromFile;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  final Solution solution = new Solution();

  @Test
  void isSubsequence0() {
    assertTrue(solution.isSubsequence("abc", "ahbgdc"));
  }

  @Test
  void isSubsequence1() {
    assertFalse(solution.isSubsequence("axc", "ahbgdc"));
  }

  @Test
  void isSubsequence2() {
    assertFalse(solution.isSubsequence("acb", "ahbgdc"));
  }

  @Test
  void isSubsequence3() {
    assertTrue(solution.isSubsequence("b", "abc"));
  }

  @Test
  void isSubsequence4() {
    assertTrue(solution.isSubsequence("b", "abdac"));
  }

  @Test
  void isSubsequence5() {
    assertFalse(solution.isSubsequence("abbc", "ahbdc"));
  }

  @Test
  void isSubsequence6() throws Exception {
    testReadingFromFile("is-subsequence-test6.txt", true);
  }

  @Test
  void isSubsequence7() throws Exception {
    testReadingFromFile("is-subsequence-test7.txt", false);
  }

  private void testReadingFromFile(final String name, final boolean expected) throws Exception {
    fromFile(name, line -> {
      String str = line.get();
      String substr = line.get();
      assertEquals(expected, solution.isSubsequence(substr, str));
    });
  }
}
